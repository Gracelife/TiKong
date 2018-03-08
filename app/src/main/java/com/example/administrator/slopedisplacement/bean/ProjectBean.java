package com.example.administrator.slopedisplacement.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 */

public class ProjectBean {

    /**
     * List : [{"row_number":1,"ProjName":"汇川物联网","ProjAddress":"福建省福州市工业路451号鼓楼科技商务中心","ProjStatusCurrent":"监控中(5/6)","ProjStatusCurrId":116,"ProjID":10806,"ProjLat":"26.068699","ProjLng":"119.174085","ProjRegionCode":350121,"ArpCheckStartDate":null,"city":"福州市","area":"闽侯县"},{"row_number":2,"ProjName":"汇川吴志鉴测试1","ProjAddress":"产品中心","ProjStatusCurrent":"监控中(28/32)","ProjStatusCurrId":116,"ProjID":11921,"ProjLat":"26.075664","ProjLng":"119.28468","ProjRegionCode":350102,"ArpCheckStartDate":"2015-06-19 08:38:19","city":"福州市","area":"鼓楼区"},{"row_number":3,"ProjName":"中国电信上海研究院智慧工地","ProjAddress":"福建省福州市鼓楼区工业路451号鼓楼科技商务中心9楼","ProjStatusCurrent":"监控中(10/12)","ProjStatusCurrId":116,"ProjID":11980,"ProjLat":"27.384758","ProjLng":"118.091022","ProjRegionCode":350100,"ArpCheckStartDate":null,"city":"福州市","area":null},{"row_number":4,"ProjName":"漳州长泰边坡位移监测试点","ProjAddress":"1","ProjStatusCurrent":"监控中(2/2)","ProjStatusCurrId":116,"ProjID":32698,"ProjLat":"26.052406","ProjLng":"119.332259","ProjRegionCode":350100,"ArpCheckStartDate":null,"city":"福州市","area":null}]
     * TotalCount : 4
     */

    private int TotalCount;
    private ArrayList<ListBean> List;

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public ArrayList<ListBean> getList() {
        return List;
    }

    public void setList(ArrayList<ListBean> List) {
        this.List = List;
    }

    public static class ListBean {
        /**
         * row_number : 1
         * ProjName : 汇川物联网
         * ProjAddress : 福建省福州市工业路451号鼓楼科技商务中心
         * ProjStatusCurrent : 监控中(5/6)
         * ProjStatusCurrId : 116
         * ProjID : 10806
         * ProjLat : 26.068699
         * ProjLng : 119.174085
         * ProjRegionCode : 350121
         * ArpCheckStartDate : null
         * city : 福州市
         * area : 闽侯县
         */

        private int row_number;
        private String ProjName;
        private String ProjAddress;
        private String ProjStatusCurrent;
        private int ProjStatusCurrId;
        private int ProjID;
        private String ProjLat;
        private String ProjLng;
        private int ProjRegionCode;
        private Object ArpCheckStartDate;
        private String city;
        private String area;

        public int getRow_number() {
            return row_number;
        }

        public void setRow_number(int row_number) {
            this.row_number = row_number;
        }

        public String getProjName() {
            return ProjName;
        }

        public void setProjName(String ProjName) {
            this.ProjName = ProjName;
        }

        public String getProjAddress() {
            return ProjAddress;
        }

        public void setProjAddress(String ProjAddress) {
            this.ProjAddress = ProjAddress;
        }

        public String getProjStatusCurrent() {
            return ProjStatusCurrent;
        }

        public void setProjStatusCurrent(String ProjStatusCurrent) {
            this.ProjStatusCurrent = ProjStatusCurrent;
        }

        public int getProjStatusCurrId() {
            return ProjStatusCurrId;
        }

        public void setProjStatusCurrId(int ProjStatusCurrId) {
            this.ProjStatusCurrId = ProjStatusCurrId;
        }

        public int getProjID() {
            return ProjID;
        }

        public void setProjID(int ProjID) {
            this.ProjID = ProjID;
        }

        public String getProjLat() {
            return ProjLat;
        }

        public void setProjLat(String ProjLat) {
            this.ProjLat = ProjLat;
        }

        public String getProjLng() {
            return ProjLng;
        }

        public void setProjLng(String ProjLng) {
            this.ProjLng = ProjLng;
        }

        public int getProjRegionCode() {
            return ProjRegionCode;
        }

        public void setProjRegionCode(int ProjRegionCode) {
            this.ProjRegionCode = ProjRegionCode;
        }

        public Object getArpCheckStartDate() {
            return ArpCheckStartDate;
        }

        public void setArpCheckStartDate(Object ArpCheckStartDate) {
            this.ArpCheckStartDate = ArpCheckStartDate;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }
}
