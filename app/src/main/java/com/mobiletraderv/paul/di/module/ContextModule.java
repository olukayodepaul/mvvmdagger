package com.mobiletraderv.paul.di.module;

import android.content.Context;
import com.mobiletraderv.paul.di.qualifier.ApplicationContext;
import com.mobiletraderv.paul.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext(){
        return context;
    }
}
