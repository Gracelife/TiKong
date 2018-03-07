package com.example.administrator.slopedisplacement.http;

import com.example.administrator.slopedisplacement.exception.ApiException;
import com.example.administrator.slopedisplacement.exception.ErrorType;
import com.example.administrator.slopedisplacement.exception.ExceptionEngine;
import com.example.administrator.slopedisplacement.utils.L;
import com.example.administrator.slopedisplacement.utils.NetworkUtil;
import com.orhanobut.logger.Logger;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 *
 */

public abstract class HttpObserver<T extends HttpResponse> extends BaseObserver<T> {

    @Override
    public void onNext(@NonNull T response) {
        //防止闪退问题
        try {
            if(response.getCode() == ErrorType.SUCCESS) {
                onSuccess(response);
            }
            else {
                onFail(new ApiException(response.getMsg(),ErrorType.FAIL));
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            L.e("网络异常！错误码:"+ ErrorType.DATE_NULL);
        }catch (Exception e){
            e.printStackTrace();
            L.e("网络异常！错误码:"+ ErrorType.UN_KNOWN_ERROR);
        }
    }
}
