package com.me.boliplate_mvvm.view.common.vo;

import java.util.List;

public class CommonChildResponse {


    /**
     * errorCode : 0
     * message :
     * data : true
     * errors:{}
     */

    private int code;
    private String message;
    private List<ErrorsBean> errors;

    public List<ErrorsBean> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorsBean> errors) {
        this.errors = errors;
    }

    public int getErrorCode() {
        return code;
    }

    public void setErrorCode(int errorCode) {
        this.code = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   }
