package com.example.administrator.slopedisplacement.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.mvp.contact.AlarmCharViewContact;
import com.example.administrator.slopedisplacement.mvp.presenter.AlarmChartViewPresenter;

public class AlarmChartViewActivity extends BaseMvpActivity<AlarmChartViewPresenter> implements AlarmCharViewContact.View{
    Intent intent;

    @Override
    protected AlarmChartViewPresenter loadPresenter() {
        return new AlarmChartViewPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_alarm_chart_view;
    }

    @Override
    protected void initView() {
        intent = getIntent();
        //setActionBar();
    }
}
