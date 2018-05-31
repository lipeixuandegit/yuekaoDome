package com.example.administrator.yuekaodome.ui.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yuekaodome.R;
import com.example.administrator.yuekaodome.bean.AdBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/31.
 */

public class AdAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<AdBean.MiaoshaBean.ListBeanX> list;
    private LayoutInflater inflater;

    public AdAdapter(Context context, List<AdBean.MiaoshaBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rvseckill_item, parent, false);
        SecKillViewHolder secKillViewHolder = new SecKillViewHolder(view);
        return secKillViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SecKillViewHolder secKillViewHolder = (SecKillViewHolder) holder;
        AdBean.MiaoshaBean.ListBeanX listBeanX = list.get(position);
        String s = listBeanX.getImages().split("\\|")[0];
        secKillViewHolder.iv.setImageURI(s);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class SecKillViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView iv;

        public SecKillViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
