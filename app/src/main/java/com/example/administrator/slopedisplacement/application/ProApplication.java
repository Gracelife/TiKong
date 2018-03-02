package com.example.administrator.slopedisplacement.application;


import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * Created by GaoSheng on 2016/9/13.
 * 应用,主要用来做一下初始化的操作
 */

public class ProApplication extends Application {
    private static Context mContext;
   // public LocationService locationService;
    public Vibrator mVibrator;
    private  final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        //locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
       // SDKInitializer.initialize(getApplicationContext());
        mContext = this;
        mInstance = this;
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }

    private static ProApplication mInstance;


    public static ProApplication getInstance() {
        return mInstance;
    }

    /**
     * @return
     * 全局的上下文
     */
    public static Context getmContext() {
        return mContext;
    }

    private Intent intent;

    public void putIntent(Intent intent) {
        this.intent = intent;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public void jumpToTargetActivity(Context context) {

        context.startActivity(intent);
        this.intent = null;
    }
}
