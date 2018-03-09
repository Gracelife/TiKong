package com.example.administrator.slopedisplacement.mvp.model;



import com.example.administrator.slopedisplacement.http.NetTransformer;
import com.example.administrator.slopedisplacement.http.RetrofitUtils;
import com.example.administrator.slopedisplacement.mvp.IModel;

import io.reactivex.Observable;

/**
 * Created by administr8ation on 2017/9/8.
 */

public class SelectDriverModel implements IModel {
    public Observable getVideoCamList(String projId, String uid) {
        return RetrofitUtils.Instance
                .getApiService()
                .getVideoCamList(projId, uid)
                .compose(NetTransformer.compose());
    }
    public Observable getSchemeList(String camId, String uid) {
        return RetrofitUtils.Instance
                .getApiService()
                .getSchemeList(camId, uid)
                .compose(NetTransformer.compose());
    }

}
