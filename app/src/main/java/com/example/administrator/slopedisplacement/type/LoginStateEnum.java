package com.example.administrator.slopedisplacement.type;

/**
 * 登录的状态
 */

public enum LoginStateEnum {
    /**
     * 未登录
     */
    UN_LOGGED("0"),
    /**
     * 已登录
     */
    LOGGED("1"),

    /**
     * 免登录(记住了密码)
     */
    FREE_LOGGED("2");

    private String mState;

    private LoginStateEnum(String state) {
        mState = state;
    }

    public String getState() {
        return mState;
    }
}
