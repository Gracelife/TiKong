package com.example.administrator.slopedisplacement.pushgetui;

/**
 *  个推接收到的信息解析类
 */

public class PushGeTuiMsgJson {


    /**
     * result : 1
     * msg : 查询成功
     * data : {"schemeID":"19","mUserName":"hxht_admin","mPassword":"123456","msysCode":"28","mIp":"222.77.183.67","mPort":"80","mType":"5","Cam_Dx_Puid":"086591--1187927600","camId":"1026714","camName":"","camFlowState":"15"}
     */

    private String result;
    private String msg;
    private DataBean data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
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
         * schemeID : 19
         * mUserName : hxht_admin
         * mPassword : 123456
         * msysCode : 28
         * mIp : 222.77.183.67
         * mPort : 80
         * mType : 5
         * Cam_Dx_Puid : 086591--1187927600
         * camId : 1026714
         * camName :
         * camFlowState : 15
         */

        private String schemeID;
        private String mUserName;
        private String mPassword;
        private String msysCode;
        private String mIp;
        private String mPort;
        private String mType;
        private String Cam_Dx_Puid;
        private String camId;
        private String camName;
        private String camFlowState;

        public String getSchemeID() {
            return schemeID;
        }

        public void setSchemeID(String schemeID) {
            this.schemeID = schemeID;
        }

        public String getMUserName() {
            return mUserName;
        }

        public void setMUserName(String mUserName) {
            this.mUserName = mUserName;
        }

        public String getMPassword() {
            return mPassword;
        }

        public void setMPassword(String mPassword) {
            this.mPassword = mPassword;
        }

        public String getMsysCode() {
            return msysCode;
        }

        public void setMsysCode(String msysCode) {
            this.msysCode = msysCode;
        }

        public String getMIp() {
            return mIp;
        }

        public void setMIp(String mIp) {
            this.mIp = mIp;
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

        public String getCam_Dx_Puid() {
            return Cam_Dx_Puid;
        }

        public void setCam_Dx_Puid(String Cam_Dx_Puid) {
            this.Cam_Dx_Puid = Cam_Dx_Puid;
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

        public String getCamFlowState() {
            return camFlowState;
        }

        public void setCamFlowState(String camFlowState) {
            this.camFlowState = camFlowState;
        }
    }
}
