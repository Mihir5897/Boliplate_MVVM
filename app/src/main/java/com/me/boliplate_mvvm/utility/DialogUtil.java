package com.me.boliplate_mvvm.utility;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;
import com.me.boliplate_mvvm.R;
//import androidx.coordinatorlayout.widget.CoordinatorLayout;
//
//import com.google.android.material.snackbar.Snackbar;

public class DialogUtil {


    // get a blocking progress dialog.
//    public static ProgressDialog getProgressDialog11(Context context) {
//        ProgressDialog progressDialog = new ProgressDialog(context, R.style.MyTheme);
//        progressDialog.setMessage(context.getResources().getString(R.string.please_wait));
//        progressDialog.setCancelable(false);
//        return progressDialog;
//    }


    // get a blocking progress dialog.
    public static ProgressDialog getProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getResources().getString(R.string.please_wait));
        progressDialog.setCancelable(false);
        return progressDialog;
    }

    /**
     * Static method to get an create of material styled progress bar
     *
     * @param context Context of the current class
     * @param resId   Resource Id of the progress bar
     * @return An create of MaterialProgressBar
     */
    public static ProgressBar getProgressBarInstance(Context context, int resId) {
        ProgressBar nonBlockingProgressBar = ((Activity) context).getWindow().findViewById(resId);
        return nonBlockingProgressBar;
    }

    public static ProgressBar getProgressBarInstance(View view, int resId) {
        if (view != null) {
            ProgressBar nonBlockingProgressBar = view.findViewById(resId);
            return nonBlockingProgressBar;
        }
        return null;
    }

    public static void showToast(@NonNull Context context, String msg) {
        Toast.makeText(context.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showNoNetworkToast(Context context) {
        showToast(context, context.getString(R.string.no_internet_error_msg));
    }

    public static Snackbar showNoNetworkSnackBar(@NonNull View anyView) {
        return showSnackBar(anyView, "no_internet_error_msg");
    }

    @SuppressLint("ResourceAsColor")
    public static Snackbar showSnackBar(View anyView, String msg) {
        final Snackbar snackBar = Snackbar.make(anyView, msg, Snackbar.LENGTH_SHORT);
        snackBar.setActionTextColor(Color.WHITE);
        if (anyView instanceof CoordinatorLayout) {
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams)
                    snackBar.getView().getLayoutParams();
            params.setMargins(0, 0, 0, 130);
            snackBar.getView().setLayoutParams(params);
        }
        View view = snackBar.getView();
        view.setBackgroundColor(R.color.bg_dim_color);
        //TextView tv = view.findViewById(R.id.snackbar_text);
        //tv.setTextColor(Color.WHITE);
       // tv.setMaxLines(5);
        snackBar.show();
        return snackBar;
    }
}
