package com.example.administrator.slopedisplacement.mvp.contact;


import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.bean.SchemeBean;
import com.example.administrator.slopedisplacement.http.HttpResponse;
import com.example.administrator.slopedisplacement.mvp.IView;

/**
 * Created by administration on 2017/9/4.
 */

public class SelectDriverContact {
    public interface View extends IView {
        void onGetVideoCamListSuccess(DriverBean driverBean);
        void onGetVideoCamListFail(String msg);
        void onGetSchemeListSuccess(SchemeBean schemeBean);
        void onGetSchemeListFail(String msg);
    }

    public interface Presenter {
        void getVideoCamList(String projId, String uid);
        void getSchemeList(String camId, String uid);
    }
}
