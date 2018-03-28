package com.example.administrator.slopedisplacement.pushmi;

import java.io.Serializable;

/**
 *
 */

public class PushMiJson implements Serializable{

    /**
     * result : 1
     * msg : 获取成功
     * data : {"Cam_Dx_Puid":"086591--1187927600","camFlowState":"15","camId":"1026714","camName":"","mIp":"222.77.183.67","mPassword":"123456","mPort":"80","mType":"5","mUserName":"hxht_admin","msysCode":"28","schemeID":"19","userID":"103652"}
     */

    private int result;
    private String msg;
    private DataBean data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Cam_Dx_Puid : 086591--1187927600
         * camFlowState : 15
         * camId : 1026714
         * camName :
         * mIp : 222.77.183.67
         * mPassword : 123456
         * mPort : 80
         * mType : 5
         * mUserName : hxht_admin
         * msysCode : 28
         * schemeID : 19
         * userID : 103652
         */

        private String Cam_Dx_Puid;
        private String camFlowState;
        private String camId;
        private String camName;
        private String mIp;
        private String mPassword;
        private String mPort;
        private String mType;
        private String mUserName;
        private String msysCode;
        private String schemeID;
        private String userID;

        public String getCam_Dx_Puid() {
            return Cam_Dx_Puid;
        }

        public void setCam_Dx_Puid(String Cam_Dx_Puid) {
            this.Cam_Dx_Puid = Cam_Dx_Puid;
        }

        public String getCamFlowState() {
            return camFlowState;
        }

        public void setCamFlowState(String camFlowState) {
            this.camFlowState = camFlowState;
        }

        public String getCamId() {
            return camId;
        }

        public void setCamId(String camId) {
            this.camId = camId;
        }

        public String getCamName() {
            return camName;
        }

        public void setCamName(String camName) {
            this.camName = camName;
        }

        public String getMIp() {
            return mIp;
        }

        public void setMIp(String mIp) {
            this.mIp = mIp;
        }

        public String getMPassword() {
            return mPassword;
        }

        public void setMPassword(String mPassword) {
            this.mPassword = mPassword;
        }

        public String getMPort() {
            return mPort;
        }

        public void setMPort(String mPort) {
            this.mPort = mPort;
        }

        public String getMType() {
            return mType;
        }

        public void setMType(String mType) {
            this.mType = mType;
        }

        public String getMUserName() {
            return mUserName;
        }

        public void setMUserName(String mUserName) {
            this.mUserName = mUserName;
        }

        public String getMsysCode() {
            return msysCode;
        }

        public void setMsysCode(String msysCode) {
            this.msysCode = msysCode;
        }

        public String getSchemeID() {
            return schemeID;
        }

        public void setSchemeID(String schemeID) {
            this.schemeID = schemeID;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }
    }
}
