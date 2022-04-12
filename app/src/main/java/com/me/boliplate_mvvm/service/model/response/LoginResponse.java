package com.me.boliplate_mvvm.service.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("otp")
    @Expose
    private String otp;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getUser_account_status() {
        if (user_account_status == null) {
            user_account_status = "";
        }
        return user_account_status;
    }

    public void setUser_account_status(String user_account_status) {
        this.user_account_status = user_account_status;
    }

    @SerializedName("user_account_status")
    @Expose
    private String user_account_status;


    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("user_data")
    @Expose
    private UserData userData;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
