package com.me.boliplate_mvvm.service.api;


import com.me.boliplate_mvvm.service.model.request.LoginRequest;
import com.me.boliplate_mvvm.service.model.request.SignUpRequest;
import com.me.boliplate_mvvm.service.model.response.LoginResponse;
import com.me.boliplate_mvvm.service.model.response.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    //stagging admin portal to verify users
    // http://3.111.20.233/user/
    //development admin portal to verify users
    //  http://15.206.216.242/users

    @POST(ApiConstant.SIGNUP)
    Call<SignUpResponse> doSignup(@Body SignUpRequest requestBody);
//
//    @POST(ApiConstant.VERIFY_OTP_DURING_REGISTRATION)
//    Call<VerifyOtpResponse> doVerifyOtpDuringRegistarion(@Body VerifyOtpRequest requestBody);
//
//    @POST(ApiConstant.VERIFY_OTP_DURING_LOGIN)
//    Call<VerifyOtpResponse> doVerifyOtpDuringLogin(@Body VerifyOtpRequest requestBody);
//
//    @POST(ApiConstant.RESEND_OTP)
//    Call<ResendOtpResponse> doResendOtp(@Body ResendOtpRequest requestBody);
//
//    @POST(ApiConstant.RESEND_OTP)
//    Call<ResendOtpResponse> doResendOtpDuringLogin(@Body ResendOtpRequest requestBody);
//
    @POST(ApiConstant.LOGIN)
    Call<LoginResponse> doLogin(@Body LoginRequest requestBody);
