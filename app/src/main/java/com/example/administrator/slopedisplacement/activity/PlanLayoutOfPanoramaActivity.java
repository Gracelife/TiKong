package com.example.administrator.slopedisplacement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.GetSchemeAlarmListAdapter;
import com.example.administrator.slopedisplacement.adapter.PanoramaAdapter;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.IVMS_8700_Bean;
import com.example.administrator.slopedisplacement.bean.PanoramaImgBean;
import com.example.administrator.slopedisplacement.bean.SchemeAlarmListBean;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeAreaListJson;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeFixedListJson;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeAlarmJson;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeMonitorLogJson;
import com.example.administrator.slopedisplacement.db.UserInfoPref;
import com.example.administrator.slopedisplacement.exception.ErrorType;
import com.example.administrator.slopedisplacement.mvp.contact.PlanLayoutOfPanoramaContact;
import com.example.administrator.slopedisplacement.mvp.presenter.PlanLayoutOfPanoramaPresenter;
import com.example.administrator.slopedisplacement.utils.JumpToUtils;
import com.example.administrator.slopedisplacement.widget.CustomLoadMoreView;
import com.example.administrator.slopedisplacement.widget.point.LineBean;
import com.example.administrator.slopedisplacement.widget.point.PointBean;
import com.example.administrator.slopedisplacement.widget.point.PointDataBean;
import com.example.administrator.slopedisplacement.widget.point.PointFrameLayout;
import com.example.administrator.slopedisplacement.widget.popupwindow.BindViewHelper;
import com.example.administrator.slopedisplacement.widget.popupwindow.CommonPopupWindow;

