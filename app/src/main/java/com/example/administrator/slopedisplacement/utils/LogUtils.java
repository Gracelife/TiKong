package com.example.administrator.slopedisplacement.utils;

import android.util.Log;

import com.example.administrator.slopedisplacement.BuildConfig;
import com.orhanobut.logger.Logger;


/**
 * Created by gaosheng on 2016/7/29.
 */

public class LogUtils {

    public static final boolean isDebug = BuildConfig.DEBUG;

    /**
     * 打印一个debug等级的 log
     */
    public static void d(String tag, String msg) {
        if (isDebug) {
            Logger.d("aaaa_" + tag, msg);
        }
    }

    /**
     * 打印一个debug等级的 log
     */
    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e("aaaa_" + tag, msg);
        }
    }

    /**
     * 打印一个debug等级的 log
     */
    public static void e(Class cls, String msg) {
        if (isDebug) {
            Log.e("aaaa_" + cls.getSimpleName(), msg);
        }
    }


}
