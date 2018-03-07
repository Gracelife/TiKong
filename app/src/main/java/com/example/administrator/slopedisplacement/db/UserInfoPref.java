package com.example.administrator.slopedisplacement.db;


import io.reactivex.annotations.NonNull;

/**
 * 用户信息
 */

public class UserInfoPref {
    private static final String mUserName = "mUserName";//用户名
    private static final String mUId = "mUId";//用户名id
    private static final String mUserAccount = "mUserAccount";//用户账号

    private static final String mUserPassword = "mUserPassword";//用户密码
    private static final String mUserType = "mUserType";//用户类别  采样员 检验员

    private static final String mSavePassWord = "mSavePassWord";//是否记住密码 true  false


    private static PrefHelper mPrefHelper = PrefHelper.Instance;

    public static String getUserName() {
        return mPrefHelper.getPref(mUserName, mUserName);
    }

    public static void setUserName(@NonNull String userName) {
        mPrefHelper.setPref(mUserName, userName);
    }


    public static String getUserId() {
        return mPrefHelper.getPref(mUId, mUId);
    }

    public static void setUserId(@NonNull String userId) {
        mPrefHelper.setPref(mUId, userId);
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

    public static boolean getSavePassWord() {
        return mPrefHelper.getPref(mSavePassWord, false);
    }

    public static void setSavePassWord(@NonNull boolean loginState) {
        mPrefHelper.setPref(mSavePassWord, loginState);
    }


    /**
     * 保存用户登录信息
     */
    public static void saveLoginInfo(String userAccount, String userName, String userPassword, String userId) {
        setUserAccount(userAccount);
        setUserName(userName);
        setUserPassword(userPassword);
        setUserId(userId);
    }

    /**
     * 清除用户登录信息
     */
    public static void clearloginInfo() {
        setUserAccount("");
        setUserName("");
        setUserPassword("");
        setUserId("");
    }
}
