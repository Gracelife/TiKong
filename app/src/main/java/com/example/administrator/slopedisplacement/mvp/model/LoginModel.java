package com.example.administrator.slopedisplacement.mvp.model;



import com.example.administrator.slopedisplacement.http.NetTransformer;
import com.example.administrator.slopedisplacement.http.RetrofitUtils;
import com.example.administrator.slopedisplacement.mvp.IModel;

import io.reactivex.Observable;

/**
 * Created by administr8ation on 2017/9/8.
 */

public class LoginModel implements IModel {
    public Observable login(String passWord, String userName) {
        return RetrofitUtils.Instance
                .getApiService()
                .login(passWord, userName)
                .compose(NetTransformer.compose());
    }
    public Observable updateLoginMessage(String userName, String clentid) {
        return RetrofitUtils.Instance
                .getApiService()
                .updateLoginMessage(userName, clentid)
                .compose(NetTransformer.compose());
    }

}
