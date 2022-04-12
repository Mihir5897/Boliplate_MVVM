package com.me.boliplate_mvvm.service.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public  class SignUpRequest {
//    {
//        "first_name": "Zafar",
//            "emailId": "2zafar@systematrixtechnocrates.com",
//            "password": "Systango@2021",
//            "mobile": "8966964828",
//            "countryCode": "91",
//            "deviceType": "2",
//            "deviceToken": "asdfasdfasdfasdf"
//    }

    @SerializedName("first_name")
    @Expose
    private String first_name;


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @SerializedName("last_name")
    @Expose
    private String last_name;

    @SerializedName("role")
    @Expose
    private int role;


    @SerializedName("email")
    @Expose
    private String emailId;

    @SerializedName("mobile_number")
    @Expose
    private String mobile;


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @SerializedName("image_name")
    private String image_name;

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

}
