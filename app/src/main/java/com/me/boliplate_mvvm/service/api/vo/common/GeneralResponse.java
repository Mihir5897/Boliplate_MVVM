package com.me.boliplate_mvvm.service.api.vo.common;

public class GeneralResponse<T> extends CommonResponse {

    T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}