package com.mobiletraderv.paul.repository;


import android.arch.lifecycle.LiveData;

import com.mobiletraderv.paul.model.RegistrationEntityTable;
import com.mobiletraderv.paul.pojo.UserLoginPojo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

public interface MobiletraderRepository {

    LiveData<List<RegistrationEntityTable>> findById(int id);
    void insert(RegistrationEntityTable regEntityTable);
    Observable<Response<UserLoginPojo>> userLogin(String username, String password, String imei);
}
