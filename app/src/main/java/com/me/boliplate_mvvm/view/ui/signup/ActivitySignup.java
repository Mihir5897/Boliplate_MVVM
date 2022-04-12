package com.me.boliplate_mvvm.view.ui.signup;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.me.boliplate_mvvm.R;
import com.me.boliplate_mvvm.databinding.ActivitySignupBinding;
import com.me.boliplate_mvvm.service.model.RoomDatabase.UserDao;
import com.me.boliplate_mvvm.service.model.RoomDatabase.UserDataBase;
import com.me.boliplate_mvvm.service.model.entity.User;
import com.me.boliplate_mvvm.utility.Utilities;
import com.me.boliplate_mvvm.view.base.BaseActivity;
import com.me.boliplate_mvvm.view.ui.login.ActivityLogin;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class ActivitySignup extends BaseActivity implements View.OnClickListener {
//     SignupViewModel mViewModel;
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    Activity mActivity;
    ActivitySignupBinding mBinding;
    String phoneNo;
    String firstName, lastName, email, password;
    boolean isFirstNameValid;
    boolean isLastNameValid;
    boolean isEmailValid;
    boolean isPhoneNoValid;
    boolean isPasswordValid;
    String Image_name, extension, filename;
    Uri fileURI;

     UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = ActivitySignup.this;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
//         mViewModel = ViewModelProviders.of(this).get(SignupViewModel.class);
        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();
        initClickListeners();
        // initTextWatchers();
        // initFocusChangeListeners();
        //  checkNetworkAndShowDailog();
    }


    //    private void initTextWatchers() {
//
//        mBinding.firstNameInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                firstName = mBinding.firstNameInputLayout.getEditText().getText().toString();
//                isFirstNameValid = isFirstNameValid(firstName);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        mBinding.lastNameInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                lastName = mBinding.lastNameInputLayout.getEditText().getText().toString();
//                isLastNameValid = isLastNameValid(lastName);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        mBinding.emailInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                email = mBinding.emailInputLayout.getEditText().getText().toString().trim();
//                isEmailValid = isEmailValid(email);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        mBinding.phoneEt.getEditText().addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                phoneNo = mBinding.phoneEt.getEditText().getText().toString().trim();
//                isPhoneNoValid = isPhoneNoValid(phoneNo);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//    }
//
//    private void initFocusChangeListeners() {
//        mBinding.phoneEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (!hasFocus) {
//                    // code to execute when EditText loses focus
//                    if (!mBinding.phoneEt.hasFocus()) {
//                        mBinding.phoneEt.getEditText().setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
//                    }
//                }
//            }
//        });
//    }
//
//
    private void initClickListeners() {
        mBinding.registerBtn.setOnClickListener(this);
        // mBinding.cameraImgView.setOnClickListener(this);
        // mBinding.backImgView.setOnClickListener(this);
        mBinding.loginTv.setOnClickListener(this);
        //mBinding.userTypeSpinner.setOnItemSelectedListener(this);
    }
//
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        Log.i(TAG, "onRequestPermissionResult");
//        if (grantResults.length <= 0) {
//            Log.i(TAG, "User interaction was cancelled.");
//        } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            if (requestCode == MY_CAMERA_PERMISSION_CODE) {
//                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(cameraIntent, CAMERA_REQUEST);
//            }
//        } else {
//            finishAffinity();
//        }
//    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.registerBtn:
                // performRegisterBtnClickAction();
                addUserData();
//                addUserDataFireBases();
//                addUserDataFireStore();
                break;

            case R.id.loginTv:
                Utilities.moveTo(this, ActivityLogin.class);
                break;

            case R.id.cameraImgView:
                //openbottomSheetDialog();
                break;

        }
    }




//    public void hitSignUpApi() {
//        if (NetworkHandler.isConnected(mBinding.getRoot())) {
//            showHideProgressDialog(true);
//            mViewModel.setSignupReq(mViewModel.getRequest(firstName, lastName, email,  phoneNo,Image_name));
//            if (!mViewModel.getSignupResponse().hasObservers()) {
//                mViewModel.getSignupResponse().observe(this, response -> {
//                    showHideProgressDialog(false);
//                    try {
//                        handleSignUpResponse(response);
//                    } catch (Exception e) {
//                        ErrorHandler.showServerErrorMsg(mBinding.getRoot());
//                        e.printStackTrace();
//                    }
//                });
//            }
//        } else {
//            //showNoInternetDialog(AppConstants.Retry_Action_Submit);
//        }
//    }


