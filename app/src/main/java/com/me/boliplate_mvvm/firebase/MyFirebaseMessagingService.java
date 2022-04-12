/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.me.boliplate_mvvm.firebase;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.me.boliplate_mvvm.R;
import com.me.boliplate_mvvm.service.model.FCMResponse;
import com.me.boliplate_mvvm.utility.Utilities;
import com.me.boliplate_mvvm.utility.session.SessionManager;
import com.me.boliplate_mvvm.view.ui.splash.ActivitySplash;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Random;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    public static final String MyPREFERENCES = "MyPrefs";
    String tittle, message;

    private int NOTIFICATION_ID;

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        // Get updated InstanceID token.
        String refreshedToken = s;
        Log.d(TAG, "FCM Refreshed token: " + refreshedToken);

        SessionManager.get().setFirebaseToken(refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }

    /**
     * Persist token to third-party servers.
     * <p>
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        Log.d(TAG, "Refreshed tokens: " + token);

        // TODO: Implement this method to send token to your app server.
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        Log.d(TAG, "Message notification payload: " + remoteMessage.getNotification().toString());
        Log.d(TAG, "Message notification payload: " + remoteMessage.getNotification().getBody() + remoteMessage.getNotification().getTitle());

        tittle = remoteMessage.getNotification().getTitle();
        message = remoteMessage.getNotification().getBody();
        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            try {
                sendNotification(remoteMessage.getData());
//                boolean isLogin = SessionManager.get().isLoggedIn();
//                if (isLogin) {
//                    NOTIFICATION_ID = new Random(1000).nextInt();
//                    sendNotification(remoteMessage.getData());
//                } else
//                    return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            Log.d(TAG, "Message Notification: " + remoteMessage.getNotification());
//            showGenericNotification();

        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     */
    private void sendNotification(Map<String, String> tempObj) {
//        {type=NewDeals, sound=default, message=Check push notification}
        if (tempObj != null) {
//            String message = tempObj.get("message");
//            try {
//                String jsondata = new Gson().toJson(tempObj);
//                String newJson =  jsondata.replace("=",":");
//
//                String split[] = newJson.split("\"data\":\"");
//
//                String jsonsplit = split[1];
//                String newstr = jsonsplit.replace("\\", "");
//                String newstr_newstr = newstr.replace("}\"", "");
//
//                Gson gson = new Gson();
//                FCMResponse response = gson.fromJson(newstr_newstr, FCMResponse.class);
//
//                showNotification(response.getNotificationType(),response.getNotificationSubType(), response.getKey1());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            //String message = tempObj.get("message");
            try {
                String jsondata = new Gson().toJson(tempObj);
                String newJson = jsondata.replace("=", ":");

                String split[] = newJson.split("\"data\":\"");

                String jsonsplit = split[1];
                String newstr = jsonsplit.replace("\\", "");
                String newstr_newstr = newstr.replace("}\"", "");

                Gson gson = new Gson();
                FCMResponse response = gson.fromJson(newstr_newstr, FCMResponse.class);

                showNotification(response);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    //Pusty  1==>AceeptOrder,2====>Preparing   3=====>Reject  4===>Complete  8====Messgaeging

    public void showGenericNotification() {
        Intent intent;
        intent = new Intent(this, ActivitySplash.class);
//        intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        Intent localIntent = new Intent("hii");
        LocalBroadcastManager.getInstance(MyFirebaseMessagingService.this).sendBroadcast(localIntent);


        Bitmap bitmap;
//        Bitmap bitmaps = getBitmapFromURL((image_url.equals("") ? "" : image_url));
//        if (bitmaps != null) {
//            bitmap = bitmaps;
//        } else {
////           bitmap = drawableToBitmap(getApplicationContext().getResources().getDrawable(R.mipmap.ic_launcher));
        bitmap = null;
//        }
        PendingIntent pIntent = getPendingIntentWithStackBuilder(intent);
        String channelId = getString(R.string.default_notification_channel_id);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle(tittle)
                        .setContentText(message)
                        .setAutoCancel(true)
                        // .setStyle(new NotificationCompat.BigTextStyle().bigText(meesage))
                        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND).setVibrate(new long[]{1000, 1000})
                        .setSound(defaultSoundUri)
                        .setAutoCancel(true).setContentIntent(pIntent);

        if (bitmap != null) {
            notificationBuilder.setLargeIcon(bitmap)
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(bitmap)
                            .bigLargeIcon(null));
        } else {
            notificationBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(message));
        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//            notificationBuilder.setColor(ContextCompat.getColor(this, R.color.col_1ee0df));

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(new Random().nextInt() /* ID of notification */, notificationBuilder.build());
    }

    public void showNotification(FCMResponse response) {
        String notificationType = response.getNotificationType();
        String action = response.getAction();
        int meeting_status = response.getMeeting_status();

        if (action == null) {
            action = "";
        }
        if (notificationType == null) {
            notificationType = "";
        }
        Intent intent = null;
//        int request_status = -1;
//        int request_stage_status;
//        boolean isUserBde = false, isUserBdm = false;
//        String userType = "";
//        userType = Utilities.getUserRoleType(SessionManager.get().getUserRoleId());
//        isUserBde = Utilities.isUserBde(userType);
//        isUserBdm = Utilities.isUserBdm(userType);
//        if (notificationType.equals("updateRemark")) {
//            intent = new Intent(this, ActivityRemarksList.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//            intent.putExtra(AppConstants.LEAD_NAME, response.getLead_name());
//        } else if (notificationType.equals("addRemark")) {
//            intent = new Intent(this, ActivityRemarksList.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//            intent.putExtra(AppConstants.REMARK_ID, response.getRemark_id());
//            intent.putExtra(AppConstants.LEAD_NAME, response.getLead_name());
//        }
//
//        else if (notificationType.equals("updateLead") && (action.equalsIgnoreCase(AppConstants.POTENTIAL) || action.equalsIgnoreCase(AppConstants.CLIENT) || action.equalsIgnoreCase(AppConstants.APPROVE) || action.equalsIgnoreCase(AppConstants.REJECT))) {//REQUEST RAISE
//            intent = new Intent(this, ActivityClientProfileDetails.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//            intent.putExtra(AppConstants.ACTION, action);
//            intent.putExtra(AppConstants.UPDATESTAGE, response.getUpdatestage());
//            intent.putExtra(AppConstants.comingFromWhereInLeadsDetailsScreen, AppConstants.COMING_FROM_CONVERSION_REQUEST);
//
//
//            Integer updatestage = response.getUpdatestage();
//            if (updatestage.equals(1)) {
//                // means request is raised
//                request_stage_status = AppConstants.RECIEVED_VALUE;
//                request_status = AppConstants.PENDING_VALUE;
//                intent.putExtra(AppConstants.REQUESTSENTRECEIVED, request_stage_status);
//                intent.putExtra(AppConstants.REQUESTSTATUS, request_status);
//            } else if (updatestage.equals(2)) {
//// means request is approved or rejected
//                request_stage_status = AppConstants.SENT_VALUE;
//                if (action.equalsIgnoreCase(AppConstants.APPROVE)) {
//                    request_status = AppConstants.APPROVED_VALUE;
//                } else if (action.equalsIgnoreCase(AppConstants.REJECT)) {
//                    request_status = AppConstants.RECIEVED_VALUE;
//                }
//
//                intent.putExtra(AppConstants.REQUESTSENTRECEIVED, request_stage_status);
//                intent.putExtra(AppConstants.REQUESTSTATUS, request_status);
//            }
//        }
//        else if (notificationType.equals("updateLead") && action.isEmpty()) {
//            intent = new Intent(this, ActivityClientProfileDetails.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//        }
//        else if (notificationType.equals("addLead")) {
//            intent = new Intent(this, ActivityClientProfileDetails.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//        }else if (notificationType.equals("createMeeting")) {
//            intent = new Intent(this, ActivityLeadMeetingsList.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//        }else if (notificationType.equals("addmeeting")) {//create meeting
//            intent = new Intent(this, ActivityEditLeadMeeting.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//            intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//            intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//            intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_SCHEDULE_MEETINGS);
//        } else if (notificationType.equals("updateMeeting") && meeting_status == 0) { //update and rescheduled
//            intent = new Intent(this, ActivityEditLeadMeeting.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//            intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//            intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//            intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_EDIT_LEAD_MEETINGS);
//
//        } else if (notificationType.equals("updateMeeting") && meeting_status == 3) {//Start meeting
//            intent = new Intent(this, ActivityEditLeadMeeting.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//            intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//            intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//            intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_LEAD_MEETINGS_LIST);
//            intent.putExtra(AppConstants.REQUEST_STATUS, response.getRequest_status());
//        } else if (notificationType.equals("updateMeeting") && meeting_status == 4) {//complete meeting
//            intent = new Intent(this, ActivityEditLeadMeeting.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//            intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//            intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//            intent.putExtra(AppConstants.REQUEST_STATUS, response.getRequest_status());
//            intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_LEAD_MEETINGS_LIST);
//        } else if (notificationType.equals("updateMeeting") && meeting_status == 5) {//reject meeting
//            intent = new Intent(this, ActivityEditLeadMeeting.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//            intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//            intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//            intent.putExtra(AppConstants.REQUEST_STATUS, response.getRequest_status());
//            intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_COMPLETED_MEETINGS_LIST);
//        } else if (notificationType.equals("updateMeeting") && meeting_status == 6) {//approved meeting
//            intent = new Intent(this, ActivityEditLeadMeeting.class);
//            intent.putExtra("isPush", "yes");
//            intent.putExtra(AppConstants.LEAD_ID, response.getLead_id());
//            intent.putExtra(AppConstants.MEETING_STATUS, response.getMeeting_status());
//            intent.putExtra(AppConstants.NOTIFICATION_ID, response.getId());
//            intent.putExtra(AppConstants.REQUEST_STATUS, response.getRequest_status());
//            intent.putExtra(AppConstants.comingFromWhereInEditMeetingsScreen, AppConstants.COMING_FROM_COMPLETED_MEETINGS_LIST);
       if (1==1){}// this line to ignore error
        else {

            intent = new Intent(this, ActivitySplash.class);
            intent.putExtra("isPush", "no");
        }

//        intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        Intent localIntent = new Intent("hii");
        LocalBroadcastManager.getInstance(MyFirebaseMessagingService.this).sendBroadcast(localIntent);


        Bitmap bitmap;
//        Bitmap bitmaps = getBitmapFromURL((image_url.equals("") ? "" : image_url));
//        if (bitmaps != null) {
//            bitmap = bitmaps;
//        } else {
////           bitmap = drawableToBitmap(getApplicationContext().getResources().getDrawable(R.mipmap.ic_launcher));
        bitmap = null;
//        }
        PendingIntent pIntent = getPendingIntentWithStackBuilder(intent);
        String channelId = getString(R.string.default_notification_channel_id);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle(tittle)
                        .setContentText(message)
                        .setAutoCancel(true)
                        // .setStyle(new NotificationCompat.BigTextStyle().bigText(meesage))
                        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND).setVibrate(new long[]{1000, 1000})
                        .setSound(defaultSoundUri)
                        .setAutoCancel(true).setContentIntent(pIntent);

        if (bitmap != null) {
            notificationBuilder.setLargeIcon(bitmap)
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(bitmap)
                            .bigLargeIcon(null));
        } else {
            notificationBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(message));
        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//            notificationBuilder.setColor(ContextCompat.getColor(this, R.color.col_1ee0df));

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(new Random().nextInt() /* ID of notification */, notificationBuilder.build());
    }

    private PendingIntent getPendingIntentWithStackBuilder(Intent intent) {
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(intent);
        return stackBuilder.getPendingIntent((int) System.currentTimeMillis(), PendingIntent.FLAG_ONE_SHOT);
    }

    public Bitmap getBitmapFromURL(String strURL) {
        try {
            if (!strURL.equals("")) {
                URL url = new URL(strURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}