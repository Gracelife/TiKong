package com.example.administrator.slopedisplacement.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/3/8.
 */

public class SchemeAlarmListBean implements Serializable{


    /**
     * List : [{"RowNumber":1,"AlarmID":279,"SchemeID":58,"AreaID":16,"CamID":1029719,"States":0,"CreateTime":"2018-03-09 09:08:38","Types":1,"Shift1":0.007999420166015625,"Shift2":0.007999420166015625,"Shift3":0.007999420166015625,"Shift4":0.007999420166015625,"AddShift1":0.0020012817382806247,"AddShift2":0.0020012817382806247,"AddShift3":0.0020012817382806247,"AddShift4":0.0020012817382806247,"MonitorID1":16,"MonitorID2":16,"MonitorID3":16,"MonitorID4":16,"Path1a":null,"path1b":null,"Path2a":null,"path2b":null,"Path3a":null,"path3b":null,"Path4a":null,"path4b":null,"SchemeName":"整理测试new","AreaNmae":"停车站new","SendNun":"否","oldPath1a":"http://ftp.jsqqy.com:8021/upfile/Puzzle/105785374/11/20180227114128.jpg","oldPath2a":"http://ftp.jsqqy.com:8021/upfile/Puzzle/105785374/11/20180227114128.jpg","oldPath3a":"http://ftp.jsqqy.com:8021/upfile/Puzzle/105785374/11/20180227114128.jpg","oldPath4a":"http://ftp.jsqqy.com:8021/upfile/Puzzle/105785374/11/20180227114128.jpg","oldPath1b":null,"oldPath2b":null,"oldPath3b":null,"oldPath4b":null,"nextPath1a":null,"nextPath2a":null,"nextPath3a":null,"nextPath4a":null,"Aha1":86.28500366210938,"Ava1":12.97406005859375,"Aha2":86.28500366210938,"Ava2":12.97406005859375,"Aha3":86.28500366210938,"Ava3":12.97406005859375,"Aha4":86.28500366210938,"Ava4":12.97406005859375},{"RowNumber":2,"AlarmID":58,"SchemeID":58,"AreaID":76,"CamID":1014462,"States":0,"CreateTime":"2018-03-08 18:31:18","Types":3,"Shift1":0.5550000071525574,"Shift2":0,"Shift3":0,"Shift4":0,"AddShift1":0.5550000071525574,"AddShift2":0,"AddShift3":0,"AddShift4":0,"MonitorID1":106,"MonitorID2":0,"MonitorID3":0,"MonitorID4":0,"Path1a":"http://ftp.jsqqy.com:8121/upfile/Puzzle/105785374_002/11/20180308183039.jpg","path1b":null,"Path2a":"","path2b":null,"Path3a":"","path3b":null,"Path4a":"","path4b":null,"SchemeName":"整理测试new","AreaNmae":"点点","SendNun":"否","oldPath1a":"http://10.1.3.55:8989/UploadFile/PuzzleImg/NodeImg/20180308181537108.jpg","oldPath2a":null,"oldPath3a":null,"oldPath4a":null,"oldPath1b":null,"oldPath2b":null,"oldPath3b":null,"oldPath4b":null,"nextPath1a":null,"nextPath2a":null,"nextPath3a":null,"nextPath4a":null,"Aha1":145.261,"Ava1":22.263,"Aha2":null,"Ava2":null,"Aha3":null,"Ava3":null,"Aha4":null,"Ava4":null}]
     * TotalCount : 2
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

    public static class ListBean {
        /**
         * RowNumber : 1
         * AlarmID : 279
         * SchemeID : 58
         * AreaID : 16
         * CamID : 1029719
         * States : 0
         * CreateTime : 2018-03-09 09:08:38
         * Types : 1
         * Shift1 : 0.007999420166015625
         * Shift2 : 0.007999420166015625
         * Shift3 : 0.007999420166015625
         * Shift4 : 0.007999420166015625
         * AddShift1 : 0.0020012817382806247
         * AddShift2 : 0.0020012817382806247
         * AddShift3 : 0.0020012817382806247
         * AddShift4 : 0.0020012817382806247
         * MonitorID1 : 16
         * MonitorID2 : 16
         * MonitorID3 : 16
         * MonitorID4 : 16
         * Path1a : null
         * path1b : null
         * Path2a : null
         * path2b : null
         * Path3a : null
         * path3b : null
         * Path4a : null
         * path4b : null
         * SchemeName : 整理测试new
         * AreaNmae : 停车站new
         * SendNun : 否
         * oldPath1a : http://ftp.jsqqy.com:8021/upfile/Puzzle/105785374/11/20180227114128.jpg
         * oldPath2a : http://ftp.jsqqy.com:8021/upfile/Puzzle/105785374/11/20180227114128.jpg
         * oldPath3a : http://ftp.jsqqy.com:8021/upfile/Puzzle/105785374/11/20180227114128.jpg
         * oldPath4a : http://ftp.jsqqy.com:8021/upfile/Puzzle/105785374/11/20180227114128.jpg
         * oldPath1b : null
         * oldPath2b : null
         * oldPath3b : null
         * oldPath4b : null
         * nextPath1a : null
         * nextPath2a : null
         * nextPath3a : null
         * nextPath4a : null
         * Aha1 : 86.28500366210938
         * Ava1 : 12.97406005859375
         * Aha2 : 86.28500366210938
         * Ava2 : 12.97406005859375
         * Aha3 : 86.28500366210938
         * Ava3 : 12.97406005859375
         * Aha4 : 86.28500366210938
         * Ava4 : 12.97406005859375
         */

