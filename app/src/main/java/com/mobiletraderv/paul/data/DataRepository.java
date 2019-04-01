package com.mobiletraderv.paul.data;


import android.arch.lifecycle.LiveData;

import com.mobiletraderv.paul.pojo.UserLoginPojo;

import io.reactivex.Observable;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

public class DataRepository  {


    private final DatabaseDaoSQLQuery daoSQLQuery;
    private final Api api;

    @Inject
    public DataRepository(DatabaseDaoSQLQuery daoSQLQuery, Api api) {
        this.daoSQLQuery = daoSQLQuery;
        this.api = api;
    }

    public LiveData<List<RegistrationEntityTable>> findById(int id) {
        return daoSQLQuery.findById(id);
    }

    public LiveData<List<RegistrationEntityTable>> findAllItem(int id) {
        return daoSQLQuery.findAllItem();
    }

    public int deleteItem(RegistrationEntityTable registrationEntityTable) {
        return daoSQLQuery.deleteItem(registrationEntityTable);
    }

    public Long insert(RegistrationEntityTable regEntityTable) {
        return this.daoSQLQuery.insert(regEntityTable);
    }

    public Observable<Response<UserLoginPojo>> userLogin(String username, String password, String imei) {
        return api.getUserLogin(username, password, imei);
    }
}
