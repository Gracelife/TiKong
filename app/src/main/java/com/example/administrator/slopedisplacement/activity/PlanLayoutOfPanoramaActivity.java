package com.example.administrator.slopedisplacement.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.GetSchemeAlarmListAdapter;
import com.example.administrator.slopedisplacement.adapter.SelectProjectAdapter;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.PanoramaImgBean;
import com.example.administrator.slopedisplacement.bean.ProjectBean;
import com.example.administrator.slopedisplacement.bean.SchemeAlarmListBean;
import com.example.administrator.slopedisplacement.bean.SchemeBean;
import com.example.administrator.slopedisplacement.db.PrefHelper;
import com.example.administrator.slopedisplacement.db.UserInfoPref;
import com.example.administrator.slopedisplacement.mvp.contact.PlanLayoutOfPanoramaContact;
import com.example.administrator.slopedisplacement.mvp.presenter.PlanLayoutOfPanoramaPresenter;
import com.example.administrator.slopedisplacement.widget.CustomLoadMoreView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class PlanLayoutOfPanoramaActivity extends BaseMvpActivity<PlanLayoutOfPanoramaPresenter> implements PlanLayoutOfPanoramaContact.View{
    Intent intent;
    int pageIndex = 0;
    int sumPage ;
    boolean isLoad = true;//判断是否已经记载全景图
    ArrayList<PanoramaImgBean.ListBean> dataList = new ArrayList<PanoramaImgBean.ListBean>();
    ArrayList<SchemeAlarmListBean.ListBean> schemeAlarmList = new ArrayList<SchemeAlarmListBean.ListBean>();
    PopupWindow mPopWindow;
    @BindView(R.id.ivPlanLayoutOfPanorama)
    ImageView ivPlanLayoutOfPanorama;
    @BindView(R.id.btnAlarmInformation)
    Button btnAlarmInformation;
    int schemeAlarmListPageIndex = 0;
    int SchemeAlarmListSumPage ;
    GetSchemeAlarmListAdapter getSchemeAlarmListAdapter;
    @Override
    protected PlanLayoutOfPanoramaPresenter loadPresenter() {
        return new PlanLayoutOfPanoramaPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_plan_layout_of_panorama;
    }
    @Override
    protected void initData(Bundle savedInstanceState) {
        intent = getIntent();
        String camId = ((DriverBean.ListBean)intent.getSerializableExtra("DriverBean")).getCamId()+"";
        mPresenter.getPanoramaImg(camId,pageIndex+"","10",UserInfoPref.getUserId());


    }
    @Override
    protected void initView() {

    }
    @OnClick({R.id.btnAlarmInformation})
    void OnClick(View view){
        switch (view.getId()){
            case R.id.btnAlarmInformation:
                showPopupWindow();
                break;
        }
    }
    private void showPopupWindow() {
        SchemeBean.ListBean schemeBean = ((SchemeBean.ListBean) intent.getSerializableExtra("SchemeBean"));
        schemeAlarmList.clear();
        mPresenter.getSchemeAlarmList(schemeBean.getSchemeID() + "",  "", "", "", schemeAlarmListPageIndex + "", "10", UserInfoPref.getUserId() + "");
        View contentView;
        contentView = LayoutInflater.from(PlanLayoutOfPanoramaActivity.this).inflate(R.layout.view_popupwindow_listview, null);
        mPopWindow = new PopupWindow(contentView);
        mPopWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.FILL_PARENT);
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setFocusable(true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());

        LinearLayout pop_LinearLayout = (LinearLayout) contentView.findViewById(R.id.pop_LinearLayout);
        RecyclerView rvAlarmInformation = (RecyclerView) contentView.findViewById(R.id.rvAlarmInformation);
        rvAlarmInformation.setLayoutManager(new LinearLayoutManager(this));
        for (SchemeAlarmListBean.ListBean list:schemeAlarmList) {
            if(list.getStates() == 3){
                schemeAlarmList.remove(list);
            }
        }
        getSchemeAlarmListAdapter = new GetSchemeAlarmListAdapter(R.layout.item_scheme_alarm_list,schemeAlarmList);
        rvAlarmInformation.setAdapter(getSchemeAlarmListAdapter);
        getSchemeAlarmListAdapter.setLoadMoreView(new CustomLoadMoreView());

        getSchemeAlarmListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override public void onLoadMoreRequested() {
                rvAlarmInformation.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(pageIndex > sumPage){
                            showToast("已经是最后一页了");
                            getSchemeAlarmListAdapter.loadMoreEnd();
                        }else {
                            mPresenter.getSchemeAlarmList(schemeBean.getSchemeID() + "",  "", "", "", schemeAlarmListPageIndex + "", "10", UserInfoPref.getUserId() + "");
                        }

                    }

                }, 1000);
            }
        }, rvAlarmInformation);
        getSchemeAlarmListAdapter.disableLoadMoreIfNotFullPage();
        getSchemeAlarmListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                SchemeAlarmListBean.ListBean schemeAlarmListBean =  schemeAlarmList.get(position);
                intent.setClass(PlanLayoutOfPanoramaActivity.this,AlarmChartViewActivity.class);
                switch (view.getId()){
                    case R.id.tvSchemeAlaramListMove1:
                        //MonitorID1 Aha1 Ava1 Shift1 Path1a nextPath1a oldPath1a
                        intent.putExtra("MonitorID",schemeAlarmListBean.getMonitorID1());
                        intent.putExtra("Aha",schemeAlarmListBean.getAha1());
                        intent.putExtra("Ava",schemeAlarmListBean.getAva1());
                        intent.putExtra("Shift",schemeAlarmListBean.getShift1());
                        intent.putExtra("Patha",schemeAlarmListBean.getPath1a()+"");
                        intent.putExtra("nextPatha",schemeAlarmListBean.getNextPath1a()+"");
                        intent.putExtra("oldPatha",schemeAlarmListBean.getOldPath1a());
                        break;
                    case R.id.tvSchemeAlaramListMove2:
                        //MonitorID2 Aha2 Ava2 Shift2 Path2a nextPath2a oldPath2a
                        intent.putExtra("MonitorID",schemeAlarmListBean.getMonitorID2());
                        intent.putExtra("Aha",schemeAlarmListBean.getAha2());
                        intent.putExtra("Ava",schemeAlarmListBean.getAva2());
                        intent.putExtra("Shift",schemeAlarmListBean.getShift2());
                        intent.putExtra("Patha",schemeAlarmListBean.getPath2a()+"");
                        intent.putExtra("nextPatha",schemeAlarmListBean.getNextPath2a()+"");
                        intent.putExtra("oldPatha",schemeAlarmListBean.getOldPath2a());
                        break;
                    case R.id.tvSchemeAlaramListMove3:
                        //MonitorID3 Aha3 Ava3 Shift3 Path3a nextPath3a oldPath3a
                        intent.putExtra("MonitorID",schemeAlarmListBean.getMonitorID3());
                        intent.putExtra("Aha",schemeAlarmListBean.getAha3());
                        intent.putExtra("Ava",schemeAlarmListBean.getAva3());
                        intent.putExtra("Shift",schemeAlarmListBean.getShift3());
                        intent.putExtra("Patha",schemeAlarmListBean.getPath3a()+"");
                        intent.putExtra("nextPatha",schemeAlarmListBean.getNextPath3a()+"");
                        intent.putExtra("oldPatha",schemeAlarmListBean.getOldPath3a());
                        break;
                    case R.id.tvSchemeAlaramListMove4:
                        //MonitorID4 Aha4 Ava4 Shift4 Path4a nextPath4a oldPath4a
                        intent.putExtra("MonitorID",schemeAlarmListBean.getMonitorID4());
                        intent.putExtra("Aha",schemeAlarmListBean.getAha4());
                        intent.putExtra("Ava",schemeAlarmListBean.getAva4());
                        intent.putExtra("Shift",schemeAlarmListBean.getShift4());
                        intent.putExtra("Patha",schemeAlarmListBean.getPath4a()+"");
                        intent.putExtra("nextPatha",schemeAlarmListBean.getNextPath4a()+"");
                        intent.putExtra("oldPatha",schemeAlarmListBean.getOldPath4a());
                        break;
                    case R.id.tvSchemeAlaramListMove5:
                        if(schemeAlarmList.get(position).getTypes() == 1){
                            showToast("此点为定点");
                        }else{
                            intent.putExtra("MonitorID",schemeAlarmListBean.getMonitorID1());
                            intent.putExtra("Aha",schemeAlarmListBean.getAha1());
                            intent.putExtra("Ava",schemeAlarmListBean.getAva1());
                            intent.putExtra("Shift",schemeAlarmListBean.getShift1());
                            intent.putExtra("Patha",schemeAlarmListBean.getPath1a()+"");
                            intent.putExtra("nextPatha",schemeAlarmListBean.getNextPath1a()+"");
                            intent.putExtra("oldPatha",schemeAlarmListBean.getOldPath1a());

                            //MonitorID1 Aha1 Ava1 Shift1 Path1a nextPath1a oldPath1a
                        }
                        break;
                    default:
                        break;
                }
                startActivity(intent);
            }
        });


        pop_LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopWindow.dismiss();
            }
        });

            mPopWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);


    }
    @Override
    public void onGetPanoramaImgSuccess(PanoramaImgBean panoramaImgBean) {
        if(panoramaImgBean.getList().size() == 0){
            showToast("暂无数据！");
        }else{
            showToast("数据加载成功！");
        }
        dataList.addAll(panoramaImgBean.getList());
        sumPage = (panoramaImgBean.getTotalCount()  +  10  - 1) / 10;
        if(pageIndex<=sumPage){
            pageIndex++;
        }
        if(isLoad) {
            Glide.with(PlanLayoutOfPanoramaActivity.this).load(dataList.get(0).getPuzzleImg())//拿到头像本地存放路径
                    .error(R.mipmap.ic_launcher)//失败默认
                    .placeholder(R.mipmap.ic_launcher)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不单独缓存
                    .skipMemoryCache(true)
                    .into(ivPlanLayoutOfPanorama);
            isLoad = false;
        }

    }

    @Override
    public void onGetPanoramaImgFail(String msg) {
        showToast(msg);
    }

    @Override
    public void onGetSchemeAlarmListSuccess(SchemeAlarmListBean schemeAlarmListBean) {
        if(schemeAlarmListBean.getList().size() == 0){
            showToast("暂无数据！");
        }else{
            showToast("数据加载成功！");
        }
        schemeAlarmList.addAll(schemeAlarmListBean.getList());
        getSchemeAlarmListAdapter.notifyDataSetChanged();
        SchemeAlarmListSumPage = (schemeAlarmListBean.getTotalCount()  +  10  - 1) / 10;
        if(schemeAlarmListPageIndex<=SchemeAlarmListSumPage){
            schemeAlarmListPageIndex++;
        }
        getSchemeAlarmListAdapter.loadMoreComplete();

    }

    @Override
    public void onGetSchemeAlarmListFail(String msg) {

    }

    @Override
    public void onGetSchemeAlarmSuccess(PanoramaImgBean panoramaImgBean) {

    }

    @Override
    public void onGetSchemeAlarmFail(String msg) {

    }
}
