package com.me.boliplate_mvvm.view.ui.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;

import androidx.room.Room;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.me.boliplate_mvvm.R;
import com.me.boliplate_mvvm.databinding.ActivitySigninBinding;
import com.me.boliplate_mvvm.service.model.RoomDatabase.UserDao;
import com.me.boliplate_mvvm.service.model.RoomDatabase.UserDataBase;
import com.me.boliplate_mvvm.service.model.entity.User;
import com.me.boliplate_mvvm.utility.Utilities;
import com.me.boliplate_mvvm.view.base.BaseActivity;
import com.me.boliplate_mvvm.view.ui.home.MainActivity;
import com.me.boliplate_mvvm.view.ui.signup.ActivitySignup;

import java.util.Arrays;
import java.util.Locale;

//import dagger.hilt.android.AndroidEntryPoint;

//@AndroidEntryPoint
public class ActivityLogin extends BaseActivity implements View.OnClickListener {
    private static final int RC_SIGN_IN = 7;
    Activity mActivity;
    ActivitySigninBinding mBinding;
    // LoginViewModel mViewModel;

    UserDao db;
    UserDataBase dataBase;
    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;
    CallbackManager callbackManager;
    AlertDialog alertDialog1;
    CharSequence[] values = {"English", "Hindi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = ActivityLogin.this;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_signin);
        // mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        dataBase = Room.databaseBuilder(ActivityLogin.this, UserDataBase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        callbackManager = CallbackManager.Factory.create();




        initClickListeners();
//        initEditorActionClickListeners();
//        initTextWatchers();
//        initFocusChangeListeners();
//        initOnTouchListeners();


//        mBinding.spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
//                setCountryPickerItemClickAction(clickedItem);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    }
public void facebookLoginorNot(){
    LoginManager.getInstance().registerCallback(callbackManager,
            new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    Utilities.moveTo(ActivityLogin.this, MainActivity.class);
                    finish();
                }

                @Override
                public void onCancel() {
                    // App code
                }

                @Override
                public void onError(FacebookException exception) {
                    // App code
                }
            });
}

    private void initEditorActionClickListeners() {

    }

    private void initTextWatchers() {
//

    }

    private void initFocusChangeListeners() {

    }

    private void initOnTouchListeners() {

    }

    private void initClickListeners() {
        mBinding.loginBtn.setOnClickListener(this);
        mBinding.registerTv.setOnClickListener(this);
        mBinding.google.setOnClickListener(this);
        mBinding.facebook.setOnClickListener(this);
        mBinding.langyageBtn.setOnClickListener(this);
    }


    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registerTv:
                Utilities.moveTo(this, ActivitySignup.class);
                break;
            case R.id.loginBtn:
                loginUserData();
                //performLoginBtnClickAction();
