package com.example.administrator.slopedisplacement.type;

/**
 * 登录的状态
 */

public enum LoginStateEnum {
    /**
     * 记住密码
     */
    UN_LOGGED(true),
    /**
     * 未记住密码
     */
    LOGGED(false);



    private boolean mState;

    private LoginStateEnum(boolean state) {
        mState = state;
    }

    public boolean getState() {
        return mState;
    }
}
