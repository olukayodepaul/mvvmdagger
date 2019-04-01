package com.mobiletraderv.paul;
import android.app.Activity;
import android.app.Application;
import com.mobiletraderv.paul.di.component.ApplicationComponent;
import com.mobiletraderv.paul.di.component.DaggerApplicationComponent;
import com.mobiletraderv.paul.di.module.ContextModule;


public class MtApp extends Application {

    private ApplicationComponent applicationComponent;

    public static MtApp get(Activity activity) {
        return (MtApp) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
