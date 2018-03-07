package com.example.administrator.slopedisplacement.db;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.administrator.slopedisplacement.application.ProApplication;
/**
 * SharedPreferences数据存储的帮助类
 */

public enum PrefHelper {
    Instance();
    private static final String PREFERENCE_NAME = "db_preferences";//数据存储名
    private SharedPreferences mPre;//SharedPreferences数据存储

    PrefHelper() {
        mPre = ProApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void setPref(String key, String valueString) {
        SharedPreferences.Editor localEditor = mPre.edit();
        localEditor.putString(key, valueString);
        localEditor.apply();
    }

    public void setPref(String key, int valueInt) {
        SharedPreferences.Editor localEditor = mPre.edit();
        localEditor.putInt(key, valueInt);
        localEditor.apply();
    }

    public void setPref(String key, long valueLong) {
        SharedPreferences.Editor localEditor = mPre.edit();
        localEditor.putLong(key, valueLong);
        localEditor.apply();
    }

    public void setPref(String key, float valueFloat) {
        SharedPreferences.Editor localEditor = mPre.edit();
        localEditor.putFloat(key, valueFloat);
        localEditor.apply();
    }

    public void setPref(String key, Double valueDouble) {
        SharedPreferences.Editor localEditor = mPre.edit();
        localEditor.putString(key, valueDouble.toString());
        localEditor.apply();
    }

    public void setPref(String key, boolean valueBoolean) {
        SharedPreferences.Editor localEditor = mPre.edit();
        localEditor.putBoolean(key, valueBoolean);
        localEditor.apply();
    }

    public String getPref(String key, String valueString) {
        return mPre.getString(key, valueString);
    }

    public int getPref(String key, int valueInt) {
        return mPre.getInt(key, valueInt);
    }

    public long getPref(String key, long valueLong) {
        return mPre.getLong(key, valueLong);
    }

    public float getPref(String key, float valueFloat) {
        return mPre.getFloat(key, valueFloat);
    }

    public double getPref(String key, Double valueDouble) {
        return Double.parseDouble(mPre.getString(key, valueDouble.toString()));
    }

    public boolean getPref(String key, boolean valueBoolean) {
        return mPre.getBoolean(key, valueBoolean);
    }

    /**
     * 清除指定key的数据
     *
     * @param key
     */
    public boolean removePref(String key) {
        SharedPreferences.Editor localEditor = mPre.edit();
        localEditor.remove(key);
        return localEditor.commit();
    }

    /**
     * 清除所有数据
     */
    public boolean clearPref() {
        SharedPreferences.Editor localEditor = mPre.edit();
        localEditor.clear();
        return localEditor.commit();
    }
}
