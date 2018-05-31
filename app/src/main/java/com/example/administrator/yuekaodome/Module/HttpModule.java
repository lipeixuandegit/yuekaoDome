package com.example.administrator.yuekaodome.Module;

import com.example.administrator.yuekaodome.net.AdApi;
import com.example.administrator.yuekaodome.net.AdApiService;
import com.example.administrator.yuekaodome.net.Api;
import com.example.administrator.yuekaodome.net.LoginApi;
import com.example.administrator.yuekaodome.net.LoginApiService;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/31.
 */
@Module
public class HttpModule {
    @Provides
    OkHttpClient.Builder providesokHttpClientbuilder(){
        return new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.MINUTES)
                .connectTimeout(10,TimeUnit.MINUTES)
                .writeTimeout(20,TimeUnit.MINUTES);
    }
    @Provides
    AdApi provideAdApi(OkHttpClient.Builder builder){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        AdApiService adApiService = retrofit.create(AdApiService.class);
        return AdApi.getAdApi(adApiService);
    }
    @Provides
    LoginApi provideLoginApi(OkHttpClient.Builder builder){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        LoginApiService adApiService = retrofit.create(LoginApiService.class);
        return LoginApi.getAdApi(adApiService);
    }
}
