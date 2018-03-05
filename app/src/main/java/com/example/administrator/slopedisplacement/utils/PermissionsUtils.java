package com.example.administrator.slopedisplacement.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

/**
 * 权限帮助类
 */

public class PermissionsUtils {
    /**
     * 蓝牙模块需要的权限
     */
    public static final String[] PERMISSION_BLUETOOTH = {
            Manifest.permission.BLUETOOTH,
            Manifest.permission.BLUETOOTH_ADMIN,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};
    /**
     * 个推推送需要的权限
     */
    public static final String[] PERMISSION_GETUI = {
            Manifest.permission.READ_PHONE_STATE,//读写 sd card 权限非常重要
            Manifest.permission.BLUETOOTH_ADMIN};//read phone state用于获取 imei 设备信息

    /**
     * 动态申请权限
     * @param activity
     * @param permissions       申请的权限名
     * @param permissionCall    申请结果回调
     */
    public static void requestPermissions(Activity activity,
                                          String[] permissions,
                                          PermissionsUtils.PermissionCall permissionCall) {
        RxPermissions rxPermission = new RxPermissions(activity);
        rxPermission.requestEach(permissions)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            // 用户已经同意该权限
                            permissionCall.onSuccess();
                            Log.d("TAG", permission.name + "用户已经同意该权限");
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                            permissionCall.onFail();
                            Log.d("TAG", permission.name + " 用户拒绝了该权限，没有选中『不再询问』");
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                            permissionCall.onFail();
                            Log.d("TAG", permission.name + "用户拒绝了该权限，并且选中『不再询问』");
                        }
                    }
                });
    }

    /**
     * 权限回调，用于处理申请成功和失败的回调
     */
    public interface PermissionCall {
        /**
         * 请求权限成功
         */
        void onSuccess();

        /**
         * 请求权限失败
         */
        void onFail();
    }
}
