package com.me.boliplate_mvvm.service.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.me.boliplate_mvvm.service.api.ApiService;
import com.me.boliplate_mvvm.service.api.AppRetrofit;
import com.me.boliplate_mvvm.service.api.vo.ApiErrorResponse;
import com.me.boliplate_mvvm.service.model.RoomDatabase.UserDao;
import com.me.boliplate_mvvm.service.model.request.SignUpRequest;
import com.me.boliplate_mvvm.service.model.response.SignUpResponse;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpRepository {



    public LiveData<SignUpResponse> doSignUp(SignUpRequest request) {
        final MutableLiveData<SignUpResponse> data = new MutableLiveData<>();
        AppRetrofit.getInstance().getApiService().doSignup(request).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {

                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
                else {
                    if (response.code() == 400) {
                        ResponseBody body = response.errorBody();
                        Gson gson = new Gson();
                        String content = null;
                        try {
                            content = body.string();
                            ApiErrorResponse apiErrorResponse = gson.fromJson(content, ApiErrorResponse.class);
                            SignUpResponse signUpResponse = new SignUpResponse();
                            signUpResponse.setStatus(apiErrorResponse.getStatus());
                            signUpResponse.setMessage(apiErrorResponse.getMessage());
                            data.setValue(signUpResponse);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else {data.setValue(null);}
                }

            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
//
//    public LiveData<UserRolesResponse> getUserRoles(BlankRequest request) {
//        final MutableLiveData<UserRolesResponse> data = new MutableLiveData<>();
//        AppRetrofit.getInstance().getApiService().getUserRoles().enqueue(new Callback<UserRolesResponse>() {
//            @Override
//            public void onResponse(Call<UserRolesResponse> call, Response<UserRolesResponse> response) {
//
//                if (response.isSuccessful()) {
//                    data.setValue(response.body());
//                }
//                else {
//                    if (response.code() == 400) {
//                        ResponseBody body = response.errorBody();
//                        Gson gson = new Gson();
//                        String content = null;
//                        try {
//                            content = body.string();
//                            ApiErrorResponse apiErrorResponse = gson.fromJson(content, ApiErrorResponse.class);
//                            UserRolesResponse signUpResponse = new UserRolesResponse();
//                            signUpResponse.setStatus(apiErrorResponse.getStatus());
//                            signUpResponse.setMessage(apiErrorResponse.getMessage());
//                            data.setValue(signUpResponse);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<UserRolesResponse> call, Throwable t) {
//                data.setValue(null);
//            }
//        });
//
//        return data;
//    }
//
//    public LiveData<ProfileImageResponse> doUpdateProfileImage(UpdateProfileImageRequest request) {
//        final MutableLiveData<ProfileImageResponse> data = new MutableLiveData<>();
//        AppRetrofit.getInstance().getAuthorizedApiService().doUpdateProfileImage(request.getImageType()).enqueue(new Callback<ProfileImageResponse>() {
//            @Override
//            public void onResponse(Call<ProfileImageResponse> call, Response<ProfileImageResponse> response) {
//
//                if (response.isSuccessful()) {
//                    ProfileImageResponse response1 = response.body();
//                    response1.setStatus(AppConstants.STATUS_SUCCESSFUL);
//                    data.setValue(response.body());
//                } else {
//                    if (response.code() == 401) {
//                        ResponseBody body = response.errorBody();
//                        Gson gson = new Gson();
//                        String content = null;
//                        try {
//                            content = body.string();
//                            ApiErrorResponse apiErrorResponse = gson.fromJson(content, ApiErrorResponse.class);
//                            ProfileImageResponse response1 = new ProfileImageResponse();
//                            response1.setStatus(apiErrorResponse.getStatus());
//                            // response1.setMessage(apiErrorResponse.getMessage());
//                            data.setValue(response1);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    } else {
//                        data.setValue(null);
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ProfileImageResponse> call, Throwable t) {
//                data.setValue(null);
//            }
//        });
//
//        return data;
//    }

}