//                loginUserDataFiredata();
                break;
            case R.id.google:
                googleLogin();
                break;
            case R.id.facebook:
                facebookLogin();
                break;
            case R.id.langyageBtn:
                CreateAlertDialogWithRadioButtonGroup();
                break;
        }
    }

    private void facebookLogin() {
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
    }

    private void googleLogin() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        //  Toast.makeText(this,"OnActivityResultCalled"+requestCode,Toast.LENGTH_SHORT).show();
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            try {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                task.getResult(ApiException.class);
                Utilities.moveTo(mActivity, MainActivity.class);
            } catch (ApiException e) {
                Toast.makeText(mActivity, "Something Wrong", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    //    public void hitLoginApi() {
//        if (NetworkHandler.isConnected(mBinding.getRoot())) {
//            showHideProgressDialog(true);
//            //mViewModel.setLoginReq(mViewModel.getRequest(final_PhoneNo));
//            if (!mViewModel.getLoginResponse().hasObservers()) {
//                mViewModel.getLoginResponse().observe(this, response -> {
//                    showHideProgressDialog(false);
//                    try {
//                        handleLoginResponse(response);
//                    } catch (Exception e) {
//                        ErrorHandler.showServerErrorMsg(mBinding.getRoot());
//                        e.printStackTrace();
//                    }
//                });
//            }
//        } else {
//          //  showNoInternetDialog(AppConstants.Retry_Action_Login);
//        }
//    }
//
//    private void handleLoginResponse(LoginResponse apiResponse) {
//        if (apiResponse != null) {
//            if (apiResponse.getStatus() == AppConstants.STATUS_SUCCESSFUL) {
//                if (apiResponse.getUser_account_status().equalsIgnoreCase(AppConstants.STATUS_ACTIVE)) {
//                    Utilities.showMessage(this, String.valueOf(apiResponse.getOtp()));
//                    //showSuccessErrorDialog(apiResponse.getMessage(), true, AppConstants.Action_Move_To_Next_Screen);
//                } else if (apiResponse.getUser_account_status().equalsIgnoreCase(AppConstants.STATUS_PENDING)) {
//                    Utilities.showMessage(this, String.valueOf(apiResponse.getOtp()));
//                    //showSuccessErrorDialog(apiResponse.getMessage(), false, AppConstants.Action_Move_To_Next_Screen);
//                } else {
//                   // showSuccessErrorDialog(apiResponse.getMessage(), false, "");
//                }
//            } else if (apiResponse.getStatus() == AppConstants.STATUS_UN_SUCCESSFUL) {
////                if (apiResponse.getUser_account_status().equalsIgnoreCase(AppConstants.STATUS_PENDING)) {
////                    goToVerify();
////                } else {
//               // showSuccessErrorDialog(apiResponse.getMessage(), false, "");
////                }
//
//            }
//        }
//    }
//
//    private void goToVerify() {
//       // Utilities.moveToWithData(this, ActivityVerificationDuringLogin.class, PrefConstant.MOBILE, final_PhoneNo);
//    }
//
//    private void goToThankyouScreen() {
//       // Utilities.moveToAndClearHistory(this, ActivityThankyouForRegistration.class);
//        finish();
//    }
//
//    private boolean checkValidation() {
//        phoneNo = mBinding.phoneEt.getText().toString().trim();
//        isPhoneNoValid = Utilities.checkPhoneNoValidations(this, phoneNo, countryCode, mBinding.mobileNoLayout, mBinding.errorTv, null, mBinding.phoneEt);
//        if (isPhoneNoValid) {
//            final_PhoneNo = countryCode + phoneNo;
//        }
//        return isPhoneNoValid;
//
//    }
    public void loginUserData() {
        String email = mBinding.emailInputLayout.getEditText().getText().toString().trim();
        String password = mBinding.passeordInputLayout.getEditText().getText().toString().trim();

        User user = db.getUser(email, password);
        if (user != null) {
            Intent i = new Intent(ActivityLogin.this, MainActivity.class);
            i.putExtra("User", user);
            startActivity(i);
            finish();
        } else {
            Toast.makeText(ActivityLogin.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
        }
    }
    public void loginUserDataFiredata() {
        String phone = mBinding.emailInputLayout.getEditText().getText().toString().trim();
        String password = mBinding.passeordInputLayout.getEditText().getText().toString().trim();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");
        Query exitUser = (Query) myRef.orderByChild("mobileNumber").equalTo(phone);
        exitUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String passwordFromDb ="111111";
                     passwordFromDb = snapshot.child(phone).child("password").getValue(String.class);
                    if (passwordFromDb.equals(password)){
                        String nameDB = snapshot.child(phone).child("firstName").getValue(String.class);
                        Intent i = new Intent(ActivityLogin.this, MainActivity.class);
                        i.putExtra("fname", nameDB);
                        startActivity(i);
                        finish();
                    }else {
                        Toast.makeText(ActivityLogin.this, "Password Wrong", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(ActivityLogin.this, "Unregistered user", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


//    private void performLoginBtnClickAction() {
//        if (checkValidation()) {
//
//            hitLoginApi();
//        }
//    }


//    @Override
//    protected void onPause() {
//        super.onPause();
//        showHideProgressDialog(false);
//    }

    public void CreateAlertDialogWithRadioButtonGroup() {


        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityLogin.this);

        builder.setTitle("Select Your Choice");

        builder.setSingleChoiceItems(values, -1, (DialogInterface.OnClickListener) (dialog, item) -> {

            switch (item) {
                case 0:
                    updateLanguage("en");
                    break;
                case 1:
                    updateLanguage("hi");
                    break;

            }
            alertDialog1.dismiss();
        });
        alertDialog1 = builder.create();
        alertDialog1.show();

    }

    @Override
    public void recreate() {
        if (android.os.Build.VERSION.SDK_INT >= 14) {
            super.recreate();
        } else {
            startActivity(getIntent());
            finish();
        }
    }

    private void updateLanguage(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences languagepref = getSharedPreferences("language", MODE_PRIVATE);
        SharedPreferences.Editor editor = languagepref.edit();
        editor.putString("languageToLoad", language);
        editor.apply();

        recreate();
    }
}