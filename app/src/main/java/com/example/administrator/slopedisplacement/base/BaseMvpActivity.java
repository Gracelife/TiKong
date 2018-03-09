package com.example.administrator.slopedisplacement.base;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.administrator.slopedisplacement.mvp.BasePresenter;
import com.example.administrator.slopedisplacement.mvp.IView;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 *
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements IView {
    protected P mPresenter;
    private ProgressDialog mProgressDialog = null;

    /**
     * 加载Presenter
     */
    protected abstract P loadPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPresenter = loadPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);
        super.onCreate(savedInstanceState);


        //初始化个推sdk
//        parseManifests();
//
//        initGeTuiSdk();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 显示加载框
     */
    @Override
    public void showLoading(String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setCanceledOnTouchOutside(false);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(msg);
            mProgressDialog.show();
        }
    }

    /**
     * 隐藏加载框
     */
    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

//    /**
//     * 显示加载对话框
//     *
//     * @param title 标题
//     * @param msg   内容
//     */
//    protected void showProgressDialog(String title, String msg) {

//    }
//
//    /**
//     * 隐藏加载对话框
//     */
//    protected void hideProgressDialog() {
//    }

    /**
     * 用于绑定bindLifecycle
     */
    @Override
    public LifecycleTransformer bindLifecycle() {
        return super.bindToLifecycle();
    }

//    private String appkey = "";
//    private String appsecret = "";
//    private String appid = "";
//    private Class userPushService = GeTuiPushService.class;
//    private static final int REQUEST_PERMISSION = 0;


//    private void parseManifests() {
//        String packageName = getApplicationContext().getPackageName();
//        try {
//            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(packageName, PackageManager.GET_META_DATA);
//            if (appInfo.metaData != null) {
//                appid = appInfo.metaData.getString("PUSH_APPID");
//                appsecret = appInfo.metaData.getString("PUSH_APPSECRET");
//                appkey = appInfo.metaData.getString("PUSH_APPKEY");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    private void initGeTuiSdk() {
//        PackageManager pkgManager = getPackageManager();
//
//        // 读写 sd card 权限非常重要, android6.0默认禁止的, 建议初始化之前就弹窗让用户赋予该权限
//        boolean sdCardWritePermission = pkgManager.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, getPackageName()) == PackageManager.PERMISSION_GRANTED;
//
//        // read phone state用于获取 imei 设备信息
//        boolean phoneSatePermission = pkgManager.checkPermission(Manifest.permission.READ_PHONE_STATE, getPackageName()) == PackageManager.PERMISSION_GRANTED;
//
//        if (Build.VERSION.SDK_INT >= 23 && !sdCardWritePermission || !phoneSatePermission) {
//            requestPermission();
//        } else {
//            PushManager.getInstance().initialize(this.getApplicationContext(), userPushService);
//        }
//
//        // 注册 intentService 后 PushDemoReceiver 无效, sdk 会使用 DemoIntentService 传递数据,
//        // AndroidManifest 对应保留一个即可(如果注册 DemoIntentService, 可以去掉 PushDemoReceiver, 如果注册了
//        // IntentService, 必须在 AndroidManifest 中声明)
//        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), GeTuiIntentService.class);
//
//        // 应用未启动, 个推 service已经被唤醒,显示该时间段内离线消息
//        if (ProApplication.payloadData != null) {
//        }
//
//        // cpu 架构
//        Log.d(TAG, "cpu arch = " + (Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0]));
//
//        // 检查 so 是否存在
//        File file = new File(this.getApplicationInfo().nativeLibraryDir + File.separator + "libgetuiext2.so");
//        Log.e(TAG, "libgetuiext2.so exist = " + file.exists());
//    }
//
//    private void requestPermission() {
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE},
//                REQUEST_PERMISSION);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        if (requestCode == REQUEST_PERMISSION) {
//            if ((grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
//                    && grantResults[1] == PackageManager.PERMISSION_GRANTED)) {
//                PushManager.getInstance().initialize(this.getApplicationContext(), userPushService);
//            } else {
//                Log.e(TAG, "We highly recommend that you need to grant the special permissions before initializing the SDK, otherwise some "
//                        + "functions will not work");
//                PushManager.getInstance().initialize(this.getApplicationContext(), userPushService);
//            }
//        } else {
//            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        }
//    }
}
