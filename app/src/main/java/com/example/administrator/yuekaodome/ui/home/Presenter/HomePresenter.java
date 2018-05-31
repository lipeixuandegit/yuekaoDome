package com.example.administrator.yuekaodome.ui.home.Presenter;

import com.example.administrator.yuekaodome.bean.AdBean;
import com.example.administrator.yuekaodome.net.AdApi;
import com.example.administrator.yuekaodome.ui.base.BasePresenter;
import com.example.administrator.yuekaodome.ui.home.Contract.HomeContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/31.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {
    private AdApi adApi;
    @Inject
    public HomePresenter(AdApi adApi) {
        this.adApi = adApi;
    }

    @Override
    public void getAd() {
        adApi.getAd()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<AdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdBean adBean) {
                        mView.getAdSuccess(adBean);

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
