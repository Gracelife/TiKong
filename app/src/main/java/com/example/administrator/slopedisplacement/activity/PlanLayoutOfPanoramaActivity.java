package com.example.administrator.slopedisplacement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.GetSchemeAlarmListAdapter;
import com.example.administrator.slopedisplacement.adapter.PanoramaAdapter;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.bean.IVMS_8700_Bean;
import com.example.administrator.slopedisplacement.bean.PanoramaImgBean;
import com.example.administrator.slopedisplacement.bean.SchemeAlarmListBean;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeAreaListJson;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeFixedListJson;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeAlarmJson;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeMonitorLogJson;
import com.example.administrator.slopedisplacement.db.UserInfoPref;
import com.example.administrator.slopedisplacement.mvp.contact.PlanLayoutOfPanoramaContact;
import com.example.administrator.slopedisplacement.mvp.presenter.PlanLayoutOfPanoramaPresenter;
import com.example.administrator.slopedisplacement.utils.JumpToUtils;
import com.example.administrator.slopedisplacement.utils.PointImgHelper;
import com.example.administrator.slopedisplacement.widget.CustomLoadMoreView;
import com.example.administrator.slopedisplacement.widget.pointImg.LineBean;
import com.example.administrator.slopedisplacement.widget.pointImg.PointBean;
import com.example.administrator.slopedisplacement.widget.pointImg.PointDataBean;
import com.example.administrator.slopedisplacement.widget.pointImg.PointFrameLayout;
import com.example.administrator.slopedisplacement.widget.popupwindow.BindViewHelper;
import com.example.administrator.slopedisplacement.widget.popupwindow.CommonPopupWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PlanLayoutOfPanoramaActivity extends BaseMvpActivity<PlanLayoutOfPanoramaPresenter> implements PlanLayoutOfPanoramaContact.View {
    Intent intent;
    int pageIndex = 0;
    int sumPage;
    boolean isLoad = true;//判断是否已经记载全景图
    ArrayList<PanoramaImgBean.ListBean> dataList = new ArrayList<PanoramaImgBean.ListBean>();
    ArrayList<SchemeAlarmListBean.ListBean> schemeAlarmList = new ArrayList<SchemeAlarmListBean.ListBean>();
    CommonPopupWindow mPopWindow;
    @BindView(R.id.ivPlanLayoutOfPanormamBack)
    ImageView ivPlanLayoutOfPanormamBack;
    @BindView(R.id.btnAlarmInformation)
    TextView btnAlarmInformation;
    @BindView(R.id.pflPoint)
    PointFrameLayout mPointFrameLayout;
    int schemeAlarmListPageIndex = 0;
    int SchemeAlarmListSumPage;
    GetSchemeAlarmListAdapter getSchemeAlarmListAdapter;
    PanoramaAdapter panoramaAdapter;
    int SchemeAlarmListPosition;
    IVMS_8700_Bean ivms_8700_bean;
    String mSchemeID;
    private boolean isFromPush = false;//是否从推送跳转过来的
    private GetDatSchemeAreaListJson mArealListJson;//区域列表数据
    private GetDatSchemeFixedListJson mFixedListJson;//定点列表数据
    /**
     * 区域数据是否准备完成
     */
    private boolean mIsPrepareAreaData = false;
    /**
     * 定点数据是否准备完成
     */
    private boolean mIsPrepareFixedData = false;
    /**
     * 背景是否准备完成
     */
    private boolean mIsPrepareImg = false;
    /**
     * 获取最新巡航点接口请求是否完成
     */
    private boolean mIsRequestGetSchemeMonitorLog = true;
    /**
     * 获取告警点接口请求是否完成
     */
    private boolean mIsRequestGetSchemeAlarm = true;

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
        ivms_8700_bean = (IVMS_8700_Bean) getIntent().getSerializableExtra(JumpToUtils.KEY_IVMS_8700_BEAN);
        Log.e("ivms_8700_bean", ivms_8700_bean.getCamFlowState());
        mSchemeID = getIntent().getStringExtra(JumpToUtils.KEY_SCHEMEID);
        String camId = getIntent().getStringExtra(JumpToUtils.KEY_CAMID);
        isFromPush = getIntent().getBooleanExtra(JumpToUtils.KEY_FROM_PUSH, false);
        mIsPrepareAreaData = false;
        mIsPrepareFixedData = false;
        mIsPrepareImg = false;
        mPresenter.getPanoramaImg(camId, pageIndex + "", "10", UserInfoPref.getUserId());
        mPresenter.getDatSchemeAreaList(mSchemeID + "", UserInfoPref.getUserId());
        mPresenter.getDatSchemeFixedList(mSchemeID + "", UserInfoPref.getUserId());
        loopQuery();
    }

    Disposable mDisposableLoopQuery;

    private void loopQuery() {
        if (mDisposableLoopQuery != null) {
            mDisposableLoopQuery.dispose();
        }
        //每隔10秒
        mDisposableLoopQuery = Observable.interval(0, 10, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    if (mIsRequestGetSchemeMonitorLog) {
                        mIsRequestGetSchemeMonitorLog = false;
                        mPresenter.getSchemeMonitorLog(mSchemeID + "", UserInfoPref.getUserId());
                    }
                    if (mIsRequestGetSchemeAlarm) {
                        mIsRequestGetSchemeAlarm = false;
                        mPresenter.getSchemeAlarm(mSchemeID + "", "2", UserInfoPref.getUserId());
                    }
                });
    }

    @Override
    protected void initView() {
    }

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

                        switch (view.getId()) {
                            case R.id.tvSchemeAlaramListMove1:
                                //MonitorID1 Aha1 Ava1 Shift1 Path1a nextPath1a oldPath1a
                                JumpToUtils.toAlarmChartViewActivity(getActivity(), schemeAlarmListBean.getMonitorID1(),
                                        schemeAlarmListBean.getAha1(), schemeAlarmListBean.getAva1(), schemeAlarmListBean.getShift1(),
                                        schemeAlarmListBean.getPath1a() + "", schemeAlarmListBean.getNextPath1a() + "", schemeAlarmListBean.getOldPath1a());
                                break;
                            case R.id.tvSchemeAlaramListMove2:
                                //MonitorID2 Aha2 Ava2 Shift2 Path2a nextPath2a oldPath2a
                                JumpToUtils.toAlarmChartViewActivity(getActivity(), schemeAlarmListBean.getMonitorID1(),
                                        schemeAlarmListBean.getAha1(), schemeAlarmListBean.getAva1(), schemeAlarmListBean.getShift1(),
                                        schemeAlarmListBean.getPath1a() + "", schemeAlarmListBean.getNextPath1a() + "", schemeAlarmListBean.getOldPath1a());
                                break;
                            case R.id.tvSchemeAlaramListMove3:
                                //MonitorID3 Aha3 Ava3 Shift3 Path3a nextPath3a oldPath3a
                                JumpToUtils.toAlarmChartViewActivity(getActivity(), schemeAlarmListBean.getMonitorID1(),
                                        schemeAlarmListBean.getAha1(), schemeAlarmListBean.getAva1(), schemeAlarmListBean.getShift1(),
                                        schemeAlarmListBean.getPath1a() + "", schemeAlarmListBean.getNextPath1a() + "", schemeAlarmListBean.getOldPath1a());
                                break;
                            case R.id.tvSchemeAlaramListMove4:
                                //MonitorID4 Aha4 Ava4 Shift4 Path4a nextPath4a oldPath4a
                                JumpToUtils.toAlarmChartViewActivity(getActivity(), schemeAlarmListBean.getMonitorID1(),
                                        schemeAlarmListBean.getAha1(), schemeAlarmListBean.getAva1(), schemeAlarmListBean.getShift1(),
                                        schemeAlarmListBean.getPath1a() + "", schemeAlarmListBean.getNextPath1a() + "", schemeAlarmListBean.getOldPath1a());
                                break;
                            case R.id.tvSchemeAlaramListMove5:
                                if (schemeAlarmList.get(position).getTypes() == 1) {
                                    showToast("此点为定点");
                                } else {
                                    JumpToUtils.toAlarmChartViewActivity(getActivity(), schemeAlarmListBean.getMonitorID1(),
                                            schemeAlarmListBean.getAha1(), schemeAlarmListBean.getAva1(), schemeAlarmListBean.getShift1(),
                                            schemeAlarmListBean.getPath1a() + "", schemeAlarmListBean.getNextPath1a() + "", schemeAlarmListBean.getOldPath1a());
                                    //MonitorID1 Aha1 Ava1 Shift1 Path1a nextPath1a oldPath1a
                                }
                                break;
                            case R.id.ivSchemeAlaramListNumConfirm:
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
                LinearLayout LLPopupPanorama = (LinearLayout) popupWindowBindView.getView(R.id.LLPopupPanorama);
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
                        mPointFrameLayout.changeBg(dataList.get(position).getPuzzleImg());
                        mPopWindow.dismiss();
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
                LLPopupPanorama.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopWindow.dismiss();
                    }
                });
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

            mIsPrepareImg = true;
            loadPointImg();
            isLoad = false;
        }

    }

    @Override
    public void onGetPanoramaImgFail(String msg) {
        showToast(msg);
        mIsPrepareImg = true;
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
        showToast(msg);
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
        mIsPrepareAreaData = true;
        loadPointImg();
    }

    @Override
    public void onGetDatSchemeAreaListFail(String msg) {
        mArealListJson = null;
        mIsPrepareAreaData = true;
        loadPointImg();
    }

    @Override
    public void onGetDatSchemeFixedListSuccess(GetDatSchemeFixedListJson fixedListJson) {
        mFixedListJson = fixedListJson;
        mIsPrepareFixedData = true;
        loadPointImg();
    }

    @Override
    public void onGetDatSchemeFixedListFail(String msg) {
        mFixedListJson = null;
        mIsPrepareFixedData = true;
        loadPointImg();
    }

    Disposable mDisposableSchemeMonitorLog;//轮循

    @Override
    public void getSchemeMonitorLogSuccess(List<GetSchemeMonitorLogJson> getSchemeMonitorLogJson) {
        mIsRequestGetSchemeMonitorLog = true;
        if (mDisposableSchemeMonitorLog != null) {
            mDisposableSchemeMonitorLog.dispose();
        }
        //轮循 每隔100毫秒执行一次
        mDisposableSchemeMonitorLog = Observable.interval(0, 100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    if (mPointFrameLayout != null && mPointFrameLayout.isPreparePoint()) {
                        mPointFrameLayout.stopAllPointAnimationMonitor();//停止所有巡航点动画
                        for (GetSchemeMonitorLogJson json : getSchemeMonitorLogJson) {
                            mPointFrameLayout.startPointAnimation(json.getMonitorID(), PointFrameLayout.AnimationType.MONITOR);
                        }
                        mDisposableSchemeMonitorLog.dispose();
                    }
                });
    }

    @Override
    public void getSchemeMonitorLogFail(String msg) {
        mIsRequestGetSchemeMonitorLog = true;
        showToast(msg);
    }

    Disposable mDisposableAlarm;

    @Override
    public void onGetSchemeAlarmSuccess(GetSchemeAlarmJson getSchemeAlarmJsons) {
        mIsRequestGetSchemeAlarm = true;
        if (mDisposableAlarm != null) {
            mDisposableAlarm.dispose();
        }
        mDisposableAlarm = Observable.interval(0, 100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    if (mPointFrameLayout != null && mPointFrameLayout.isPreparePoint()) {
                        mPointFrameLayout.stopAllPointAnimationAlarm();//停止所有告警点动画
                        for (GetSchemeAlarmJson.ListBean json : getSchemeAlarmJsons.getList()) {
                            mPointFrameLayout.startPointAnimation(json.getMonitorID1(), PointFrameLayout.AnimationType.ALARM);
                            mPointFrameLayout.startPointAnimation(json.getMonitorID2(), PointFrameLayout.AnimationType.ALARM);
                            mPointFrameLayout.startPointAnimation(json.getMonitorID3(), PointFrameLayout.AnimationType.ALARM);
                            mPointFrameLayout.startPointAnimation(json.getMonitorID4(), PointFrameLayout.AnimationType.ALARM);
                        }
                        mDisposableAlarm.dispose();
                    }
                });
    }

    @Override
    public void onGetSchemeAlarmFail(String msg) {
        mIsRequestGetSchemeAlarm = true;
        showToast(msg);
    }

    /**
     * 加载全景图和图上的点、线、面、文字
     */
    private synchronized void loadPointImg() {
        //区域列表、定点列表、获取全景图接口都调用完成后才执行加载点相关信息
        if (!mIsPrepareFixedData || !mIsPrepareAreaData || !mIsPrepareImg) {
            showLoading("加载数据中...");
            return;
        }
        ArrayList<PointBean> pointBeanList = new ArrayList<>();//点
        List<LineBean> lineBeanList = new ArrayList<>();//线
        List<LineBean> dottedLineList = new ArrayList<>();//虚线
        if (mArealListJson != null)
            PointImgHelper.areaPoint(mArealListJson.getList(), pointBeanList, lineBeanList, dottedLineList);
        if (mFixedListJson != null)
            PointImgHelper.fixedPoint(mFixedListJson.getList(), pointBeanList);

        PointDataBean imgPointBean = new PointDataBean();
        imgPointBean.setPointBeanList(pointBeanList);
        imgPointBean.setLineList(lineBeanList);
        imgPointBean.setDottedLineList(dottedLineList);
        mPointFrameLayout.setPointsInfo(imgPointBean);
        if (dataList != null && dataList.size() != 0)
            mPointFrameLayout.setBgImgUrl(dataList.get(0).getPuzzleImg());
        hideLoading();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPopWindow != null) {
            mPopWindow.dismiss();
        }
        if (mDisposableLoopQuery != null) {
            mDisposableLoopQuery.dispose();
        }
        if (mDisposableAlarm != null) {
            mDisposableAlarm.dispose();
        }
        if (mDisposableSchemeMonitorLog != null) {
            mDisposableSchemeMonitorLog.dispose();
        }
    }

    @OnClick({R.id.btnAlarmInformation, R.id.btnPanorama, R.id.btnPanoramaDataReport, R.id.btnVideo})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btnAlarmInformation:
