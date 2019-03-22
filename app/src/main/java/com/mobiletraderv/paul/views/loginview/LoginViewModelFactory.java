package com.mobiletraderv.paul.views.loginview;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;


public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private LoginCallBack registerCallBack;

    public LoginViewModelFactory(LoginCallBack registerCallBack) {
        this.registerCallBack = registerCallBack;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(registerCallBack);
    }

}
