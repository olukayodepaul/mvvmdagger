package com.mobiletraderv.paul.data;


import android.arch.lifecycle.LiveData;

import com.mobiletraderv.paul.data.RegistrationEntityTable;
import com.mobiletraderv.paul.pojo.UserLoginPojo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

public interface DataRepositoryManager {

    /*LiveData<List<RegistrationEntityTable>> findById(int id);
    LiveData<List<RegistrationEntityTable>> findAllItem(int id);
    int deleteItem(RegistrationEntityTable registrationEntityTable);
    Long insert(RegistrationEntityTable regEntityTable) ;
    Observable<Response<UserLoginPojo>> userLogin(String username, String password, String imei);*/
}
