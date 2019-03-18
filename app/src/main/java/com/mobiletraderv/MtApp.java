package com.mobiletraderv;

import android.app.Activity;
import android.app.Application;

import com.mobiletraderv.paul.di.component.ApplicationComponent;
import com.mobiletraderv.paul.di.component.DaggerApplicationComponent;
import com.mobiletraderv.paul.di.module.AppModule;
import com.mobiletraderv.paul.di.module.ContextModule;
import com.mobiletraderv.paul.di.module.PicassoModule;

public class MtApp extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        dependencyInjection();
    }

    public static MtApp get(Activity activity){
        return (MtApp) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    private void dependencyInjection(){
        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .picassoModule(new PicassoModule())
                .appModule(new AppModule(this))
                .build();
        applicationComponent.injectApplication(this);
    }

}
