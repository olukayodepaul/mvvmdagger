package com.mobiletraderv.paul.viewmodels;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.mobiletraderv.paul.di.component.ApplicationComponent;
import com.mobiletraderv.paul.di.component.DaggerApplicationComponent;
import com.mobiletraderv.paul.di.module.ContextModule;
import com.mobiletraderv.paul.di.module.MvvMModule;
import com.mobiletraderv.paul.di.module.NetworkModule;
import com.mobiletraderv.paul.di.module.PicassoModule;
import com.mobiletraderv.paul.model.RegistrationEntityTable;
import com.mobiletraderv.paul.pojo.UserLoginPojo;
import com.mobiletraderv.paul.repository.MobiletraderRepository;
import com.mobiletraderv.paul.views.loginview.LoginCallBack;
import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class RegistrationViewModel extends AndroidViewModel{

    @Inject
    MobiletraderRepository mRepo;
    LoginCallBack registerCallBack;
    private Disposable mDisposable;
    private MutableLiveData<String> mError = new MutableLiveData<>();

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

    public MutableLiveData<String> getError() {
        return mError;
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


    public void checkUsers(String username, String password, String imei) {

        disposeDisposable();
        mError.postValue(username);

        /*mDisposable = mDisposable = mRepo.userLogin(username, password, imei)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe(data -> {
                            //onNext
                            mError.postValue("error");
                        },
                        error -> {
                            //onError
                            mError.postValue("information");
                        },
                        () -> {
                            //onComplete
                        }
                );
                */
    }

    private void disposeDisposable() {
        if (mDisposable != null && !mDisposable.isDisposed())
            mDisposable.dispose();
    }

}
