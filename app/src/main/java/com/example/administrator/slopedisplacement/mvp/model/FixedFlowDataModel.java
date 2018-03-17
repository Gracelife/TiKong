package com.example.administrator.slopedisplacement.mvp.model;


import com.example.administrator.slopedisplacement.http.NetTransformer;
import com.example.administrator.slopedisplacement.http.RetrofitUtils;
import com.example.administrator.slopedisplacement.mvp.IModel;

import io.reactivex.Observable;

/**
 * 定点流水数据Model
 */

public class FixedFlowDataModel implements IModel {
    public Observable getSchemeFixedListLog(String schemeID, String fixedID, String startTime, String endTime, String monitorID, int pageindex, int pagesize, String uid) {
        return RetrofitUtils.Instance
                .getApiService()
                .getSchemeFixedListLog(schemeID, fixedID, startTime, endTime, monitorID, pageindex, pagesize, uid)
                .compose(NetTransformer.compose());
    }
}
