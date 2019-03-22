package com.mobiletraderv.paul.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.mobiletraderv.paul.mobiletradervt.R;
import com.mobiletraderv.paul.mobiletradervt.databinding.ActivityMainBinding;
import com.mobiletraderv.paul.viewmodels.RegistrationViewModel;
import com.mobiletraderv.paul.views.loginview.LoginCallBack;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity implements LoginCallBack{

    private RegistrationViewModel registrationVModel;

    @BindView(R.id.progressbar)
    ProgressBar progressbar;

    /*@BindView(R.id.u_email)
    EditText u_email;

    @BindView(R.id.u_paswd)
    EditText u_paswd;

    @BindView(R.id.loginButton)
    Button loginButton;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);
        //registrationVModel = ViewModelProviders.of(this).get(RegistrationViewModel.class);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


    }

    @Override
    public void onSuccessful(String msg) {
        /*RegistrationEntityTable register =
                new RegistrationEntityTable(7, "oviosun", "olukayode", "oviosun");
        registrationVModel.Inserts(register);*/
    }

    @Override
    public void onError(String msg) {

    }

    public void showProgressBar(){
        progressbar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar(){
        progressbar.setVisibility(View.GONE);
    }

}
