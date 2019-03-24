package com.mobiletraderv.paul.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mobiletraderv.paul.mobiletradervt.R;
import com.mobiletraderv.paul.mobiletradervt.databinding.ActivityMainBinding;
import com.mobiletraderv.paul.model.RegistrationEntityTable;
import com.mobiletraderv.paul.pojo.UserLoginPojo;
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
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setLoginViewModel(ViewModelProviders.of(this,
                new LoginViewModelFactory(this))
        .get(LoginViewModel.class));

        registrationVModel = ViewModelProviders.of(this)
                .get(RegistrationViewModel.class);
    }

    @Override
    public void onSuccessful(String username, String password) {
        registrationVModel.checkUsers(username, password, "imei");
        registrationVModel.getError().observe(this, s -> callBack(s));

        registrationVModel.getData().observe(this, data -> {

            UserLoginPojo userDetails = data;
            RegistrationEntityTable register = new RegistrationEntityTable
                    (
                         data.id, data.name, data.ecode, data.custno, data.dbroute, data.sellingunit,
                            data.lat, data.lat, data.vehiclename, data.vehicleid, data.depot_waiver, data.clokin, data.clokout
                    );
            registrationVModel.Inserts(register);
            for(int i = 0; i < data.modules.size(); i++){

            }
        });
    }

    @Override
    public void onError(String msg) {
        showProgressBar();
    }

    private void callBack(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT ).show();
    }


    public void showProgressBar(){
        activityMainBinding.progressbar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar(){
        activityMainBinding.progressbar.setVisibility(View.GONE);
    }

}