//
//    @POST(ApiConstant.ADD_LEAD)
//    Call<AddLeadResponse> doAddLead(@Body AddLeadRequest requestBody);
//
//    @PUT(ApiConstant.UPDATE_LEAD)
//    Call<AddLeadResponse> doUpdateLead(@Path("leadid") int leadid, @Body AddLeadRequest requestBody);
//
//    @GET(ApiConstant.USER_ROLES)
//    Call<UserRolesResponse> getUserRoles();
//
//    @GET(ApiConstant.PROFILE_DETAILS)
//    Call<ProfileResponse> getProfileDetails();
//
//    @PUT(ApiConstant.UPDATE)
//    Call<UpdateProfileResponse> doUpdateProfile(@Body UpdateProfileRequest requestBody);
//
//
//    @GET(ApiConstant.Countries)
//    Call<CountriesResponse> getCountries();
//
//    @GET(ApiConstant.States)
//    Call<StateResponse> getStates(@Path("id") int id);
//
//    @GET(ApiConstant.Cities)
//    Call<CityResponse> getCities(@Path("id") int id);
//
//
//    @GET(ApiConstant.USER_INTEREST)
//    Call<UserInterestResponse> getUserInterest();
//
//    @GET(ApiConstant.CATEGORIES)
//    Call<CategoryResponse> getCategories();
//
//    @GET(ApiConstant.ORIGIN)
//    Call<OriginListResponse> getOrigin();
//
//
//    @GET(ApiConstant.PRODUCTS_LIST_ACC_TO_CATEORIES)
//    Call<ProductsListResponse> getProductsListAccToCategories(@Query("category_id") int id);
//
//    @GET(ApiConstant.LEADS_LIST)
//    Call<LeadsListResponse> getLeadsList(@Path("offset") int offset, @Query("name") String name, @Query("product") String product, @Query("stage") String stage, @Query("page") int page, @Query("sortByName") String sort, @Query("sortByDate") String sortByDate, @Query("start_date") String start_date, @Query("end_date") String end_date, @Query("country") String country, @Query("state") String state, @Query("city") String city, @Query("lead_id") String lead_id);
//
//    // http://127.0.0.1:8000/api/leads/10?name=s&product=s&stage=prospect&page=1&sort=a-z
//
//    @POST(ApiConstant.ADD_REMARKS)
//    Call<AddRemarksResponse> doAddRemarks(@Path("leadid") int leadid, @Body AddRemarksRequest requestBody);
//
//    @GET(ApiConstant.BUSINESS_INTEREST)
//    Call<BusinessInterestResponse> getBusinessInterest();
//
//    @GET(ApiConstant.BUSINESS_TYPES)
//    Call<BusinessTypeResponse> getBusinessType();
//
//    @GET(ApiConstant.BUSINESS_SIZE)
//    Call<BusinessSizeResponse> getBusinessSize();
//
////    @GET(ApiConstant.REMARKS_LIST)
////    Call<RemarksListResponse> getRemarksList(@Path("leadid") int leadid,@Path("offset") int offset, @Query("name") String name, @Query("page") int page, @Query("sortByName") String sort, @Query("sortByDate") String sortByDate);
//
//
//    @GET(ApiConstant.REMARKS_LIST)
//    Call<RemarksListResponse> getRemarksList(@Path("leadid") int leadid, @Query("name") String name, @Query("page") int page, @Query("sortByName") String sort, @Query("sortByDate") String sortByDate);
//
//    @PUT(ApiConstant.EDIT_REMARKS)
//    Call<EditRemarkResponse> doEditRemarks(@Path("remarkid") int remarkid, @Body EditRemarkRequest requestBody);
//
//    @POST(ApiConstant.SCHEDULE_MEETINGS)
//    Call<ScheduleMeetingsResponse> doScheduleMeeting(@Path("leadid") int leadid, @Body ScheduleMeetingRequest requestBody);
//
//    @GET(ApiConstant.MEETINGS_LIST)
//    Call<LeadMeetingsResponse> getLeadMeetingsList(@Path("leadid") int leadid, @Query("page") int page);
//
//    @PUT(ApiConstant.UPDATE_MEETINGS)
//    Call<EditLeadMeetingResponse> doEditMeeting(@Path("meetingid") int meetingid, @Query("reminder") String reminder, @Body EditLeadMeetingsRequest requestBody);
//
//    @PUT(ApiConstant.UPDATE_MEETINGS)
//    Call<EditLeadMeetingResponse> doChangeMeetingStatus(@Path("meetingid") int meetingid, @Query("stage") String stage, @Query("status") String status, @Body ChangeMeetingStatusRequest requestBody);
//
//
//    @PUT(ApiConstant.UPDATE_LEAD)
//    Call<UpdateLeadStageResponse> doUpdateLeadStage(@Path("leadid") int leadid, @Query("updatestage") String updatestage, @Query("action") String action, @Body UpdateLeadStageRequest requestBody);
//
//    @GET(ApiConstant.LEADS_LIST)
//    Call<LeadsListResponse> getConversionRequestsList(@Path("offset") int offset, @Query("page") int page, @Query("conversion_list") String conversion_list, @Query("request_stage_status") String request_stage_status, @Query("request_status") String request_status, @Query("sortByDate") String sortByDate);
//
//    @GET(ApiConstant.MEETINGS_LIST_BY_USER)
//    Call<LeadMeetingsResponse> getMeetingsListByUser(@Query("page") int page, @Query("action_list") String action_list, @Query("request_status") String request_status, @Query("meetinginline") String meetinginline, @Query("upcomingmeetingfollowup") String upcomingmeetingfollowup, @Query("todaysfollowup") String todaysfollowup, @Query("meetingdone") String meetingdone, @Query("upcomingmeetings") String upcomingmeetings, @Query("totalfollowups") String totalfollowups);
//
//    @GET(ApiConstant.MEETINGS_LIST_BY_USER)
//    Call<LeadMeetingsResponse> getMeetingsListByUser(@Query("page") int page, @Query("action_list") String action_list, @Query("request_status") String request_status, @Query("meetinginline") String meetinginline, @Query("upcomingmeetingfollowup") String upcomingmeetingfollowup, @Query("todaysfollowup") String todaysfollowup, @Query("meetingdone") String meetingdone, @Query("upcomingmeetings") String upcomingmeetings, @Query("totalfollowups") String totalfollowups, @Query("meeting_id") String meeting_id);
//
//    @GET(ApiConstant.ACTIVITY_LOG_LIST)
//    Call<ActivityLogListResponse> getActivityLogList(@Query("offset") String offset,@Query("page") String page);
//
//    @GET(ApiConstant.GET_DASHBOARD)
//    Call<DashboardResponse> getListForDashBoard(@Query("start_date") String start_date, @Query("end_date") String end_date);
//
//    @GET(ApiConstant.GET_DASHBOARD)
//    Call<DashboardBdeResponse> getListForBdeDashBoard(@Query("start_date") String start_date, @Query("end_date") String end_date);
//
//    @GET(ApiConstant.GET_DASHBOARD)
//    Call<DashboardBdmResponse> getListForBdmDashBoard(@Query("start_date") String start_date, @Query("end_date") String end_date);
//
//    @GET(ApiConstant.GET_DASHBOARD)
//    Call<DashboardChGhResponse> getListForChGhDashBoard(@Query("start_date") String start_date, @Query("end_date") String end_date);
//
//
//    @GET(ApiConstant.NOTIFICATIONS)
//    Call<NotificationsResponse> getNotificationList();
//
//    @GET(ApiConstant.UPLOAD)
//    Call<ProfileImageResponse> doUpdateProfileImage(@Query("imageType") String imageType);
//
//    @GET(ApiConstant.CLEAR_ALL_NOTIFICATIONS)
//    Call<NotificationsResponse> clearAllNotifications();
//
//    @GET(ApiConstant.LOGOUT)
//    Call<LogoutResponse> logout();

}
