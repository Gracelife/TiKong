package com.example.administrator.slopedisplacement.mvp.presenter;


import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.exception.ApiException;
import com.example.administrator.slopedisplacement.http.HttpObserver;
import com.example.administrator.slopedisplacement.http.HttpResponse;
import com.example.administrator.slopedisplacement.mvp.BasePresenter;
import com.example.administrator.slopedisplacement.mvp.contact.HuXinVideoContact;
import com.example.administrator.slopedisplacement.mvp.contact.LoginContact;
import com.example.administrator.slopedisplacement.mvp.model.LoginModel;

/**
 * 登录Presenter
 */

public class HuXinVideoPresenter extends BasePresenter<HuXinVideoContact.View> implements HuXinVideoContact.Presenter {
    @Override
    public void login(String passWord, String userName) {

    }
    /*@Override
    public void login(String passWord, String userName) {
        getIView().showLoading("正在登录中...");
        new LoginModel()
                .login(passWord, userName)
                .compose(getIView().bindLifecycle())
                .subscribe(new HttpObserver<HttpResponse<LoginBean>>() {
                    @Override
                    public void onSuccess(HttpResponse<LoginBean> loginBean) {
                        getIView().hideLoading();
                        getIView().onLoginSuccess(loginBean.getData());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().hideLoading();
                        getIView().onLoginFail(msg.getMessage().toString());
                    }
                });
    }*/



}
