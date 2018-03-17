package com.example.administrator.slopedisplacement.bean.json;

import java.util.List;

/**
 *
 */

public class GetSchemeMonitorListLogJson {

    /**
     * List : [{"CreateTime":"2018-03-09 13:36:21","RecordID":2649,"SchemeID":0,"SchemeName":"test1","AreaID":11,"AreaNmae":"区域01","MonitorID":134,"Photo1":"http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309133701.jpg","Photo2":"http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309133717.jpg","Shift":0,"AddShift":0,"Obd":49.37699890136719,"NowShift":0,"NowShiftX":0,"NowShiftY":0,"NowShiftZ":0,"IniObd":0,"IniObdX":29.825740748712807,"IniObdY":24.152408636521326,"IniObdZ":-31.067255532967163,"PhasedObd":0,"PhasedObdX":29.825740748712807,"PhasedObdY":24.152408636521326,"PhasedObdZ":-31.067255532967163,"ShiftX":0,"ShiftY":0,"ShiftZ":0,"AddShiftX":0,"AddShiftY":0,"AddShiftZ":0,"ObdX":29.825740748712807,"ObdY":24.152408636521326,"ObdZ":-31.067255532967163}]
     * TotalCount : 1225
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
         * CreateTime : 2018-03-09 13:36:21
         * RecordID : 2649
         * SchemeID : 0
         * SchemeName : test1
         * AreaID : 11
         * AreaNmae : 区域01
         * MonitorID : 134
         * Photo1 : http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309133701.jpg
         * Photo2 : http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309133717.jpg
         * Shift : 0.0
         * AddShift : 0.0
         * Obd : 49.37699890136719
         * NowShift : 0.0
         * NowShiftX : 0.0
         * NowShiftY : 0.0
         * NowShiftZ : 0.0
         * IniObd : 0.0
         * IniObdX : 29.825740748712807
         * IniObdY : 24.152408636521326
         * IniObdZ : -31.067255532967163
         * PhasedObd : 0.0
         * PhasedObdX : 29.825740748712807
         * PhasedObdY : 24.152408636521326
         * PhasedObdZ : -31.067255532967163
         * ShiftX : 0.0
         * ShiftY : 0.0
         * ShiftZ : 0.0
         * AddShiftX : 0.0
         * AddShiftY : 0.0
         * AddShiftZ : 0.0
         * ObdX : 29.825740748712807
         * ObdY : 24.152408636521326
         * ObdZ : -31.067255532967163
         */

        private String CreateTime;
        private int RecordID;
        private int SchemeID;
        private String SchemeName;
        private int AreaID;
        private String AreaNmae;
        private int MonitorID;
        private String Photo1;
        private String Photo2;
        private double Shift;
        private double AddShift;
        private double Obd;
        private double NowShift;
        private double NowShiftX;
        private double NowShiftY;
        private double NowShiftZ;
        private double IniObd;
        private double IniObdX;
        private double IniObdY;
        private double IniObdZ;
        private double PhasedObd;
        private double PhasedObdX;
        private double PhasedObdY;
        private double PhasedObdZ;
        private double ShiftX;
        private double ShiftY;
        private double ShiftZ;
        private double AddShiftX;
        private double AddShiftY;
        private double AddShiftZ;
        private double ObdX;
        private double ObdY;
        private double ObdZ;

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getRecordID() {
            return RecordID;
        }

        public void setRecordID(int RecordID) {
            this.RecordID = RecordID;
        }

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

        public int getAreaID() {
            return AreaID;
        }

        public void setAreaID(int AreaID) {
            this.AreaID = AreaID;
        }

        public String getAreaNmae() {
            return AreaNmae;
        }

        public void setAreaNmae(String AreaNmae) {
            this.AreaNmae = AreaNmae;
        }

        public int getMonitorID() {
            return MonitorID;
        }

        public void setMonitorID(int MonitorID) {
            this.MonitorID = MonitorID;
        }

        public String getPhoto1() {
            return Photo1;
        }

        public void setPhoto1(String Photo1) {
            this.Photo1 = Photo1;
        }

