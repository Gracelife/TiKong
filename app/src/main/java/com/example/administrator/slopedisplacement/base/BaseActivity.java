package com.example.administrator.slopedisplacement.base;

import android.Manifest;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.application.ProApplication;
import com.example.administrator.slopedisplacement.mvp.BasePresenter;
import com.example.administrator.slopedisplacement.mvp.IView;
import com.example.administrator.slopedisplacement.server.GeTuiIntentService;
import com.example.administrator.slopedisplacement.server.GeTuiPushService;
import com.example.administrator.slopedisplacement.utils.ActivityUtils;
import com.igexin.sdk.PushManager;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

/**
 *
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    protected TextView mTitle;
    protected ImageView mLeftBtn;
    protected TextView mLeftTv;
    protected ImageView mRightBtn;
    protected TextView mRightTv;
    private Unbinder unbinder;

    /**
     * 获取布局id
     */
    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 初始化数据
     *
     * @param savedInstanceState
     */
    protected void initData(Bundle savedInstanceState) {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        initData(savedInstanceState);
        //       ImmersionBar.with(this)
        //             .statusBarColor(R.color.colorPrimary)
        //             .fitsSystemWindows(true)
        //             .init();   //所有子类都将继承这些相同的属性
        ActivityUtils.INSTANCE.addActivity(this);
    }

    /**
     * 设置标题栏
     */
    protected void setToolBar(String title) {
        mTitle = (TextView) findViewById(R.id.actionbar_mid_tv);
        mTitle.setText(title);
        mLeftBtn = (ImageView) findViewById(R.id.actionbar_left_btn);
        mLeftTv = (TextView) findViewById(R.id.actionbar_left_tv);
        mRightBtn = (ImageView) findViewById(R.id.actionbar_right_btn);
        mRightTv = (TextView) findViewById(R.id.actionbar_right_tv);
        mLeftBtn.setOnClickListener(v -> onLeftClick(v));
        mLeftTv.setOnClickListener(v -> onLeftClick(v));
        mRightBtn.setOnClickListener(v -> onRightClick(v));
        mRightTv.setOnClickListener(v -> onRightClick(v));

    }

    /**
     * 标题左边按钮事件（含左边文字）
     */
    public void onLeftClick(View v) {
        finish();
    }

    /**
     * 标题右边按钮事件（含右边文字）
     */
    public void onRightClick(View v) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
//        ImmersionBar.with(this).destroy();  //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        ActivityUtils.INSTANCE.finishActivity(this);
    }

    public BaseActivity getActivity() {
        return this;
    }

    /**
     * 显示吐司()
     * @param msg 内容
     */
    public void showToast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
    }
}

