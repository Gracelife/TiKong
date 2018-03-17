package com.example.administrator.slopedisplacement.pushgetui;

import com.example.administrator.slopedisplacement.base.BaseActivity;
import com.igexin.sdk.PushManager;

/**
 *
 */

public class PushGeTuiUtil {
    public static void init(BaseActivity activity) {
        // 初始化服务
        PushManager.getInstance().initialize(activity, PushGeTuiPushService.class);
        // 注册消息接收服务
        PushManager.getInstance().registerPushIntentService(activity, PushGeTuiIntentService.class);
        PushManager.getInstance().bindAlias(activity,"233");
    }
}
