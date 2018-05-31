package com.example.administrator.yuekaodome.net;

import com.example.administrator.yuekaodome.bean.AdBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/5/31.
 */

public class AdApi {
    private static AdApi adApi;
    private AdApiService adApiService;

    public AdApi(AdApiService adApiService) {
        this.adApiService = adApiService;
    }
    public static AdApi getAdApi(AdApiService adApiService){
        if (adApi==null){
            adApi=new AdApi(adApiService);
        }
        return adApi;
    }
    public Observable<AdBean> getAd(){
        return adApiService.getAd();
    }
}
