package com.example.administrator.slopedisplacement.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/8.
 */

public class PanoramaImgBean {

    /**
     * List : [{"RecordId":205,"CamSn":"105785374","CamId":1014462,"ProjId":239,"StartTime":"2016-10-11 12:59:24","EndTime":"2016-10-11 12:59:24","PuzzleImg":"http://ftp.jsqqy.com:8121/upfile/Puzzle/ptimg/792732542/136222_201802261118071181.jpg","ImageTimes":1,"Pictrait":"8917,4429","CutImage":"http://ftp.jsqqy.com:8121/upfile/Puzzle/ptimg/792732542/136222_201802261118071181.jpg","PanoramicCount":0}]
     * TotalCount : 1
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
         * RecordId : 205
         * CamSn : 105785374
         * CamId : 1014462
         * ProjId : 239
         * StartTime : 2016-10-11 12:59:24
         * EndTime : 2016-10-11 12:59:24
         * PuzzleImg : http://ftp.jsqqy.com:8121/upfile/Puzzle/ptimg/792732542/136222_201802261118071181.jpg
         * ImageTimes : 1
         * Pictrait : 8917,4429
         * CutImage : http://ftp.jsqqy.com:8121/upfile/Puzzle/ptimg/792732542/136222_201802261118071181.jpg
         * PanoramicCount : 0
         */

        private int RecordId;
        private String CamSn;
        private int CamId;
        private int ProjId;
        private String StartTime;
        private String EndTime;
        private String PuzzleImg;
        private int ImageTimes;
        private String Pictrait;
        private String CutImage;
        private int PanoramicCount;

        public int getRecordId() {
            return RecordId;
        }

        public void setRecordId(int RecordId) {
            this.RecordId = RecordId;
        }

        public String getCamSn() {
            return CamSn;
        }

        public void setCamSn(String CamSn) {
            this.CamSn = CamSn;
        }

        public int getCamId() {
            return CamId;
        }

        public void setCamId(int CamId) {
            this.CamId = CamId;
        }

        public int getProjId() {
            return ProjId;
        }

        public void setProjId(int ProjId) {
            this.ProjId = ProjId;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public String getPuzzleImg() {
            return PuzzleImg;
        }

        public void setPuzzleImg(String PuzzleImg) {
            this.PuzzleImg = PuzzleImg;
        }

        public int getImageTimes() {
            return ImageTimes;
        }

        public void setImageTimes(int ImageTimes) {
            this.ImageTimes = ImageTimes;
        }

        public String getPictrait() {
            return Pictrait;
        }

        public void setPictrait(String Pictrait) {
            this.Pictrait = Pictrait;
        }

        public String getCutImage() {
            return CutImage;
        }

        public void setCutImage(String CutImage) {
            this.CutImage = CutImage;
        }

        public int getPanoramicCount() {
            return PanoramicCount;
        }

        public void setPanoramicCount(int PanoramicCount) {
            this.PanoramicCount = PanoramicCount;
        }
    }
}

