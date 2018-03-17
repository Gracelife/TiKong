package com.example.administrator.slopedisplacement.activity;

import android.content.Intent;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.base.BaseActivity;
import com.example.administrator.slopedisplacement.utils.JumpToUtils;
import com.example.administrator.slopedisplacement.utils.LoadImgUtils;

import butterknife.BindView;

/**
 * 显示检测图(长焦图和广角图)页面
 */

public class ShowMonitoringImgActivity extends BaseActivity {
    @BindView(R.id.ivShowMonitoringImgWideAngle)
    ImageView mIvShowMonitoringImgWideAngle;
    @BindView(R.id.ivShowMonitoringImgLongFocal)
    ImageView mIvShowMonitoringImgLongFocal;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show_monitoring_img;
    }

    @Override
    protected void initView() {
        String title = "", wideAngleImg = "", longFocalImg = "";
        try {
            Intent intent = getIntent();
            title = intent.getStringExtra(JumpToUtils.KEY_TITLE);
            wideAngleImg = intent.getStringExtra(JumpToUtils.KEY_WIDE_ANGLE_IMG);
            longFocalImg = intent.getStringExtra(JumpToUtils.KEY_LONG_FOCAL_IMG);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        setToolBar(title);
        LoadImgUtils.loadImg(getActivity(), wideAngleImg, mIvShowMonitoringImgWideAngle);
        LoadImgUtils.loadImg(getActivity(), longFocalImg, mIvShowMonitoringImgLongFocal);
    }
}
