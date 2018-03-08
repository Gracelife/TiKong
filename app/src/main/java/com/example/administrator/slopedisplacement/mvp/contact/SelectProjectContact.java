package com.example.administrator.slopedisplacement.mvp.contact;


import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.bean.ProjectBean;
import com.example.administrator.slopedisplacement.http.HttpResponse;
import com.example.administrator.slopedisplacement.mvp.IView;

/**
 * Created by administration on 2017/9/4.
 */

public class SelectProjectContact {
    public interface View extends IView {
        void onGetVideoMonitorListSuccess(ProjectBean projectBean);
        void onGetVideoMonitorListFail(String msg);
    }

    public interface Presenter {
        void getVideoMonitorList(String keyword, String pageindex,String pagesize,String uid);
    }
}
