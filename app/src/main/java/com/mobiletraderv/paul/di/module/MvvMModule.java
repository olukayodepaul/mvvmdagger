package com.mobiletraderv.paul.di.module;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.mobiletraderv.paul.data.DataRepository;
import com.mobiletraderv.paul.di.qualifier.ApplicationContext;
import com.mobiletraderv.paul.di.scope.ApplicationScope;
import com.mobiletraderv.paul.data.Api;
import com.mobiletraderv.paul.data.DatabaseDaoSQLQuery;
import com.mobiletraderv.paul.data.DatabaseManager;
import com.mobiletraderv.paul.viewmodels.CustomViewModelFactory;


import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class, NetworkModule.class})
public class MvvMModule {

    private DatabaseManager dManager;

    public MvvMModule(@ApplicationContext Context  application) {
        this.dManager =
                Room.databaseBuilder(application, DatabaseManager.class, "demo-db")
                        .build();
    }

    @Provides
    @ApplicationScope
    DataRepository provideDataRepository(DatabaseDaoSQLQuery databaseDaoSQLQuery, Api api ){
      return new DataRepository(databaseDaoSQLQuery,api);
    }

    @Provides
    @ApplicationScope
    DatabaseDaoSQLQuery providesDbDao(DatabaseManager dbManager) {
        return dbManager.getDataaccess();
    }

    @Provides
    @ApplicationScope
    DatabaseManager providesRoomDatabase(@ApplicationContext Context  application) {
        return dManager;
    }

    @Provides
    @ApplicationScope
    ViewModelProvider.Factory provideViewModelFactory(DataRepository repository){
        return new CustomViewModelFactory(repository);
    }
}
