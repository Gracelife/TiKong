package com.example.administrator.slopedisplacement.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.bean.SchemeAlarmListBean;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeMonitorListLogJson;
import com.example.administrator.slopedisplacement.utils.FormatUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 巡航流水数据的适配器
 */

public class CruiseDataAdapter extends BaseItemDraggableAdapter<GetSchemeMonitorListLogJson.ListBean, BaseViewHolder> {
    public CruiseDataAdapter(int layoutResId, List<GetSchemeMonitorListLogJson.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GetSchemeMonitorListLogJson.ListBean item) {
        helper.setText(R.id.tvItemCruiseDataId, item.getRecordID() + "")
                .setText(R.id.tvItemCruiseDataCreateTime, item.getCreateTime() + "")
                .setText(R.id.tvItemCruiseDataAreaName, item.getAreaNmae() + "")
                .setText(R.id.tvItemCruiseDataMonitorID, item.getMonitorID() + "")
                .setText(R.id.tvItemCruiseDataNowShift, FormatUtils.format2(item.getNowShift()))
                .setText(R.id.tvItemCruiseDataShift, FormatUtils.format2(item.getShift()))
                .setText(R.id.tvItemCruiseDataAddShift, FormatUtils.format2(item.getAddShift()))
                .setText(R.id.tvItemCruiseDataObd, FormatUtils.format5(item.getObd()));
        helper.addOnClickListener(R.id.tvItemCruiseDataNowShift);
    }
}
