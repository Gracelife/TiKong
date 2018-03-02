package com.example.administrator.slopedisplacement.exception;

/**
 * 自定义的服务器异常
 */

public class ServerException extends RuntimeException {
    public int code;
    public String msg;

    public ServerException(int code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
