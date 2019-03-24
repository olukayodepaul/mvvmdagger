package com.mobiletraderv.paul.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mobiletraderv.paul.mobiletradervt.R;
import com.mobiletraderv.paul.mobiletradervt.databinding.ActivityMainBinding;
import com.mobiletraderv.paul.viewmodels.RegistrationViewModel;
import com.mobiletraderv.paul.views.loginview.LoginCallBack;
import com.mobiletraderv.paul.views.loginview.LoginViewModel;
import com.mobiletraderv.paul.views.loginview.LoginViewModelFactory;

import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity implements LoginCallBack{

    RegistrationViewModel registrationVModel;

    ActivityMainBinding activityMainBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setLoginViewModel(ViewModelProviders.of(this,
                new LoginViewModelFactory(this))
        .get(LoginViewModel.class));

        registrationVModel = ViewModelProviders.of(this)
                .get(RegistrationViewModel.class);

        registrationVModel.checkUsers("paul","olukayode","oviosun");
        registrationVModel.getError().observe(this, s -> updateError(s));


    }

    private void updateError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccessful(String username, String password) {
        //registrationVModel.checkUsers(username,password,"imei");
        //Toast.makeText(this,username+" "+password,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String msg) {
    }

    public void showProgressBar(){
        activityMainBinding.progressbar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar(){
        activityMainBinding.progressbar.setVisibility(View.GONE);
    }

}
