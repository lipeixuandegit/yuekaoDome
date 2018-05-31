package com.example.administrator.yuekaodome.ui.mine.Presenter;

import com.example.administrator.yuekaodome.bean.LoginBean;
import com.example.administrator.yuekaodome.net.LoginApi;
import com.example.administrator.yuekaodome.ui.base.BasePresenter;
import com.example.administrator.yuekaodome.ui.mine.Contract.LoginContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/31.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    private LoginApi loginApi;
    @Inject
    public LoginPresenter(LoginApi loginApi) {
        this.loginApi = loginApi;
    }

    @Override
    public void getLogin(String mobile, String password) {
        loginApi.getLogin(mobile,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        mView.onSuccess(loginBean);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
