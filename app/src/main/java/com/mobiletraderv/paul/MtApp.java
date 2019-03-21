package com.mobiletraderv.paul;

import android.app.Application;

import com.mobiletraderv.paul.di.component.ApplicationComponent;

import com.mobiletraderv.paul.di.component.DaggerApplicationComponent;
import com.mobiletraderv.paul.di.module.ContextModule;
import com.mobiletraderv.paul.di.module.MvvMModule;
import com.mobiletraderv.paul.di.module.NetworkModule;
import com.mobiletraderv.paul.di.module.PicassoModule;


public class MtApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
