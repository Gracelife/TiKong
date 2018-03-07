package com.example.administrator.slopedisplacement.http;




import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.bean.UpdateBean;
import com.example.administrator.slopedisplacement.url.UrlHelper;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by GaoSheng on 2016/9/13.
 * 网络请求的接口都在这里
 */

public interface ApiService {
    //获取banner
    //String url = "";

    @FormUrlEncoded
    @POST(UrlHelper.API+"Login")
    Observable<HttpResponse<LoginBean>> login(@Field("userPassWord") String passWord, @Field("userName") String userName);

    @FormUrlEncoded
    @POST(UrlHelper.API+"UpdateLoginMessage")
    Observable<HttpResponse> updateLoginMessage(@Field("userName") String userName, @Field("clentid") String clentid);
}
