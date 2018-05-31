package com.example.administrator.yuekaodome.net;

import com.example.administrator.yuekaodome.bean.AdBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/5/31.
 */

public interface AdApiService {
    @GET("ad/getAd")
    Observable<AdBean> getAd();

}
