package com.example.administrator.yuekaodome.inter;

import android.view.View;

/**
 * Created by Administrator on 2018/5/31.
 */

public interface IBase {
    int getContentLayout();
    void inject();

    void initView(View view);
}
