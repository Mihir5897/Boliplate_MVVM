package com.me.boliplate_mvvm.view.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.me.boliplate_mvvm.service.model.request.LoginRequest;
import com.me.boliplate_mvvm.service.model.response.LoginResponse;
import com.me.boliplate_mvvm.service.repository.LoginRepository;
import com.me.boliplate_mvvm.utility.AbsentLiveData;
import com.me.boliplate_mvvm.view.base.BaseViewModel;




public class LoginViewModel extends BaseViewModel {


    private final LiveData<LoginResponse> loginresponse;
    private final MutableLiveData<LoginRequest> loginreq;
    private final LoginRepository repository;


    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginreq = new MutableLiveData<>();
        repository = new LoginRepository();

        loginresponse = Transformations.switchMap(loginreq, new Function<LoginRequest, LiveData<LoginResponse>>() {
            @Override
            public LiveData<LoginResponse> apply(LoginRequest input) {
                if (input == null)
                    return AbsentLiveData.create();
                else
                    return repository.doLogin(input);
            }
        });
    }

    public LoginRequest getRequest(String mobileNo) {
        LoginRequest listRequest = new LoginRequest();
        listRequest.setMobile_number(mobileNo);
        return listRequest;
    }

    public void setLoginReq(LoginRequest request) {
        loginreq.setValue(request);
    }

    public LiveData<LoginResponse> getLoginResponse() {
        return loginresponse;
    }


}
