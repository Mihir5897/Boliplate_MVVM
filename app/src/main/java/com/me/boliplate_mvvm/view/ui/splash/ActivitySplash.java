package com.me.boliplate_mvvm.view.ui.splash;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;

import com.google.gson.Gson;
import com.me.boliplate_mvvm.R;
import com.me.boliplate_mvvm.databinding.ActivitySplashBinding;
import com.me.boliplate_mvvm.service.model.FCMResponse;
import com.me.boliplate_mvvm.utility.Utilities;
import com.me.boliplate_mvvm.utility.session.SessionManager;
import com.me.boliplate_mvvm.view.base.BaseActivity;
import com.me.boliplate_mvvm.view.ui.home.MainActivity;
import com.me.boliplate_mvvm.view.ui.login.ActivityLogin;
import com.me.boliplate_mvvm.view.ui.signup.ActivitySignup;

import java.util.Locale;

public class ActivitySplash extends BaseActivity  {
    private static final long DELAY_TIME = 3000;
    Activity mActivity;
    ActivitySplashBinding mBinding;
    Boolean isLoggedIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        mActivity = ActivitySplash.this;

       // Utilities.getApplicationLanguage(mActivity);

        openActivity();

    }

    public void openActivity() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
//                isLoggedIn = SessionManager.get().isLoggedIn();
//                if (isLoggedIn) {
//                    Utilities.moveTo(ActivitySplash.this, MainActivity.class);
//                    finish();
//                } else {

                    Utilities.moveTo(ActivitySplash.this, ActivityLogin.class);
                    finish();
               // }
            }
        }, DELAY_TIME);
    }



    public void showpushNotification() {
//        Intent i = getIntent();
//        Bundle extras = i.getExtras();
//        if (extras != null) {
//            try {
//                String tempObj = extras.getString("data");
//                // Utilities.showMessage(this, tempObj);
//                FCMResponse response = new Gson().fromJson(tempObj, FCMResponse.class);
//                String notificationType = response.getNotificationType();
//                // isPushNotification = "yes";
//                Intent intent;
//                int meeting_status = response.getMeeting_status();
//
//
//                String action = response.getAction();
//                if (action == null) {
//                    action = "";
//                }
//                if (notificationType == null) {
//                    notificationType = "";
//                }
//                int request_status = -1;
//                int request_stage_status;
//                boolean isUserBde = false, isUserBdm = false;
//                String userType = "";
//                userType = Utilities.getUserRoleType(SessionManager.get().getUserRoleId());
//                isUserBde = Utilities.isUserBde(userType);
//                isUserBdm = Utilities.isUserBdm(userType);
//                if (notificationType != null && !notificationType.isEmpty()) {
//                    if (notificationType.equals("updateRemark")) {
//                        intent = new Intent(this, ActivityRemarksList.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        intent.putExtra(AppConstants.LEAD_NAME, response.getLead_name());
//                        startActivity(intent);
//                    } else if (notificationType.equals("addRemark")) {
//                        intent = new Intent(this, ActivityRemarksList.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        intent.putExtra(AppConstants.REMARK_ID, response.getRemark_id());
//                        intent.putExtra(AppConstants.LEAD_NAME, response.getLead_name());
//                        startActivity(intent);
//                    } else if (notificationType.equals("updateLead") && (action.equalsIgnoreCase(AppConstants.POTENTIAL) || action.equalsIgnoreCase(AppConstants.CLIENT) || action.equalsIgnoreCase(AppConstants.APPROVE) || action.equalsIgnoreCase(AppConstants.REJECT))) {//REQUEST RAISE
//                        intent = new Intent(this, ActivityClientProfileDetails.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        intent.putExtra(AppConstants.ACTION, action);
//                        intent.putExtra(AppConstants.UPDATESTAGE, response.getUpdatestage());
//                        intent.putExtra(AppConstants.comingFromWhereInLeadsDetailsScreen, AppConstants.COMING_FROM_CONVERSION_REQUEST);
//
//
//                        Integer updatestage = response.getUpdatestage();
//                        if (updatestage.equals(1)) {
//                            // means request is raised
//                            request_stage_status = AppConstants.RECIEVED_VALUE;
//                            request_status = AppConstants.PENDING_VALUE;
//                            intent.putExtra(AppConstants.REQUESTSENTRECEIVED, request_stage_status);
//                            intent.putExtra(AppConstants.REQUESTSTATUS, request_status);
//                            startActivity(intent);
//                        } else if (updatestage.equals(2)) {
//// means request is approved or rejected
//                            request_stage_status = AppConstants.SENT_VALUE;
//                            if (action.equalsIgnoreCase(AppConstants.APPROVE)) {
//                                request_status = AppConstants.APPROVED_VALUE;
//                            } else if (action.equalsIgnoreCase(AppConstants.REJECT)) {
//                                request_status = AppConstants.RECIEVED_VALUE;
//                            }
//
//                            intent.putExtra(AppConstants.REQUESTSENTRECEIVED, request_stage_status);
//                            intent.putExtra(AppConstants.REQUESTSTATUS, request_status);
//                            startActivity(intent);
//                        }
//                    } else if (notificationType.equals("updateLead") && action.isEmpty()) {
//                        intent = new Intent(this, ActivityClientProfileDetails.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        startActivity(intent);
//                    } else if (notificationType.equals("addLead")) {
//                        intent = new Intent(this, ActivityClientProfileDetails.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        startActivity(intent);
//                    } else if (notificationType.equals("updateMeeting")) {
//                        intent = new Intent(this, ActivityLeadMeetingsList.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        startActivity(intent);
//                    } else if (notificationType.equals("createMeeting")) {
//                        intent = new Intent(this, ActivityLeadMeetingsList.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        startActivity(intent);
//                    } else if (notificationType.equals("addmeeting")) {//create meeting
//                        intent = new Intent(this, ActivityEditLeadMeeting.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//                        intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//                        intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_SCHEDULE_MEETINGS);
//                    } else if (notificationType.equals("updateMeeting") && meeting_status == 0) { //update and rescheduled
//                        intent = new Intent(this, ActivityEditLeadMeeting.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//                        intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//                        intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_EDIT_LEAD_MEETINGS);
//                    } else if (notificationType.equals("updateMeeting") && meeting_status == 3) {//Start meeting
//                        intent = new Intent(this, ActivityEditLeadMeeting.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//                        intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//                        intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_LEAD_MEETINGS_LIST);
//                        intent.putExtra(AppConstants.REQUEST_STATUS, response.getRequest_status());
//                    } else if (notificationType.equals("updateMeeting") && meeting_status == 4) {//complete meeting
//                        intent = new Intent(this, ActivityEditLeadMeeting.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//                        intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//                        intent.putExtra(AppConstants.REQUEST_STATUS, response.getRequest_status());
//                        intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_LEAD_MEETINGS_LIST);
//                    } else if (notificationType.equals("updateMeeting") && meeting_status == 5) {//reject meeting
//                        intent = new Intent(this, ActivityEditLeadMeeting.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//                        intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//                        intent.putExtra(AppConstants.REQUEST_STATUS, response.getRequest_status());
//                        intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_COMPLETED_MEETINGS_LIST);
//                    } else if (notificationType.equals("updateMeeting") && meeting_status == 6) {//approved meeting
//                        intent = new Intent(this, ActivityEditLeadMeeting.class);
//                        intent.putExtra("isPush", "yes");
//                        intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//                        intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//                        intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//                        intent.putExtra(AppConstants.REQUEST_STATUS, response.getRequest_status());
//                        intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_COMPLETED_MEETINGS_LIST);
//                    }
//                else {
//                        openActivity();
//                    }
//                } else {
//                    openActivity();
//                }
//            } catch (Exception e) {
//                openActivity();
//            }
//        } else {
//            openActivity();
//        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        showHideProgressDialog(false);
    }





}