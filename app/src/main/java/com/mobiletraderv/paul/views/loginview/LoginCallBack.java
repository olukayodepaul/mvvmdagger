package com.mobiletraderv.paul.views.loginview;

public interface LoginCallBack {

    void onSuccessful(String username, String pass);
    void onError(String msg);

}
