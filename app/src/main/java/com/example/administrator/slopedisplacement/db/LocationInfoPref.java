package com.example.administrator.slopedisplacement.db;


import io.reactivex.annotations.NonNull;

/**
 * 位置信息
 */

public class LocationInfoPref {
    /**
     * 纬度
     */
    private static final String mLatitude = "mLatitude";
    /**
     * 经度
     */
    private static final String mLongitude = "mLongitude";
    /**
     * 地址信息
     */
    private static final String mAddress = "mAddress";

    private static PrefHelper mPrefHelper = PrefHelper.Instance;

    public static double getLatitude() {
        return mPrefHelper.getPref(mLatitude, 0);
    }

    public static void setLatitude(@NonNull double latitude) {
        mPrefHelper.setPref(mLatitude, latitude);
    }


    public static double getLongitude() {
        return mPrefHelper.getPref(mLongitude, 0);
    }

    public static void setLongitude(@NonNull double longitude) {
        mPrefHelper.setPref(mLongitude, longitude);
    }

    public static String getAddress() {
        return mPrefHelper.getPref(mAddress, mAddress);
    }

    public static void setAddress(@NonNull String address) {
        mPrefHelper.setPref(mAddress, address);
    }

    /**
     * 保存位置信息
     */
    public static void saveLocation(double latitude, double longitude, String address) {
        setLatitude(latitude);
        setLongitude(longitude);
        setAddress(address);
    }

    /**
     * 清除位置信息
     */
    public static void clearLocation() {
        setLatitude(0);
        setLongitude(0);
        setAddress("");
    }
}
