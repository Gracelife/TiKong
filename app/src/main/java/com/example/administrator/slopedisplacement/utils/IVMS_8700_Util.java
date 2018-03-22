//package com.example.administrator.slopedisplacement.utils;
//
//import android.content.Context;
//import android.net.wifi.WifiInfo;
//import android.net.wifi.WifiManager;
//import android.os.Looper;
//import android.util.Log;
//import android.view.SurfaceView;
//
//import com.example.administrator.slopedisplacement.application.ProApplication;
//import com.hikvision.sdk.VMSNetSDK;
//import com.hikvision.sdk.consts.SDKConstant;
//import com.hikvision.sdk.net.bean.LoginData;
//import com.hikvision.sdk.net.business.OnVMSNetSDKBusiness;
//
///**
// *
// */
//
//public class IVMS_8700_Util {
//    private static void test() {
//        IVMS_8700_Util.login(new OnVMSNetSDKBusiness() {
//            @Override
//            public void onFailure() {
////                mHandler.sendEmptyMessage(LOGIN_FAILED);
//                Log.e("8700", "登录失败");
//            }
//
//            @Override
//            public void onSuccess(Object obj) {
//                Log.e("8700", "登录成功");
//                if (obj instanceof LoginData) {
//                    SurfaceView surfaceView = null;
//                    int mStreamType = SDKConstant.LiveSDKConstant.MAIN_HIGH_STREAM;//码流
//                    IVMS_8700_Util.start("mSysCode", surfaceView, mStreamType);
//                }
//            }
//        });
//    }
//
//    /**
//     * 获取登录设备mac地址
//     *
//     * @return Mac地址
//     */
//    public static String getMacAddress() {
//        WifiManager wm = (WifiManager) ProApplication.getInstance().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//        WifiInfo connectionInfo = wm.getConnectionInfo();
//        String mac = connectionInfo.getMacAddress();
//        return mac == null ? "" : mac;
//    }
//
//    public static void login(OnVMSNetSDKBusiness business) {
////        String loginAddress = HttpConstants.HTTPS + "192.168.1.87:4433";
//        String loginAddress = "https://" + "120.35.11.49:443";
//        String userName = "admin";
//        String password = "Hckj1234";
//        String macAddress = getMacAddress();
//        VMSNetSDK.getInstance().Login(loginAddress, userName, password, macAddress, business);
//    }
//
//    public static void start(final String mSysCode, final SurfaceView mSurfaceView, final int mStreamType) {
//        new Thread() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                VMSNetSDK.getInstance().startLiveOpt(mSysCode, mSurfaceView, mStreamType, new OnVMSNetSDKBusiness() {
//                    @Override
//                    public void onFailure() {
//                        Log.e("8700", "播放失败");
////                        mHandler.sendEmptyMessage(GET_CAMERA_INFO_FAILURE);
//                    }
//
//                    @Override
//                    public void onSuccess(Object obj) {
//                        Log.e("8700", "播放成功");
////                        mHandler.sendEmptyMessage(GET_CAMERA_INFO_SUCCESS);
//                    }
//                });
//                Looper.loop();
//            }
//        }.start();
//    }
//}
