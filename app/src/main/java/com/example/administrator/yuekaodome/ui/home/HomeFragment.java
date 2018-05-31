package com.example.administrator.yuekaodome.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.yuekaodome.Component.DaggerHttpComponent;
import com.example.administrator.yuekaodome.R;
import com.example.administrator.yuekaodome.bean.AdBean;
import com.example.administrator.yuekaodome.ui.base.BaseFragment;
import com.example.administrator.yuekaodome.ui.home.Contract.HomeContract;
import com.example.administrator.yuekaodome.ui.home.Presenter.HomePresenter;
import com.example.administrator.yuekaodome.ui.home.adapter.AdAdapter;
import com.example.administrator.yuekaodome.ui.home.adapter.RvRecommendAdapter;
import com.example.administrator.yuekaodome.ui.music.MusicActivity;
import com.example.administrator.yuekaodome.utils.GlideImageLoader;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/31.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {
    private Banner mBanner;
    /**
     * 京东秒杀:
     */
    private TextView mTvJD;
    private MarqueeView mMarqueeView;
    private RecyclerView mRvSecKill;
    private RecyclerView mRvRecommend;

    @Override
    public int getContentLayout() {
        return R.layout.home_item;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build().inject(this);


    }

    @Override
    public void initView(View view) {
        mTvJD = (TextView) view.findViewById(R.id.tvJD);
        mMarqueeView = (MarqueeView) view.findViewById(R.id.marqueeView);
        mRvSecKill = (RecyclerView) view.findViewById(R.id.rvSecKill);
        mRvRecommend = (RecyclerView) view.findViewById(R.id.rvRecommend);
        mBanner = (Banner) view.findViewById(R.id.banner);

        List<String> info = new ArrayList<>();
        info.add("1. 大家好，我是孙福生。");
        info.add("2. 欢迎大家关注我哦！");
        info.add("3. GitHub帐号：sfsheng0322");
        info.add("4. 新浪微博：孙福生微博");
        info.add("5. 个人博客：sunfusheng.com");
        info.add("6. 微信公众号：孙福生");
        mMarqueeView.startWithList(info);



        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        mRvRecommend.setLayoutManager(gridLayoutManager);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        mRvSecKill.setLayoutManager(gridLayoutManager1);


        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getContext(), MusicActivity.class);
                startActivity(intent);
            }
        });
        mPresenter.getAd();

    }



    @Override
    public void getAdSuccess(AdBean adBean) {
        List<AdBean.DataBean> data = adBean.getData();
        List<String> image = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            image.add(data.get(i).getIcon());
        }
        mBanner.setImages(image);
        mBanner.start();
        AdAdapter adAdapter = new AdAdapter(getContext(), adBean.getMiaosha().getList());
        mRvSecKill.setAdapter(adAdapter);

        RvRecommendAdapter adapter = new RvRecommendAdapter(getContext(),adBean.getTuijian().getList());

        mRvRecommend.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBanner.stopAutoPlay();
    }
}
