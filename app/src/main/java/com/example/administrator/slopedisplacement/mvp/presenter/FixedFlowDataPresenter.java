package com.example.administrator.slopedisplacement.mvp.presenter;


import com.example.administrator.slopedisplacement.bean.json.GetSchemeFixedListLogJson;
import com.example.administrator.slopedisplacement.exception.ApiException;
import com.example.administrator.slopedisplacement.http.HttpObserver;
import com.example.administrator.slopedisplacement.http.HttpResponse;
import com.example.administrator.slopedisplacement.mvp.BasePresenter;
import com.example.administrator.slopedisplacement.mvp.contact.FixedFlowDataContact;
import com.example.administrator.slopedisplacement.mvp.model.FixedFlowDataModel;

/**
 * 定点流水数据Presenter
 */

public class FixedFlowDataPresenter extends BasePresenter<FixedFlowDataContact.View> implements FixedFlowDataContact.Presenter {
    @Override
    public void getSchemeFixedListLog(String schemeID, String fixedID, String startTime, String endTime, String monitorID, int pageindex, int pagesize, String uid) {
        new FixedFlowDataModel()
                .getSchemeFixedListLog(schemeID, fixedID, startTime, endTime, monitorID, pageindex, pagesize, uid)
                .compose(getIView().bindLifecycle())
                .subscribe(new HttpObserver<HttpResponse<GetSchemeFixedListLogJson>>() {
                    @Override
                    public void onSuccess(HttpResponse<GetSchemeFixedListLogJson> json) {
                        getIView().hideLoading();
                        getIView().onGetSchemeFixedListLogSuccess(json.getData());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onGetSchemeFixedListLogFail(msg.getMessage().toString());
                    }
                });
    }
}
