package com.example.administrator.slopedisplacement.mvp.model;


import com.example.administrator.slopedisplacement.http.NetTransformer;
import com.example.administrator.slopedisplacement.http.RetrofitUtils;
import com.example.administrator.slopedisplacement.mvp.IModel;

import io.reactivex.Observable;

/**
 * 巡航流水数据Model
 */

public class CruiseCurveAreaMapModel implements IModel {
    public Observable getNewSchemeMonitorChartsByDateTop(String schemeID, String areaID,  String monitorID, int timeType, String selDate, String uid) {
        return RetrofitUtils.Instance
                .getApiService()
                .getNewSchemeMonitorChartsByDateTop(schemeID, areaID, monitorID, timeType, selDate, uid)
                .compose(NetTransformer.compose());
    }
}
