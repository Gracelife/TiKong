package com.example.administrator.slopedisplacement.bean;

/**
 * 海康8700播放视频所需数据
 */

public class IVMS_8700_Bean {

    private String mUserName;
    private String mPassword;
    private String mSysCode;
    private String mIp;
    private String mPort;
    private String mType;

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmSysCode() {
        return mSysCode;
    }

    public void setmSysCode(String mSysCode) {
        this.mSysCode = mSysCode;
    }

    public String getmIp() {
        return mIp;
    }

    public void setmIp(String mIp) {
        this.mIp = mIp;
    }

    public String getmPort() {
        return mPort;
    }

    public void setmPort(String mPort) {
        this.mPort = mPort;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    @Override
    public String toString() {
        return "IVMS_8700_Bean{" +
                "mUserName='" + mUserName + '\'' +
                ", mPassword='" + mPassword + '\'' +
                ", mSysCode='" + mSysCode + '\'' +
                ", mIp='" + mIp + '\'' +
                ", mPort='" + mPort + '\'' +
                ", mType='" + mType + '\'' +
                '}';
    }
}
