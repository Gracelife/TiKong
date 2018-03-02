package com.example.administrator.slopedisplacement.http;


import com.example.administrator.slopedisplacement.url.UrlHelper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018-01-08.
 */

public enum  RetrofitUtils {
    Instance();
    private static final int CONNECT_TIME_OUT = 30;//连接超时时长x秒
    private static final int READ_TIME_OUT = 30;//读数据超时时长x秒
    private static final int WRITE_TIME_OUT = 30;//写数据接超时时长x秒

    private Retrofit getRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())//使用interceptors会导致header中的cookie等信息不会打印出来
//                .addNetworkInterceptor(new LogInterceptor())//添加日志拦截器，打印日志
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .build();
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(UrlHelper.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return mRetrofit;
    }

    public ApiService getApiService() {
        return  getRetrofit().create(ApiService.class);
    }
}
