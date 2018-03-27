package com.example.administrator.slopedisplacement.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.bean.IVMS_8700_Bean;
import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.mvp.IView;
import com.example.administrator.slopedisplacement.mvp.contact.HuXinVideoContact;
import com.example.administrator.slopedisplacement.mvp.presenter.HuXinVideoPresenter;
import com.example.administrator.slopedisplacement.utils.HuXinUtil;
import com.example.administrator.slopedisplacement.utils.JumpToUtils;
import com.ffcs.surfingscene.function.GeyeUserLogin;
import com.ffcs.surfingscene.function.SurfingScenePlayer;
import com.ffcs.surfingscene.function.onPlayListener;
import com.ffcs.surfingscene.http.HttpCallBack;
import com.ffcs.surfingscene.response.BaseResponse;
import com.ffcs.surfingscene.util.PublicUtils;


import butterknife.BindView;
import butterknife.OnClick;


public class HuXinVideoActivity extends BaseMvpActivity<HuXinVideoPresenter> implements HuXinVideoContact.View {
    @BindView(R.id.GLsurface_view)
    public GLSurfaceView glv;
    @BindView(R.id.layout_pross)
    public View layoutPross;
    @BindView(R.id.txt_pross)
    public TextView prossTV;
    public SurfingScenePlayer splay;
    IVMS_8700_Bean ivms_8700_bean;
    @BindView(R.id.ivHuXinBack)
    ImageView ivHuXinBack;
    @Override
    protected HuXinVideoPresenter loadPresenter() {
        return new HuXinVideoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hu_xin_video;
    }

    @Override
    protected void initView() {
        ivms_8700_bean = (IVMS_8700_Bean) getIntent().getSerializableExtra(JumpToUtils.KEY_IVMS_8700_BEAN);
        splay = new SurfingScenePlayer(this);
        glv = (GLSurfaceView) this.findViewById(R.id.GLsurface_view);
        showLoading("正在加载中...");
        HuXinUtil.initVideoSDK(this,ivms_8700_bean.getmUserName(), ivms_8700_bean.getmPassword(),new HttpCallBack<BaseResponse>() {
            @Override
            public void callBack(BaseResponse arg0, String arg1) {

                if ("1".equals(arg0.getReturnCode())) {
                    hideLoading();
                    HuXinUtil.initVideo(splay,glv,"086591-1435552375",ivms_8700_bean.getmUserName(),new  onPlayListener() {

                        @Override
                        public void setOnPlaysuccess() {
                            prossTV.setText("视频缓冲进度：100%");
                            layoutPross.setVisibility(View.GONE);
                        }

                        @Override
                        public void onPlayFail(int arg0, final String error) {
                            layoutPross.setVisibility(View.GONE);
                            // DialogUtil.showDialog(PuIdPlayerActivity.this, error);

                            showErrorDialog(HuXinVideoActivity.this,"播放失败："+error);
                            //上传错误信息
                            //sendErrorData(error);

                        }
                        @Override
                        public void onBufferProssgress(int bufferValue) {

                            if (bufferValue >= 99) {
                                prossTV.setText("视频缓冲进度：100%");
                                layoutPross.setVisibility(View.GONE);
                            } else {
                                prossTV.setText("视频缓冲进度：" + bufferValue + "%");
                            }
                        }
                    });
                } else {
                    hideLoading();
                    new AlertDialog.Builder(HuXinVideoActivity.this).setTitle("播放提示")
                            .setMessage("播放失败："+arg0.getMsg()).setPositiveButton("确定",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                }
                            })
                            .setCancelable(false).create().show();

                }
            }
        });

    }
    public static void showErrorDialog(final Context context, String error) {
        new AlertDialog.Builder(context).setTitle("播放提示").setMessage(error+"")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ((HuXinVideoActivity) context).finish();

                    }
                }).setCancelable(false).create().show();
    }
    @OnClick({R.id.ivHuXinBack})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.ivHuXinBack:
                finish();
                break;
        }
    }
   /* private void initVideo() {

        splay = new SurfingScenePlayer(this);
        glv = (GLSurfaceView) this.findViewById(R.id.GLsurface_view);
        glv.setVisibility(View.VISIBLE);
        splay.init(glv);
        splay.getProgressValue();

        splay.setPlayListener(new onPlayListener() {

            @Override
            public void setOnPlaysuccess() {
                prossTV.setText("视频缓冲进度：100%");
                layoutPross.setVisibility(View.GONE);
            }

            @Override
            public void onPlayFail(int arg0, final String error) {
                layoutPross.setVisibility(View.GONE);
                // DialogUtil.showDialog(PuIdPlayerActivity.this, error);

                showErrorDialog(HuXinVideoActivity.this,"播放失败："+error);
                //上传错误信息
                //sendErrorData(error);

            }


            @Override
            public void onBufferProssgress(int bufferValue) {

                if (bufferValue >= 99) {
                    prossTV.setText("视频缓冲进度：100%");
                    layoutPross.setVisibility(View.GONE);
                } else {
                    prossTV.setText("视频缓冲进度：" + bufferValue + "%");
                }
            }
        });

        splay.playerVideoByPuId("086591-1435552375", 2, "350100", 2, 1, ivms_8700_bean.getmUserName(), 1);
        //splay.playerVideoByPuId(ivms_8700_bean.getCam_Dx_Puid(), 2, "350100", 2, 1, ivms_8700_bean.getmUserName(), 1);
    }
    public static void showErrorDialog(final Context context, String error) {
        new AlertDialog.Builder(context).setTitle("播放提示").setMessage(error+"")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        ((HuXinVideoActivity) context).finish();

                    }
                }).setCancelable(false).create().show();
    }
    public void initVideoSDK(){
        PublicUtils.savekey(this, "fzhc", "fzhc1234");//设置appkey和appSecret
        showLoading("正在加载中...");
        GeyeUserLogin.getInstance(HuXinVideoActivity.this).userLogin(ivms_8700_bean.getmUserName(), Long.valueOf(ivms_8700_bean.getmPassword()),
                350100, new HttpCallBack<BaseResponse>() {
                    @Override
                    public void callBack(BaseResponse arg0, String arg1) {

                        if ("1".equals(arg0.getReturnCode())) {
                            hideLoading();
                            initVideo();
                        } else {
                            hideLoading();
                            new AlertDialog.Builder(HuXinVideoActivity.this).setTitle("播放提示")
                                    .setMessage("播放失败："+arg0.getMsg()).setPositiveButton("确定",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog,
                                                            int which) {
                                        }
                                    })
                                    .setCancelable(false).create().show();

                        }
                    }
                });
    }*/


}
