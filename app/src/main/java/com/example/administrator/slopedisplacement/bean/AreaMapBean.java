package com.example.administrator.slopedisplacement.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/28.
 */

public class AreaMapBean {


    /**
     * Obd : [3.781,3.781,3.781,3.781,3.781,3.782,3.781,3.781,3.782,3.782,3.781,3.781,3.781,3.781,3.781,3.78,3.781,3.782,3.781,3.782,3.781,3.783,3.781]
     * Shift : [0,0,0,0,0,0.001,0,0,0.001,0.001,0,0,0,0,0,-0.001,0,0.001,0,0.001,0,0.002,0]
     * AddShift : [0,0,0,0,0,0.001,0,0,0.001,0.001,0,0,0,0,0,-0.001,0,0.001,0,0.001,0,0.002,0]
     * NowShift : [0,0,0,0,0,0.001,-0.001,0,0.001,0,-0.001,0,0,0,0,-0.001,0.001,0.001,-0.001,0.001,-0.001,0.002,-0.002]
     * timeName : ["2018-03-08 18:20","2018-03-08 18:35","2018-03-08 19:00","2018-03-08 19:14","2018-03-08 19:30","2018-03-08 19:45","2018-03-08 19:59","2018-03-08 20:14","2018-03-08 20:27","2018-03-08 20:41","2018-03-08 20:54","2018-03-08 21:09","2018-03-08 21:22","2018-03-08 21:37","2018-03-08 21:53","2018-03-08 22:08","2018-03-08 22:22","2018-03-08 22:36","2018-03-08 22:50","2018-03-08 23:07","2018-03-08 23:22","2018-03-08 23:37","2018-03-08 23:52"]
     * recordID : [1973,1984,1995,2006,2017,2029,2040,2051,2063,2074,2085,2096,2107,2119,2130,2141,2152,2164,2175,2186,2197,2208,2220]
     * name : 108
     * id : 108
     * data : [0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003,0.003]
     */

    private String name;
    private int id;
    private List<Double> Obd;
    private List<Double> Shift;
    private List<Double> AddShift;
    private List<Double> NowShift;
    private List<String> timeName;
    private List<Integer> recordID;
    private List<Double> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Double> getObd() {
        return Obd;
    }

    public void setObd(List<Double> Obd) {
        this.Obd = Obd;
    }

    public List<Double> getShift() {
        return Shift;
    }

    public void setShift(List<Double> Shift) {
        this.Shift = Shift;
    }

    public List<Double> getAddShift() {
        return AddShift;
    }

    public void setAddShift(List<Double> AddShift) {
        this.AddShift = AddShift;
    }

    public List<Double> getNowShift() {
        return NowShift;
    }

    public void setNowShift(List<Double> NowShift) {
        this.NowShift = NowShift;
    }

    public List<String> getTimeName() {
        return timeName;
    }

    public void setTimeName(List<String> timeName) {
        this.timeName = timeName;
    }

    public List<Integer> getRecordID() {
        return recordID;
    }

    public void setRecordID(List<Integer> recordID) {
        this.recordID = recordID;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }
}