//                mPointFrameLayout.stopAllPointAnimationAlarm();//停止所有告警点动画
                showPopupWindow();
                break;
            case R.id.btnPanorama:
                showPanoramaPopupWindow();
                break;
            case R.id.btnVideo:
                if (ivms_8700_bean.getCamFlowState().equals("15")) {
                    //2,5,8为互信、3中星微2.1、7中星微3.3、15海康8700
                    if (ivms_8700_bean.getmType().equals("2") || ivms_8700_bean.getmType().equals("5") || ivms_8700_bean.getmType().equals("8") || ivms_8700_bean.getmType().equals("3") || ivms_8700_bean.getmType().equals("7")) {
                        JumpToUtils.toHuXinVideoActivity(getActivity(), ivms_8700_bean);
                    } else {
                        //showToast("此为海康平台：");
                        JumpToUtils.toHKVideoActivity(getActivity(), ivms_8700_bean);
                    }
                } else {
                    showToast("此视频维护或不在线");
                }
                break;
            case R.id.btnPanoramaDataReport://跳转到查看数据页面
                JumpToUtils.toDataReportActivity(getActivity(), mArealListJson, mFixedListJson, mSchemeID + "");
                break;
            case R.id.ivPlanLayoutOfPanormamBack:
                finish();
                break;
        }
    }
}
