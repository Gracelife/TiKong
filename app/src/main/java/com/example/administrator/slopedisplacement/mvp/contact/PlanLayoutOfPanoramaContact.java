package com.example.administrator.slopedisplacement.mvp.contact;


import com.example.administrator.slopedisplacement.bean.PanoramaImgBean;
import com.example.administrator.slopedisplacement.bean.SchemeAlarmListBean;
import com.example.administrator.slopedisplacement.mvp.IView;

/**
 * Created by administration on 2017/9/4.
 */

public class PlanLayoutOfPanoramaContact {
    public interface View extends IView {
        void onGetPanoramaImgSuccess(PanoramaImgBean panoramaImgBean);
        void onGetPanoramaImgFail(String msg);
        void onGetSchemeAlarmListSuccess(SchemeAlarmListBean schemeAlarmListBean);
        void onGetSchemeAlarmListFail(String msg);
        void onGetSchemeAlarmSuccess(PanoramaImgBean panoramaImgBean);
        void onGetSchemeAlarmFail(String msg);
    }

    public interface Presenter {
        void getPanoramaImg(String camId, String pageindex,String pagesize,String uid);
        void getSchemeAlarmList(String schemeID, String states,String startTime,String endTime,String pageindex,String pagesize,String uid) ;
        void getSchemeAlarm(String schemeID, String states,String uid);
    }
}
