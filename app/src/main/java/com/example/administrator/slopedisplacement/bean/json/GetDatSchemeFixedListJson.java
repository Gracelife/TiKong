package com.example.administrator.slopedisplacement.bean.json;

import java.io.Serializable;
import java.util.List;

/**
 *
 */

public class GetDatSchemeFixedListJson implements Serializable {

    /**
     * List : [{"FixedID":4,"FixedName":"33","SchemeID":19,"CamID":1026714,"CamSn":"754187357","States":0,"Ox":53.37672904800651,"Oy":58.446129032258064,"Space":5,"Photo":"/images/deformation.jpg","Threshold":20,"Obd":33.821998596191406,"OldObd":50.16400146484375,"CreateTime":null,"NowObd":33.827999114990234},{"FixedID":8,"FixedName":"55","SchemeID":19,"CamID":1026722,"CamSn":"763039560","States":0,"Ox":70.62652563059399,"Oy":61.441520737327195,"Space":5,"Photo":"/images/deformation.jpg","Threshold":20,"Obd":44,"OldObd":null,"CreateTime":null,"NowObd":null}]
     * TotalCount : 2
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

    public static class ListBean implements Serializable{
        /**
         * FixedID : 4
         * FixedName : 33
         * SchemeID : 19
         * CamID : 1026714
         * CamSn : 754187357
         * States : 0
         * Ox : 53.37672904800651
         * Oy : 58.446129032258064
         * Space : 5
         * Photo : /images/deformation.jpg
         * Threshold : 20
         * Obd : 33.821998596191406
         * OldObd : 50.16400146484375
         * CreateTime : null
         * NowObd : 33.827999114990234
         */

        private String FixedID;
        private String FixedName;
        private String SchemeID;
        private String CamID;
        private String CamSn;
        private String States;
        private String Ox;
        private String Oy;
        private String Space;
        private String Photo;
        private String Threshold;
        private String Obd;
        private String OldObd;
        private String CreateTime;
        private String NowObd;

        public String getFixedID() {
            return FixedID;
        }

        public void setFixedID(String FixedID) {
            this.FixedID = FixedID;
        }

        public String getFixedName() {
            return FixedName;
        }

        public void setFixedName(String FixedName) {
            this.FixedName = FixedName;
        }

        public String getSchemeID() {
            return SchemeID;
        }

        public void setSchemeID(String SchemeID) {
            this.SchemeID = SchemeID;
        }

        public String getCamID() {
            return CamID;
        }

        public void setCamID(String CamID) {
            this.CamID = CamID;
        }

        public String getCamSn() {
            return CamSn;
        }

        public void setCamSn(String CamSn) {
            this.CamSn = CamSn;
        }

        public String getStates() {
            return States;
        }

        public void setStates(String States) {
            this.States = States;
        }

        public String getOx() {
            return Ox;
        }

        public void setOx(String Ox) {
            this.Ox = Ox;
        }

        public String getOy() {
            return Oy;
        }

        public void setOy(String Oy) {
            this.Oy = Oy;
        }

        public String getSpace() {
            return Space;
        }

        public void setSpace(String Space) {
            this.Space = Space;
        }

        public String getPhoto() {
            return Photo;
        }

        public void setPhoto(String Photo) {
            this.Photo = Photo;
        }

        public String getThreshold() {
            return Threshold;
        }

        public void setThreshold(String Threshold) {
            this.Threshold = Threshold;
        }

        public String getObd() {
            return Obd;
        }

        public void setObd(String Obd) {
            this.Obd = Obd;
        }

        public String getOldObd() {
            return OldObd;
        }

        public void setOldObd(String OldObd) {
            this.OldObd = OldObd;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getNowObd() {
            return NowObd;
        }

        public void setNowObd(String NowObd) {
            this.NowObd = NowObd;
        }
    }
}
