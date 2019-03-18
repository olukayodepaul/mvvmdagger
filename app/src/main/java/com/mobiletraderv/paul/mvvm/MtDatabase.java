package com.mobiletraderv.paul.mvvm;

import android.arch.persistence.room.RoomDatabase;

import com.mobiletraderv.paul.data.MtDao;

public abstract class MtDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract MtDao getProductDao();

}
