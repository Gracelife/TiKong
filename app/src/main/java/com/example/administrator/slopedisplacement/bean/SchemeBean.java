package com.example.administrator.slopedisplacement.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/3/8.
 */

public class SchemeBean implements Serializable{

    /**
     * List : [{"SchemeID":46,"SchemeName":"室内测试","CamID":1014462,"CamSn":"105785374_002","States":0,"Phone":"15980680652","IsSend":"0","CreateTime":"2018-02-27 14:03:50","Threshold":2,"TimeOut":31},{"SchemeID":47,"SchemeName":"面线点测试","CamID":1014462,"CamSn":"105785374_002","States":0,"Phone":"","IsSend":"0","CreateTime":"2018-03-06 16:25:27","Threshold":20,"TimeOut":32},{"SchemeID":48,"SchemeName":"测试1","CamID":1014462,"CamSn":"","States":0,"Phone":"","IsSend":"0","CreateTime":"2018-03-07 11:09:45","Threshold":20,"TimeOut":331},{"SchemeID":49,"SchemeName":"测试2","CamID":1014462,"CamSn":"105785374_002","States":0,"Phone":"","IsSend":"0","CreateTime":"2018-03-06 15:48:23","Threshold":20,"TimeOut":34},{"SchemeID":50,"SchemeName":"新增OK测试","CamID":1014462,"CamSn":"","States":0,"Phone":"15980680652","IsSend":"1","CreateTime":"2018-03-07 10:59:42","Threshold":20,"TimeOut":45},{"SchemeID":51,"SchemeName":"巡航流水报表测试","CamID":1014462,"CamSn":"105785374_002","States":0,"Phone":"","IsSend":"0","CreateTime":"2018-03-06 15:48:44","Threshold":1,"TimeOut":36},{"SchemeID":56,"SchemeName":"整体测试","CamID":1014462,"CamSn":"105785374_002","States":1,"Phone":"15980680652","IsSend":"1         ","CreateTime":"2018-03-08 11:08:09","Threshold":20,"TimeOut":30}]
     * TotalCount : 7
     */

    private int TotalCount;
    private java.util.List<ListBean> List;

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public List<ListBean> getList() {
        return List;
    }

    public void setList(List<ListBean> List) {
        this.List = List;
    }

    public static class ListBean implements Serializable{
        /**
         * SchemeID : 46
         * SchemeName : 室内测试
         * CamID : 1014462
         * CamSn : 105785374_002
         * States : 0
         * Phone : 15980680652
         * IsSend : 0
         * CreateTime : 2018-02-27 14:03:50
         * Threshold : 2.0
         * TimeOut : 31
         */

        private int SchemeID;
        private String SchemeName;
        private int CamID;
        private String CamSn;
        private int States;
        private String Phone;
        private String IsSend;
        private String CreateTime;
        private double Threshold;
        private int TimeOut;

        public int getSchemeID() {
            return SchemeID;
        }

        public void setSchemeID(int SchemeID) {
            this.SchemeID = SchemeID;
        }

        public String getSchemeName() {
            return SchemeName;
        }

        public void setSchemeName(String SchemeName) {
            this.SchemeName = SchemeName;
        }

        public int getCamID() {
            return CamID;
        }

        public void setCamID(int CamID) {
            this.CamID = CamID;
        }

        public String getCamSn() {
            return CamSn;
        }

        public void setCamSn(String CamSn) {
            this.CamSn = CamSn;
        }

        public int getStates() {
            return States;
        }

        public void setStates(int States) {
            this.States = States;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String Phone) {
            this.Phone = Phone;
        }

        public String getIsSend() {
            return IsSend;
        }

        public void setIsSend(String IsSend) {
            this.IsSend = IsSend;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public double getThreshold() {
            return Threshold;
        }

        public void setThreshold(double Threshold) {
            this.Threshold = Threshold;
        }

        public int getTimeOut() {
            return TimeOut;
        }

        public void setTimeOut(int TimeOut) {
            this.TimeOut = TimeOut;
        }
    }
}
