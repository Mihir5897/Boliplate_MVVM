package com.me.boliplate_mvvm.view.base;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;

import com.me.boliplate_mvvm.R;
import com.me.boliplate_mvvm.utility.DialogUtil;


public class BaseFragment extends Fragment  implements BaseListener{

    private ProgressDialog progressDialog;
    private ProgressBar mProgressBar;
    public BaseActivity context;
    private Dialog progressDialogNew;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = (BaseActivity) getActivity();

        progressDialogNew = new Dialog(context);
        progressDialogNew.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialogNew.setContentView(R.layout.layout_circular_progressbar);
        progressDialogNew.setCancelable(false);
        progressDialogNew.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void onResume() {
        super.onResume();
        context = (BaseActivity) getActivity();
    }

    /**
     * Show and hide Progress dialog
     *
     * @param isShow
     */
    @Override
    public void showHideProgressDialog(boolean isShow) {
        if (progressDialogNew != null)
            if (isShow) {
                progressDialogNew.show();
            } else {
                progressDialogNew.hide();
                progressDialogNew.dismiss();
            }
    }

    /**
     * Show and hide Progressbar
     *
     * @param iShow
     */
    @Override
    public void showHideProgressBar(boolean iShow) {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
            if (iShow)
                mProgressBar.setVisibility(View.VISIBLE);
            else {
                mProgressBar.setVisibility(View.GONE);
                mProgressBar = null;
            }
        } else {
            mProgressBar = DialogUtil.getProgressBarInstance(getView(), R.id.circular_progress_bar);
            if (mProgressBar == null) return;
            showHideProgressBar(iShow);
        }
    }
}
