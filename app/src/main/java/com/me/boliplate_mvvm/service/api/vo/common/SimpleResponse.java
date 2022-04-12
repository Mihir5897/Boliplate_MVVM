package com.me.boliplate_mvvm.service.api.vo.common;


import com.me.boliplate_mvvm.view.common.vo.CommonChildResponse;

public class SimpleResponse<T> extends CommonChildResponse {
    T data;

    public T getData() {
        return data;
    }

    public void setData(T result) {
        this.data = result;
    }

}
