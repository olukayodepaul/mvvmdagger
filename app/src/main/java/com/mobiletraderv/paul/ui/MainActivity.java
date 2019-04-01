package com.mobiletraderv.paul.ui;


import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.mobiletraderv.paul.MtApp;
import com.mobiletraderv.paul.di.component.ApplicationComponent;
import com.mobiletraderv.paul.di.util.AppUtil;
import com.mobiletraderv.paul.mobiletradervt.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.u_email)
    EditText u_email;

    @BindView(R.id.u_paswd)
    EditText u_paswd;

    @BindView(R.id.loginButton)
    Button loginButton;

    @BindView(R.id.progressbar)
    ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ApplicationComponent component = ((MtApp) getApplication()).getApplicationComponent();
        component.inject(this);

    }

    public void process(){

        if(TextUtils.isEmpty(u_email.getText().toString())){
            AppUtil.showAlertDialog(this, "Error", "please enter username", "Ok");
        }else if(TextUtils.isEmpty(u_paswd.getText().toString())){
            AppUtil.showAlertDialog(this, "Error", "please enter password", "Ok");
        }else{


        }
    }

    public void showProgressBar(){
        progressbar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar(){
        progressbar.setVisibility(View.GONE);
    }


}
