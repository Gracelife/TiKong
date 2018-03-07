package com.example.administrator.slopedisplacement.http;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 网络请求运行在io线程，响应回调运行在Ui线程
 */

public class NetTransformer {
    public static <T> ObservableTransformer<T, T> compose() {
        return observable -> observable.subscribeOn(Schedulers.io())//io线程发起请求
                .observeOn(AndroidSchedulers.mainThread());//UI线程处理响应

    }
}
