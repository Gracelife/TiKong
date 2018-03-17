package com.example.administrator.slopedisplacement.application;


import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;

import com.example.administrator.slopedisplacement.pushmi.PushMiUtils;
import com.example.administrator.slopedisplacement.utils.L;
import com.example.administrator.slopedisplacement.utils.PhoneSystemUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.Logger;


/**
 * Created by GaoSheng on 2016/9/13.
 * 应用,主要用来做一下初始化的操作
 */

public class ProApplication extends Application {
    private static Context mContext;
    // public LocationService locationService;
    public Vibrator mVibrator;

    private static ProApplication mInstance;
    public static ProApplication getInstance() {
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //locationService = new LocationService(getApplicationContext());
        mVibrator = (Vibrator) getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        // SDKInitializer.initialize(getApplicationContext());
        mContext = this;
        mInstance = this;
        L.isDebug = true;//true显示log日志，false不显示
        Logger.addLogAdapter(new AndroidLogAdapter());
        if (PhoneSystemUtils.isMIUI()) {
            PushMiUtils.init();
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }

}