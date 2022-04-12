package com.me.boliplate_mvvm.app;

import android.app.Activity;
import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;


import com.me.boliplate_mvvm.utility.Utilities;
import com.me.boliplate_mvvm.utility.constant.AppConstants;
import com.me.boliplate_mvvm.utility.network.NetworkChangeReceiver;
import com.me.boliplate_mvvm.utility.network.NetworkHandler;
import com.me.boliplate_mvvm.view.base.BaseActivity;

import java.lang.reflect.Method;


public final class AppController extends Application implements Application.ActivityLifecycleCallbacks {

    private static AppController instance;
    private NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
    private BaseActivity activity;
    private int numRunningActivities = 0;

    public static synchronized AppController getInstance() {
        return instance;
    }

    /**
     * Set crachlytics
     * Check Network State
     * Register Recivers
     * Register lifecycle
     */
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        NetworkHandler.isConnected = Utilities.getNetworkState(this);
        registerReceiver(networkChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        registerActivityLifecycleCallbacks(this);


        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        numRunningActivities++;
        if (numRunningActivities == 1) {
            Log.d("APPLICATION", "APP IN FOREGROUND");
            AppConstants.onlineStatus=1;

//            if(SessionManager.get().isLoggedIn())
//                EventBus.getDefault().post(new CheckUser());
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (activity instanceof BaseActivity)
            this.activity = (BaseActivity) activity;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.d("onActivityPaused","ads");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.d("onActivityStopped","ads");
        numRunningActivities--;
        if (numRunningActivities == 0) {
            Log.e("APPLICATION", "App is in BACKGROUND");
            AppConstants.onlineStatus=0;
        }

        /*smsVerifyCatcher.onStop();*/
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.d("onActivityDestroyed","ads");
    }

    public BaseActivity getActivity() {
        return activity;
    }

}
