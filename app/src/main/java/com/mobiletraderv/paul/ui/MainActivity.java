package com.mobiletraderv.paul.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.mobiletraderv.paul.mobiletradervt.R;
import com.mobiletraderv.paul.mobiletradervt.databinding.ActivityMainBinding;
import com.mobiletraderv.paul.viewmodels.RegistrationViewModel;
import com.mobiletraderv.paul.views.loginview.LoginCallBack;
import com.mobiletraderv.paul.views.loginview.LoginViewModel;
import com.mobiletraderv.paul.views.loginview.LoginViewModelFactory;


public class MainActivity extends AppCompatActivity implements LoginCallBack{

    RegistrationViewModel registrationVModel;

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registrationVModel = ViewModelProviders.of(this).get(RegistrationViewModel.class);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setLoginViewModel(ViewModelProviders.of(this,
                new LoginViewModelFactory(this))
        .get(LoginViewModel.class));
        showProgressBar();
    }

    @Override
    public void onSuccessful(String msg) {
        hideProgressBar();
    }

    @Override
    public void onError(String msg) {
        hideProgressBar();
    }

    public void showProgressBar(){
        activityMainBinding.progressbar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar(){
        activityMainBinding.progressbar.setVisibility(View.GONE);
    }

}
