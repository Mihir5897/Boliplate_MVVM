package com.me.boliplate_mvvm.view.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.me.boliplate_mvvm.R;
import com.me.boliplate_mvvm.utility.DialogUtil;


public class BaseActivity extends AppCompatActivity implements BaseListener, View.OnClickListener {
    protected BaseActivity mThis;
    private ProgressDialog progressDialog;
    private ProgressBar mProgressBar;
    private Dialog progressDialogNew;
    public FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        mThis = this;
        progressDialogNew = new Dialog(mThis);
        progressDialogNew.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialogNew.setContentView(R.layout.layout_circular_progressbar);
       // progressDialogNew.setContentView(R.layout.lotti_loading_anim);
        progressDialogNew.setCancelable(false);
        progressDialogNew.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        changetStatusBarColor();

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }


    // Change status Bar Color
    public void changetStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }


    // Show and hide Dialog
//    @Override
    public void showHideProgressDialog(boolean isShow) {
        if (progressDialogNew != null)
            if (isShow) {
                progressDialogNew.show();
            } else {
                progressDialogNew.cancel();
                progressDialogNew.hide();
                progressDialogNew.dismiss();
            }
    }


    // Show and hide Progress Bar
    @Override
    public synchronized void showHideProgressBar(boolean iShow) {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
            if (iShow)
                mProgressBar.setVisibility(View.VISIBLE);
            else {
                mProgressBar.setVisibility(View.GONE);
                mProgressBar = null;
            }
        } else {
            mProgressBar = DialogUtil.getProgressBarInstance(this, R.id.circular_progress_bar);
            if (mProgressBar == null) return;
            showHideProgressBar(iShow);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        }
    }


}