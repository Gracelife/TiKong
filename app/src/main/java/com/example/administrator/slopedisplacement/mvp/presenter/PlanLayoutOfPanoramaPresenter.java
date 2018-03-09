package com.example.administrator.slopedisplacement.mvp.presenter;


import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.PanoramaImgBean;
import com.example.administrator.slopedisplacement.exception.ApiException;
import com.example.administrator.slopedisplacement.http.HttpObserver;
import com.example.administrator.slopedisplacement.http.HttpResponse;
import com.example.administrator.slopedisplacement.mvp.BasePresenter;
import com.example.administrator.slopedisplacement.mvp.contact.PlanLayoutOfPanoramaContact;
import com.example.administrator.slopedisplacement.mvp.contact.SelectSchemeContact;
import com.example.administrator.slopedisplacement.mvp.model.PlanLayoutOfPanoramaModel;
import com.example.administrator.slopedisplacement.mvp.model.SelectDriverModel;

/**
 * 登录Presenter
 */

public class PlanLayoutOfPanoramaPresenter extends BasePresenter<PlanLayoutOfPanoramaContact.View> implements PlanLayoutOfPanoramaContact.Presenter {
    @Override
    public void getPanoramaImg(String camId, String pageindex,String pagesize,String uid) {
        getIView().showLoading("正在加载中...");
        new PlanLayoutOfPanoramaModel()
                .getPanoramaImg(camId,"","",pageindex,pagesize,uid)
                .compose(getIView().bindLifecycle())
                .subscribe(new HttpObserver<HttpResponse<PanoramaImgBean>>() {
                    @Override
                    public void onSuccess(HttpResponse<PanoramaImgBean> panoramaImgBean) {
                        getIView().hideLoading();
                        getIView().onGetPanoramaImgSuccess(panoramaImgBean.getData());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onGetPanoramaImgFail(msg.getMessage().toString());
                    }
                });
    }
    @Override
    public void getSchemeAlarmList(String schemeID, String states,String startTime,String endTime,String pageindex,String pagesize,String uid) {
        getIView().showLoading("正在加载中...");
        new PlanLayoutOfPanoramaModel()
                .getSchemeAlarmList(schemeID,states,startTime,endTime,pageindex,pagesize,uid)
                .compose(getIView().bindLifecycle())
                .subscribe(new HttpObserver<HttpResponse<PanoramaImgBean>>() {
                    @Override
                    public void onSuccess(HttpResponse<PanoramaImgBean> panoramaImgBean) {
                        getIView().hideLoading();
                        getIView().onGetPanoramaImgSuccess(panoramaImgBean.getData());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onGetPanoramaImgFail(msg.getMessage().toString());
                    }
                });
    }
    @Override
    public void getSchemeAlarm(String schemeID, String states,String uid) {
        getIView().showLoading("正在加载中...");
        new PlanLayoutOfPanoramaModel()
                .getSchemeAlarm(schemeID,states,uid)
                .compose(getIView().bindLifecycle())
                .subscribe(new HttpObserver<HttpResponse<PanoramaImgBean>>() {
                    @Override
                    public void onSuccess(HttpResponse<PanoramaImgBean> panoramaImgBean) {
                        getIView().hideLoading();
                        getIView().onGetPanoramaImgSuccess(panoramaImgBean.getData());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onGetPanoramaImgFail(msg.getMessage().toString());
                    }
                });
    }

}
