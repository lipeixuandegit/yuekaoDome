package com.example.administrator.yuekaodome.net;

import com.example.administrator.yuekaodome.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/5/31.
 */

public interface LoginApiService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> login(@Field("mobile") String mobile,@Field("password") String password);
}
