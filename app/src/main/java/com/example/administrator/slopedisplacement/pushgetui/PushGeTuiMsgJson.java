package com.example.administrator.slopedisplacement.pushgetui;

/**
 *  个推接收到的信息解析类
 */

public class PushGeTuiMsgJson {

    /**
     * result : 1
     * msg : 查询成功
     * data : {"camId":"1026714","schemeID":"19"}
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
         * camId : 1026714
         * schemeID : 19
         */

        private String camId;
        private String schemeID;

        public String getCamId() {
            return camId;
        }

        public void setCamId(String camId) {
            this.camId = camId;
        }

        public String getSchemeID() {
            return schemeID;
        }

        public void setSchemeID(String schemeID) {
            this.schemeID = schemeID;
        }
    }

    @Override
    public String toString() {
        return "PushGeTuiMsgJson{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
