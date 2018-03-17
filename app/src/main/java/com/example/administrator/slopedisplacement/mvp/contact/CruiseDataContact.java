package com.example.administrator.slopedisplacement.mvp.contact;


import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeMonitorListLogJson;
import com.example.administrator.slopedisplacement.http.HttpResponse;
import com.example.administrator.slopedisplacement.mvp.IView;

/**
 * 巡航流水数据Contact
 */

public class CruiseDataContact {
    public interface View extends IView {
        void onGetSchemeMonitorListLogSuccess(GetSchemeMonitorListLogJson jsonData);

        void onGetSchemeMonitorListLogFail(String msg);
    }

    public interface Presenter {
        void getSchemeMonitorListLog(String schemeID, String areaID, String startTime, String endTime, String monitorID, int pageindex, int pagesize, String uid);
    }
}
