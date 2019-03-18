package com.mobiletraderv.paul.di.module;


import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import com.fatboyindustrial.gsonjodatime.DateTimeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobiletraderv.paul.mvvm.MtDataSource;
import com.mobiletraderv.paul.data.MtRepository;
import com.mobiletraderv.paul.data.RetrofitService;
import com.mobiletraderv.paul.di.qualifier.ApplicationContext;
import com.mobiletraderv.paul.di.scope.ApplicationScope;
import com.mobiletraderv.paul.data.MtDao;
import com.mobiletraderv.paul.mvvm.MtDatabase;
import org.joda.time.DateTime;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class AppModule {

    private MtDatabase demoDatabase;

    @Provides
    @ApplicationScope
    @Named("mt_server")
    Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    @Named("dynamic_server")
    Retrofit getRetrotBasket(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000); //10MB Cahe
    }

    @Provides
    @ApplicationScope
    public File cacheFile(@ApplicationContext Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @ApplicationScope
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        return gsonBuilder.create();
    }

    @Provides
    @ApplicationScope
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES )
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @ApplicationScope
    HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @ApplicationScope
    public RetrofitService provideApiService(@Named("mt_server") Retrofit retrofit) {
        return retrofit.create(RetrofitService .class);
    }

    public AppModule(Application mApplication) {
        demoDatabase = Room.databaseBuilder(mApplication, MtDatabase.class, "mobiletrader").build();
    }

    @Provides
    @ApplicationScope
    MtDatabase providesRoomDatabase() {
        return demoDatabase;
    }

    @Provides
    @ApplicationScope
    MtDao providesMtDao(MtDatabase mtDatabase) {
        return mtDatabase.getProductDao();
    }

    @Provides
    @ApplicationScope
    MtRepository mtRepository(MtDao  mtDao) {
        return new MtDataSource(mtDao);
    }


}
