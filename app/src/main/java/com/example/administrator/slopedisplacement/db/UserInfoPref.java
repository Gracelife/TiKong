package com.example.administrator.slopedisplacement.db;


import io.reactivex.annotations.NonNull;

/**
 * 用户信息
 */

public class UserInfoPref {
    private static final String mUserName = "mUserName";//用户名
    private static final String mUserId = "mUserId";//用户名id
    private static final String mUserAccount = "mUserAccount";//用户账号

    private static final String mUserPassword = "mUserPassword";//用户密码
    private static final String mUserType = "mUserType";//用户类别  采样员 检验员

    private static final String mLoginState = "mLoginState";//登录状态 0未登录 1已登陆 2免登陆


    private static PrefHelper mPrefHelper = PrefHelper.Instance;

    public static String getUserName() {
        return mPrefHelper.getPref(mUserName, mUserName);
    }

    public static void setUserName(@NonNull String userName) {
        mPrefHelper.setPref(mUserName, userName);
    }


    public static String getUserId() {
        return mPrefHelper.getPref(mUserId, mUserId);
    }

    public static void setUserId(@NonNull String userId) {
        mPrefHelper.setPref(mUserId, userId);
    }


    public static String getUserAccount() {
        return mPrefHelper.getPref(mUserAccount, mUserAccount);
    }

    public static void setUserAccount(@NonNull String userAccount) {
        mPrefHelper.setPref(mUserAccount, userAccount);
    }


    public static String getUserPassword() {
        return mPrefHelper.getPref(mUserPassword, mUserPassword);
    }

    public static void setUserPassword(@NonNull String userPassword) {
        mPrefHelper.setPref(mUserPassword, userPassword);
    }


    public static String getUserType() {
        return mPrefHelper.getPref(mUserType, mUserType);
    }

    public static void setUserType(@NonNull String userType) {
        mPrefHelper.setPref(mUserType, userType);
    }

    public static String getLoginState() {
        return mPrefHelper.getPref(mLoginState, mLoginState);
    }

    public static void setLoginState(@NonNull String loginState) {
        mPrefHelper.setPref(mLoginState, loginState);
    }


    /**
     * 保存用户登录信息
     */
    public static void saveLoginInfo(String userAccount, String userName, String userPassword, String userId, String savePassword) {
        setUserAccount(userAccount);
        setUserName(userName);
        setUserPassword(userPassword);
        setUserId(userId);
        setLoginState(savePassword);
    }

    /**
     * 清除用户登录信息
     */
    public static void clearloginInfo() {
        setUserAccount("");
        setUserName("");
        setUserPassword("");
        setUserId("");
        setLoginState("0");
    }
}
