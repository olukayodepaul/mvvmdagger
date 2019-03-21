package com.mobiletraderv.paul.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobiletraderv.paul.di.component.ApplicationComponent;
import com.mobiletraderv.paul.di.component.DaggerApplicationComponent;
import com.mobiletraderv.paul.di.module.ContextModule;
import com.mobiletraderv.paul.di.module.MvvMModule;
import com.mobiletraderv.paul.di.module.NetworkModule;
import com.mobiletraderv.paul.di.module.PicassoModule;
import com.mobiletraderv.paul.model.RegistrationEntityTable;
import com.mobiletraderv.paul.mobiletradervt.R;
import com.mobiletraderv.paul.repository.MobiletraderRepository;
import com.mobiletraderv.paul.viewmodels.RegistrationViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private RegistrationViewModel registrationVModel;
    //@BindView(R.id.progressbar)
    //ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrationVModel = ViewModelProviders.of(this).get(RegistrationViewModel.class);
        RegistrationEntityTable register =
                new RegistrationEntityTable(20, "oviosun", "olukayode", "oviosun");
        registrationVModel.Inserts(register);

    }



}
