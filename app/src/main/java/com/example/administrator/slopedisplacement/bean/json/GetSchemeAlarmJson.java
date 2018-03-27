package com.example.administrator.slopedisplacement.bean.json;

import java.io.Serializable;
import java.util.List;

/**
 * 告警日志
 */

public class GetSchemeAlarmJson implements Serializable {

    /**
     * List : [{"AlarmID":58,"SchemeID":58,"AreaID":76,"CamID":1014462,"States":2,"CreateTime":"2018-03-08 18:31:18","Types":3,"Shift1":0.5550000071525574,"Shift2":0,"Shift3":0,"Shift4":0,"AddShift1":0.5550000071525574,"AddShift2":0,"AddShift3":0,"AddShift4":0,"MonitorID1":106,"MonitorID2":0,"MonitorID3":0,"MonitorID4":0,"Path1a":"http://ftp.jsqqy.com:8121/upfile/Puzzle/105785374_002/11/20180308183039.jpg","path1b":null,"Path2a":"","path2b":null,"Path3a":"","path3b":null,"Path4a":"","path4b":null}]
     * TotalCount : 1
     */

    private String TotalCount;
    private java.util.List<ListBean> List;

    public String getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(String TotalCount) {
        this.TotalCount = TotalCount;
    }

    public List<ListBean> getList() {
        return List;
    }

    public void setList(List<ListBean> List) {
        this.List = List;
    }

    public static class ListBean {
        /**
         * AlarmID : 58
         * SchemeID : 58
         * AreaID : 76
         * CamID : 1014462
         * States : 2
         * CreateTime : 2018-03-08 18:31:18
         * Types : 3
         * Shift1 : 0.5550000071525574
         * Shift2 : 0
         * Shift3 : 0
         * Shift4 : 0
         * AddShift1 : 0.5550000071525574
         * AddShift2 : 0
         * AddShift3 : 0
         * AddShift4 : 0
         * MonitorID1 : 106
         * MonitorID2 : 0
         * MonitorID3 : 0
         * MonitorID4 : 0
         * Path1a : http://ftp.jsqqy.com:8121/upfile/Puzzle/105785374_002/11/20180308183039.jpg
         * path1b : null
         * Path2a :
         * path2b : null
         * Path3a :
         * path3b : null
         * Path4a :
         * path4b : null
         */

        private String AlarmID;
        private String SchemeID;
        private String AreaID;
        private String CamID;
        private String States;
        private String CreateTime;
        private String Types;
        private String Shift1;
        private String Shift2;
        private String Shift3;
        private String Shift4;
        private String AddShift1;
        private String AddShift2;
        private String AddShift3;
        private String AddShift4;
        private String MonitorID1;
        private String MonitorID2;
        private String MonitorID3;
        private String MonitorID4;
        private String Path1a;
        private String path1b;
        private String Path2a;
        private String path2b;
        private String Path3a;
        private String path3b;
        private String Path4a;
        private String path4b;

        public String getAlarmID() {
            return AlarmID;
        }

        public void setAlarmID(String AlarmID) {
            this.AlarmID = AlarmID;
        }

        public String getSchemeID() {
            return SchemeID;
        }

        public void setSchemeID(String SchemeID) {
            this.SchemeID = SchemeID;
        }

        public String getAreaID() {
            return AreaID;
        }

        public void setAreaID(String AreaID) {
            this.AreaID = AreaID;
        }

        public String getCamID() {
            return CamID;
        }

        public void setCamID(String CamID) {
            this.CamID = CamID;
        }

        public String getStates() {
            return States;
        }

        public void setStates(String States) {
            this.States = States;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getTypes() {
            return Types;
        }

        public void setTypes(String Types) {
            this.Types = Types;
        }

        public String getShift1() {
            return Shift1;
        }

        public void setShift1(String Shift1) {
            this.Shift1 = Shift1;
        }

        public String getShift2() {
            return Shift2;
        }

        public void setShift2(String Shift2) {
            this.Shift2 = Shift2;
        }

        public String getShift3() {
            return Shift3;
        }

        public void setShift3(String Shift3) {
            this.Shift3 = Shift3;
        }

        public String getShift4() {
            return Shift4;
        }

        public void setShift4(String Shift4) {
            this.Shift4 = Shift4;
        }

        public String getAddShift1() {
            return AddShift1;
        }

        public void setAddShift1(String AddShift1) {
            this.AddShift1 = AddShift1;
        }

        public String getAddShift2() {
            return AddShift2;
        }

        public void setAddShift2(String AddShift2) {
            this.AddShift2 = AddShift2;
        }

        public String getAddShift3() {
            return AddShift3;
        }

        public void setAddShift3(String AddShift3) {
            this.AddShift3 = AddShift3;
        }

        public String getAddShift4() {
            return AddShift4;
        }

        public void setAddShift4(String AddShift4) {
            this.AddShift4 = AddShift4;
        }

        public String getMonitorID1() {
            return MonitorID1;
        }

        public void setMonitorID1(String MonitorID1) {
            this.MonitorID1 = MonitorID1;
        }

        public String getMonitorID2() {
            return MonitorID2;
        }

        public void setMonitorID2(String MonitorID2) {
            this.MonitorID2 = MonitorID2;
        }

        public String getMonitorID3() {
            return MonitorID3;
        }

        public void setMonitorID3(String MonitorID3) {
            this.MonitorID3 = MonitorID3;
        }

        public String getMonitorID4() {
            return MonitorID4;
        }

        public void setMonitorID4(String MonitorID4) {
            this.MonitorID4 = MonitorID4;
        }

        public String getPath1a() {
            return Path1a;
        }

        public void setPath1a(String Path1a) {
            this.Path1a = Path1a;
        }

        public String getPath1b() {
            return path1b;
        }

        public void setPath1b(String path1b) {
            this.path1b = path1b;
        }

        public String getPath2a() {
            return Path2a;
        }

        public void setPath2a(String Path2a) {
            this.Path2a = Path2a;
        }

        public String getPath2b() {
            return path2b;
        }

        public void setPath2b(String path2b) {
            this.path2b = path2b;
        }

        public String getPath3a() {
            return Path3a;
        }

        public void setPath3a(String Path3a) {
            this.Path3a = Path3a;
        }

        public String getPath3b() {
            return path3b;
        }

        public void setPath3b(String path3b) {
            this.path3b = path3b;
        }

        public String getPath4a() {
            return Path4a;
        }

        public void setPath4a(String Path4a) {
            this.Path4a = Path4a;
        }

        public String getPath4b() {
            return path4b;
        }

        public void setPath4b(String path4b) {
            this.path4b = path4b;
        }
    }
}
