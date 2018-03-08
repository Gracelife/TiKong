package com.example.administrator.slopedisplacement.mvp.model;



import com.example.administrator.slopedisplacement.http.NetTransformer;
import com.example.administrator.slopedisplacement.http.RetrofitUtils;
import com.example.administrator.slopedisplacement.mvp.IModel;

import io.reactivex.Observable;

/**
 * Created by administr8ation on 2017/9/8.
 */

public class SelectProjectModel implements IModel {
    public Observable getVideoMonitorList(String keyword,String sysId,String status, String pageindex,String pagesize,String ismode,String areaName,String uid) {
        return RetrofitUtils.Instance
                .getApiService()
                .getVideoMonitorList(keyword,sysId,status,pageindex,pagesize,ismode,areaName,uid)
                .compose(NetTransformer.compose());
    }


}
