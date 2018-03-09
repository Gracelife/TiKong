package com.example.administrator.slopedisplacement.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.bean.DriverBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/18.
 */

public class SelectDriverAdapter extends BaseItemDraggableAdapter<DriverBean.ListBean, BaseViewHolder> {
    public SelectDriverAdapter(int layoutResId, ArrayList<DriverBean.ListBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, DriverBean.ListBean item) {
           helper.setText(R.id.tvDriverName,item.getCamName()+"");
           if((item.getCamFlowState()+"").equals("16")){
               //16 维护中
               helper.setImageResource(R.id.ivDriverStatus,R.mipmap.ic_launcher_round);
           }else{
               //监控中
               helper.setImageResource(R.id.ivDriverStatus,R.mipmap.ic_launcher_round);
           }
           //helper.addOnClickListener(R.id.text_samll);

    }
}
