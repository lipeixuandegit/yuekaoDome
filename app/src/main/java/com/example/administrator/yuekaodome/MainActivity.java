package com.example.administrator.yuekaodome;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.yuekaodome.ui.home.HomeFragment;
import com.example.administrator.yuekaodome.ui.mine.MineFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private FrameLayout mFl;
    private RadioGroup mRg;
    /**
     * 首页
     */
    private RadioButton mBtn1;
    /**
     * 分类
     */
    private RadioButton mBtn2;
    /**
     * 购物车
     */
    private RadioButton mBtn3;
    /**
     * 我的
     */
    private RadioButton mBtn4;
    private MineFragment mineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        mineFragment = new MineFragment();
        fragmentManager.beginTransaction().replace(R.id.fl, homeFragment).commit();
        setListener();

    }

    private void setListener() {
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn1:
                        fragmentManager.beginTransaction().replace(R.id.fl, homeFragment).commit();
                        break;
                    case R.id.btn2:
                        //fragmentManager.beginTransaction().replace(R.id.fl, homeFragment).commit();
                        break;
                    case R.id.btn3:
                        //fragmentManager.beginTransaction().replace(R.id.fl, homeFragment).commit();
                        break;
                    case R.id.btn4:
                        fragmentManager.beginTransaction().replace(R.id.fl, mineFragment).commit();
                        break;

                }
            }
        });


    }

    private void initView() {
        mFl = (FrameLayout) findViewById(R.id.fl);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mBtn1 = (RadioButton) findViewById(R.id.btn1);
        mBtn2 = (RadioButton) findViewById(R.id.btn2);
        mBtn3 = (RadioButton) findViewById(R.id.btn3);
        mBtn4 = (RadioButton) findViewById(R.id.btn4);
    }
}
