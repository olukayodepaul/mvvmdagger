package com.mobiletraderv.paul.di.component;

import android.content.Context;

import com.mobiletraderv.MtApp;
import com.mobiletraderv.paul.data.MtDao;
import com.mobiletraderv.paul.data.MtRepository;
import com.mobiletraderv.paul.data.RetrofitService;
import com.mobiletraderv.paul.di.module.AppModule;
import com.mobiletraderv.paul.di.module.ContextModule;
import com.mobiletraderv.paul.di.module.PicassoModule;
import com.mobiletraderv.paul.di.qualifier.ApplicationContext;
import com.mobiletraderv.paul.di.scope.ApplicationScope;
import com.mobiletraderv.paul.mvvm.MtDatabase;
import com.squareup.picasso.Picasso;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, AppModule.class, PicassoModule.class })
public interface ApplicationComponent {

    RetrofitService getApiService();
    MtDao getData();
    Picasso getPicasso();
    MtDatabase getDatabase();
    MtRepository getPersistenceData();


    @ApplicationContext
    Context getContext();
    void injectApplication(MtApp myApplication);

}
