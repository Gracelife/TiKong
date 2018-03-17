package com.example.administrator.slopedisplacement.mvp.presenter;


import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeMonitorListLogJson;
import com.example.administrator.slopedisplacement.exception.ApiException;
import com.example.administrator.slopedisplacement.http.HttpObserver;
import com.example.administrator.slopedisplacement.http.HttpResponse;
import com.example.administrator.slopedisplacement.mvp.BasePresenter;
import com.example.administrator.slopedisplacement.mvp.contact.CruiseDataContact;
import com.example.administrator.slopedisplacement.mvp.contact.LoginContact;
import com.example.administrator.slopedisplacement.mvp.model.CruiseDataModel;
import com.example.administrator.slopedisplacement.mvp.model.LoginModel;

/**
 * 巡航流水数据Presenter
 */

public class CruiseDataPresenter extends BasePresenter<CruiseDataContact.View> implements CruiseDataContact.Presenter {
    @Override
    public void getSchemeMonitorListLog(String schemeID, String areaID, String startTime, String endTime, String monitorID, int pageindex, int pagesize, String uid) {
        new CruiseDataModel()
                .getSchemeMonitorListLog(schemeID, areaID, startTime, endTime, monitorID, pageindex, pagesize, uid)
                .compose(getIView().bindLifecycle())
                .subscribe(new HttpObserver<HttpResponse<GetSchemeMonitorListLogJson>>() {
                    @Override
                    public void onSuccess(HttpResponse<GetSchemeMonitorListLogJson> json) {
                        getIView().hideLoading();
                        getIView().onGetSchemeMonitorListLogSuccess(json.getData());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onGetSchemeMonitorListLogFail(msg.getMessage().toString());
                    }
                });
    }
}
