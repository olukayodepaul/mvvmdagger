package com.mobiletraderv.paul.di.component;



import com.mobiletraderv.paul.di.module.ContextModule;
import com.mobiletraderv.paul.di.module.MvvMModule;
import com.mobiletraderv.paul.di.module.NetworkModule;
import com.mobiletraderv.paul.di.module.PicassoModule;
import com.mobiletraderv.paul.di.scope.ApplicationScope;
import com.mobiletraderv.paul.ui.MainActivity;

import dagger.Component;

@ApplicationScope
@Component(modules = {MvvMModule.class, ContextModule.class, NetworkModule.class, PicassoModule.class})
public interface ApplicationComponent {

  void inject(MainActivity mainActivity);

}








