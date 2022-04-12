package com.me.boliplate_mvvm.utility.session;

import android.app.Application;

import com.me.boliplate_mvvm.app.AppController;
import com.me.boliplate_mvvm.utility.constant.PrefConstant;


public class SessionManager {
    private static SessionManager sInstance;
    private final PreferenceUtil pref;


    private SessionManager(Application application) {
        pref = new PreferenceUtil(application);
    }

    public static SessionManager get() {
        init(AppController.getInstance());
        return sInstance;
    }

    public static void init(Application application) {
        if (sInstance == null) {
            sInstance = new SessionManager(application);
        }
    }

    public void clear() {
        pref.clear();
    }

    public boolean isPermissionFirst() {
        return pref.getBoolean(PrefConstant.IS_FIRST_TIME_PERMISSION);
    }

    public void setPermissionFirst(boolean b) {
        pref.setBooleanData(PrefConstant.IS_FIRST_TIME_PERMISSION, b);
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(PrefConstant.IS_LOGGED_IN);
    }

    public void setLoggedIn(boolean b) {
        pref.setBooleanData(PrefConstant.IS_LOGGED_IN, b);
    }

    public int getUserId() {
        return pref.getIntData(PrefConstant.USERID);
    }

    public void setUserId(int UserID) {
        pref.setIntData(PrefConstant.USERID, UserID);
    }

    public String getMobile() {
        return pref.getStringData(PrefConstant.MOBILE);
    }

    public void setMobile(String Mobile) {
        pref.setStringData(PrefConstant.MOBILE, Mobile);
    }

    public String getCountryCode() {
        return pref.getStringData(PrefConstant.COUNTRY_CODE);
    }

    public void setCountryCode(String CountryCode) {
        pref.setStringData(PrefConstant.COUNTRY_CODE, CountryCode);
    }

    public String getFirstName() {
        return pref.getStringData(PrefConstant.First_Name);
    }

    public void setFirstName(String token) {
        pref.setStringData(PrefConstant.First_Name, token);
    }

    public String getSelectedLanguage() {
        return pref.getStringData(PrefConstant.selectedLanguage);
    }

    public void setSelectedLanguage(String selectedLanguage) {
        pref.setStringData(PrefConstant.selectedLanguage, selectedLanguage);
    }

    public String getLatitude() {
        return pref.getStringData(PrefConstant.LATITUDE);
    }

    public void setLatitude(String latitude) {
        pref.setStringData(PrefConstant.LATITUDE, latitude);
    }

    public String getLongitude() {
        return pref.getStringData(PrefConstant.LONGITUDE);
    }

    public void setLongitude(String longitude) {
        pref.setStringData(PrefConstant.LONGITUDE, longitude);
    }

    public String getSelectedPlace() {
        return pref.getStringData(PrefConstant.SELECTEDPLACE);
    }

    public void setSelectedPlace(String SelectedPlace) {
        pref.setStringData(PrefConstant.SELECTEDPLACE, SelectedPlace);
    }

    public int getCatererId() {
        return pref.getIntData(PrefConstant.CATERER_ID);
    }

    public void setCatererId(int catererId) {
        pref.setIntData(PrefConstant.CATERER_ID, catererId);
    }

    public int getCartId() {
        return pref.getIntData(PrefConstant.CARTID);
    }

    public void setCartId(int CARTID) {
        pref.setIntData(PrefConstant.CARTID, CARTID);
    }

    public int getDeleteCarId() {
        return pref.getIntData(PrefConstant.DELETECARID);
    }

    public void setDeleteCarId(int DeleteCar) {
        pref.setIntData(PrefConstant.DELETECARID, DeleteCar);
    }

    public String getFirebaseToken() {
        return pref.getStringData(PrefConstant.FIREBASE_TOKEN);
    }

    public void setFirebaseToken(String FirebaseToken) {
        pref.setStringData(PrefConstant.FIREBASE_TOKEN, FirebaseToken);
    }


    public String getRestroTime() {
        return pref.getStringData(PrefConstant.Restro_time);
    }

    public void setRestroTime(String time) {
        pref.setStringData(PrefConstant.Restro_time, time);
    }

    public String getAccessToken() {
        return pref.getStringData(PrefConstant.ACCESSTOKEN);
    }

    public void setAccessToken(String AccessToken) {
        pref.setStringData(PrefConstant.ACCESSTOKEN, AccessToken);
    }

    public String getSelectedCar() {
        return pref.getStringData(PrefConstant.SELECTEDCAR);
    }

    public void setSelectedCar(String SelectedCar) {
        pref.setStringData(PrefConstant.SELECTEDCAR, SelectedCar);
    }

    public int getCartCount() {
        return pref.getIntData(PrefConstant.CARTCOUNT);
    }

    public void setCartCount(int CartCount) {
        pref.setIntData(PrefConstant.CARTCOUNT, CartCount);
    }

    public String getProductList() {
        return pref.getStringData(PrefConstant.SELECTED_PRODUCT);
    }

    public void setProductList(String Product) {
        pref.setStringData(PrefConstant.SELECTED_PRODUCT, Product);
    }

    public int getProductListPosition() {
        return pref.getIntData(PrefConstant.SELECTED_PRODUCT_POS);
    }

    public void setProductListPosition(int ProductListPosition) {
        pref.setIntData(PrefConstant.SELECTED_PRODUCT_POS, ProductListPosition);
    }


    public int getItemId() {
        return pref.getIntData(PrefConstant.ITEMID);
    }

    public void setItemId(int ItemId) {
        pref.setIntData(PrefConstant.ITEMID, ItemId);
    }

    //==================
    public int getEventId() {
        return pref.getIntData(PrefConstant.EVENT_ID);
    }

    public void setEventId(int EventId) {
        pref.setIntData(PrefConstant.EVENT_ID, EventId);
    }

    public int getVenueId() {
        return pref.getIntData(PrefConstant.VENUE_ID);
    }

    public void setVenueId(int VenueId) {
        pref.setIntData(PrefConstant.VENUE_ID, VenueId);
    }


    public Integer getUserRoleId() {
        return pref.getIntData(PrefConstant.USERROLE_ID);
    }

    public void setUserRoleId(Integer userRoleId) {
        pref.setIntData(PrefConstant.USERROLE_ID, userRoleId);
    }

}