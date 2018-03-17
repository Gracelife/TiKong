package com.example.administrator.slopedisplacement.pushmi;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.app.ActivityManager.RunningAppProcessInfo;
import com.example.administrator.slopedisplacement.application.ProApplication;
import com.example.administrator.slopedisplacement.db.UserInfoPref;
import com.xiaomi.mipush.sdk.MiPushClient;

import java.util.List;

/**
 * 小米推送工具类
 */

public class PushMiUtils {
    // user your appid the key.
    private static final String APP_ID = "2882303761517742225";
    // user your appid the key.
    private static final String APP_KEY = "5121774217225";

    public static void init() {
        if (shouldInit()){
            MiPushClient.registerPush(ProApplication.getInstance(), APP_ID, APP_KEY);
        }
    }

    private static boolean shouldInit() {
        ActivityManager am = ((ActivityManager) ProApplication.getInstance().getSystemService(Context.ACTIVITY_SERVICE));
        List<RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = ProApplication.getInstance().getPackageName();
        int myPid = Process.myPid();
        for (RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }
}
