package com.example.administrator.slopedisplacement.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.SchemeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/18.
 */

public class SelectSchemeAdapter extends BaseItemDraggableAdapter<SchemeBean.ListBean, BaseViewHolder> {
    public SelectSchemeAdapter(int layoutResId, List<SchemeBean.ListBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, SchemeBean.ListBean item) {
        helper.setText(R.id.tvSchemeName,item.getSchemeName()+"");

    }
}
