package com.me.boliplate_mvvm.utility.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.me.boliplate_mvvm.utility.constant.AppConstants;


public class PreferenceUtil {

    public static final String SHARED_PREF_NAME = AppConstants.APP_NAME;
    private final SharedPreferences mSpref;
    private final Context context;
    private String TAG = PreferenceUtil.class.getSimpleName();

    public PreferenceUtil(Context context) {
        this.context = context;
        mSpref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public int getIntData(String key) {
        return mSpref.getInt(key, 0);
    }

    public void setIntData(String key, int value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putInt(key, value);
        appInstallInfoEditor.commit();
    }

    public void setStringData(String key, String value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putString(key, value);
        appInstallInfoEditor.apply();
    }

    public boolean getBoolean(String key) {
        return mSpref.getBoolean(key, false);
    }

    public String getStringData(String key) {
        return mSpref.getString(key, "");

    }

    public void setBooleanData(String key, boolean value) {
        SharedPreferences.Editor appInstallInfoEditor = mSpref.edit();
        appInstallInfoEditor.putBoolean(key, value);
        appInstallInfoEditor.apply();
    }

    public void clear() {
        mSpref.edit().clear().apply();
    }

}
