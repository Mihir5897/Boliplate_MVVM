package com.me.boliplate_mvvm.service.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonSyntaxException;

import com.google.gson.Gson;
import com.me.boliplate_mvvm.service.api.AppRetrofit;
import com.me.boliplate_mvvm.service.api.vo.ApiErrorResponse;
import com.me.boliplate_mvvm.service.model.request.LoginRequest;
import com.me.boliplate_mvvm.service.model.response.LoginResponse;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {


    public LiveData<LoginResponse> doLogin(LoginRequest request) {

        final MutableLiveData<LoginResponse> data = new MutableLiveData<>();
        AppRetrofit.getInstance().getApiService().doLogin(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                } else {
                    ResponseBody body = response.errorBody();
                    Gson gson = new Gson();
                    String content = null;
                    try {
                        content = body.string();
                        ApiErrorResponse apiErrorResponse = gson.fromJson(content, ApiErrorResponse.class);
                        LoginResponse loginResponse = new LoginResponse();
                        loginResponse.setStatus(apiErrorResponse.getStatus());
                        loginResponse.setMessage(apiErrorResponse.getMessage());
                        loginResponse.setUser_account_status(apiErrorResponse.getUser_account_status());
                        data.setValue(loginResponse);
                    } catch (IOException | JsonSyntaxException | IllegalStateException | NullPointerException e) {
                        data.setValue(null);
                    } catch (Exception e) {
                        data.setValue(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }
}
