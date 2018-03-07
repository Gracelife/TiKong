package com.example.administrator.slopedisplacement.mvp.presenter;


import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.bean.UpdateBean;
import com.example.administrator.slopedisplacement.bean.json.TestJson;
import com.example.administrator.slopedisplacement.exception.ApiException;
import com.example.administrator.slopedisplacement.http.BaseObserver;
import com.example.administrator.slopedisplacement.http.NetTransformer;
import com.example.administrator.slopedisplacement.http.RetrofitUtils;
import com.example.administrator.slopedisplacement.mvp.BasePresenter;
import com.example.administrator.slopedisplacement.mvp.contact.LoginContact;
import com.example.administrator.slopedisplacement.mvp.model.LoginModel;
import com.example.administrator.slopedisplacement.utils.L;

import junit.framework.Test;

/**
 * 登录Presenter
 */

public class LoginPresenter extends BasePresenter<LoginContact.View> implements LoginContact.Presenter {
    @Override
    public void login(String passWord, String userName, String imei) {
        new LoginModel()
                .login(passWord, userName, imei)
                .compose(getIView().bindLifecycle())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean loginBean) {
                        getIView().onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().onLoginFail();
                    }
                });
    }

    @Override
    public void getVersion(String packageName, String updateVersionCode) {
        new LoginModel()
                .getVersion(packageName, updateVersionCode)
                .compose(getIView().bindLifecycle())
                .subscribe(new BaseObserver<UpdateBean>() {
                    @Override
                    public void onSuccess(UpdateBean loginBean) {
                        getIView().onGetVersionSuccess(loginBean);
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        getIView().onGetVersionFail();
                    }
                });
    }
    public void test(){
        RetrofitUtils.Instance
                .getApiService()
                .test("admin", "hckj1234")
                .compose(NetTransformer.compose())
                .compose(getIView().bindLifecycle())
                .subscribe(new BaseObserver<TestJson>() {
                    @Override
                    public void onSuccess(TestJson o) {
                        L.e(o.toString());
                    }

                    @Override
                    public void onFail(ApiException msg) {
                        L.e(msg.toString());
                    }
                });
    }
}