//    private void handleSignUpResponse(SignUpResponse apiResponse) {
//        if (apiResponse != null) {
//            if (apiResponse.getStatus() == AppConstants.STATUS_SUCCESSFUL) {
//                Utilities.showMessage(this, String.valueOf(apiResponse.getOtp()));
//               // showSuccessErrorDialog(apiResponse.getMessage(), true, AppConstants.Action_Move_To_Next_Screen);
//            } else if (apiResponse.getStatus() == AppConstants.STATUS_UN_SUCCESSFUL) {
//                Utilities.showMessage(this, apiResponse.getMessage());
//               // showSuccessErrorDialog(apiResponse.getMessage(), false, "");
//            }
//        }
//    }


    private void goToVerify() {
        // Utilities.moveToWithData(this, ActivityVerifictaion.class, PrefConstant.MOBILE, final_PhoneNo);
    }


//    @SuppressLint("UseCompatLoadingForDrawables")
//    private boolean checkValidation() {
//        firstName = mBinding.firstNameInputLayout.getEditText().getText().toString().trim();
//        lastName = mBinding.lastNameInputLayout.getEditText().getText().toString().trim();
//        email = mBinding.emailInputLayout.getEditText().getText().toString().trim().trim();
//        password = mBinding.passeordInputLayout.getEditText().getText().toString().trim().trim();
//        phoneNo = mBinding.phoneEt.getEditText().getText().toString().trim();
//
//        isFirstNameValid = isFirstNameValid(firstName);
//        isLastNameValid = isLastNameValid(lastName);
//        isEmailValid = isEmailValid(email);
//        isPhoneNoValid = isPhoneNoValid(phoneNo);
//
//
//
//        if (isFirstNameValid && isLastNameValid && isEmailValid && isPhoneNoValid ) {
//
//            return true;
//        } else {
//            return false;
//        }
//    }

    public void addUserData() {
        firstName = mBinding.firstNameInputLayout.getEditText().getText().toString().trim();
        lastName = mBinding.lastNameInputLayout.getEditText().getText().toString().trim();
        email = mBinding.emailInputLayout.getEditText().getText().toString().trim().trim();
        password = mBinding.passeordInputLayout.getEditText().getText().toString().trim().trim();
        phoneNo = mBinding.phoneEt.getEditText().getText().toString().trim();

        User user = new User(firstName, lastName, email, phoneNo, password);
        userDao.insert(user);
        Toast.makeText(ActivitySignup.this, "User Register", Toast.LENGTH_SHORT).show();

        Utilities.moveTo(this, ActivityLogin.class);

    }

    public void addUserDataFireBases() {
        firstName = mBinding.firstNameInputLayout.getEditText().getText().toString().trim();
        lastName = mBinding.lastNameInputLayout.getEditText().getText().toString().trim();
        email = mBinding.emailInputLayout.getEditText().getText().toString().trim().trim();
        password = mBinding.passeordInputLayout.getEditText().getText().toString().trim().trim();
        phoneNo = mBinding.phoneEt.getEditText().getText().toString().trim();

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");

        User user = new User(firstName, lastName, email, phoneNo, password);
        myRef.child(phoneNo).setValue(user);
        Utilities.moveTo(this, ActivityLogin.class);

    }
    private void addUserDataFireStore() {
        firstName = mBinding.firstNameInputLayout.getEditText().getText().toString().trim();
        lastName = mBinding.lastNameInputLayout.getEditText().getText().toString().trim();
        email = mBinding.emailInputLayout.getEditText().getText().toString().trim().trim();
        password = mBinding.passeordInputLayout.getEditText().getText().toString().trim().trim();
        phoneNo = mBinding.phoneEt.getEditText().getText().toString().trim();

        // Write a message to the database
        FirebaseFirestore database = FirebaseFirestore.getInstance();

        DocumentReference myRef = database.collection("user").document(phoneNo);

        Map<String, Object> user = new HashMap<>();
        user.put("firstName", firstName);
        user.put("lastName", lastName);
        user.put("Email", email);
        user.put("phoneNo", phoneNo);
        user.put("Password", password);
        myRef.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(ActivitySignup.this, "User Register", Toast.LENGTH_SHORT).show();
            }
        });
        Utilities.moveTo(this, ActivityLogin.class);

    }
