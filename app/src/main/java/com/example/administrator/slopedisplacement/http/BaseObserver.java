package com.example.administrator.slopedisplacement.http;

import com.example.administrator.slopedisplacement.exception.ApiException;
import com.example.administrator.slopedisplacement.exception.ErrorType;
import com.example.administrator.slopedisplacement.utils.L;
import com.example.administrator.slopedisplacement.utils.NetworkUtil;
import com.orhanobut.logger.Logger;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018-01-09.
 */

public abstract class BaseObserver<T> implements Observer<T>, HttpRequest<T> {
    private Disposable disposable;
    //当订阅后，会首先调用这个方法，其实就相当于onStart()，
    //传入的Disposable d参数可以用于取消订阅
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        disposable = d;
        if (!NetworkUtil.isNetworkAvailable()) {
            Logger.e("网络不可用");
            disposable.dispose();
        }
    }
    @Override
    public void onNext(@NonNull T response) {
        //防止闪退问题
        try {
            onSuccess(response);
        }catch (NullPointerException e){
            e.printStackTrace();
            L.e("网络异常！错误码:"+ ErrorType.DATE_NULL);
        }catch (Exception e){
            e.printStackTrace();
            L.e("网络异常！错误码:"+ ErrorType.UN_KNOWN_ERROR);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        ApiException apiException = (ApiException) e;
        Logger.e(apiException.getMessage());
        onFail(apiException);
//        disposable.dispose();
    }

    @Override
    public void onComplete() {
    }
}
