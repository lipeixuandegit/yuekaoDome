package com.example.administrator.yuekaodome.ui.home.Contract;

import com.example.administrator.yuekaodome.bean.AdBean;
import com.example.administrator.yuekaodome.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/5/31.
 */

public interface HomeContract {
    interface View extends BaseContract.BaseView{
        void getAdSuccess(AdBean adBean);


    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getAd();
    }
}
