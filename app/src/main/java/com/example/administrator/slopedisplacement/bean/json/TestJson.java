package com.example.administrator.slopedisplacement.bean.json;

import com.example.administrator.slopedisplacement.http.HttpResponse;

/**
 *
 */

public class TestJson extends HttpResponse<TestJson> {

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

    @Override
    public String toString() {
        return "TestJson{" +
                "Uid=" + Uid +
                ", UserName='" + UserName + '\'' +
                '}';
    }
}
