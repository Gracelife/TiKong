package com.example.administrator.slopedisplacement.bean.json;

import java.io.Serializable;
import java.util.List;

/**
 *
 */

public class GetDatSchemeAreaListJson implements Serializable {

    /**
     * List : [{"NewMonitor":[{"id":"1","MonitorID":134,"SchemeID":19,"AreaID":11,"Aha":39.000003814697266,"Ava":38.99999237060547,"Obd":49.35100173950195,"Photo1":"http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309133701.jpg","Photo2":null,"IniObd":49.37699890136719,"CreateTime":"2018-03-09 13:34:27","NowObd":null,"Ox":null,"Oy":null,"EntityKey":null},{"id":"2","MonitorID":135,"SchemeID":19,"AreaID":11,"Aha":39.000003814697266,"Ava":50.47833251953125,"Obd":40.250999450683594,"Photo1":"http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309190648.jpg","Photo2":null,"IniObd":37.54999923706055,"CreateTime":"2018-03-09 13:34:27","NowObd":null,"Ox":null,"Oy":null,"EntityKey":null},{"id":"3","MonitorID":136,"SchemeID":19,"AreaID":11,"Aha":38.000003814697266,"Ava":38,"Obd":50.428001403808594,"Photo1":"http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309190756.jpg","Photo2":null,"IniObd":50.439998626708984,"CreateTime":"2018-03-09 13:34:27","NowObd":null,"Ox":null,"Oy":null,"EntityKey":null},{"id":"4","MonitorID":137,"SchemeID":19,"AreaID":11,"Aha":38.000003814697266,"Ava":49.47834014892578,"Obd":40.83300018310547,"Photo1":"http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309190917.jpg","Photo2":null,"IniObd":40.685001373291016,"CreateTime":"2018-03-09 13:34:27","NowObd":null,"Ox":null,"Oy":null,"EntityKey":null}],"AreaID":11,"AreaType":null,"AreaNmae":"区域01","SchemeID":19,"Threshold":25,"Aha1":501,"Ava1":501,"Obd1":5,"Photo1":"/images/deformation.jpg","Ox1":69.4060211554109,"Oy1":36.7880184331797,"Aha2":502,"Ava2":502,"Obd2":5,"Ox2":52.7257933279089,"Oy2":46.2350230414747,"Photo2":"/images/deformation.jpg","Err":1,"Xgap":1,"Ygap":1,"States":1,"CreateTime":"2018-01-09 10:39:54"}]
     * TotalCount : 3
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
         * NewMonitor : [{"id":"1","MonitorID":134,"SchemeID":19,"AreaID":11,"Aha":39.000003814697266,"Ava":38.99999237060547,"Obd":49.35100173950195,"Photo1":"http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309133701.jpg","Photo2":null,"IniObd":49.37699890136719,"CreateTime":"2018-03-09 13:34:27","NowObd":null,"Ox":null,"Oy":null,"EntityKey":null},{"id":"2","MonitorID":135,"SchemeID":19,"AreaID":11,"Aha":39.000003814697266,"Ava":50.47833251953125,"Obd":40.250999450683594,"Photo1":"http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309190648.jpg","Photo2":null,"IniObd":37.54999923706055,"CreateTime":"2018-03-09 13:34:27","NowObd":null,"Ox":null,"Oy":null,"EntityKey":null},{"id":"3","MonitorID":136,"SchemeID":19,"AreaID":11,"Aha":38.000003814697266,"Ava":38,"Obd":50.428001403808594,"Photo1":"http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309190756.jpg","Photo2":null,"IniObd":50.439998626708984,"CreateTime":"2018-03-09 13:34:27","NowObd":null,"Ox":null,"Oy":null,"EntityKey":null},{"id":"4","MonitorID":137,"SchemeID":19,"AreaID":11,"Aha":38.000003814697266,"Ava":49.47834014892578,"Obd":40.83300018310547,"Photo1":"http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309190917.jpg","Photo2":null,"IniObd":40.685001373291016,"CreateTime":"2018-03-09 13:34:27","NowObd":null,"Ox":null,"Oy":null,"EntityKey":null}]
         * AreaID : 11
         * AreaType : null
         * AreaNmae : 区域01
         * SchemeID : 19
         * Threshold : 25
         * Aha1 : 501
         * Ava1 : 501
         * Obd1 : 5
         * Photo1 : /images/deformation.jpg
         * Ox1 : 69.4060211554109
         * Oy1 : 36.7880184331797
         * Aha2 : 502
         * Ava2 : 502
         * Obd2 : 5
         * Ox2 : 52.7257933279089
         * Oy2 : 46.2350230414747
         * Photo2 : /images/deformation.jpg
         * Err : 1
         * Xgap : 1
         * Ygap : 1
         * States : 1
         * CreateTime : 2018-01-09 10:39:54
         */

