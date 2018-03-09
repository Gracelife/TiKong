package com.example.administrator.slopedisplacement.mvp.presenter;


import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.bean.ProjectBean;
import com.example.administrator.slopedisplacement.exception.ApiException;
import com.example.administrator.slopedisplacement.http.HttpObserver;
import com.example.administrator.slopedisplacement.http.HttpResponse;
import com.example.administrator.slopedisplacement.mvp.BasePresenter;
import com.example.administrator.slopedisplacement.mvp.contact.LoginContact;
import com.example.administrator.slopedisplacement.mvp.contact.SelectProjectContact;
import com.example.administrator.slopedisplacement.mvp.model.LoginModel;
import com.example.administrator.slopedisplacement.mvp.model.SelectProjectModel;

/**
 * 登录Presenter
 */

public class SelectProjectPresenter extends BasePresenter<SelectProjectContact.View> implements SelectProjectContact.Presenter {
    @Override
    public void getVideoMonitorList(String keyword, String pageindex,String pagesize,String uid) {
        getIView().showLoading("正在搜索中...");
        new SelectProjectModel()
                .getVideoMonitorList(keyword, "28","0",pageindex,pagesize,"0","",uid)
               //116是边坡设备
                // .getVideoMonitorList(keyword, "28","116",pageindex,pagesize,"0","",uid)
                .compose(getIView().bindLifecycle())
                .subscribe(new HttpObserver<HttpResponse<ProjectBean>>() {
                    @Override
                    public void onSuccess(HttpResponse<ProjectBean> projectBean) {
                        getIView().hideLoading();
                        getIView().onGetVideoMonitorListSuccess(projectBean.getData());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onGetVideoMonitorListFail(msg.getMessage().toString());
                    }
                });
    }



}
