package com.mobiletraderv.paul.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.mobiletraderv.paul.di.qualifier.ApplicationContext;
import com.mobiletraderv.paul.di.scope.ApplicationScope;
import com.mobiletraderv.paul.model.DatabaseDaoSQLQuery;
import com.mobiletraderv.paul.model.DatabaseManager;
import com.mobiletraderv.paul.repository.MobileTraderDataSource;
import com.mobiletraderv.paul.repository.MobiletraderRepository;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class MvvMModule {

    private DatabaseManager dManager;


    public MvvMModule(@ApplicationContext Context context) {
        dManager =
                Room.databaseBuilder(context, DatabaseManager.class, "demo-db")
                        .build();
    }

    @Provides
    @ApplicationScope
    DatabaseManager providesRoomDatabase() {
        return dManager;
    }

    @Provides
    @ApplicationScope
    DatabaseDaoSQLQuery providesDbDao(DatabaseManager dbManager) {
        return dbManager.getDataaccess();
    }

    @Provides
    @ApplicationScope
    MobiletraderRepository AppRepository(DatabaseDaoSQLQuery dManagers) {
        return new MobileTraderDataSource(dManagers);
    }
}
