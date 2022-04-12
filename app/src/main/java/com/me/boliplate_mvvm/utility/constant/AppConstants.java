package com.me.boliplate_mvvm.utility.constant;


import com.me.boliplate_mvvm.R;

public class    AppConstants {
    public static int onlineStatus = 0;
    public static final String API_KEY = "f10294cfb88656e9d26c1db1b34c8a7d";

    public static final String APP_NAME = "Asapp";
    public static final String TITLE = "title";
    public static final String URL = "url";
    public static final String MEETINGS_OBJECT = "MEETINGS_OBJECT";

    public static final String RESOURCE_ERROR_TYPE = "type must be a resource";
    public static final String RESOURCE_ERROR_PARAMETER = "resource must be parameterized";
    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANGUAGE_ARABIC = "ar";
    //    ==========Staging=======
    //  public static final String BASE_URL = "http://3.111.20.233/api/";
    //     public static final String BASE_URL = "https://stage.agroworlds.com/api/";

    //    ==========Development=======
     //public static final String BASE_URL = "http://15.206.216.242/api/";
      public static final String BASE_URL = "https://dev.agroworlds.com/api/";
      public static final String DATABASE_NAME = "mi-database.db";

    public static String selectedLanguage = "selectedLanguage";
    public static String IS_LOGGEDIN = "IS_LOGGEDIN";

    public static int STATUS_SUCCESSFUL = 1;
    public static int STATUS_UN_SUCCESSFUL = 0;

    public static String STATUS_ACTIVE = "ACTIVE";
    public static String STATUS_PENDING = "PENDING";

    public static String WRONG_OTP_MESSAGE = "You have entered the wrong OTP";
    public static String RESEND_OTP_MAX_LIMIT_REACHED_MESSAGE = "Coudlnt resent OTP more than 3 times";
    public static int MAX_LIMIT_FOR_RESEND_OTP = 3;



    public static int firstNameMaxLength = 30;
    public static int lastNameMaxLength = 30;
    public static int emailMaxLength = 110;

    public static int phoneNumberMaxLength = 10;
    public static int phoneNumberUAECountryMaxLength = 9;
    public static int phoneNumberCNCountryMaxLength = 13;

    public static int companyNameMaxLength = 130;
    public static int addressMaxLength = 200;
    public static int pincodeMaxLength = 6; // for India
    public static int websiteMaxLength = 100;
    public static int pocNameMaxLength = 45;
    public static int nameMaxLength = 50;
    public static int socialHandleMaxLength = 250;
    public static int keyManagementPersonalMaxLength = 150;

    public static String indiaCountryCode = "+91";
    public static String indiaCountryName = "India";
    public static int maxLengthForMobileNoForIndia = 10;

    public static String uaeCountryCode = "+86";
    public static String uaeCountryName = "Dubai";
    public static int maxLengthForMobileNoForUae = 9;

    public static String chinaCountryCode = "+971";
    public static String chinaCountryName = "China";
    public static int maxLengthForMobileNoForChina = 13;
    public static int Default_DropDownValue = -1;
    public static int Default_Origin_Value = 1;
    public static String Default_DropDownValueString = "-1";
    public static int Default_PinCodeValue = -1;

    public static String SORT_ORDER_ASC = "asc";
    public static String SORT_ORDER_DSC = "desc";
    public static String SORT_ORDER_NOT_SELECTED = "";

    public static String PROSPECT = "Prospect";
    public static String POTENTIAL = "Potential";
    public static String CLIENT = "Client";
    public static String SELECTLEADSTAGE = "Select";

    public static String CompanyName = "CompanyName";
    public static String CompanyAddress = "CompanyAddress";
    public static String NameInitials = "NameInitials";
    public static String PhoneNo = "PhoneNo";
    public static String RandomNo = "RandomNo";
    public static String InterestStatus = "InterestStatus";

