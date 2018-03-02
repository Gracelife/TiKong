package com.example.administrator.slopedisplacement.exception;

/**
 * Created by gaosheng on 2016/11/6.
 * 21:58
 * com.example.gaosheng.myapplication.exception
 * 自定义的异常,处理解析网络时的错误
 */

public class ApiException extends RuntimeException {

    private int code;
    private String message;

    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