import java.util.ArrayList;
import java.util.List;

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
        mPresenter.getSchemeMonitorLog(mSchemeID + "", UserInfoPref.getUserId());
        mPresenter.getSchemeAlarm(mSchemeID + "", "2",UserInfoPref.getUserId() );
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
                               JumpToUtils.toAlarmChartViewActivity(getActivity(),schemeAlarmListBean.getMonitorID1(),
                                       schemeAlarmListBean.getAha1(),schemeAlarmListBean.getAva1(),schemeAlarmListBean.getShift1(),
                                       schemeAlarmListBean.getPath1a() + "",schemeAlarmListBean.getNextPath1a() + "",schemeAlarmListBean.getOldPath1a());
                                break;
                            case R.id.tvSchemeAlaramListMove2:
                                //MonitorID2 Aha2 Ava2 Shift2 Path2a nextPath2a oldPath2a
                                JumpToUtils.toAlarmChartViewActivity(getActivity(),schemeAlarmListBean.getMonitorID1(),
                                        schemeAlarmListBean.getAha1(),schemeAlarmListBean.getAva1(),schemeAlarmListBean.getShift1(),
                                        schemeAlarmListBean.getPath1a() + "",schemeAlarmListBean.getNextPath1a() + "",schemeAlarmListBean.getOldPath1a());
                                break;
                            case R.id.tvSchemeAlaramListMove3:
                                //MonitorID3 Aha3 Ava3 Shift3 Path3a nextPath3a oldPath3a
                                JumpToUtils.toAlarmChartViewActivity(getActivity(),schemeAlarmListBean.getMonitorID1(),
                                        schemeAlarmListBean.getAha1(),schemeAlarmListBean.getAva1(),schemeAlarmListBean.getShift1(),
                                        schemeAlarmListBean.getPath1a() + "",schemeAlarmListBean.getNextPath1a() + "",schemeAlarmListBean.getOldPath1a());
                                break;
                            case R.id.tvSchemeAlaramListMove4:
                                //MonitorID4 Aha4 Ava4 Shift4 Path4a nextPath4a oldPath4a
                                JumpToUtils.toAlarmChartViewActivity(getActivity(),schemeAlarmListBean.getMonitorID1(),
                                        schemeAlarmListBean.getAha1(),schemeAlarmListBean.getAva1(),schemeAlarmListBean.getShift1(),
                                        schemeAlarmListBean.getPath1a() + "",schemeAlarmListBean.getNextPath1a() + "",schemeAlarmListBean.getOldPath1a());
                                break;
                            case R.id.tvSchemeAlaramListMove5:
                                if (schemeAlarmList.get(position).getTypes() == 1) {
                                    showToast("此点为定点");
                                } else {
                                    JumpToUtils.toAlarmChartViewActivity(getActivity(),schemeAlarmListBean.getMonitorID1(),
                                            schemeAlarmListBean.getAha1(),schemeAlarmListBean.getAva1(),schemeAlarmListBean.getShift1(),
                                            schemeAlarmListBean.getPath1a() + "",schemeAlarmListBean.getNextPath1a() + "",schemeAlarmListBean.getOldPath1a());
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
    Handler handlerAlarm = new Handler();
    @Override
    public void onGetSchemeAlarmSuccess(GetSchemeAlarmJson getSchemeAlarmJsons) {
        handlerAlarm.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mPointFrameLayout.isPreparePoint()) {
                    for (GetSchemeAlarmJson.ListBean json : getSchemeAlarmJsons.getList()) {
                        mPointFrameLayout.startPointAnimation(json.getMonitorID1());
                        mPointFrameLayout.startPointAnimation(json.getMonitorID2());
                        mPointFrameLayout.startPointAnimation(json.getMonitorID3());
                        mPointFrameLayout.startPointAnimation(json.getMonitorID4());
                    }
                    return;
                }
                handlerAlarm.postDelayed(this, 100);
            }
        }, 100);
    }


    @Override
    public void onGetSchemeAlarmFail(String msg) {
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
    public void onGetDatSchemeFixedListSuccess(GetDatSchemeFixedListJson fixedListJson) {
        mFixedListJson = fixedListJson;
        mIsPrepareFixedData = true;
        loadPointImg();
    }
    Handler handlerSchemeMonitorLog = new Handler();
    @Override
    public void getSchemeMonitorLogSuccess(List<GetSchemeMonitorLogJson> getSchemeMonitorLogJson) {
        handlerSchemeMonitorLog.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mPointFrameLayout.isPreparePoint()) {
                    for (GetSchemeMonitorLogJson json : getSchemeMonitorLogJson) {
                        mPointFrameLayout.startPointAnimation(json.getMonitorID());
                    }
                    return;
                }
                handlerSchemeMonitorLog.postDelayed(this, 100);
            }
        }, 100);
    }
    /**
     * 区域 状态为面 点偏移百分比
     */
    private int pointOffsetScale = 4;
    private synchronized void loadPointImg() {
        //区域列表、定点列表、获取全景图接口都调用完成后才执行加载点相关信息
        if (!mIsPrepareFixedData || !mIsPrepareAreaData || !mIsPrepareImg) {
            return;
        }
        ArrayList<PointBean> pointBeanList = new ArrayList<>();//点
        List<LineBean> lineBeanList = new ArrayList<>();//线
        List<LineBean> dottedLineList = new ArrayList<>();//虚线

        //区域列表里的点线
        List<GetDatSchemeAreaListJson.ListBean> areaList = mArealListJson.getList();
        for (GetDatSchemeAreaListJson.ListBean area : areaList) {
            if (area.getAreaType().equals("1")) {//区域
                double startX = Double.parseDouble(area.getOx1());
                double startY = Double.parseDouble(area.getOy1());
                double endX = Double.parseDouble(area.getOx2());
                double endY = Double.parseDouble(area.getOy2());
                int num = area.getNewMonitor().size();
                boolean isPointVertical = isPointVertical(startX, startY, endX, endY);
                int pointBeanListIndex = pointBeanList.size();
                for (int i = 0; i < num / 2; i++) {
                    PointBean pointBean1 = new PointBean();
                    double scaleX = fun(startX, endX, i, num / 2 - 1);
                    double scaleY = fun(startY, endY, i, num / 2 - 1);
                    pointBean1.setXScale(scaleX);
                    pointBean1.setYScale(scaleY);
                    pointBean1.setmMonitorID(area.getNewMonitor().get(i * 2).getMonitorID());
                    if (i == 0) {
                        pointBean1.setPointName(area.getAreaNmae());
                    }
                    pointBean1.setPointIndex(pointBeanListIndex + i * 2);

                    PointBean pointBean2 = new PointBean();
                    if (isPointVertical) {
                        pointBean2.setXScale(scaleX + pointOffsetScale);
                        pointBean2.setYScale(scaleY);
                    } else {
                        pointBean2.setXScale(scaleX);
                        pointBean2.setYScale(scaleY + pointOffsetScale);
                    }
                    pointBean2.setmMonitorID(area.getNewMonitor().get(i * 2 + 1).getMonitorID());
                    pointBean2.setPointIndex(pointBeanListIndex + i * 2 + 1);
                    pointBeanList.add(pointBean1);
                    pointBeanList.add(pointBean2);
                }
                if (num > 2) {
                    dottedLineList.add(new LineBean(pointBeanList.get(pointBeanListIndex).getPointIndex(), pointBeanList.get(pointBeanListIndex + 1).getPointIndex()));
                    dottedLineList.add(new LineBean(pointBeanList.get(pointBeanListIndex + num - 2).getPointIndex(), pointBeanList.get(pointBeanListIndex + num - 1).getPointIndex()));
                }
                lineBeanList.add(new LineBean(pointBeanList.get(pointBeanListIndex).getPointIndex(), pointBeanList.get(pointBeanListIndex + num - 2).getPointIndex()));

            } else if (area.getAreaType().equals("2")) {//线
                String areaName = area.getAreaNmae();
                double startX = Double.parseDouble(area.getOx1());
                double startY = Double.parseDouble(area.getOy1());
                double endX = Double.parseDouble(area.getOx2());
                double endY = Double.parseDouble(area.getOy2());

                PointBean pointStart = new PointBean();
                pointStart.setXScale(startX);
                pointStart.setYScale(startY);
                PointBean pointEnd = new PointBean();
                pointEnd.setXScale(endX);
                pointEnd.setYScale(endY);

                if (startX < endX || (startX == endX && startY > endY)) {
                    pointStart.setPointName(areaName);
                } else {
                    pointEnd.setPointName(areaName);
                }
                //添加newMonitorId用于启动和关闭点的动画
                List<GetDatSchemeAreaListJson.ListBean.NewMonitorBean> newMonitorBeanList = area.getNewMonitor();
                if (newMonitorBeanList != null && newMonitorBeanList.size() >= 2) {
                    pointStart.setmMonitorID(area.getNewMonitor().get(0).getMonitorID());
                    pointEnd.setmMonitorID(area.getNewMonitor().get(1).getMonitorID());
                }

                pointStart.setPointIndex(pointBeanList.size());
                pointBeanList.add(pointStart);

                pointEnd.setPointIndex(pointBeanList.size());
                pointBeanList.add(pointEnd);
                lineBeanList.add(new LineBean(pointStart.getPointIndex(), pointEnd.getPointIndex()));
            } else if (area.getAreaType().equals("3")) {//点
                List<GetDatSchemeAreaListJson.ListBean.NewMonitorBean> newMonitorBeanList = area.getNewMonitor();
                int num = newMonitorBeanList.size();
                String areaName = area.getAreaNmae();
                for (int i = 0; i < num; i++) {
                    PointBean pointBean = new PointBean();
                    pointBean.setXScale(Double.parseDouble(newMonitorBeanList.get(i).getOx()));
                    pointBean.setYScale(Double.parseDouble(newMonitorBeanList.get(i).getOy()));
                    pointBean.setPointIndex(pointBeanList.size());
                    pointBean.setPointName(areaName + "_" + (i + 1));
                    pointBean.setmMonitorID(newMonitorBeanList.get(i).getMonitorID());
                    pointBeanList.add(pointBean);
                }
            }
        }
        //定点列表里的点
        List<GetDatSchemeFixedListJson.ListBean> fixedList = mFixedListJson.getList();
        for (GetDatSchemeFixedListJson.ListBean fixed : fixedList) {
            PointBean pointBean = new PointBean();
            pointBean.setXScale(Double.parseDouble(fixed.getOx()));
            pointBean.setYScale(Double.parseDouble(fixed.getOy()));
            pointBean.setPointIndex(pointBeanList.size());
            pointBean.setPointName(fixed.getFixedName());
            pointBean.setmMonitorID(fixed.getFixedID());
            pointBeanList.add(pointBean);
        }
        PointDataBean imgPointBean = new PointDataBean();
        imgPointBean.setPointBeanList(pointBeanList);
        imgPointBean.setLineList(lineBeanList);
        imgPointBean.setDottedLineList(dottedLineList);
        mPointFrameLayout.setPointsInfo(imgPointBean);
        mPointFrameLayout.setBgImgUrl(dataList.get(0).getPuzzleImg());
    }

    /**
     * 点的方向
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return true 向右 false 向下
     */
    private boolean isPointVertical(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            return true;
        }
        if (y1 == y2) {
            return false;
        }
        return Math.abs((y2 - y1) / (x2 - x1)) < 1;
    }

    private double fun(double start, double end, int n, int m) {
        return (end - start) * n / m + start;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPopWindow != null) {
            mPopWindow.dismiss();
        }
        if (isFromPush) {//从推送页面过来，则关闭所有页面，并跳转到选择项目页面
            Intent intent = new Intent(getActivity(), SelectProjectActivity.class);
            startActivity(intent);
        }
    }

    @OnClick({R.id.btnAlarmInformation, R.id.btnPanorama, R.id.btnPanoramaDataReport, R.id.btnVideo})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btnAlarmInformation:
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
                        JumpToUtils.toHKVideoActivity(getActivity(),ivms_8700_bean);
                    }
                } else {
                    showToast("此视频维护或不在线");
                }
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
