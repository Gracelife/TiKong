package com.example.administrator.slopedisplacement.mvp.contact;


import com.example.administrator.slopedisplacement.bean.json.GetSchemeFixedListLogJson;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeMonitorListLogJson;
import com.example.administrator.slopedisplacement.mvp.IView;

/**
 * 定点流水数据Contact
 */

public class FixedFlowDataContact {
    public interface View extends IView {
        void onGetSchemeFixedListLogSuccess(GetSchemeFixedListLogJson jsonData);

        void onGetSchemeFixedListLogFail(String msg);
    }

    public interface Presenter {
        void getSchemeFixedListLog(String schemeID, String areaID, String startTime, String endTime, String monitorID, int pageindex, int pagesize, String uid);
    }
}
