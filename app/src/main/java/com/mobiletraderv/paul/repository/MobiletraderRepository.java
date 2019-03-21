package com.mobiletraderv.paul.repository;


import android.arch.lifecycle.LiveData;

import com.mobiletraderv.paul.model.RegistrationEntityTable;

import java.util.List;

public interface MobiletraderRepository {

    LiveData<List<RegistrationEntityTable>> findById(int id);
    void insert(RegistrationEntityTable regEntityTable);
}
