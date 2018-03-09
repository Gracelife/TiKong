package com.example.administrator.slopedisplacement.mvp.presenter;


import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.bean.SchemeBean;
import com.example.administrator.slopedisplacement.exception.ApiException;
import com.example.administrator.slopedisplacement.http.HttpObserver;
import com.example.administrator.slopedisplacement.http.HttpResponse;
import com.example.administrator.slopedisplacement.mvp.BasePresenter;
import com.example.administrator.slopedisplacement.mvp.contact.LoginContact;
import com.example.administrator.slopedisplacement.mvp.contact.SelectDriverContact;
import com.example.administrator.slopedisplacement.mvp.model.LoginModel;
import com.example.administrator.slopedisplacement.mvp.model.SelectDriverModel;

/**
 * 登录Presenter
 */

public class SelectDriverPresenter extends BasePresenter<SelectDriverContact.View> implements SelectDriverContact.Presenter {
    @Override
    public void getVideoCamList(String projId, String uid) {
        getIView().showLoading("正在加载中...");
        new SelectDriverModel()
                .getVideoCamList(projId, uid)
                .compose(getIView().bindLifecycle())
                .subscribe(new HttpObserver<HttpResponse<DriverBean>>() {
                    @Override
                    public void onSuccess(HttpResponse<DriverBean> driverBean) {
                        getIView().hideLoading();
                        getIView().onGetVideoCamListSuccess(driverBean.getData());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onGetVideoCamListFail(msg.getMessage().toString());
                    }
                });
    }
    @Override
    public void getSchemeList(String camId, String uid) {
        getIView().showLoading("正在加载中...");
        new SelectDriverModel()
                .getSchemeList(camId, uid)
                .compose(getIView().bindLifecycle())
                .subscribe(new HttpObserver<HttpResponse<SchemeBean>>() {
                    @Override
                    public void onSuccess(HttpResponse<SchemeBean> schemeBean) {
                        getIView().hideLoading();
                        getIView().onGetSchemeListSuccess(schemeBean.getData());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onGetSchemeListFail(msg.getMessage().toString());
                    }
                });
    }

}
