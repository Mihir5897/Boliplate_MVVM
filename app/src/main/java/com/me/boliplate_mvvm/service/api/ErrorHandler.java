package com.me.boliplate_mvvm.service.api;

import android.view.View;

import com.me.boliplate_mvvm.utility.DialogUtil;


public class ErrorHandler {

    public static void showServerErrorMsg(View view) {
        String msg="Request failed, please try again later";
        DialogUtil.showSnackBar(view, msg);
    }
}
