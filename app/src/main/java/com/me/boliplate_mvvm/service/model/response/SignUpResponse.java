package com.me.boliplate_mvvm.service.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpResponse {

    @SerializedName("otp")
    @Expose
    private String otp;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private int status;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIs_already_registered() {
        return is_already_registered;
    }

    public void setIs_already_registered(String is_already_registered) {
        this.is_already_registered = is_already_registered;
    }

    @SerializedName("is_already_registered")
    @Expose
    private String is_already_registered;



}
