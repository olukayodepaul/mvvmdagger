package com.mobiletraderv.paul.views.loginview;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;


public class LoginViewModel extends ViewModel{

    Logins logins;
    LoginCallBack registerCallBack;

    public LoginViewModel(LoginCallBack registerCallBack) {
        this.logins =  new Logins();
        this.registerCallBack = registerCallBack;
    }

    public TextWatcher getEmail() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                logins.setEmail(editable.toString());
            }
        };
    }

    public TextWatcher getPassword() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                logins.setPassword(editable.toString());
            }
        };
    }

    public void onLoginClick(View view){

        if(logins.isValidData())
            registerCallBack.onSuccessful("true");
        else
            registerCallBack.onError("false");
    }





}
