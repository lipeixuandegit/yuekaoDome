package com.example.administrator.yuekaodome.ui.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.yuekaodome.Component.DaggerHttpComponent;
import com.example.administrator.yuekaodome.MainActivity;
import com.example.administrator.yuekaodome.Module.HttpModule;
import com.example.administrator.yuekaodome.R;
import com.example.administrator.yuekaodome.bean.LoginBean;
import com.example.administrator.yuekaodome.ui.base.BaseActivity;
import com.example.administrator.yuekaodome.ui.mine.Contract.LoginContract;
import com.example.administrator.yuekaodome.ui.mine.Presenter.LoginPresenter;
import com.example.administrator.yuekaodome.utils.SharedPreferencesUtils;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View, View.OnClickListener {

    /**
     * 18310830365
     */
    private EditText mMobile;
    /**
     * 123456
     */
    private EditText mPassword;
    /**
     * 登录
     */
    private Button mBtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        initView();
    }

    private void initView() {
        mMobile = (EditText) findViewById(R.id.mobile);
        mPassword = (EditText) findViewById(R.id.password);
        mBtLogin = (Button) findViewById(R.id.btLogin);
        mBtLogin.setOnClickListener(this);

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {


    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast.makeText(LoginActivity.this, loginBean.getMsg(), Toast.LENGTH_SHORT).show();
        SharedPreferencesUtils.setParam(LoginActivity.this,"uid",loginBean.getData().getUid() + "");
        SharedPreferencesUtils.setParam(LoginActivity.this,"name",loginBean.getData().getUsername() + "");
        SharedPreferencesUtils.setParam(LoginActivity.this,"iconUrl",loginBean.getData().getIcon() + "");
        SharedPreferencesUtils.setParam(LoginActivity.this,"token",loginBean.getData().getToken() + "");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btLogin:
                String mobile = mMobile.getText().toString();
                String password = mPassword.getText().toString();
                mPresenter.getLogin(mobile,password);
                break;
        }
    }
}
