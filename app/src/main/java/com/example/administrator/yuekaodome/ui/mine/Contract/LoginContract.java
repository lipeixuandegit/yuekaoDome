package com.example.administrator.yuekaodome.ui.mine.Contract;

import com.example.administrator.yuekaodome.bean.LoginBean;
import com.example.administrator.yuekaodome.ui.base.BaseContract;

/**
 * Created by Administrator on 2018/5/31.
 */

public interface LoginContract {
    interface View extends BaseContract.BaseView{
        void onSuccess(LoginBean loginBean);

    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getLogin(String mobile,String password);

    }
}
