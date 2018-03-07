package com.example.administrator.slopedisplacement;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.slopedisplacement.base.BaseActivity;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.mvp.BasePresenter;

public class MainActivity extends BaseMvpActivity {

    @Override
    protected BasePresenter loadPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        showLoading("测试");
    }


}