    public static String INTEREST_STATUS_INTERESTED = "INTEREST_STATUS_INTERESTED";
    public static String INTEREST_CONTACT_LATER_INTERESTED = "INTEREST_CONTACT_LATER_INTERESTED";
    public static String INTEREST_DOESNT_MEET_CRITERIA_INTERESTED = "INTEREST_DOESNT_MEET_CRITERIA_INTERESTED";
    public static String INTEREST_NOT_INTERESTED_INTERESTED = "INTEREST_NOT_INTERESTED_INTERESTED";

    public static String LEAD_ID = "LEAD_ID";
    public static String MEETING_STATUS = "MEETING_STATUS";
    public static String REQUEST_STATUS = "REQUEST_STATUS";
    public static String NOTIFICATION_ID = "NOTIFICATION_ID";
    public static String LEAD_OBJECT = "LEAD_OBJECT";
    public static Integer DEFAULT_LEAD_ID = -1;
    public static Integer MAX_RANDOM_COLOR_COUNTER_VALUE = 6;
    public static Integer DEFAULT_RANDOM_COLOR_COUNTER_VALUE = 0;

    public static Integer USER_TYPE_BDE = 1;
    public static Integer UPDATE_LEAD_REQUEST_CODE = 2;

    public static String SORT_ORDER_MODIFIED_ASC = "asc";
    public static String SORT_ORDER__DEFAULT_MODIFIED_ASC = "asc";
    public static String SORT_ORDER_MODIFIED_DSC = "desc";

    public static String BUSINESS_SETUP_INDIA = "India";
    public static String BUSINESS_SETUP_FORIEGN = "Foriegn";
    public static String ACTION_ADD_LEAD = "ACTION_ADD_LEAD";
    public static String ACTION_EDIT_LEAD = "ACTION_EDIT_LEAD";

    public static Integer MEETING_REMINDER_SEND_FOLLOWUP = 1;
    public static Integer MEETING_REMINDER_DONOT_SEND_FOLLOWUP = 0;

    public static Integer MEETING_STATUS_SCHEDULED = 1;
    public static Integer MEETING_STATUS_RESCHEDULED = 2;
    public static Integer MEETING_STATUS_INPROGRESS = 3;
    public static Integer MEETING_STATUS_COMPLETE = 4;
    public static Integer MEETING_STATUS_APPROVED = 6;
    public static Integer MEETING_STATUS_CANCELLED = 5;


    public static String COMING_FROM_LEADS_LIST = "COMING_FROM_LEADS_LIST";
    public static String COMING_FROM_CONVERSION_REQUEST = "COMING_FROM_CONVERSION_REQUEST";
    public static String comingFromWhereInLeadsDetailsScreen = "comingFromWhereInLeadsDetailsScreen";
    public static String comingFromWhereInEditMeetingsScreen = "comingFromWhereInEditMeetingsScreen";
    public static String comingFromWhere = "comingFromWhere";
    public static String COMING_FROM_COMPLETED_MEETINGS_LIST = "COMING_FROM_COMPLETED_MEETINGS_LIST";
    public static String COMING_FROM_SCHEDULE_MEETINGS = "COMING_FROM_SCHEDULE_MEETINGS";
    public static String COMING_FROM_LEAD_MEETINGS_LIST = "COMING_FROM_LEAD_MEETINGS_LIST";
    public static String COMING_FROM_EDIT_LEAD_MEETINGS = "COMING_FROM_EDIT_LEAD_MEETINGS";
    public static String COMING_FROM_MEETINGS_LIST = "COMING_FROM_MEETINGS_LIST";

    public static String UPDATE_STAGE_CONVERSION_ACTION = "1";
    public static String UPDATE_STAGE_APPROVAL_REJECTION_ACTION = "2";
    public static String UPDATE_STAGE_REJECTION_ACTION = "reject";
    public static String UPDATE_STAGE_APPROVAL_ACTION = "approve";

