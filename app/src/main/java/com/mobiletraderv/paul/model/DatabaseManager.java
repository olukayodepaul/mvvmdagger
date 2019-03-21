package com.mobiletraderv.paul.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {RegistrationEntityTable.class}, version = 1 , exportSchema = false)
public abstract class DatabaseManager extends RoomDatabase {

    static final int VERSION = 1;
    public abstract DatabaseDaoSQLQuery getDataaccess();

}


