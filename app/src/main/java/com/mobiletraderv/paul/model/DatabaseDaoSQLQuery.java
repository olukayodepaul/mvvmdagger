package com.mobiletraderv.paul.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DatabaseDaoSQLQuery {

    @Query("SELECT * FROM RegistrationEntityTable WHERE id=:id")
    LiveData<List<RegistrationEntityTable>> findById(int id);

    @Insert
    void insert(RegistrationEntityTable registrationEntity);

}
