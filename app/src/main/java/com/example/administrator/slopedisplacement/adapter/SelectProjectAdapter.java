package com.example.administrator.slopedisplacement.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.bean.ProjectBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/18.
 */

public class SelectProjectAdapter extends BaseItemDraggableAdapter<ProjectBean.ListBean, BaseViewHolder> {
    public SelectProjectAdapter(int layoutResId, ArrayList<ProjectBean.ListBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, ProjectBean.ListBean item) {
        helper.setText(R.id.tvProjectId,item.getRow_number());
        helper.setText(R.id.tvProjectName,item.getProjName());
        helper.setText(R.id.tvProjectStatic,item.getProjStatusCurrent());
        helper.setText(R.id.tvProjectAddress,item.getProjAddress());
        //helper.addOnClickListener(R.id.text_samll);
    }
}