        private String AreaID;
        private String AreaType;
        private String AreaNmae;
        private String SchemeID;
        private String Threshold;
        private String Aha1;
        private String Ava1;
        private String Obd1;
        private String Photo1;
        private String Ox1;
        private String Oy1;
        private String Aha2;
        private String Ava2;
        private String Obd2;
        private String Ox2;
        private String Oy2;
        private String Photo2;
        private String Err;
        private String Xgap;
        private String Ygap;
        private String States;
        private String CreateTime;
        private java.util.List<NewMonitorBean> NewMonitor;

        public String getAreaID() {
            return AreaID;
        }

        public void setAreaID(String AreaID) {
            this.AreaID = AreaID;
        }

        public String getAreaType() {
            return AreaType;
        }

        public void setAreaType(String AreaType) {
            this.AreaType = AreaType;
        }

        public String getAreaNmae() {
            return AreaNmae;
        }

        public void setAreaNmae(String AreaNmae) {
            this.AreaNmae = AreaNmae;
        }

        public String getSchemeID() {
            return SchemeID;
        }

        public void setSchemeID(String SchemeID) {
            this.SchemeID = SchemeID;
        }

        public String getThreshold() {
            return Threshold;
        }

        public void setThreshold(String Threshold) {
            this.Threshold = Threshold;
        }

        public String getAha1() {
            return Aha1;
        }

        public void setAha1(String Aha1) {
            this.Aha1 = Aha1;
        }

        public String getAva1() {
            return Ava1;
        }

        public void setAva1(String Ava1) {
            this.Ava1 = Ava1;
        }

        public String getObd1() {
            return Obd1;
        }

        public void setObd1(String Obd1) {
            this.Obd1 = Obd1;
        }

        public String getPhoto1() {
            return Photo1;
        }

        public void setPhoto1(String Photo1) {
            this.Photo1 = Photo1;
        }

        public String getOx1() {
            return Ox1;
        }

        public void setOx1(String Ox1) {
            this.Ox1 = Ox1;
        }

        public String getOy1() {
            return Oy1;
        }

        public void setOy1(String Oy1) {
            this.Oy1 = Oy1;
        }

        public String getAha2() {
            return Aha2;
        }

        public void setAha2(String Aha2) {
            this.Aha2 = Aha2;
        }

        public String getAva2() {
            return Ava2;
        }

        public void setAva2(String Ava2) {
            this.Ava2 = Ava2;
        }

        public String getObd2() {
            return Obd2;
        }

        public void setObd2(String Obd2) {
            this.Obd2 = Obd2;
        }

        public String getOx2() {
            return Ox2;
        }

        public void setOx2(String Ox2) {
            this.Ox2 = Ox2;
        }

        public String getOy2() {
            return Oy2;
        }

        public void setOy2(String Oy2) {
            this.Oy2 = Oy2;
        }

        public String getPhoto2() {
            return Photo2;
        }

        public void setPhoto2(String Photo2) {
            this.Photo2 = Photo2;
        }

        public String getErr() {
            return Err;
        }

        public void setErr(String Err) {
            this.Err = Err;
        }

        public String getXgap() {
            return Xgap;
        }

        public void setXgap(String Xgap) {
            this.Xgap = Xgap;
        }

        public String getYgap() {
            return Ygap;
        }

        public void setYgap(String Ygap) {
            this.Ygap = Ygap;
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

        public List<NewMonitorBean> getNewMonitor() {
            return NewMonitor;
        }

        public void setNewMonitor(List<NewMonitorBean> NewMonitor) {
            this.NewMonitor = NewMonitor;
        }

        public static class NewMonitorBean implements Serializable{
            /**
             * id : 1
             * MonitorID : 134
             * SchemeID : 19
             * AreaID : 11
             * Aha : 39.000003814697266
             * Ava : 38.99999237060547
             * Obd : 49.35100173950195
             * Photo1 : http://ftp.jsqqy.com:8121/upfile/Puzzle/754187357/11/20180309133701.jpg
             * Photo2 : null
             * IniObd : 49.37699890136719
             * CreateTime : 2018-03-09 13:34:27
             * NowObd : null
             * Ox : null
             * Oy : null
             * EntityKey : null
             */

            private String id;
            private String MonitorID;
            private String SchemeID;
            private String AreaID;
            private String Aha;
            private String Ava;
            private String Obd;
            private String Photo1;
            private String Photo2;
            private String IniObd;
            private String CreateTime;
            private String NowObd;
            private String Ox;
            private String Oy;
            private String EntityKey;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getIniObd() {
                return IniObd;
            }

            public void setIniObd(String IniObd) {
                this.IniObd = IniObd;
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

            public String getEntityKey() {
                return EntityKey;
            }

            public void setEntityKey(String EntityKey) {
                this.EntityKey = EntityKey;
            }
        }
    }
}

