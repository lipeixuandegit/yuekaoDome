package com.example.administrator.yuekaodome.net;

import com.example.administrator.yuekaodome.bean.AdBean;
import com.example.administrator.yuekaodome.bean.LoginBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/5/31.
 */

public class LoginApi {
    private static LoginApi loginApi;
    private LoginApiService loginApiService;

    public LoginApi(LoginApiService loginApiService) {
        this.loginApiService = loginApiService;
    }
    public static LoginApi getAdApi(LoginApiService loginApiService){
        if (loginApi==null){
            loginApi=new LoginApi(loginApiService);
        }
        return loginApi;
    }
    public Observable<LoginBean> getLogin(String mobile,String password){
        return loginApiService.login(mobile,password);
    }
}
