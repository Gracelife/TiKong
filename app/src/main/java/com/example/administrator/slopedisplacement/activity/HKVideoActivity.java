package com.example.administrator.slopedisplacement.activity;


import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.bean.IVMS_8700_Bean;
import com.example.administrator.slopedisplacement.exception.ErrorType;
import com.example.administrator.slopedisplacement.mvp.contact.HKVideoContact;
import com.example.administrator.slopedisplacement.mvp.presenter.HKVideoPresenter;
import com.example.administrator.slopedisplacement.utils.IVMS_8700_Util;
import com.example.administrator.slopedisplacement.utils.JumpToUtils;
import com.example.administrator.slopedisplacement.widget.CustomSurfaceView;
import com.hikvision.sdk.VMSNetSDK;
import com.hikvision.sdk.consts.SDKConstant;
import com.hikvision.sdk.net.bean.LoginData;
import com.hikvision.sdk.net.business.OnVMSNetSDKBusiness;

import butterknife.BindView;
import butterknife.OnClick;

public class HKVideoActivity extends BaseMvpActivity<HKVideoPresenter> implements HKVideoContact.View , SurfaceHolder.Callback{
    @BindView(R.id.svHKVideo)
    CustomSurfaceView customSurfaceView;
    @BindView(R.id.ivHKBack)
    ImageView ivHKBack;
    @Override
    protected HKVideoPresenter loadPresenter() {
        return new HKVideoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hkvideo;
    }

    @Override
    protected void initView() {
        customSurfaceView.getHolder().addCallback(HKVideoActivity.this);
        IVMS_8700_Bean ivms_8700_bean = (IVMS_8700_Bean) getIntent().getSerializableExtra(JumpToUtils.KEY_IVMS_8700_BEAN);
        IVMS_8700_Util.login(ivms_8700_bean.getmIp(),ivms_8700_bean.getmPort(),ivms_8700_bean.getmUserName(),ivms_8700_bean.getmPassword(),new OnVMSNetSDKBusiness(){
            @Override
            public void onFailure() {
//                    mHandler.sendEmptyMessage(LOGIN_FAILED);
                showToast("登录失败");
                Log.e("8700", "登录失败");
            }

            @Override
            public void onSuccess(Object obj) {
                //Log.e("8700", "登录成功");
                if (obj instanceof LoginData) {
                    int mStreamType = SDKConstant.LiveSDKConstant.MAIN_HIGH_STREAM; // 码流
                    IVMS_8700_Util.start(ivms_8700_bean.getmSysCode(), customSurfaceView, mStreamType);
                }
            }
        });
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    @OnClick({R.id.ivHKBack})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.ivHKBack:
                finish();
                break;
        }
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean stopLiveResult = VMSNetSDK.getInstance().stopLiveOpt();
        if (stopLiveResult) {
            showToast("停止成功");
        }
    }
}
