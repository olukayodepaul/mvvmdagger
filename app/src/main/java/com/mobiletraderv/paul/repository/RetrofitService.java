package com.mobiletraderv.paul.repository;


import com.mobiletraderv.paul.pojo.UserLoginPojo;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {

    @POST("/mobiletrader/login")
    Observable<Response<UserLoginPojo>> getUserLogin(
            @Query("username") String username,
            @Query("password") String password,
            @Query("imei") String imei
    );
}

