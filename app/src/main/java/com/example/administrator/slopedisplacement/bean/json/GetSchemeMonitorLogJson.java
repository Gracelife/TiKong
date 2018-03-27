package com.example.administrator.slopedisplacement.bean.json;

import java.io.Serializable;

/**
 * 获取区域监测点日志top1(最新一条)
 */

public class GetSchemeMonitorLogJson implements Serializable {

    /**
     * RecordID : 3878
     * MonitorID : 113
     * SchemeID : 58
     * AreaID : 74
     * Aha : 110.09400177001953
     * Ava : 35.49599838256836
     * Obd : 1.847000002861023
     * Photo1 : http://ftp.jsqqy.com:8121/upfile/Puzzle/105785374_002/11/20180311010028.jpg
     * Photo2 : http://ftp.jsqqy.com:8121/upfile/Puzzle/105785374_002/11/20180311010101.jpg
     * CreateTime : 2018-03-11 01:00:59
     * Shift : 0.0
     * AddShift : 0.0
     * NowShift : 0.001000046730041504
     */

    private String RecordID;
    private String MonitorID;
    private String SchemeID;
    private String AreaID;
    private String Aha;
    private String Ava;
    private String Obd;
    private String Photo1;
    private String Photo2;
    private String CreateTime;
    private String Shift;
    private String AddShift;
    private String NowShift;

    public String getRecordID() {
        return RecordID;
    }

    public void setRecordID(String RecordID) {
        this.RecordID = RecordID;
    }

    public String getMonitorID() {
        return MonitorID;
    }

    public void setMonitorID(String MonitorID) {
        this.MonitorID = MonitorID;
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

    public String getAha() {
        return Aha;
    }

    public void setAha(String Aha) {
        this.Aha = Aha;
    }

    public String getAva() {
        return Ava;
    }

    public void setAva(String Ava) {
        this.Ava = Ava;
    }

    public String getObd() {
        return Obd;
    }

    public void setObd(String Obd) {
        this.Obd = Obd;
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

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String Shift) {
        this.Shift = Shift;
    }

    public String getAddShift() {
        return AddShift;
    }

    public void setAddShift(String AddShift) {
        this.AddShift = AddShift;
    }

    public String getNowShift() {
        return NowShift;
    }

    public void setNowShift(String NowShift) {
        this.NowShift = NowShift;
    }
}
