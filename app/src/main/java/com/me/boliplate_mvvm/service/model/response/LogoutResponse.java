package com.me.boliplate_mvvm.service.model.response;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    Integer status;
}
