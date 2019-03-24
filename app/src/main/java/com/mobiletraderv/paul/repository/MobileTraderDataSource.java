package com.mobiletraderv.paul.repository;


import android.arch.lifecycle.LiveData;

import com.mobiletraderv.paul.model.Api;
import com.mobiletraderv.paul.model.DatabaseDaoSQLQuery;
import com.mobiletraderv.paul.model.RegistrationEntityTable;
import com.mobiletraderv.paul.pojo.UserLoginPojo;
import io.reactivex.Observable;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

public class MobileTraderDataSource implements MobiletraderRepository {

    private DatabaseDaoSQLQuery daoSQLQuery;
    private Api api;

    @Inject
    public MobileTraderDataSource(DatabaseDaoSQLQuery daoSQLQuery, Api api) {
        this.daoSQLQuery = daoSQLQuery;
        this.api = api;
    }

    @Override
    public LiveData<List<RegistrationEntityTable>> findById(int id) {
        return null;
    }

    @Override
    public void insert(RegistrationEntityTable regEntityTable) {
        this.daoSQLQuery.insert(regEntityTable);
    }

    @Override
    public Observable<Response<UserLoginPojo>> userLogin(String username, String password, String imei) {
        return api.getUserLogin(username, password, imei);
    }
}
