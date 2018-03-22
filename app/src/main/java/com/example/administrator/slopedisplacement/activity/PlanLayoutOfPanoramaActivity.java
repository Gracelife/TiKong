package com.example.administrator.slopedisplacement.activity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.GetSchemeAlarmListAdapter;
import com.example.administrator.slopedisplacement.adapter.PanoramaAdapter;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.PanoramaImgBean;
import com.example.administrator.slopedisplacement.bean.SchemeAlarmListBean;
import com.example.administrator.slopedisplacement.bean.SchemeBean;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeAreaListJson;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeFixedListJson;
import com.example.administrator.slopedisplacement.db.UserInfoPref;
import com.example.administrator.slopedisplacement.exception.ErrorType;
import com.example.administrator.slopedisplacement.mvp.contact.PlanLayoutOfPanoramaContact;
import com.example.administrator.slopedisplacement.mvp.presenter.PlanLayoutOfPanoramaPresenter;
import com.example.administrator.slopedisplacement.utils.ActivityUtils;
import com.example.administrator.slopedisplacement.utils.JumpToUtils;
import com.example.administrator.slopedisplacement.widget.CustomLoadMoreView;
import com.example.administrator.slopedisplacement.widget.point.PointFrameLayout;
import com.example.administrator.slopedisplacement.widget.popupwindow.BindViewHelper;
import com.example.administrator.slopedisplacement.widget.popupwindow.CommonPopupWindow;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class PlanLayoutOfPanoramaActivity extends BaseMvpActivity<PlanLayoutOfPanoramaPresenter> implements PlanLayoutOfPanoramaContact.View {
    Intent intent;
    int pageIndex = 0;
    int sumPage;
    boolean isLoad = true;//判断是否已经记载全景图
    ArrayList<PanoramaImgBean.ListBean> dataList = new ArrayList<PanoramaImgBean.ListBean>();
    ArrayList<SchemeAlarmListBean.ListBean> schemeAlarmList = new ArrayList<SchemeAlarmListBean.ListBean>();
    CommonPopupWindow mPopWindow;
//    @BindView(R.id.ivPlanLayoutOfPanorama)
//    ImageView ivPlanLayoutOfPanorama;
    @BindView(R.id.btnAlarmInformation)
    Button btnAlarmInformation;
    @BindView(R.id.pflPoint)
    PointFrameLayout mPointFrameLayout;
    int schemeAlarmListPageIndex = 0;
    int SchemeAlarmListSumPage;
    GetSchemeAlarmListAdapter getSchemeAlarmListAdapter;
    PanoramaAdapter panoramaAdapter;
    int SchemeAlarmListPosition;
    String mSchemeID;
    private boolean isFromPush = false;//是否从推送跳转过来的
    private GetDatSchemeAreaListJson mArealListJson;//区域列表数据
    private GetDatSchemeFixedListJson mFixedListJson;//定点列表数据

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
        mSchemeID = getIntent().getStringExtra(JumpToUtils.KEY_SCHEMEID);
        String camId = getIntent().getStringExtra(JumpToUtils.KEY_CAMID);
        isFromPush = getIntent().getBooleanExtra(JumpToUtils.KEY_FROM_PUSH, false);
        mPresenter.getPanoramaImg(camId, pageIndex + "", "10", UserInfoPref.getUserId());
        mPresenter.getDatSchemeAreaList(mSchemeID + "", UserInfoPref.getUserId());
        mPresenter.getDatSchemeFixedList(mSchemeID + "", UserInfoPref.getUserId());
    }
    @Override
    protected void initView() {}
    private void showPopupWindow() {
        mPopWindow = new CommonPopupWindow.Builder(this) {
            @Override
            public void popBindView(BindViewHelper popupWindowBindView) {
                schemeAlarmList.clear();
                mPresenter.getSchemeAlarmList(mSchemeID + "", "", "", "", schemeAlarmListPageIndex + "", "10", UserInfoPref.getUserId() + "");
                LinearLayout pop_LinearLayout = (LinearLayout) popupWindowBindView.getView(R.id.pop_LinearLayout);
                RecyclerView rvAlarmInformation = (RecyclerView) popupWindowBindView.getView(R.id.rvAlarmInformation);
                rvAlarmInformation.setLayoutManager(new LinearLayoutManager(PlanLayoutOfPanoramaActivity.this));
                for (SchemeAlarmListBean.ListBean list : schemeAlarmList) {
                    //3表示不显示   所以这边做移除
                    if (list.getStates() == 3) {
                        schemeAlarmList.remove(list);
                    }
                }
                getSchemeAlarmListAdapter = new GetSchemeAlarmListAdapter(R.layout.item_scheme_alarm_list, schemeAlarmList);
                rvAlarmInformation.setAdapter(getSchemeAlarmListAdapter);
                getSchemeAlarmListAdapter.setLoadMoreView(new CustomLoadMoreView());

                getSchemeAlarmListAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                    @Override
                    public void onLoadMoreRequested() {
                        rvAlarmInformation.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (pageIndex > sumPage) {
                                    showToast("已经是最后一页了");
                                    getSchemeAlarmListAdapter.loadMoreEnd();
                                } else {
                                    mPresenter.getSchemeAlarmList(mSchemeID + "", "", "", "", schemeAlarmListPageIndex + "", "10", UserInfoPref.getUserId() + "");
                                }

                            }

                        }, 1000);
                    }
                }, rvAlarmInformation);
                getSchemeAlarmListAdapter.disableLoadMoreIfNotFullPage();
                getSchemeAlarmListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {

                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                        SchemeAlarmListBean.ListBean schemeAlarmListBean = schemeAlarmList.get(position);
                        intent.setClass(PlanLayoutOfPanoramaActivity.this, AlarmChartViewActivity.class);
                        switch (view.getId()) {
                            case R.id.tvSchemeAlaramListMove1:
                                //MonitorID1 Aha1 Ava1 Shift1 Path1a nextPath1a oldPath1a
                                intent.putExtra("MonitorID", schemeAlarmListBean.getMonitorID1());
                                intent.putExtra("Aha", schemeAlarmListBean.getAha1());
                                intent.putExtra("Ava", schemeAlarmListBean.getAva1());
                                intent.putExtra("Shift", schemeAlarmListBean.getShift1());
                                intent.putExtra("Patha", schemeAlarmListBean.getPath1a() + "");
                                intent.putExtra("nextPatha", schemeAlarmListBean.getNextPath1a() + "");
                                intent.putExtra("oldPatha", schemeAlarmListBean.getOldPath1a());
                                startActivity(intent);
                                break;
                            case R.id.tvSchemeAlaramListMove2:
                                //MonitorID2 Aha2 Ava2 Shift2 Path2a nextPath2a oldPath2a
                                intent.putExtra("MonitorID", schemeAlarmListBean.getMonitorID2());
                                intent.putExtra("Aha", schemeAlarmListBean.getAha2());
                                intent.putExtra("Ava", schemeAlarmListBean.getAva2());
                                intent.putExtra("Shift", schemeAlarmListBean.getShift2());
                                intent.putExtra("Patha", schemeAlarmListBean.getPath2a() + "");
                                intent.putExtra("nextPatha", schemeAlarmListBean.getNextPath2a() + "");
                                intent.putExtra("oldPatha", schemeAlarmListBean.getOldPath2a());
                                startActivity(intent);
                                break;
                            case R.id.tvSchemeAlaramListMove3:
                                //MonitorID3 Aha3 Ava3 Shift3 Path3a nextPath3a oldPath3a
                                intent.putExtra("MonitorID", schemeAlarmListBean.getMonitorID3());
                                intent.putExtra("Aha", schemeAlarmListBean.getAha3());
                                intent.putExtra("Ava", schemeAlarmListBean.getAva3());
                                intent.putExtra("Shift", schemeAlarmListBean.getShift3());
                                intent.putExtra("Patha", schemeAlarmListBean.getPath3a() + "");
                                intent.putExtra("nextPatha", schemeAlarmListBean.getNextPath3a() + "");
                                intent.putExtra("oldPatha", schemeAlarmListBean.getOldPath3a());
                                startActivity(intent);
                                break;
                            case R.id.tvSchemeAlaramListMove4:
                                //MonitorID4 Aha4 Ava4 Shift4 Path4a nextPath4a oldPath4a
                                intent.putExtra("MonitorID", schemeAlarmListBean.getMonitorID4());
                                intent.putExtra("Aha", schemeAlarmListBean.getAha4());
                                intent.putExtra("Ava", schemeAlarmListBean.getAva4());
                                intent.putExtra("Shift", schemeAlarmListBean.getShift4());
                                intent.putExtra("Patha", schemeAlarmListBean.getPath4a() + "");
                                intent.putExtra("nextPatha", schemeAlarmListBean.getNextPath4a() + "");
                                intent.putExtra("oldPatha", schemeAlarmListBean.getOldPath4a());
                                startActivity(intent);
                                break;
                            case R.id.tvSchemeAlaramListMove5:
                                if (schemeAlarmList.get(position).getTypes() == 1) {
                                    showToast("此点为定点");
                                } else {
                                    intent.putExtra("MonitorID", schemeAlarmListBean.getMonitorID1());
                                    intent.putExtra("Aha", schemeAlarmListBean.getAha1());
                                    intent.putExtra("Ava", schemeAlarmListBean.getAva1());
                                    intent.putExtra("Shift", schemeAlarmListBean.getShift1());
                                    intent.putExtra("Patha", schemeAlarmListBean.getPath1a() + "");
                                    intent.putExtra("nextPatha", schemeAlarmListBean.getNextPath1a() + "");
                                    intent.putExtra("oldPatha", schemeAlarmListBean.getOldPath1a());
                                    startActivity(intent);
                                    //MonitorID1 Aha1 Ava1 Shift1 Path1a nextPath1a oldPath1a
                                }
                                break;
                            case R.id.btnSchemeAlaramListNumConfirm:
                                //记录点击的position，
                                SchemeAlarmListPosition = position;
                                mPresenter.updateSchemeAlarmByAlarmID(schemeAlarmList.get(position).getAlarmID() + "", "2", UserInfoPref.getUserId() + "");

                                break;
                            default:
                                break;
                        }

                    }
                });


                pop_LinearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopWindow.dismiss();
                    }
                });
            }
        }.setContentView(R.layout.view_popupwindow_listview)
                .setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setHeight(ViewGroup.LayoutParams.FILL_PARENT)
                .setOutsideTouchable(true)
                .setFocusable(true)
                .builder()
                .showAtLocation(R.layout.activity_plan_layout_of_panorama, Gravity.BOTTOM, 0, 0);
    }

    private void showPanoramaPopupWindow() {
        mPopWindow = new CommonPopupWindow.Builder(this) {
            @Override
            public void popBindView(BindViewHelper popupWindowBindView) {
                RecyclerView rvPanorama = (RecyclerView) popupWindowBindView.getView(R.id.rvPanorama);
                rvPanorama.setLayoutManager(new LinearLayoutManager(PlanLayoutOfPanoramaActivity.this));
                panoramaAdapter = new PanoramaAdapter(R.layout.item_panorama, dataList);
                rvPanorama.setAdapter(panoramaAdapter);
                panoramaAdapter.setLoadMoreView(new CustomLoadMoreView());
                panoramaAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                        Glide.with(PlanLayoutOfPanoramaActivity.this).load(dataList.get(position).getPuzzleImg())//拿到头像本地存放路径
//                                .error(R.mipmap.ic_launcher)//失败默认
//                                .placeholder(R.mipmap.ic_launcher)
//                                .diskCacheStrategy(DiskCacheStrategy.NONE)//不单独缓存
//                                .skipMemoryCache(true)
//                                .into(ivPlanLayoutOfPanorama);
                    }
                });

                panoramaAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                    @Override
                    public void onLoadMoreRequested() {
                        rvPanorama.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (pageIndex > sumPage) {
                                    showToast("已经是最后一页了");
                                    panoramaAdapter.loadMoreEnd();
                                } else {
                                    mPresenter.getSchemeAlarmList(mSchemeID + "", "", "", "", schemeAlarmListPageIndex + "", "10", UserInfoPref.getUserId() + "");
                                }

                            }

                        }, 1000);
                    }
                }, rvPanorama);
                panoramaAdapter.disableLoadMoreIfNotFullPage();
            }
        }.setContentView(R.layout.view_popupwindow_panorama)
                .setWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setHeight(ViewGroup.LayoutParams.FILL_PARENT)
                .setOutsideTouchable(true)
                .setFocusable(true)
                .builder()
                .showAtLocation(R.layout.activity_plan_layout_of_panorama, Gravity.RIGHT, 0, 0);

    }

    @Override
    public void onGetPanoramaImgSuccess(PanoramaImgBean panoramaImgBean) {
        if (panoramaImgBean.getList().size() == 0) {
            showToast("暂无数据！");
        } else {
            showToast("数据加载成功！");
        }
        dataList.addAll(panoramaImgBean.getList());
        sumPage = (panoramaImgBean.getTotalCount() + 10 - 1) / 10;
        if (pageIndex <= sumPage) {
            pageIndex++;
        }
        if (isLoad) {
//            Glide.with(PlanLayoutOfPanoramaActivity.this).load(dataList.get(0).getPuzzleImg())//拿到头像本地存放路径
//                    .error(R.mipmap.ic_launcher)//失败默认
//                    .placeholder(R.mipmap.ic_launcher)
//                    .diskCacheStrategy(DiskCacheStrategy.NONE)//不单独缓存
//                    .skipMemoryCache(true)
//                    .into(ivPlanLayoutOfPanorama);
            isLoad = false;
        }

    }

    @Override
    public void onGetPanoramaImgFail(String msg) {
        showToast(msg);
    }

    @Override
    public void onGetSchemeAlarmListSuccess(SchemeAlarmListBean schemeAlarmListBean) {
        if (schemeAlarmListBean.getList().size() == 0) {
            showToast("暂无数据！");
        } else {
            showToast("数据加载成功！");
        }
        schemeAlarmList.addAll(schemeAlarmListBean.getList());
        getSchemeAlarmListAdapter.notifyDataSetChanged();
        SchemeAlarmListSumPage = (schemeAlarmListBean.getTotalCount() + 10 - 1) / 10;
        if (schemeAlarmListPageIndex <= SchemeAlarmListSumPage) {
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

    @Override
    public void onUpdateSchemeAlarmByAlarmIDSuccess(String msg) {
        //2代表已确认
        schemeAlarmList.get(SchemeAlarmListPosition).setStates(2);
        getSchemeAlarmListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onUpdateSchemeAlarmByAlarmIDFail(String msg) {

    }


    @Override
    public void onGetDatSchemeAreaListSuccess(GetDatSchemeAreaListJson arealListJson) {
        mArealListJson = arealListJson;
    }

    @Override
    public void onGetDatSchemeFixedListSuccess(GetDatSchemeFixedListJson fixedListJson) {
        mFixedListJson = fixedListJson;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPopWindow != null) {
            mPopWindow.dismiss();
        }
        if (isFromPush) {//关闭所有页面，并跳转到选择项目页面
            Intent intent = new Intent(getActivity(), SelectProjectActivity.class);
            startActivity(intent);
        }
    }

    @OnClick({R.id.btnAlarmInformation, R.id.btnPanorama, R.id.btnPanoramaDataReport})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btnAlarmInformation:
                showPopupWindow();
                break;
            case R.id.btnPanorama:
                showPanoramaPopupWindow();
                break;
            case R.id.btnPanoramaDataReport://跳转到查看数据页面

                if (mArealListJson == null || mFixedListJson == null) {
                    showToast("错误码：" + ErrorType.DATE_NULL);
                } else {
                    JumpToUtils.toDataReportActivity(getActivity(), mArealListJson, mFixedListJson, mSchemeID + "");
                }
                break;
        }
    }
}
