package com.example.administrator.slopedisplacement.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.mvp.BasePresenter;
import com.example.administrator.slopedisplacement.mvp.IView;
import com.example.administrator.slopedisplacement.utils.ActivityUtils;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.RxActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by GaoSheng on 2016/9/13.
 */

public abstract class BaseActivity<P extends BasePresenter> extends RxActivity implements IView {

    protected TextView mTitle;
    protected ImageView mLeftBtn;
    protected TextView mLeftTv;
    protected ImageView mRightBtn;
    protected TextView mRightTv;

    private Unbinder unbinder;
    protected boolean mScreenOrientation = false;//屏幕的方向：横屏(true)   竖屏(false)
    protected P mPresenter;

    /**
     * 加载Presenter
     */
    protected abstract P loadPresenter();

    /**
     * 获取布局id
     */
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

    /**
     * 是否有标题栏
     */
    protected boolean hasActionBar() {
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mPresenter = loadPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);

//        initScreenOrientation();//用于横竖屏适配
        initToolBar();
        initView();
        initData(savedInstanceState);
        //       ImmersionBar.with(this)
        //             .statusBarColor(R.color.colorPrimary)
        //             .fitsSystemWindows(true)
        //             .init();   //所有子类都将继承这些相同的属性
        ActivityUtils.INSTANCE.addActivity(this);
    }

    /**
     * 初始化标题栏
     */
    private void initToolBar() {
        if (hasActionBar()) {
            mTitle = (TextView) findViewById(R.id.actionbar_mid_tv);
            mLeftBtn = (ImageView) findViewById(R.id.actionbar_left_btn);
            mLeftTv = (TextView) findViewById(R.id.actionbar_left_tv);
            mRightBtn = (ImageView) findViewById(R.id.actionbar_right_btn);
            mRightTv = (TextView) findViewById(R.id.actionbar_right_tv);
            mLeftBtn.setOnClickListener(v -> onLeftClick(v));
            mLeftTv.setOnClickListener(v -> onLeftClick(v));
            mRightBtn.setOnClickListener(v -> onRightClick(v));
            mRightTv.setOnClickListener(v -> onRightClick(v));
        }
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
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder.unbind();
//        ImmersionBar.with(this).destroy();  //不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        ActivityUtils.INSTANCE.finishActivity(this);
    }

    public Activity getActivity() {
        return this;
    }

    /**
     * 显示加载框
     */
    @Override
    public void showLoading() {

    }

    /**
     * 隐藏加载框
     */
    @Override
    public void hideLoading() {

    }

    /**
     * 用于绑定bindLifecycle
     */
    @Override
    public LifecycleTransformer bindLifecycle() {
        return super.bindToLifecycle();
    }
//    /**
//     * 初始化横屏/竖屏的标识
//     */
//    private void initScreenOrientation() {
//        Configuration mConfiguration = this.getResources().getConfiguration(); //获取设置的配置信息
//        int ori = mConfiguration.orientation; //获取屏幕方向
//        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
//            mScreenOrientation = true;//横屏
//        } else if (ori == mConfiguration.ORIENTATION_PORTRAIT) {
//            mScreenOrientation = false;//竖屏
//        }
//        changeScreen();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Log.e("1111", "onConfigurationChanged横屏");
//            mScreenOrientation = true;
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            Log.e("1111", "onConfigurationChanged竖屏");
//            mScreenOrientation = false;
//        } else if (newConfig.orientation == Configuration.ORIENTATION_UNDEFINED) {
//            Log.e("1111", "onConfigurationChanged竖屏");
//            mScreenOrientation = false;
//        }
//        changeScreen();
//    }
//
//    /**
//     * 转屏和onCreate时 设置显示 横屏/竖屏的布局
//     */
//    protected void changeScreen() {
//    }


}

