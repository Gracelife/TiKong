package com.example.administrator.slopedisplacement.bean;

import com.example.administrator.slopedisplacement.http.HttpResponse;

import java.io.Serializable;

/**
 * Created by administration on 2017/9/11.
 */

public class LoginBean {

    /**
     * Uid : 100039
     * UserName : 管理员
     */

    private int Uid;
    private String UserName;

    public int getUid() {
        return Uid;
    }

    public void setUid(int Uid) {
        this.Uid = Uid;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}
