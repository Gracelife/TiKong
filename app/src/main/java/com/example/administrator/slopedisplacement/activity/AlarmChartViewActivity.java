package com.example.administrator.slopedisplacement.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.mvp.contact.AlarmCharViewContact;
import com.example.administrator.slopedisplacement.mvp.presenter.AlarmChartViewPresenter;

import java.text.DecimalFormat;

import butterknife.BindView;

public class AlarmChartViewActivity extends BaseMvpActivity<AlarmChartViewPresenter> implements AlarmCharViewContact.View{
    Intent intent;
    @BindView(R.id.ivAlarmChartViewNow)
    ImageView ivAlarmChartViewNow;
    @BindView(R.id.ivAlarmChartViewOld)
    ImageView ivAlarmChartViewOld;
    @BindView(R.id.ivAlarmChartView)
    ImageView ivAlarmChartView;
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
        DecimalFormat df   = new DecimalFormat("######0.00");
        DecimalFormat df2   = new DecimalFormat("######0");
        setToolBar("告警图查看（ID:"+intent.getIntExtra("MonitorID",0)+",水平角度："+df.format(intent.getDoubleExtra("Aha",0))+",垂直角度："+df.format(intent.getDoubleExtra("Ava",0))+")位移值："+(df2.format(intent.getDoubleExtra("Shift",0)*1000)));
        Glide.with(AlarmChartViewActivity.this).load(intent.getStringExtra("Patha"))//拿到头像本地存放路径
                .error(R.mipmap.ic_launcher)//失败默认
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不单独缓存
                .skipMemoryCache(false)
                .into(ivAlarmChartViewNow);
        Glide.with(AlarmChartViewActivity.this).load(intent.getStringExtra("nextPatha"))//拿到头像本地存放路径
                .error(R.mipmap.ic_launcher)//失败默认
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不单独缓存
                .skipMemoryCache(false)
                .into(ivAlarmChartViewOld);
        Glide.with(AlarmChartViewActivity.this).load(intent.getStringExtra("oldPatha"))//拿到头像本地存放路径
                .error(R.mipmap.ic_launcher)//失败默认
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.NONE)//不单独缓存
                .skipMemoryCache(false)
                .into(ivAlarmChartView);
    }
}