//    private boolean isEmailValid(String email) {
//        if (email.isEmpty()) {
//            return Utilities.setEdittextErrorStyle(this, mBinding.emailInputLayout, mBinding.emailTitleTv, R.string.empty_email_address, R.string.email_address_title);
//        } else if (!Utilities.isValidEmailId(email)) {
//            return Utilities.setEdittextErrorStyle(this, mBinding.emailInputLayout, mBinding.emailTitleTv, R.string.valid_email_address, R.string.email_address_title);
//        } else {
//            return Utilities.setClearEdittextErrorStyle(this, mBinding.emailInputLayout, mBinding.emailTitleTv, R.string.email_address_title);
//        }
//    }
//    private boolean isPhoneNoValid(String phoneNo) {
//        if (phoneNo.isEmpty()) {
//            return Utilities.setEdittextErrorStyle(this, mBinding.phoneEt, mBinding.emailTitleTv, R.string.empty_email_address, R.string.email_address_title);
//        } else if (!Utilities.isValidNumber(phoneNo)) {
//            return Utilities.setEdittextErrorStyle(this, mBinding.phoneEt, mBinding.emailTitleTv, R.string.valid_email_address, R.string.email_address_title);
//        } else {
//            return Utilities.setClearEdittextErrorStyle(this, mBinding.phoneEt, mBinding.emailTitleTv, R.string.email_address_title);
//        }
//    }
//
//    private boolean isLastNameValid(String lastName) {
//        if (lastName.isEmpty()) {
//            return Utilities.setEdittextErrorStyle(this, mBinding.lastNameInputLayout, mBinding.lastNameTitleTv, R.string.empty_lastname, R.string.lastname_title);
//        } else {
//            if (lastName.length() < 3) {
//                return Utilities.setEdittextErrorStyle(this, mBinding.lastNameInputLayout, mBinding.lastNameTitleTv, R.string.last_name_length_small, R.string.lastname_title);
//            } else {
//                if (Utilities.doesntContainsSpecialCharactersForName(lastName)) {
//                    return Utilities.setClearEdittextErrorStyle(this, mBinding.lastNameInputLayout, mBinding.lastNameTitleTv, R.string.lastname_title);
//                } else {
//                    return Utilities.setEdittextErrorStyle(this, mBinding.lastNameInputLayout, mBinding.lastNameTitleTv, R.string.special_characters_not_allowed, R.string.lastname_title);
//                }
//            }
//        }
//    }
//
//    private boolean isFirstNameValid(String firstName) {
//        if (firstName.isEmpty()) {
//            return Utilities.setEdittextErrorStyle(this, mBinding.firstNameInputLayout, mBinding.firstNameTitleTv, R.string.empty_firstname, R.string.firstname_title);
//        } else {
//            if (firstName.length() < 3) {
//                return Utilities.setEdittextErrorStyle(this, mBinding.firstNameInputLayout, mBinding.firstNameTitleTv, R.string.first_name_length_small, R.string.firstname_title);
//            } else {
//                if (Utilities.doesntContainsSpecialCharactersForName(firstName)) {
//                    return Utilities.setClearEdittextErrorStyle(this, mBinding.firstNameInputLayout, mBinding.firstNameTitleTv, R.string.firstname_title);
//                } else {
//                    return Utilities.setEdittextErrorStyle(this, mBinding.firstNameInputLayout, mBinding.firstNameTitleTv, R.string.special_characters_not_allowed, R.string.firstname_title);
//                }
//            }
//        }
//    }
//
//
//
//
//
//    private void checkNetworkAndShowDailog() {
//        if (!NetworkHandler.isConnected(mBinding.getRoot())) {
//            //showNoInternetDialog(AppConstants.Retry_Action_On_Screen_Opened);
//        }
//    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == Activity.RESULT_OK) {
//            //Image Uri will not be null for RESULT_OK
//            Uri uri = data.getData();
//            fileURI = uri;
//            String filename = uri.getLastPathSegment();
//            extension = filename.substring(filename.lastIndexOf(".") + 1);
//            mBinding.profilePicImageView.setImageURI(uri);
//        } else if (resultCode == ImagePicker.RESULT_ERROR) {
//            Utilities.showMessage(mActivity,ImagePicker.getError(data));
//        } else {
//            // Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show();
//        }
//    }
//

//    private void performRegisterBtnClickAction() {
//        if (checkValidation()) {
//            if (fileURI == null) {
//                hitSignUpApi();
//            } else {
//              //  hitUpdateProfileImageApi();
//            }
//        }
//    }

//    public void openbottomSheetDialog() {
//        final BottomSheetDialog dialog = new BottomSheetDialog(this.mActivity, R.style.SheetDialog);
//        View view = View.inflate(mActivity, R.layout.dialog_camera_gallery_view, null);
//        dialog.setContentView(view);
//        dialog.setCanceledOnTouchOutside(true);
//        Utilities.setDialogSheetBg(dialog);
//
//        LinearLayout ll_removepic = dialog.findViewById(R.id.ll_removepic);
//        LinearLayout ll_gallery = dialog.findViewById(R.id.ll_gallery);
//        LinearLayout ll_camera = dialog.findViewById(R.id.ll_camera);
//        AppCompatImageView iv_cross = dialog.findViewById(R.id.iv_cross);
//
//        iv_cross.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//
//        ll_removepic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                DialogUtil.showToastInfo(mActivity,getString(R.string.coming_soon));
////                dialog.dismiss();
//            }
//        });
//
//
//        ll_camera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                ImagePicker.with(ActivitySignup.this).cameraOnly()
//                        .crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
//                        .start();
//            }
//        });
//
//        ll_gallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//                ImagePicker.with(ActivitySignup.this).galleryOnly()
//                        .crop()                    //Crop image(Optional), Check Customization for more option
//                        .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)    //Final image resolution will be less than 1080 x 1080(Optional)
//                        .start();
//            }
//        });
//
//        dialog.show();
//    }
//


}