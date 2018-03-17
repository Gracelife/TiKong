package com.example.administrator.slopedisplacement.mvp.model;


import com.example.administrator.slopedisplacement.http.NetTransformer;
import com.example.administrator.slopedisplacement.http.RetrofitUtils;
import com.example.administrator.slopedisplacement.mvp.IModel;

import io.reactivex.Observable;
import retrofit2.http.Field;

/**
 * 巡航流水数据Model
 */

public class CruiseDataModel implements IModel {
    public Observable getSchemeMonitorListLog(String schemeID, String areaID, String startTime, String endTime, String monitorID, int pageindex, int pagesize, String uid) {
        return RetrofitUtils.Instance
                .getApiService()
                .getSchemeMonitorListLog(schemeID, areaID, startTime, endTime, monitorID, pageindex, pagesize, uid)
                .compose(NetTransformer.compose());
    }
}
