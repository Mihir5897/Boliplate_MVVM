package com.me.boliplate_mvvm.service.api;

public class ApiConstant {
    public static final String KEY_CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static final String USER_ID = "userId";
    public static final String ACCESS_TOKEN = "X-CSRF-TOKEN";
    //public static final String ACCESS_TOKEN = "accessToken";
    public static final int VALIDATION_ERROR_CODE = 4;
    public static final int LOGOUT_CODE = 3;

    public static final String height = "height";
    public static final String width = "width";

    public static final String SIGNUP = "register";
    public static final String VERIFY_OTP_DURING_LOGIN = "verify";
    public static final String VERIFY_OTP_DURING_REGISTRATION = "otpverify";
    public static final String RESEND_OTP = "resend";
    public static final String LOGIN = "login";
    public static final String ADD_LEAD = "newLead";
    public static final String UPDATE_LEAD = "updatelead/{leadid}";
    public static final String USER_ROLES = "roles";
    public static final String PROFILE_DETAILS = "getProfile";
    public static final String UPDATE = "profile";
    public static final String Countries = "getcountries";
    public static final String States = "getstates/{id}";
    public static final String Cities = "getcities/{id}";
    public static final String USER_INTEREST = "userinterest";
    public static final String CATEGORIES = "categories";
    public static final String ORIGIN = "origin";
    public static final String PRODUCTS_LIST_ACC_TO_CATEORIES = "productcategory/{CategoryId}";
    public static final String LEADS_LIST = "leads/{offset}";
    //public static final String LEADS_LIST = "leads/page";
    public static final String ADD_REMARKS = "lead/{leadid}/remark";
    public static final String EDIT_REMARKS = "remark/{remarkid}";

    public static final String BUSINESS_INTEREST = "businessinterest";
    public static final String BUSINESS_TYPES = "businesstypes";
    public static final String BUSINESS_SIZE = "businessize";

    public static final String REMARKS_LIST = "lead/{leadid}/remark";

    public static final String SCHEDULE_MEETINGS = "lead/{leadid}/meeting";
    public static final String UPDATE_MEETINGS = "meeting/{meetingid}";


    public static final String MEETINGS_LIST = "lead/{leadid}/meeting";
    public static final String MEETINGS_LIST_BY_USER   = "user/meeting";
    public static final String MEETINGS_LIST_BY_USERS   = "user/meeting";

    public static final String ACTIVITY_LOG_LIST = "activitylog";
    public static final String GET_DASHBOARD   = "getdashboard";
    public static final String NOTIFICATIONS = "notifications";
    public static final String UPLOAD = "upload";
    public static final String CLEAR_ALL_NOTIFICATIONS = "clearnotifications";
    public static final String LOGOUT = "logout";

}
