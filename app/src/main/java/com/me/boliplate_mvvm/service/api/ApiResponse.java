package com.me.boliplate_mvvm.service.api;

import android.util.Log;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.UnknownHostException;

import retrofit2.Response;


/**
 * Generic class to hold response from Apis
 *
 * @param <R> : respective response model class
 */
public class ApiResponse<R> {

    public final int code;
    @Nullable
    public final R body;
    @Nullable
    public final String errorMessage;
    public String TAG = "Api Response";

    public ApiResponse(Throwable error) {
        if (error instanceof UnknownHostException)
            code = ApiResponseStatusCode.INTERNET_ERROR;
        else
            code = ApiResponseStatusCode.DATABASE_ERROR;
        body = null;
        errorMessage = error.getMessage();
    }

    public ApiResponse(Response<R> response) {
        code = response.code();
        if (response.isSuccessful()) {
            body = response.body();
            errorMessage = null;
        } else {
            String message = null;
            if (response.errorBody() != null) {
                try {
                    message = response.errorBody().string();
                } catch (IOException ignored) {
                    Log.e(TAG, "error while parsing response");
                }
            }
            if (message == null || message.trim().length() == 0) {
                message = response.message();
            }
            errorMessage = message;
            body = null;
        }

    }
}
