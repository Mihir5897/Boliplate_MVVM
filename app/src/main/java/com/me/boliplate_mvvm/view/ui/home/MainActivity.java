package com.me.boliplate_mvvm.view.ui.home;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;


import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.me.boliplate_mvvm.R;
import com.me.boliplate_mvvm.databinding.ActivityMainBinding;
import com.me.boliplate_mvvm.service.model.RoomDatabase.UserDao;
import com.me.boliplate_mvvm.service.model.RoomDatabase.UserDataBase;
import com.me.boliplate_mvvm.service.model.entity.User;
import com.me.boliplate_mvvm.utility.Utilities;
import com.me.boliplate_mvvm.view.base.BaseActivity;
import com.me.boliplate_mvvm.view.ui.login.ActivityLogin;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends BaseActivity {
    ActivityMainBinding mBinding;
    Activity mActivity;
    GoogleSignInOptions gso;
    GoogleSignInClient mGoogleSignInClient;
    String firstName=" ", lastName=" ", email=" ", password=" ", phoneNo=" ";
    private User user;
    private UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = MainActivity.this;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        userDao = Room.databaseBuilder(this, UserDataBase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();
       // googleSignOrNot();

        userLoginRoomdata();
//        userLoginFireData();

    }

    private void userLoginFireData() {
        Intent intent = getIntent();
        String fname = intent.getStringExtra("fname");
        mBinding.tvUser.setText("WELCOME " + fname);
    }

    private void userLoginRoomdata() {

        user = (User) getIntent().getSerializableExtra("User");
        if (user != null) {
            mBinding.tvUser.setText("WELCOME " + user.getFirstName());
        }
    }

    private void facebookloggedin() {
        AccessToken accessToken=AccessToken.getCurrentAccessToken();
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {
                        try {
                            String frist_name=object.getString("first_name");
                            mBinding.tvUser.setText("WELCOME " + frist_name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void googleSignOrNot() {
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(mActivity);
         firstName = account.getDisplayName();
         lastName = account.getFamilyName();
         email = account.getEmail();
         user = new User(firstName, lastName, email, phoneNo, password);
        userDao.insert(user);
        mBinding.tvUser.setText("WELCOME " + firstName);

    }
    void googleSignOut(){
        mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                Utilities.moveTo(mActivity, ActivityLogin.class);
            }
        });
    }
    public void faceBookLogout(){
        LoginManager.getInstance().logOut();
        Utilities.moveTo(MainActivity.this,ActivityLogin.class);
        finish();
    }

}