        public String getPhoto2() {
            return Photo2;
        }

        public void setPhoto2(String Photo2) {
            this.Photo2 = Photo2;
        }

        public double getShift() {
            return Shift;
        }

        public void setShift(double Shift) {
            this.Shift = Shift;
        }

        public double getAddShift() {
            return AddShift;
        }

        public void setAddShift(double AddShift) {
            this.AddShift = AddShift;
        }

        public double getObd() {
            return Obd;
        }

        public void setObd(double Obd) {
            this.Obd = Obd;
        }

        public double getNowShift() {
            return NowShift;
        }

        public void setNowShift(double NowShift) {
            this.NowShift = NowShift;
        }

        public double getNowShiftX() {
            return NowShiftX;
        }

        public void setNowShiftX(double NowShiftX) {
            this.NowShiftX = NowShiftX;
        }

        public double getNowShiftY() {
            return NowShiftY;
        }

        public void setNowShiftY(double NowShiftY) {
            this.NowShiftY = NowShiftY;
        }

        public double getNowShiftZ() {
            return NowShiftZ;
        }

        public void setNowShiftZ(double NowShiftZ) {
            this.NowShiftZ = NowShiftZ;
        }

        public double getIniObd() {
            return IniObd;
        }

        public void setIniObd(double IniObd) {
            this.IniObd = IniObd;
        }

        public double getIniObdX() {
            return IniObdX;
        }

        public void setIniObdX(double IniObdX) {
            this.IniObdX = IniObdX;
        }

        public double getIniObdY() {
            return IniObdY;
        }

        public void setIniObdY(double IniObdY) {
            this.IniObdY = IniObdY;
        }

        public double getIniObdZ() {
            return IniObdZ;
        }

        public void setIniObdZ(double IniObdZ) {
            this.IniObdZ = IniObdZ;
        }

        public double getPhasedObd() {
            return PhasedObd;
        }

        public void setPhasedObd(double PhasedObd) {
            this.PhasedObd = PhasedObd;
        }

        public double getPhasedObdX() {
            return PhasedObdX;
        }

        public void setPhasedObdX(double PhasedObdX) {
            this.PhasedObdX = PhasedObdX;
        }

        public double getPhasedObdY() {
            return PhasedObdY;
        }

        public void setPhasedObdY(double PhasedObdY) {
            this.PhasedObdY = PhasedObdY;
        }

        public double getPhasedObdZ() {
            return PhasedObdZ;
        }

        public void setPhasedObdZ(double PhasedObdZ) {
            this.PhasedObdZ = PhasedObdZ;
        }

        public double getShiftX() {
            return ShiftX;
        }

        public void setShiftX(double ShiftX) {
            this.ShiftX = ShiftX;
        }

        public double getShiftY() {
            return ShiftY;
        }

        public void setShiftY(double ShiftY) {
            this.ShiftY = ShiftY;
        }

        public double getShiftZ() {
            return ShiftZ;
        }

        public void setShiftZ(double ShiftZ) {
            this.ShiftZ = ShiftZ;
        }

        public double getAddShiftX() {
            return AddShiftX;
        }

        public void setAddShiftX(double AddShiftX) {
            this.AddShiftX = AddShiftX;
        }

        public double getAddShiftY() {
            return AddShiftY;
        }

        public void setAddShiftY(double AddShiftY) {
            this.AddShiftY = AddShiftY;
        }

        public double getAddShiftZ() {
            return AddShiftZ;
        }

        public void setAddShiftZ(double AddShiftZ) {
            this.AddShiftZ = AddShiftZ;
        }

        public double getObdX() {
            return ObdX;
        }

        public void setObdX(double ObdX) {
            this.ObdX = ObdX;
        }

        public double getObdY() {
            return ObdY;
        }

        public void setObdY(double ObdY) {
            this.ObdY = ObdY;
        }

        public double getObdZ() {
            return ObdZ;
        }

        public void setObdZ(double ObdZ) {
            this.ObdZ = ObdZ;
        }
    }
}
