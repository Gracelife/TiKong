package com.example.administrator.slopedisplacement.mvp.model;



import com.example.administrator.slopedisplacement.http.NetTransformer;
import com.example.administrator.slopedisplacement.http.RetrofitUtils;
import com.example.administrator.slopedisplacement.mvp.IModel;

import io.reactivex.Observable;

/**
 * Created by administr8ation on 2017/9/8.
 */

public class PlanLayoutOfPanoramaModel implements IModel {
    public Observable getPanoramaImg(String camId,String startime,String endTime, String pageindex,String pagesize,String uid) {
        return RetrofitUtils.Instance
                .getApiService()
                .getPanoramaImg(camId,startime,endTime,pageindex,pagesize,uid)
                .compose(NetTransformer.compose());
    }
    public Observable getSchemeAlarmList(String schemeID, String states,String startTime,String endTime,String pageindex,String pagesize,String uid) {
        return RetrofitUtils.Instance
                .getApiService()
                .getSchemeAlarmList(schemeID,states,startTime,endTime,pageindex,pagesize,uid)
                .compose(NetTransformer.compose());
    }
    public Observable getSchemeAlarm(String schemeID, String states,String uid) {
        return RetrofitUtils.Instance
                .getApiService()
                .getSchemeAlarm(schemeID,states,uid)
                .compose(NetTransformer.compose());
    }
    public Observable updateSchemeAlarmByAlarmID(String alarmID, String states,String uid) {
        return RetrofitUtils.Instance
                .getApiService()
                .updateSchemeAlarmByAlarmID(alarmID,states,uid)
                .compose(NetTransformer.compose());
    }
}
