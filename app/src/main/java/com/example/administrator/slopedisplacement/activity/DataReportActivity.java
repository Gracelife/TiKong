package com.example.administrator.slopedisplacement.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.DataReportAdapter;
import com.example.administrator.slopedisplacement.base.BaseActivity;
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
        String schemeID = getIntent().getStringExtra(JumpToUtils.SCHEME_ID);
        DataReportAdapter mHomeAdapter = new DataReportAdapter(getSupportFragmentManager(),schemeID);
        mViewPager.setOffscreenPageLimit(4);//设置缓存
        mViewPager.setAdapter(mHomeAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }
}
