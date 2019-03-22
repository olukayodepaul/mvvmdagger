package com.mobiletraderv.paul.views.loginview;

import android.databinding.BaseObservable;
import android.text.TextUtils;

public class Logins extends BaseObservable {

    private String email, password;

    public Logins() {
    }

    public Logins(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int isValidData(){
        if(TextUtils.isEmpty(getEmail())){
            return 0;
        }else if(TextUtils.isEmpty(getPassword())){
            return 1;
        }else{
            return 2;
        }
    }
}
