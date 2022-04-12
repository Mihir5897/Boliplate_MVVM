package com.me.boliplate_mvvm.service.api;




import com.google.gson.GsonBuilder;

import com.me.boliplate_mvvm.utility.LiveDataCallAdapterFactory;
import com.me.boliplate_mvvm.utility.constant.AppConstants;
import com.me.boliplate_mvvm.utility.session.SessionManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRetrofit {

    private static AppRetrofit instance;
    private final ApiService apiService;
    private final ApiService authorizedApiService;
    private boolean authRequired = true;

    private AppRetrofit() {
        apiService = provideService(AppConstants.BASE_URL);
        authorizedApiService = provideAuthorizedService(AppConstants.BASE_URL);
    }

    public AppRetrofit(String BaseUrl) {
        apiService = provideService(BaseUrl);
        authorizedApiService = provideAuthorizedService(BaseUrl);
    }

    private static void initInstance() {
        if (instance == null) {
            // Create the instance
            instance = new AppRetrofit();
        }
    }

    public static AppRetrofit getInstance() {
        // Return the instance
        initInstance();
        return instance;
    }

    public ApiService getApiService() {
        return apiService;
    }

    public ApiService getAuthorizedApiService() {
        return authorizedApiService;
    }


    private ApiService provideService(String BaseUrl) {
        // To show the Api Request & Params
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        try {
            // Create a trust manager that does not validate certificate chains
//            final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
//                @Override
//                public void checkClientTrusted(
//                        java.security.cert.X509Certificate[] chain,
//                        String authType) throws CertificateException {
//                }
//
//                @Override
//                public void checkServerTrusted(
//                        java.security.cert.X509Certificate[] chain,
//                        String authType) throws CertificateException {
//                }
//
//                @Override
//                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                    return new java.security.cert.X509Certificate[0];
//                }
//            }};
//
//            // Install the all-trusting trust manager
//            final SSLContext sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, trustAllCerts,
//                    new java.security.SecureRandom());
//            // Create an ssl socket factory with our all-trusting manager
//            final SSLSocketFactory sslSocketFactory = sslContext
//                    .getSocketFactory();


            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            // X509TrustManager trustManager = (X509TrustManager) trustAllCerts[0];
            httpClient.connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    // .sslSocketFactory(sslSocketFactory,trustManager)
                    //  .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
                    .readTimeout(15, TimeUnit.SECONDS).build();

            System.out.println("Access token app retrofit==" + SessionManager.get().getAccessToken());
            httpClient.addInterceptor(logging).addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request.Builder requestBuilder = chain.request().newBuilder()
                            .addHeader(ApiConstant.KEY_CONTENT_TYPE, ApiConstant.CONTENT_TYPE)
                            .addHeader("Accept", "application/json");
                    // .addHeader(ApiConstant.ACCESS_TOKEN, SessionManager.get().getAccessToken());
                    Request request = requestBuilder.build();
                    Response response = chain.proceed(request);

                    return response;
                }
            });


            return new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                    .client(httpClient.build()).build().create(ApiService.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private ApiService provideAuthorizedService(String BaseUrl) {
        // To show the Api Request & Params
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        try {
            // Create a trust manager that does not validate certificate chains
//            final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
//                @Override
//                public void checkClientTrusted(
//                        java.security.cert.X509Certificate[] chain,
//                        String authType) throws CertificateException {
//                }
//
//                @Override
//                public void checkServerTrusted(
//                        java.security.cert.X509Certificate[] chain,
//                        String authType) throws CertificateException {
//                }
//
//                @Override
//                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                    return new java.security.cert.X509Certificate[0];
//                }
//            }};
//
//            // Install the all-trusting trust manager
//            final SSLContext sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, trustAllCerts,
//                    new java.security.SecureRandom());
//            // Create an ssl socket factory with our all-trusting manager
//            final SSLSocketFactory sslSocketFactory = sslContext
//                    .getSocketFactory();


            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            // X509TrustManager trustManager = (X509TrustManager) trustAllCerts[0];
            httpClient.connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    // .sslSocketFactory(sslSocketFactory,trustManager)
                    //  .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
                    .readTimeout(15, TimeUnit.SECONDS).build();

            System.out.println("Access token app retrofit==" + SessionManager.get().getAccessToken());

            httpClient.addInterceptor(logging).addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    String accessToken=SessionManager.get().getAccessToken();
                    accessToken="Bearer "+accessToken;
                    Request.Builder requestBuilder = chain.request().newBuilder()
                            .addHeader(ApiConstant.KEY_CONTENT_TYPE, ApiConstant.CONTENT_TYPE)
                            .addHeader("Accept", "application/json")
                    .addHeader("Authorization", accessToken);
                    //.addHeader(ApiConstant.ACCESS_TOKEN, accessToken);

                    Request request = requestBuilder.build();
                    Response response = chain.proceed(request);

                    return response;
                }
            });


            return new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                    .client(httpClient.build()).build().create(ApiService.class);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void createLog(Response response, Request request) throws IOException {
        ResponseBody responseBody = response.peekBody(Long.MAX_VALUE);
        ErrorLog log = new GsonBuilder().create().fromJson(responseBody.string(), ErrorLog.class);
        String requestData = "";

        // Fetch Request Data
        try {
            RequestBody copy = request.body();
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);

            requestData = buffer.readUtf8();
        } catch (Exception e) {
            e.printStackTrace();
        }

       // HyperLog.e("Request :- ", requestData + " Response :- " + response.networkResponse().toString());
    }


    public class ErrorLog {
        private boolean status;

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }


}