        private int RowNumber;
        private int AlarmID;
        private int SchemeID;
        private int AreaID;
        private int CamID;
        private int States;
        private String CreateTime;
        private int Types;
        private double Shift1;
        private double Shift2;
        private double Shift3;
        private double Shift4;
        private double AddShift1;
        private double AddShift2;
        private double AddShift3;
        private double AddShift4;
        private int MonitorID1;
        private int MonitorID2;
        private int MonitorID3;
        private int MonitorID4;
        private Object Path1a;
        private Object path1b;
        private Object Path2a;
        private Object path2b;
        private Object Path3a;
        private Object path3b;
        private Object Path4a;
        private Object path4b;
        private String SchemeName;
        private String AreaNmae;
        private String SendNun;
        private String oldPath1a;
        private String oldPath2a;
        private String oldPath3a;
        private String oldPath4a;
        private Object oldPath1b;
        private Object oldPath2b;
        private Object oldPath3b;
        private Object oldPath4b;
        private Object nextPath1a;
        private Object nextPath2a;
        private Object nextPath3a;
        private Object nextPath4a;
        private double Aha1;
        private double Ava1;
        private double Aha2;
        private double Ava2;
        private double Aha3;
        private double Ava3;
        private double Aha4;
        private double Ava4;

        public int getRowNumber() {
            return RowNumber;
        }

        public void setRowNumber(int RowNumber) {
            this.RowNumber = RowNumber;
        }

        public int getAlarmID() {
            return AlarmID;
        }

        public void setAlarmID(int AlarmID) {
            this.AlarmID = AlarmID;
        }

        public int getSchemeID() {
            return SchemeID;
        }

        public void setSchemeID(int SchemeID) {
            this.SchemeID = SchemeID;
        }

        public int getAreaID() {
            return AreaID;
        }

        public void setAreaID(int AreaID) {
            this.AreaID = AreaID;
        }

        public int getCamID() {
            return CamID;
        }

        public void setCamID(int CamID) {
            this.CamID = CamID;
        }

        public int getStates() {
            return States;
        }

