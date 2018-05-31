package com.example.administrator.yuekaodome.Component;

import com.example.administrator.yuekaodome.Module.HttpModule;
import com.example.administrator.yuekaodome.ui.home.HomeFragment;
import com.example.administrator.yuekaodome.ui.mine.LoginActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/5/31.
 */
@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(HomeFragment homeFragment);

    void inject(LoginActivity loginActivity);

}
