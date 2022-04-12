package com.me.boliplate_mvvm.service.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {
   /* {
        "mobile_number": "+911234567890"

    }*/

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    @SerializedName("mobile_number")
    @Expose
    private String mobile_number;


}
