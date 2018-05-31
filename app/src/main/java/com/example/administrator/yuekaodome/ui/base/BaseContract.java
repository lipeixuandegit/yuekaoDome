package com.example.administrator.yuekaodome.ui.base;

/**
 * Created by Administrator on 2018/5/31.
 */

public interface BaseContract {
    interface BasePresenter <T extends BaseView>{
        void attchView(T view);

        void detachView();

    }

    interface BaseView{
        void showLoading();

        void dismissLoading();

    }

}