    public static final String Retry_Action_Add = "Retry_Action_Add";
    public static final String Retry_Action_Edit = "Retry_Action_Edit";
    public static final String Retry_Action_Submit = "Retry_Action_Submit";
    public static final String Retry_Action_Action_Btns = "Retry_Action_Left_Btn";
    public static final String Retry_Action_Login = "Retry_Action_Login";
    public static final String Retry_Action_Connect_Again = "Retry_Action_Connect_Again";
    public static final String Retry_Action_On_Screen_Opened = "Retry_Action_On_Screen_Opened";
    public static final String Retry_Action_Resend_Otp = "Retry_Action_Resend_Otp";
    public static final String Retry_Action_Verify = "Retry_Action_Verify";
    public static final String Retry_Action_Load_Profile = "Retry_Action_Load_Profile";
    public static final String Retry_Action_Load_Data = "Retry_Action_Load_Data";
    public static final String Retry_Action_Load_Category = "Retry_Action_Load_Category";
    public static final String Retry_Action_Load_Products = "Retry_Action_Load_Products";

    public static final String Action_Move_To_Thankyou = "Action_Move_To_Next_Screen";
    public static final String Action_Move_To_Next_Screen = "Action_Move_To_Next_Screen";
    public static final String Action_Next_Action = "Action_Next_Action";
    public static final String Action_Something_Went_Wrong = "Action_Something_Went_Wrong";
    public static final String Action_Failed_To_Update = "Action_Failed_To_Update";

    public static final String LATITUDE = "LATITUDE";
    public static final String LONGITUDE = "LONGITUDE";

    public static String MEETING_ID = "LEAD_ID";
    public static String STAGE = "STAGE";
    public static String STATUS = "STATUS";
    public static String APPROVE = "APPROVE";
    public static String REJECT = "REJECT";
    public static final String APPROVED= "Approved";
    public static final String REJECTED= "Rejected";
    public static final String PENDING= "Pending";
    public static final int APPROVED_VALUE=3 ;
    public static final int REJECTED_VALUE= 2;
    public static final int PENDING_VALUE= 1;
    public static final int SENT_VALUE= 1;
    public static final int RECIEVED_VALUE= 2;
    public static final String DEVICE_PLATFORM= "ANDROID";
    public static final String REQUESTSENTRECEIVED= "requestSentReceived";
    public static final String REQUESTSTATUS= "REQUESTSTATUS";

    public static final String totalProspect= "totalProspect";
    public static final String totalInlinedMeetings= "totalInlinedMeetings";
    public static final String totalFollowUpsPending= "totalFollowUpsPending";
    public static final String totalFollowUpsUpcoming= "totalFollowUpsUpcoming";
    public static final String totalPotential= "totalPotential";
    public static final String totalClient= "totalClient";
    public static final String totalConversion= "totalConversion";
    public static final String totalUpcomingMeetings= "totalUpcomingMeetings";
    public static final String totalMeetingDone= "totalMeetingDone";
    public static final String totalFollowupMeeting= "totalFollowupMeeting";
    public static final String totalconversionpending= "totalconversionpending";
    public static final String totalconversionreject= "totalconversionreject";
    public static final String totalMeetingsInline= "totalMeetingsInline";
    public static final String totalKycUpload= "totalKycUpload";
    public static final String totalLeads= "totalLeads";

    public static final String whichTabToSet= "whichTabToSet";
    public static final String homeTab= "homeTab";
    public static final String meetingsTab= "meetingsTab";
    public static final String leadsTab= "leadsTab";
    public static final String profileTab= "profileTab";

    public static String LEAD_NAME = "LEAD_NAME";
    public static String REMARK_ID = "REMARK_ID";
    public static String ACTION = "ACTION";
    public static String UPDATESTAGE = "UPDATESTAGE";
    public static String RANDOMCOLORID = "randomColorId";
    public static String isPush = "isPush";
    public static String Yes = "Yes";
    public static String No = "No";
}
