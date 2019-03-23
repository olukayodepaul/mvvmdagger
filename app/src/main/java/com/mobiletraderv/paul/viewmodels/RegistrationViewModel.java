package com.mobiletraderv.paul.viewmodels;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.mobiletraderv.paul.di.component.ApplicationComponent;
import com.mobiletraderv.paul.di.component.DaggerApplicationComponent;
import com.mobiletraderv.paul.di.module.ContextModule;
import com.mobiletraderv.paul.di.module.MvvMModule;
import com.mobiletraderv.paul.di.module.NetworkModule;
import com.mobiletraderv.paul.di.module.PicassoModule;
import com.mobiletraderv.paul.model.RegistrationEntityTable;
import com.mobiletraderv.paul.repository.MobiletraderRepository;
import com.mobiletraderv.paul.repository.Api;

import javax.inject.Inject;

public class RegistrationViewModel extends AndroidViewModel {

    @Inject
    MobiletraderRepository mRepo;

    @Inject
    Api retrofitService;


    public RegistrationViewModel(@NonNull Application application) {
        super(application);
        ApplicationComponent component = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(getApplication()))
                .picassoModule(new PicassoModule())
                .mvvMModule(new MvvMModule(getApplication()))
                .networkModule(new NetworkModule())
                .build();
        component.inject(this);
    }

    public void Inserts(RegistrationEntityTable rEntTable){
        new InsertAsyTask(mRepo).execute(rEntTable);
    }



    private class InsertAsyTask extends AsyncTask<RegistrationEntityTable, Void, Void> {

        MobiletraderRepository mRepo;

        public InsertAsyTask(MobiletraderRepository mRepo) {
            this.mRepo = mRepo;
        }

        @Override
        protected Void doInBackground(RegistrationEntityTable... registrationEntityTables) {
            mRepo.insert(registrationEntityTables[0]);
            return null;
        }
    }




}