        public void setStates(int States) {
            this.States = States;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getTypes() {
            return Types;
        }

        public void setTypes(int Types) {
            this.Types = Types;
        }

        public double getShift1() {
            return Shift1;
        }

        public void setShift1(double Shift1) {
            this.Shift1 = Shift1;
        }

        public double getShift2() {
            return Shift2;
        }

        public void setShift2(double Shift2) {
            this.Shift2 = Shift2;
        }

        public double getShift3() {
            return Shift3;
        }

        public void setShift3(double Shift3) {
            this.Shift3 = Shift3;
        }

        public double getShift4() {
            return Shift4;
        }

        public void setShift4(double Shift4) {
            this.Shift4 = Shift4;
        }

        public double getAddShift1() {
            return AddShift1;
        }

        public void setAddShift1(double AddShift1) {
            this.AddShift1 = AddShift1;
        }

        public double getAddShift2() {
            return AddShift2;
        }

        public void setAddShift2(double AddShift2) {
            this.AddShift2 = AddShift2;
        }

        public double getAddShift3() {
            return AddShift3;
        }

        public void setAddShift3(double AddShift3) {
            this.AddShift3 = AddShift3;
        }

        public double getAddShift4() {
            return AddShift4;
        }

        public void setAddShift4(double AddShift4) {
            this.AddShift4 = AddShift4;
        }

        public int getMonitorID1() {
            return MonitorID1;
        }

        public void setMonitorID1(int MonitorID1) {
            this.MonitorID1 = MonitorID1;
        }

        public int getMonitorID2() {
            return MonitorID2;
        }

        public void setMonitorID2(int MonitorID2) {
            this.MonitorID2 = MonitorID2;
        }

        public int getMonitorID3() {
            return MonitorID3;
        }

        public void setMonitorID3(int MonitorID3) {
            this.MonitorID3 = MonitorID3;
        }

        public int getMonitorID4() {
            return MonitorID4;
        }

        public void setMonitorID4(int MonitorID4) {
            this.MonitorID4 = MonitorID4;
        }

        public Object getPath1a() {
            return Path1a;
        }

        public void setPath1a(Object Path1a) {
            this.Path1a = Path1a;
        }

        public Object getPath1b() {
            return path1b;
        }

        public void setPath1b(Object path1b) {
            this.path1b = path1b;
        }

        public Object getPath2a() {
            return Path2a;
        }

        public void setPath2a(Object Path2a) {
            this.Path2a = Path2a;
        }

        public Object getPath2b() {
            return path2b;
        }

        public void setPath2b(Object path2b) {
            this.path2b = path2b;
        }

        public Object getPath3a() {
            return Path3a;
        }

        public void setPath3a(Object Path3a) {
            this.Path3a = Path3a;
        }

        public Object getPath3b() {
            return path3b;
        }

        public void setPath3b(Object path3b) {
            this.path3b = path3b;
        }

        public Object getPath4a() {
            return Path4a;
        }

        public void setPath4a(Object Path4a) {
            this.Path4a = Path4a;
        }

        public Object getPath4b() {
            return path4b;
        }

        public void setPath4b(Object path4b) {
            this.path4b = path4b;
        }

        public String getSchemeName() {
            return SchemeName;
        }

        public void setSchemeName(String SchemeName) {
            this.SchemeName = SchemeName;
        }

        public String getAreaNmae() {
            return AreaNmae;
        }

        public void setAreaNmae(String AreaNmae) {
            this.AreaNmae = AreaNmae;
        }

        public String getSendNun() {
            return SendNun;
        }

        public void setSendNun(String SendNun) {
            this.SendNun = SendNun;
        }

        public String getOldPath1a() {
            return oldPath1a;
        }

        public void setOldPath1a(String oldPath1a) {
            this.oldPath1a = oldPath1a;
        }

        public String getOldPath2a() {
            return oldPath2a;
        }

        public void setOldPath2a(String oldPath2a) {
            this.oldPath2a = oldPath2a;
        }

        public String getOldPath3a() {
            return oldPath3a;
        }

        public void setOldPath3a(String oldPath3a) {
            this.oldPath3a = oldPath3a;
        }

        public String getOldPath4a() {
            return oldPath4a;
        }

        public void setOldPath4a(String oldPath4a) {
            this.oldPath4a = oldPath4a;
        }

        public Object getOldPath1b() {
            return oldPath1b;
        }

        public void setOldPath1b(Object oldPath1b) {
            this.oldPath1b = oldPath1b;
        }

        public Object getOldPath2b() {
            return oldPath2b;
        }

        public void setOldPath2b(Object oldPath2b) {
            this.oldPath2b = oldPath2b;
        }

        public Object getOldPath3b() {
            return oldPath3b;
        }

        public void setOldPath3b(Object oldPath3b) {
            this.oldPath3b = oldPath3b;
        }

        public Object getOldPath4b() {
            return oldPath4b;
        }

        public void setOldPath4b(Object oldPath4b) {
            this.oldPath4b = oldPath4b;
        }

        public Object getNextPath1a() {
            return nextPath1a;
        }

        public void setNextPath1a(Object nextPath1a) {
            this.nextPath1a = nextPath1a;
        }

        public Object getNextPath2a() {
            return nextPath2a;
        }

        public void setNextPath2a(Object nextPath2a) {
            this.nextPath2a = nextPath2a;
        }

        public Object getNextPath3a() {
            return nextPath3a;
        }

        public void setNextPath3a(Object nextPath3a) {
            this.nextPath3a = nextPath3a;
        }

        public Object getNextPath4a() {
            return nextPath4a;
        }

        public void setNextPath4a(Object nextPath4a) {
            this.nextPath4a = nextPath4a;
        }

        public double getAha1() {
            return Aha1;
        }

        public void setAha1(double Aha1) {
            this.Aha1 = Aha1;
        }

        public double getAva1() {
            return Ava1;
        }

        public void setAva1(double Ava1) {
            this.Ava1 = Ava1;
        }

        public double getAha2() {
            return Aha2;
        }

        public void setAha2(double Aha2) {
            this.Aha2 = Aha2;
        }

        public double getAva2() {
            return Ava2;
        }

        public void setAva2(double Ava2) {
            this.Ava2 = Ava2;
        }

        public double getAha3() {
            return Aha3;
        }

        public void setAha3(double Aha3) {
            this.Aha3 = Aha3;
        }

        public double getAva3() {
            return Ava3;
        }

        public void setAva3(double Ava3) {
            this.Ava3 = Ava3;
        }

        public double getAha4() {
            return Aha4;
        }

        public void setAha4(double Aha4) {
            this.Aha4 = Aha4;
        }

        public double getAva4() {
            return Ava4;
        }

        public void setAva4(double Ava4) {
            this.Ava4 = Ava4;
        }
    }
}
