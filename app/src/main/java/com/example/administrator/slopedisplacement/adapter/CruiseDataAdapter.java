package com.example.administrator.slopedisplacement.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.bean.SchemeAlarmListBean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 巡航流水数据的适配器
 */

public class CruiseDataAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    public CruiseDataAdapter(int layoutResId, List< String> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper,  String item) {

    }
}
