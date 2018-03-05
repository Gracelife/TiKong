package com.example.administrator.slopedisplacement.base;

import android.Manifest;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

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

import java.io.File;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.ContentValues.TAG;

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
    private String appkey = "";
    private String appsecret = "";
    private String appid = "";
    private Class userPushService = GeTuiPushService.class;
    private static final int REQUEST_PERMISSION = 0;
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
        //initToolBar();
        initView();
        //初始化个推sdk
        parseManifests();
        initGeTuiSdk();
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
private void parseManifests() {
    String packageName = getApplicationContext().getPackageName();
    try {
        ApplicationInfo appInfo = getPackageManager().getApplicationInfo(packageName, PackageManager.GET_META_DATA);
        if (appInfo.metaData != null) {
            appid = appInfo.metaData.getString("PUSH_APPID");
            appsecret = appInfo.metaData.getString("PUSH_APPSECRET");
            appkey = appInfo.metaData.getString("PUSH_APPKEY");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private void initGeTuiSdk(){
    PackageManager pkgManager = getPackageManager();

    // 读写 sd card 权限非常重要, android6.0默认禁止的, 建议初始化之前就弹窗让用户赋予该权限
    boolean sdCardWritePermission =
            pkgManager.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, getPackageName()) == PackageManager.PERMISSION_GRANTED;

    // read phone state用于获取 imei 设备信息
    boolean phoneSatePermission =
            pkgManager.checkPermission(Manifest.permission.READ_PHONE_STATE, getPackageName()) == PackageManager.PERMISSION_GRANTED;

    if (Build.VERSION.SDK_INT >= 23 && !sdCardWritePermission || !phoneSatePermission) {
        requestPermission();
    } else {
        PushManager.getInstance().initialize(this.getApplicationContext(), userPushService);
    }

    // 注册 intentService 后 PushDemoReceiver 无效, sdk 会使用 DemoIntentService 传递数据,
    // AndroidManifest 对应保留一个即可(如果注册 DemoIntentService, 可以去掉 PushDemoReceiver, 如果注册了
    // IntentService, 必须在 AndroidManifest 中声明)
    PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), GeTuiIntentService.class);

    // 应用未启动, 个推 service已经被唤醒,显示该时间段内离线消息
    if (ProApplication.payloadData != null) {
    }

    // cpu 架构
    Log.d(TAG, "cpu arch = " + (Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0]));

    // 检查 so 是否存在
    File file = new File(this.getApplicationInfo().nativeLibraryDir + File.separator + "libgetuiext2.so");
    Log.e(TAG, "libgetuiext2.so exist = " + file.exists());
}
private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE},
                REQUEST_PERMISSION);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION) {
            if ((grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED)) {
                PushManager.getInstance().initialize(this.getApplicationContext(), userPushService);
            } else {
                Log.e(TAG, "We highly recommend that you need to grant the special permissions before initializing the SDK, otherwise some "
                        + "functions will not work");
                PushManager.getInstance().initialize(this.getApplicationContext(), userPushService);
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}

