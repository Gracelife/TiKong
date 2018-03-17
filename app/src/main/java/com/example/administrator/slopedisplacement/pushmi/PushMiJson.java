package com.example.administrator.slopedisplacement.pushmi;

import com.example.administrator.slopedisplacement.base.BaseActivity;
import com.example.administrator.slopedisplacement.pushgetui.PushGeTuiIntentService;
import com.example.administrator.slopedisplacement.pushgetui.PushGeTuiMsgJson;
import com.example.administrator.slopedisplacement.pushgetui.PushGeTuiPushService;
import com.igexin.sdk.PushManager;

/**
 *
 */

public class PushMiJson {

    /**
     * result : 1
     * msg : 查询成功
     * data : {"camId":"1026714","schemeID":"19"}
     */

    private String result;
    private String msg;
    private PushGeTuiMsgJson.DataBean data;

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

    public PushGeTuiMsgJson.DataBean getData() {
        return data;
    }

    public void setData(PushGeTuiMsgJson.DataBean data) {
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
}
