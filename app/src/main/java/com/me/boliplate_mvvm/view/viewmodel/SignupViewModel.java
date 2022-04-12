package com.me.boliplate_mvvm.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.me.boliplate_mvvm.service.model.request.SignUpRequest;
import com.me.boliplate_mvvm.service.model.response.SignUpResponse;
import com.me.boliplate_mvvm.service.repository.SignUpRepository;
import com.me.boliplate_mvvm.utility.AbsentLiveData;
import com.me.boliplate_mvvm.view.base.BaseViewModel;

import javax.inject.Inject;


public class SignupViewModel extends BaseViewModel {
    private final LiveData<SignUpResponse> signupresponse;
    private final MutableLiveData<SignUpRequest> signupreq;
    private final SignUpRepository repository;

    public SignupViewModel(@NonNull Application application) {
        super(application);
        signupreq = new MutableLiveData<>();
        repository = new SignUpRepository();

        signupresponse = Transformations.switchMap(signupreq, new Function<SignUpRequest, LiveData<SignUpResponse>>() {
            @Override
            public LiveData<SignUpResponse> apply(SignUpRequest input) {
                if (input == null)
                    return AbsentLiveData.create();
                else
                    return repository.doSignUp(input);
            }
        });

    }



    public SignUpRequest getRequest(String firstName,String lastName, String email, String mobile,String Image_Name ) {
        SignUpRequest listRequest = new SignUpRequest();
        listRequest.setFirst_name(firstName);
        listRequest.setLast_name(lastName);
        listRequest.setEmailId(email);

        listRequest.setMobile(mobile);
        listRequest.setImage_name(Image_Name);
        return listRequest;
    }

    public void setSignupReq(SignUpRequest request) {
        signupreq.setValue(request);
    }

    public LiveData<SignUpResponse> getSignupResponse() {
        return signupresponse;
    }


}
