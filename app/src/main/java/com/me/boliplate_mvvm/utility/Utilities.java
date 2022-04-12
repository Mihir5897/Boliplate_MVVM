package com.me.boliplate_mvvm.utility;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.os.Build;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


//import com.google.android.material.bottomsheet.BottomSheetDialog;
//
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.material.textfield.TextInputLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;
import com.me.boliplate_mvvm.R;
import com.me.boliplate_mvvm.app.AppController;
import com.me.boliplate_mvvm.utility.constant.AppConstants;
import com.me.boliplate_mvvm.utility.session.SessionManager;
import com.me.boliplate_mvvm.view.ui.login.ActivityLogin;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;


public class Utilities {
    public static String selectedLanguage;

    public static String getCurrentDateInString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getCurrentDateInStringToShow() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getCurrentDateInStringToSend() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getCurrentTimeInStringToShow() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getCurrentTimeInStringToSend() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getCurrentTimeStampInStringToSend() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:MM:SS");
        Date date = new Date();
        return formatter.format(date);
    }

    public static boolean checkIsStartDateLessOrEqualsEndDate(String fromDateToSend, String toDateToSend) {
        SimpleDateFormat dfDate = new SimpleDateFormat("yyyy-MM-dd");
        boolean b = false;
        try {
            if (dfDate.parse(fromDateToSend).before(dfDate.parse(toDateToSend))) {
                b = true;//If start date is before end date
            } else if (dfDate.parse(fromDateToSend).equals(dfDate.parse(toDateToSend))) {
                b = true;//If two dates are equal
            } else {
                b = false; //If start date is after the end date
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return b;
    }


//    public static String getEndTimeInStringToSend(String time) {
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm");
////        String currentDateandTime = sdf.format(new Date());
////
////        Date date = sdf.parse(currentDateandTime);
////        Calendar calendar = Calendar.getInstance();
////        calendar.setTime(date);
////        calendar.add(Calendar.HOUR, 1);
////
////        System.out.println("Time here " + calendar.getTime());
////        return calendar.getTime();
//    }


    public static String parseDate(String date_str) {
        String inputPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
//        String inputPattern = "yyyy-MM-dd HH:mm:ss";
        String outputPattern = "dd MMMM, yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(date_str);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String parseDate(String date_str, String inputFormate, String outputFormate) {
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputFormate);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputFormate);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(date_str);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return str;
    }


    public static String parseSecondTime(String date_str) {
        String inputPattern = "ss";
        String outputPattern = "hh a";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(date_str);
            str = outputFormat.format(date);
            if (str.contains("0")) {
                str = str.replace("0", "");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return str.toLowerCase();
    }

    public static String parseTime(String date_str) {
        String inputPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        String outputPattern = "HH:mm a";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(date_str);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return str;
    }


//    private static void setanimation(RelativeLayout rlCart, Context context) {
//        final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce);
//        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.1, 40);
//        myAnim.setInterpolator(interpolator);
//        rlCart.startAnimation(myAnim);
//    }


    public static String getFullAddress(Context mActivity, Double currentlat, Double currentLong) {
        Geocoder geocoder;
        List<Address> addresses;
        String city = "", state = "", country = "";
        geocoder = new Geocoder(mActivity, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(currentlat, currentLong, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            city = addresses.get(0).getLocality();
            state = addresses.get(0).getAdminArea();
            country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName(); //

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (city == null) {
            return country;
        } else {
            return city + ", " + country;
        }
    }

    public static Drawable drawableFromUrl(String url) throws IOException {
        Bitmap x;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();

        x = BitmapFactory.decodeStream(input);
        return new BitmapDrawable(Resources.getSystem(), x);
    }



    public static void setDialogAttributes(Dialog dialog) {
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().setBackgroundDrawableResource(R.color.dialog_bg_color);
        dialog.setCancelable(false);
    }


    public static boolean isValidEmailId(String email) {
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }

    // check for string is number
    public static boolean isNumber(final String str) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^[+]?[0-9]{7,16}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean isValidNumber(final String str) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "[0-9]+";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean isPincodeValid(String pinCode) {
        if (pinCode != null && !pinCode.isEmpty() && pinCode.length() == 6) {
            boolean isValid = isValidNumber(pinCode);
            return isValid;

        }
        return false;
    }

    public static void setMaxCharValidationForPhoneNo(String countryCode, EditText phoneEt) {
        if (countryCode != null) {
            if (countryCode.equalsIgnoreCase(AppConstants.uaeCountryCode)) {
                phoneEt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(AppConstants.maxLengthForMobileNoForUae)});
            } else if (countryCode.equalsIgnoreCase(AppConstants.indiaCountryCode)) {
                phoneEt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(AppConstants.maxLengthForMobileNoForIndia)});
            } else if (countryCode.equalsIgnoreCase(AppConstants.chinaCountryCode)) {
                phoneEt.setFilters(new InputFilter[]{new InputFilter.LengthFilter(AppConstants.maxLengthForMobileNoForChina)});
            }
        }
    }

    public static boolean isValidPhoneNumber(CharSequence phoneNumber, String countryCode) {
//India
        if (countryCode.equalsIgnoreCase(AppConstants.indiaCountryCode)) {
            if (phoneNumber.length() == AppConstants.maxLengthForMobileNoForIndia) {
                return true;
            }
        }
        //china
        else if (countryCode.equalsIgnoreCase(AppConstants.chinaCountryCode)) {
            if (phoneNumber.length() == AppConstants.maxLengthForMobileNoForChina) {
                return true;
            }
        }
        //dubai
        else if (countryCode.equalsIgnoreCase(AppConstants.uaeCountryCode)) {
            if (phoneNumber.length() == AppConstants.maxLengthForMobileNoForUae) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPhoneNoValidations(Context context, String phoneNo, String countryCode, View mobileNoLayout, TextView errorTv, TextView phoneNoTitleTv, EditText editText) {
        if (countryCode == null) {
            countryCode = "";
        }
        if (phoneNo == null) {
            phoneNo = "";
        }
        try {
            if (phoneNo != null) {
                if (phoneNo.isEmpty()) {
                    mobileNoLayout.setBackgroundResource(R.drawable.et_error_border);
                    errorTv.setText(context.getResources().getString(R.string.empty_phone_number));
                    if (phoneNoTitleTv != null) {
                        phoneNoTitleTv.setText(Utilities.getErrorMessageForTextInputLayoutHeading(context, context.getResources().getString(R.string.phone_no_title)));
                    }
                    editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_end_error, 0);
                    return false;
                } else if (countryCode.isEmpty()) {
                    errorTv.setText(context.getResources().getString(R.string.empty_country_code));
                    if (phoneNoTitleTv != null) {
                        phoneNoTitleTv.setText(Utilities.getErrorMessageForTextInputLayoutHeading(context, context.getResources().getString(R.string.phone_no_title)));
                    }
                    return false;
                } else if (!Utilities.isValidPhoneNumber(phoneNo, countryCode)) {
                    mobileNoLayout.setBackgroundResource(R.drawable.et_error_border);
                    errorTv.setText(context.getResources().getString(R.string.valid_phone_number));
                    if (phoneNoTitleTv != null) {
                        phoneNoTitleTv.setText(Utilities.getErrorMessageForTextInputLayoutHeading(context, context.getResources().getString(R.string.phone_no_title)));
                    }
                    editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_end_error, 0);
                    return false;
                } else {
                    mobileNoLayout.setBackgroundResource(R.drawable.et_border);
                    errorTv.setText("");
                    if (phoneNoTitleTv != null) {
                        phoneNoTitleTv.setText(context.getResources().getString(R.string.phone_no_title));
                    }
                    //editText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_dialog_cancel_icon, 0);
                    return true;
                }
            }
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
        }

        return false;
    }


    public static void getApplicationLanguage(Activity mActivity) {
        selectedLanguage = SessionManager.get().getSelectedLanguage();
        if (selectedLanguage.equals(AppConstants.LANGUAGE_ENGLISH)) {
            Utilities.setApplicationlanguage(mActivity, AppConstants.LANGUAGE_ENGLISH);
        } else {
            if (selectedLanguage.isEmpty()) {
                Utilities.setApplicationlanguage(mActivity, AppConstants.LANGUAGE_ENGLISH);
            } else {
                Utilities.setApplicationlanguage(mActivity, AppConstants.LANGUAGE_ARABIC);
            }

        }
    }

    public static void setApplicationlanguage(Activity activity, String language) {
        Resources res = activity.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            conf.setLocale(new Locale(language)); // API 17+ only.
        } else {
            conf.locale = new Locale(language);
        }
        try {
            res.updateConfiguration(conf, dm);
            SessionManager.get().setSelectedLanguage(language);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method to hide keyboard
    public static void hideKeyboard(Context mContext) {
        try {
//            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

            ((Activity) mContext).getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
            );

//            InputMethodManager inputManager = (InputMethodManager) mContext
//                    .getSystemService(INPUT_METHOD_SERVICE);
//            inputManager.hideSoftInputFromWindow(((Activity) mContext).getCurrentFocus().getWindowToken(), 0);
        } catch (Exception ignored) {
        }
    }

    public static boolean getNetworkState(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

    public static boolean CheckPermission() {
        if (checkStoragePermission()) {
            return true;
        } else {
            requestPermission();
            return false;
        }
    }

    public static void requestPermission() {
        ActivityCompat.requestPermissions(AppController.getInstance().getActivity(),
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);
    }

    public static boolean checkStoragePermission() {
        return ContextCompat.checkSelfPermission(AppController.getInstance().getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(AppController.getInstance().getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    // Clear All Data from session and Logout
    public static void clearUserDataOnLogout(Context context) {
        SessionManager.get().setLoggedIn(false);
        SessionManager.get().clear();
        Intent logoutIntent = new Intent(context, ActivityLogin.class);
        logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(logoutIntent);
    }


    public static SpannableString getErrorMessageForTextInputLayoutHeading(Context context, String errorMessage) {
        SpannableString ss = new SpannableString(errorMessage);
        ForegroundColorSpan fcsRed = new ForegroundColorSpan(ContextCompat.getColor(context, R.color.error_color));
        ss.setSpan(fcsRed, errorMessage.length() - 1, errorMessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }

    public static void moveTo(Context context, Class activity) {
        try {
            Intent intent = new Intent(context, activity);
            context.startActivity(intent);
        } catch (Exception ignored) {
            Log.d("e", ignored.toString());
        }
    }

    public static void moveToWithData(Context context, Class activity, String key, String value) {
        try {
            Intent intent = new Intent(context, activity);
            intent.putExtra(key, value);
            context.startActivity(intent);
        } catch (Exception ignored) {
        }
    }

    public static void moveToWithData(Context context, Class activity, String key, Integer value) {
        try {
            Intent intent = new Intent(context, activity);
            intent.putExtra(key, value);
            context.startActivity(intent);
        } catch (Exception ignored) {
        }
    }

    public static void moveToAndClearHistory(Context context, Class activity) {
        try {
            Intent intent = new Intent(context, activity);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
        } catch (Exception ignored) {
        }
    }
    public static void moveToWithDataAndClearHistory(Context context, Class activity, String key, String value) {
        try {
            Intent intent = new Intent(context, activity);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra(key, value);
            context.startActivity(intent);
        } catch (Exception ignored) {
        }
    }

    public static void showMessage(Context context, String message) {
        try {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        } catch (Exception ignored) {
        }
    }

    public static boolean setEdittextErrorStyle(Context context, TextInputLayout textInputLayout, TextView textView, @StringRes int edittextErrorMessage, @StringRes int textViewErrorMessage) {
        try {
            textInputLayout.setErrorEnabled(true);
            textInputLayout.setError(context.getResources().getString(edittextErrorMessage));
            String titleErrorMessage = context.getResources().getString(textViewErrorMessage);
            if (titleErrorMessage.contains("*")) {
                textView.setText(Utilities.getErrorMessageForTextInputLayoutHeading(context, titleErrorMessage));
            } else {
                textView.setText(titleErrorMessage);
            }

        } catch (NullPointerException e) {
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean setClearEdittextErrorStyle(Context context, TextInputLayout textInputLayout, TextView textView, @StringRes int textViewErrorMessage) {
        try {
            textInputLayout.setError(null);
            textInputLayout.setErrorEnabled(false);
            textView.setText(context.getResources().getString(textViewErrorMessage));
        } catch (NullPointerException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void showNoNetworkMessage(Context context) {
        try {
            Toast.makeText(context, context.getString(R.string.no_internet_error_msg), Toast.LENGTH_SHORT).show();
        } catch (Exception ignored) {
        }
    }

    public static void setViewVisibile(View view) {
        try {
            view.setVisibility(View.VISIBLE);
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
        }
    }

    public static void setViewGone(View view) {
        try {
            view.setVisibility(View.GONE);
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
        }
    }

    public static void setViewInVisible(View view) {
        try {
            view.setVisibility(View.INVISIBLE);
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
        }
    }




    public static int getUserRole(String userType) {
        int role = -1;
        if (userType != null) {
            if (userType.equalsIgnoreCase("BDE")) {
                role = 1;
            } else if (userType.equalsIgnoreCase("BDM")) {
                role = 2;
            } else if (userType.equalsIgnoreCase("GH")) {
                role = 3;
            } else if (userType.equalsIgnoreCase("Admin")) {
                role = 4;
            } else if (userType.equalsIgnoreCase("Country Head")) {
                role = 5;
            }
        }
        return role;
    }

    public static String getUserRoleType(Integer userRoleId) {
        String role = "";
        if (userRoleId != null) {
            if (userRoleId.equals(1)) {
                role = "BDE";
            } else if (userRoleId.equals(2)) {
                role = "BDM";
            } else if (userRoleId.equals(3)) {
                role = "GH";
            } else if (userRoleId.equals(4)) {
                role = "CountryHead";
            }
        }
        return role;
    }

    public static boolean isUserBde(String userRole) {
        if (userRole != null) {
            if (userRole.equalsIgnoreCase("BDE")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUserBdm(String userRole) {
        if (userRole != null) {
            if (userRole.equalsIgnoreCase("BDM")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUserGHOrCountryHead(String userRole) {
        if (userRole != null) {
            if (userRole.equalsIgnoreCase("GH") || userRole.equalsIgnoreCase("CountryHead")) {
                return true;
            }
        }
        return false;
    }

    public static String getInterestStatusValue(Integer interestStatus) {
        String status = "";
        if (interestStatus != null) {
            if (interestStatus == 1) {
                status = AppConstants.INTEREST_STATUS_INTERESTED;
            } else if (interestStatus == 2) {
                status = AppConstants.INTEREST_CONTACT_LATER_INTERESTED;
            } else if (interestStatus == 3) {
                status = AppConstants.INTEREST_DOESNT_MEET_CRITERIA_INTERESTED;
            } else if (interestStatus == 4) {
                status = AppConstants.INTEREST_NOT_INTERESTED_INTERESTED;
            }
        }
        return status;
    }

    public static int getLeadStageType(String leadStageType) {
        int leadStageId = -1;
        if (leadStageType != null) {
            if (leadStageType.equalsIgnoreCase("Prospect")) {
                leadStageId = 1;
            } else if (leadStageType.equalsIgnoreCase("Potential")) {
                leadStageId = 2;
            } else if (leadStageType.equalsIgnoreCase("Client")) {
                leadStageId = 3;
            }
        }
        return leadStageId;
    }

    public static int getBusinessSetupId(String businessSetup) {
        int businessSetupId = -1;
        if (businessSetup != null) {
            if (businessSetup.equalsIgnoreCase(AppConstants.BUSINESS_SETUP_INDIA)) {
                businessSetupId = 1;
            } else if (businessSetup.equalsIgnoreCase(AppConstants.BUSINESS_SETUP_FORIEGN)) {
                businessSetupId = 2;
            }
        }
        return businessSetupId;
    }

    public static String getBusinessSetupName(Integer businessSetupId) {
        String businessSetupName = "";
        if (businessSetupId != null) {
            if (businessSetupId.equals(1)) {
                businessSetupName = AppConstants.BUSINESS_SETUP_INDIA;
            } else if (businessSetupId.equals(2)) {
                businessSetupName = AppConstants.BUSINESS_SETUP_FORIEGN;
            }
        }
        return businessSetupName;
    }

    public static String getNameInitialFromFirstName(String name) {
        String nameInitial = "";
        if (nameInitial != null) {
            char ch1 = name.charAt(0);
            nameInitial = String.valueOf(ch1);

        }
        return nameInitial;
    }

    public static String capitalizeName(String str) {
        String capitalizeWord = "";
        if (str != null && !str.isEmpty()) {
            String words[] = str.split("\\s");
            for (String w : words) {
                String first = w.substring(0, 1);
                String afterfirst = w.substring(1);
                capitalizeWord += first.toUpperCase() + afterfirst + " ";
            }
        }
        return capitalizeWord.trim();
    }


    public static boolean checkDropDownValidations(Context context, String value, Spinner spinner, TextView errorTv, TextView titleTv, int errorMessageResId, int titleMessageResId) {
        try {
            if (value != null) {
                if (value.isEmpty()) {
                    return setDropDownError(context, spinner, errorTv, titleTv, errorMessageResId, titleMessageResId);
                } else {
                    return clearDropDownError(context, spinner, errorTv, titleTv, errorMessageResId, titleMessageResId);
                }
            } else {
                return setDropDownError(context, spinner, errorTv, titleTv, errorMessageResId, titleMessageResId);
            }
        } catch (NullPointerException e) {
            Log.d("e", e.toString());
        } catch (Exception e) {
            Log.d("e", e.toString());
        }

        return false;
    }

    public static boolean checkDropDownValidations(Context context, Integer value, Spinner spinner, TextView errorTv, TextView titleTv, int errorMessageResId, int titleMessageResId) {
        try {
            if (value != null) {
                if (value == AppConstants.Default_DropDownValue) {
                    return setDropDownError(context, spinner, errorTv, titleTv, errorMessageResId, titleMessageResId);
                } else {
                    return clearDropDownError(context, spinner, errorTv, titleTv, errorMessageResId, titleMessageResId);
                }
            } else {
                return setDropDownError(context, spinner, errorTv, titleTv, errorMessageResId, titleMessageResId);
            }
        } catch (NullPointerException e) {
            Log.d("e", e.toString());
        } catch (Exception e) {
            Log.d("e", e.toString());
        }

        return false;
    }


    public static boolean setDropDownError(Context context, Spinner spinner, TextView errorTv, TextView titleTv, Integer errorMessageResId, Integer titleMessageResId) {
         //spinner.setBackgroundResource(R.drawable.bg_error_spinner);
        // spinner.setBackgroundResource(R.drawable.bg_spinner);
        Utilities.setViewVisibile(errorTv);
        errorTv.setText(context.getResources().getString(errorMessageResId));
        titleTv.setText(Utilities.getErrorMessageForTextInputLayoutHeading(context, context.getResources().getString(titleMessageResId)));
        return false;
    }

    public static boolean clearDropDownError(Context context, Spinner spinner, TextView errorTv, TextView titleTv, Integer errorMessageResId, Integer titleMessageResId) {
       // spinner.setBackgroundResource(R.drawable.bg_spinner);
        Utilities.setViewGone(errorTv);
        errorTv.setText("");
        titleTv.setText(context.getResources().getString(titleMessageResId));
        return true;
    }

    public static int getRandomColorForLeadProfile(Integer randomColor) {
        Integer drawable = null;
        if (randomColor != null) {
            if (randomColor == 0) {
                drawable = Color.parseColor("#FFB700");
            } else if (randomColor == 1) {
                drawable = Color.parseColor("#FF7A00");
            } else if (randomColor == 2) {
                drawable = Color.parseColor("#AD00FF");
            } else if (randomColor == 3) {
                drawable = Color.parseColor("#00B2FF");
            } else if (randomColor == 4) {
                drawable = Color.parseColor("#FF004C");
            } else if (randomColor == 5) {
                drawable = Color.parseColor("#02F870");
            } else if (randomColor == 6) {
                drawable = Color.parseColor("#02F870");
            }

        }
        return drawable;
    }

//    public static void setRandromBackGroundToProfile(TextView nameInitialTv, int randomNum) {
//        if (randomNum == 1) {
//            nameInitialTv.setBackgroundResource(R.drawable.ic_name_initial_first_bg);
//        } else if (randomNum == 2) {
//            nameInitialTv.setBackgroundResource(R.drawable.ic_name_initial_second_bg);
//        } else if (randomNum == 3) {
//            nameInitialTv.setBackgroundResource(R.drawable.ic_name_initial_third_bg);
//        } else if (randomNum == 4) {
//            nameInitialTv.setBackgroundResource(R.drawable.ic_name_initial_fourth_bg);
//        } else if (randomNum == 5) {
//            nameInitialTv.setBackgroundResource(R.drawable.ic_name_initial_fifth_bg);
//        } else if (randomNum == 6) {
//            nameInitialTv.setBackgroundResource(R.drawable.ic_name_initial_sixth_bg);
//        }
//        else {
//            nameInitialTv.setBackgroundResource(R.drawable.ic_name_initial_first_bg);
//        }
//    }

    public static void setInterestStatusViews(String interestStatus, TextView interestedTv, TextView contactLaterTv, TextView doesntMeetTheCriteriaTv, TextView notInterestedTv) {
        if (interestStatus != null) {
            if (interestStatus.equalsIgnoreCase(AppConstants.INTEREST_STATUS_INTERESTED)) {
                Utilities.setViewVisibile(interestedTv);
                Utilities.setViewGone(contactLaterTv);
                Utilities.setViewGone(doesntMeetTheCriteriaTv);
                Utilities.setViewGone(notInterestedTv);
            } else if (interestStatus.equalsIgnoreCase(AppConstants.INTEREST_CONTACT_LATER_INTERESTED)) {
                Utilities.setViewVisibile(contactLaterTv);
                Utilities.setViewGone(interestedTv);
                Utilities.setViewGone(doesntMeetTheCriteriaTv);
                Utilities.setViewGone(notInterestedTv);
            } else if (interestStatus.equalsIgnoreCase(AppConstants.INTEREST_DOESNT_MEET_CRITERIA_INTERESTED)) {
                Utilities.setViewGone(contactLaterTv);
                Utilities.setViewGone(interestedTv);
                Utilities.setViewVisibile(doesntMeetTheCriteriaTv);
                Utilities.setViewGone(notInterestedTv);
            } else if (interestStatus.equalsIgnoreCase(AppConstants.INTEREST_NOT_INTERESTED_INTERESTED)) {
                Utilities.setViewVisibile(notInterestedTv);
                Utilities.setViewGone(contactLaterTv);
                Utilities.setViewGone(interestedTv);
                Utilities.setViewGone(doesntMeetTheCriteriaTv);
            }
        }
    }



    public static boolean doesntContainsSpecialCharacters(String str) {
        boolean isValid = false;
        String expression = "^[a-z_A-Z0-9 ]*$";
        CharSequence inputStr = str;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean doesntContainsSpecialCharactersForName(String str) {
        boolean isValid = false;
        String expression = "^[a-zA-Z ]*$";
        CharSequence inputStr = str;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

//    public static String getDashBoardCardsTitleAccToKey(String key, Context context) {
//        String value = "";
//        if (key != null && !key.isEmpty()) {
//            if (key != null) {
//                if (key.equalsIgnoreCase(AppConstants.totalProspect)) {
//                    value = context.getResources().getString(R.string.totalProspect);
//                } else if (key.equalsIgnoreCase(AppConstants.totalInlinedMeetings)) {
//                    value = context.getResources().getString(R.string.totalInlinedMeetings);
//                } else if (key.equalsIgnoreCase(AppConstants.totalFollowUpsPending)) {
//                    value = context.getResources().getString(R.string.totalFollowUpsPending);
//                } else if (key.equalsIgnoreCase(AppConstants.totalFollowUpsUpcoming)) {
//                    value = context.getResources().getString(R.string.totalFollowUpsUpcoming);
//                } else if (key.equalsIgnoreCase(AppConstants.totalPotential)) {
//                    value = context.getResources().getString(R.string.totalPotential);
//                } else if (key.equalsIgnoreCase(AppConstants.totalClient)) {
//                    value = context.getResources().getString(R.string.totalClient);
//                } else if (key.equalsIgnoreCase(AppConstants.totalConversion)) {
//                    value = context.getResources().getString(R.string.totalConversion);
//                } else if (key.equalsIgnoreCase(AppConstants.totalUpcomingMeetings)) {
//                    value = context.getResources().getString(R.string.totalUpcomingMeetings);
//                } else if (key.equalsIgnoreCase(AppConstants.totalMeetingDone)) {
//                    value = context.getResources().getString(R.string.totalMeetingDone);
//                } else if (key.equalsIgnoreCase(AppConstants.totalFollowupMeeting)) {
//                    value = context.getResources().getString(R.string.totalFollowupMeeting);
//                } else if (key.equalsIgnoreCase(AppConstants.totalconversionpending)) {
//                    value = context.getResources().getString(R.string.totalconversionpending);
//                } else if (key.equalsIgnoreCase(AppConstants.totalconversionreject)) {
//                    value = context.getResources().getString(R.string.totalconversionreject);
//                } else if (key.equalsIgnoreCase(AppConstants.totalMeetingsInline)) {
//                    value = context.getResources().getString(R.string.totalMeetingsInline);
//                } else if (key.equalsIgnoreCase(AppConstants.totalKycUpload)) {
//                    value = context.getResources().getString(R.string.totalKycUpload);
//                } else if (key.equalsIgnoreCase(AppConstants.totalLeads)) {
//                    value = context.getResources().getString(R.string.totalLeads);
//                }
//            }
//        }
//        return value;
//    }

//    public static void setDialogSheetBg(BottomSheetDialog dialog) {
//        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//    }

    public static void restrictSpecialCharacter(TextInputLayout textInputLayout) {
//        InputFilter filter = new InputFilter() {
//            public CharSequence filter(CharSequence source, int start, int end,
//                                       Spanned dest, int dstart, int dend) {
//                for (int i = start; i < end; i++) {
//                    if (!Character.isLetter(source.charAt(i)) && !Character.isSpaceChar(source.charAt(i))) {
//                        return "";
//                    }
//                }
//                return null;
//            }
//        };
//        textInputLayout.getEditText().setFilters(new InputFilter[]{filter});
        InputFilter filter = new InputFilter() {
            //        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
//            if (source instanceof SpannableStringBuilder) {
//                SpannableStringBuilder sourceAsSpannableBuilder = (SpannableStringBuilder) source;
//                for (int i = end - 1; i >= start; i--) {
//                    char currentChar = source.charAt(i);
//                    if (i < mAlphabetCount) {
//                        if (!Character.isLetter(currentChar)) {
//                            sourceAsSpannableBuilder.delete(i, i + 1);
//                        }
//                    } else {
//                        if (!Character.isDigit(currentChar)) {
//                            sourceAsSpannableBuilder.delete(i, i + 1);
//                        }
//                    }
//                }
//                return source;
//            } else {
//                StringBuilder filteredStringBuilder = new StringBuilder();
//                for (int i = start; i < end; i++) {
//                    char currentChar = source.charAt(i);
//                    if (dest.length() < mAlphabetCount) {
//                        if (Character.isLetter(currentChar)) {
//                            filteredStringBuilder.append(currentChar);
//                        }
//                    } else {
//                        if (Character.isDigit(currentChar)) {
//                            filteredStringBuilder.append(currentChar);
//                        }
//                    }
//                }
//                return filteredStringBuilder.toString();
//            }
//        }
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {

                if (source instanceof SpannableStringBuilder) {
                    SpannableStringBuilder sourceAsSpannableBuilder = (SpannableStringBuilder) source;
                    for (int i = end - 1; i >= start; i--) {
                        char currentChar = source.charAt(i);
                        if (!Character.isLetter(currentChar) && !Character.isSpaceChar(currentChar)) {
                            sourceAsSpannableBuilder.delete(i, i + 1);
                        }
                    }
                    return source;
                } else {
                    StringBuilder filteredStringBuilder = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        char currentChar = source.charAt(i);
                        if (Character.isLetter(currentChar) || Character.isSpaceChar(currentChar)) {
                            filteredStringBuilder.append(currentChar);
                        }
                    }
                    return filteredStringBuilder.toString();
                }
            }
        };
        textInputLayout.getEditText().setFilters(new InputFilter[]{filter});
    }

    public static void restrictSomeSpecialCharacter(TextInputLayout textInputLayout) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                if (source instanceof SpannableStringBuilder) {
                    SpannableStringBuilder sourceAsSpannableBuilder = (SpannableStringBuilder) source;
                    for (int i = end - 1; i >= start; i--) {
                        char currentChar = source.charAt(i);

                        if (!Character.isLetter(currentChar) && !Character.isSpaceChar(currentChar)) {
                            if (currentChar=='.'||currentChar=='-'){

                            }else {
                                sourceAsSpannableBuilder.delete(i, i + 1);
                            }

                        }
                    }
                    return source;
                } else {
                    StringBuilder filteredStringBuilder = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        char currentChar = source.charAt(i);
                        if (Character.isLetter(currentChar) || Character.isSpaceChar(currentChar)||currentChar=='.'||currentChar=='-') {

                            filteredStringBuilder.append(currentChar);
                        }
                    }
                    return filteredStringBuilder.toString();
                }
            }
        };
        textInputLayout.getEditText().setFilters(new InputFilter[]{filter});

    }
public static void restrictAddressCharacter(TextInputLayout textInputLayout) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                if (source instanceof SpannableStringBuilder) {
                    SpannableStringBuilder sourceAsSpannableBuilder = (SpannableStringBuilder) source;
                    for (int i = end - 1; i >= start; i--) {
                        char currentChar = source.charAt(i);
                        if (!Character.isLetterOrDigit(currentChar) && !Character.isSpaceChar(currentChar)) {//&& currentchar=='π'
                            if (currentChar=='.'||currentChar=='-'||currentChar=='/'||currentChar==','){

                            }else {
                                sourceAsSpannableBuilder.delete(i, i + 1);
                            }

                        }
                    }
                    return source;
                } else {
                    StringBuilder filteredStringBuilder = new StringBuilder();
                    for (int i = start; i < end; i++) {
                        char currentChar = source.charAt(i);
                        if (Character.isLetterOrDigit(currentChar) || Character.isSpaceChar(currentChar)||
                                currentChar=='.'||currentChar=='-'||currentChar=='/'||currentChar==',') {

                            filteredStringBuilder.append(currentChar);
                        }
                    }
                    return filteredStringBuilder.toString();
                }
            }
        };
        textInputLayout.getEditText().setFilters(new InputFilter[]{filter});

    }

}
