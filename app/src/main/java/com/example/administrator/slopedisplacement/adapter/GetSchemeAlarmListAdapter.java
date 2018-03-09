package com.example.administrator.slopedisplacement.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.SchemeAlarmListBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/18.
 */

public class GetSchemeAlarmListAdapter extends BaseItemDraggableAdapter<SchemeAlarmListBean.ListBean, BaseViewHolder> {
    public GetSchemeAlarmListAdapter(int layoutResId, ArrayList<SchemeAlarmListBean.ListBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, SchemeAlarmListBean.ListBean item) {



    }
}
