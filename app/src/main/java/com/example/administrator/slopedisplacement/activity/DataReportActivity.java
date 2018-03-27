package com.example.administrator.slopedisplacement.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.DataReportAdapter;
import com.example.administrator.slopedisplacement.base.BaseActivity;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeAreaListJson;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeFixedListJson;
import com.example.administrator.slopedisplacement.utils.JumpToUtils;

import butterknife.BindView;

/**
 * 数据报表页面
 */

public class DataReportActivity extends BaseActivity {

    @BindView(R.id.vpDataReport)
    ViewPager mViewPager;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_data_report;
    }

    @Override
    protected void initView() {
        try {
            setToolBar("数据报表");
            GetDatSchemeAreaListJson areaListJson = (GetDatSchemeAreaListJson) getIntent().getSerializableExtra(JumpToUtils.KEY_AREAL_LIST);
            GetDatSchemeFixedListJson fixedListJson = (GetDatSchemeFixedListJson) getIntent().getSerializableExtra(JumpToUtils.KEY_FIXED_LIST);
            String schemeID = getIntent().getStringExtra(JumpToUtils.KEY_SCHEME_ID);
            DataReportAdapter mHomeAdapter = new DataReportAdapter(getSupportFragmentManager(), areaListJson, fixedListJson, schemeID);
            mViewPager.setOffscreenPageLimit(4);//设置缓存
            mViewPager.setAdapter(mHomeAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
