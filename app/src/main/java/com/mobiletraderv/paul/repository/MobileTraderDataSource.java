package com.mobiletraderv.paul.repository;


import android.arch.lifecycle.LiveData;

import com.mobiletraderv.paul.model.DatabaseDaoSQLQuery;
import com.mobiletraderv.paul.model.RegistrationEntityTable;

import java.util.List;

import javax.inject.Inject;

public class MobileTraderDataSource implements MobiletraderRepository {

    private DatabaseDaoSQLQuery daoSQLQuery;

    @Inject
    public MobileTraderDataSource(DatabaseDaoSQLQuery daoSQLQuery) {
        this.daoSQLQuery = daoSQLQuery;
    }


    @Override
    public LiveData<List<RegistrationEntityTable>> findById(int id) {
        return null;
    }

    @Override
    public void insert(RegistrationEntityTable regEntityTable) {
        this.daoSQLQuery.insert(regEntityTable);
    }
}
