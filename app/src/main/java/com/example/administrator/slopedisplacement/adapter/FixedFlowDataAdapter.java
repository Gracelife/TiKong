package com.example.administrator.slopedisplacement.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeFixedListLogJson;
import com.example.administrator.slopedisplacement.utils.FormatUtils;

import java.util.List;

/**
 * 定点流水数据的适配器
 */

public class FixedFlowDataAdapter extends BaseItemDraggableAdapter<GetSchemeFixedListLogJson.ListBean, BaseViewHolder> {
    public FixedFlowDataAdapter(int layoutResId, List<GetSchemeFixedListLogJson.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GetSchemeFixedListLogJson.ListBean item) {
        helper.setText(R.id.tvItemFixedFlowDataId, item.getFixedLogID() + "")
                .setText(R.id.tvItemFixedFlowDataCreateTime, item.getCreateTime() + "")
                .setText(R.id.tvItemFixedFlowName, item.getFixedName() + "")
                .setText(R.id.tvItemFixedFlowDataNowShift, FormatUtils.format2(item.getNowShift()))
                .setText(R.id.tvItemFixedFlowDataShift, FormatUtils.format2(item.getShift()))
                .setText(R.id.tvItemFixedFlowDataAddShift, FormatUtils.format2(item.getAddShift()))
                .setText(R.id.tvItemFixedFlowDataObd, FormatUtils.format5(item.getObd()));
    }
}
