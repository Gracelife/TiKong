package com.example.administrator.slopedisplacement.exception;

import android.net.ParseException;

import com.example.administrator.slopedisplacement.http.NetResponse;
import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;


/**
 * 异常处理类
 */

public class ExceptionEngine {
    //对应HTTP的状态码
    public static final int UN_KNOWN_ERROR = 1000;//未知错误
    public static final int ANALYTIC_SERVER_DATA_ERROR = 1001;//解析(服务器)数据错误
    public static final int ANALYTIC_CLIENT_DATA_ERROR = 1002;//解析(客户端)数据错误
    public static final int CONNECT_ERROR = 1003;//网络连接错误
    public static final int TIME_OUT_ERROR = 1004;//网络连接超时

    public static ApiException handleException(Throwable e) {
        ApiException ex;
        if (e instanceof HttpException) {             //HTTP错误
            HttpException httpExc = (HttpException) e;
            ex = new ApiException(e, httpExc.code());
            ex.setMessage("网络错误");  //均视为网络错误
            return ex;
        } else if (e instanceof ServerException) {    //服务器返回的错误
            ServerException serverExc = (ServerException) e;
            ex = new ApiException(serverExc, serverExc.getCode());
            ex.setMessage(serverExc.getMessage());
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException || e instanceof MalformedJsonException) {  //解析数据错误
            ex = new ApiException(e, ANALYTIC_SERVER_DATA_ERROR);
            ex.setMessage("解析错误");
            return ex;
        } else if (e instanceof ConnectException) {//连接网络错误
            ex = new ApiException(e, CONNECT_ERROR);
            ex.setMessage("连接失败");
            return ex;
        } else if (e instanceof SocketTimeoutException) {//网络超时
            ex = new ApiException(e, TIME_OUT_ERROR);
            ex.setMessage("网络超时");
            return ex;
        } else {  //未知错误
            ex = new ApiException(e, UN_KNOWN_ERROR);
            ex.setMessage("未知错误");
            return ex;
        }
    }

    /**
     * 检测Api异常
     * @param response
     */
    public static void checkApiException(NetResponse response){
        if (response == null) {
            throw new ServerException(ErrorType.EMPTY_BEAN, "服务器返回的数据为空");
        } else if (!response.isSuccess()) {
            throw new ServerException(response.getCode(), response.getMsg());
        }
    }
}

