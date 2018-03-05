package com.example.administrator.slopedisplacement.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.example.administrator.slopedisplacement.application.ProApplication;
import com.example.administrator.slopedisplacement.base.BaseActivity;
import com.example.administrator.slopedisplacement.server.GeTuiIntentService;
import com.example.administrator.slopedisplacement.server.GeTuiPushService;
import com.igexin.sdk.PushManager;

import java.io.File;

import static android.content.ContentValues.TAG;

/**
 *
 */

public class GeTuiUtil {
    public static void init(BaseActivity activity) {
        PushManager.getInstance().initialize(activity, GeTuiPushService.class);
        // com.getui.demo.DemoPushService 为第三方自定义推送服务

        // com.getui.demo.DemoIntentService 为第三方自定义的推送服务事件接收类
//        PushManager.getInstance().registerPushIntentService(context, GeTuiIntentService.class);
    }
}
