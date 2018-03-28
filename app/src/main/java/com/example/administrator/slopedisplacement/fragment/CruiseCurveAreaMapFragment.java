package com.example.administrator.slopedisplacement.fragment;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.classic.adapter.BaseAdapterHelper;
import com.classic.adapter.CommonAdapter;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.CruiseDataAdapter;
import com.example.administrator.slopedisplacement.base.BaseLazyFragment;
import com.example.administrator.slopedisplacement.base.BaseMvpLazyFragment;
import com.example.administrator.slopedisplacement.bean.AreaMapBean;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeAreaListJson;
import com.example.administrator.slopedisplacement.bean.json.GetSchemeMonitorListLogJson;
import com.example.administrator.slopedisplacement.db.UserInfoPref;
import com.example.administrator.slopedisplacement.mvp.contact.CruiseCurveAreaMapContact;
import com.example.administrator.slopedisplacement.mvp.contact.CruiseDataContact;
import com.example.administrator.slopedisplacement.mvp.presenter.CruiseCurveAreaMapPresenter;
import com.example.administrator.slopedisplacement.mvp.presenter.CruiseDataPresenter;
import com.example.administrator.slopedisplacement.utils.FormatUtils;
import com.example.administrator.slopedisplacement.utils.LineChartUtils;
import com.example.administrator.slopedisplacement.utils.TimePickerUtils;
import com.example.administrator.slopedisplacement.widget.MyMarkerView;
import com.ffcs.android.api.internal.util.StringUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 巡航曲线区域图
 */

public class CruiseCurveAreaMapFragment extends BaseMvpLazyFragment<CruiseCurveAreaMapPresenter> implements  CruiseCurveAreaMapContact.View {
    private GetDatSchemeAreaListJson mArealListJson;
    private CruiseDataAdapter adapter;
    @BindView(R.id.spnCruiseDataAreaMap)
    Spinner spnCruiseDataAreaMap;
    @BindView(R.id.spnCruiseDataMonitorMap)
    Spinner spnCruiseDataMonitorMap;
    @BindView(R.id.spnCruiseDataTypeMap)
    Spinner spnCruiseDataTypeMap;
    @BindView(R.id.tvTimeMap)
    TextView tvTimeMap;
    @BindView(R.id.tvMapName)
    TextView tvMapName;
    @BindView(R.id.btnTimeForDayMap)
    Button btnTimeForDayMap;
    @BindView(R.id.btnTimeForMonthMap)
    Button btnTimeForMonthMap;
    @BindView(R.id.btnTimeForYearMap)
    Button btnTimeForYearMap;
    @BindView(R.id.lcAreaMap)
    LineChart lcAreaMap;
    
    int timeType = 2;
    List<AreaMapBean> areaMapBeanList = new ArrayList<AreaMapBean>();
    List<Double> PositiveThresholdList = new ArrayList<Double>();;
    List<Double> NegativeThresholdList = new ArrayList<Double>();;
    List<Double> shiftDataList = new ArrayList<Double>();;
    List<String> timeList = new ArrayList<String>();;
    LineData data ;
    /**
     * 区域下拉列表里显示的数据
     */
    List<GetDatSchemeAreaListJson.ListBean> mAreaList = new ArrayList<>();
    /**
     * 监测点下拉列表里显示的数据
     */
    List<GetDatSchemeAreaListJson.ListBean.NewMonitorBean> mNewMonitorList = new ArrayList<>();
//    private String mSchemeID;
    private CommonAdapter<String> mSpnAdapterDataType;
    private CommonAdapter<GetDatSchemeAreaListJson.ListBean> mSpnAdapterArea;
    private CommonAdapter<GetDatSchemeAreaListJson.ListBean.NewMonitorBean> mSpnAdapterMonitor;
    private String mSchemeID = "";
    public static CruiseCurveAreaMapFragment newInstance(GetDatSchemeAreaListJson areaListJson, String schemeID) {
        CruiseCurveAreaMapFragment cruiseDataFragment = new CruiseCurveAreaMapFragment();
//        cruiseDataFragment.mSchemeID = schemeID;
        if(areaListJson==null||areaListJson.getList()==null||areaListJson.getList().isEmpty()){
            cruiseDataFragment.setDataEmpty();
        }else {
            cruiseDataFragment.mArealListJson = areaListJson;
            cruiseDataFragment.mSchemeID = schemeID;
        }
        return cruiseDataFragment;
    }
    @Override
    protected CruiseCurveAreaMapPresenter loadPresenter() {
        return new CruiseCurveAreaMapPresenter();
    }
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_cruise_curve_area_map;
    }

    @Override
    public void initView() {
        data = new LineData();
        data.setValueFormatter(new MyValueFormatter());
        initSpnCruiseDataTypeMap();
        initSpnArea(mArealListJson.getList());
        if(mArealListJson.getList().size() != 0){
            spnCruiseDataAreaMap.setSelection(0);
            tvTimeMap.setText(FormatUtils.calendarToString(Calendar.getInstance()));
            initSpnMonitor(mArealListJson.getList().get(spnCruiseDataAreaMap.getSelectedItemPosition()).getNewMonitor());
            mPresenter.getNewSchemeMonitorChartsByDateTop(mSchemeID, mAreaList.get(spnCruiseDataAreaMap.getSelectedItemPosition()).getAreaID() + ""
                    ,mNewMonitorList.get(spnCruiseDataMonitorMap.getSelectedItemPosition()).getMonitorID() + "",timeType,tvTimeMap.getText().toString(), UserInfoPref.getUserId());
        }

    }
    /**
     * 初始化数据类型
     *
     *
     */
    private void initSpnCruiseDataTypeMap(){
        ArrayList<String> dataType = new ArrayList<String>();
        dataType.add("阶段位移");
        dataType.add("累计位移");
        dataType.add("单次位移");
        dataType.add("距离");
        mSpnAdapterDataType = new CommonAdapter<String>(getActivity(),R.layout.item_spinner, dataType) {
            @Override
            public void onUpdate(BaseAdapterHelper helper, String item, int position) {
                helper.setText(R.id.tvItemSpinner, item);
            }
        };
        spnCruiseDataTypeMap.setAdapter(mSpnAdapterDataType);
        spnCruiseDataTypeMap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               /* GetDatSchemeAreaListJson.ListBean list = (GetDatSchemeAreaListJson.ListBean) parent.getAdapter().getItem(position);
                initSpnMonitor(list.getNewMonitor());*/
                mPresenter.getNewSchemeMonitorChartsByDateTop(mSchemeID, mAreaList.get(spnCruiseDataAreaMap.getSelectedItemPosition()).getAreaID() + ""
                        , mNewMonitorList.get(spnCruiseDataMonitorMap.getSelectedItemPosition()).getMonitorID() + "", timeType, tvTimeMap.getText().toString(), UserInfoPref.getUserId());
                if (areaMapBeanList.size() != 0) {
                    switch (spnCruiseDataTypeMap.getSelectedItemPosition()) {
                        case 0:
                            //阶段位移
                            shiftDataList = areaMapBeanList.get(0).getShift();

                            break;
                        case 1:
                            //累计位移
                            shiftDataList = areaMapBeanList.get(0).getAddShift();
                            break;
                        case 2:
                            //单次位移
                            shiftDataList = areaMapBeanList.get(0).getNowShift();
                            break;
                        case 3:
                            //距离
                            shiftDataList = areaMapBeanList.get(0).getObd();
                            break;

                    }

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    /**
     * 初始化区域的Spinner,并添加默认"全部"选项
     *
     * @param list 数据
     */
    private void initSpnArea(List<GetDatSchemeAreaListJson.ListBean> list) {
        mSpnAdapterArea = new CommonAdapter<GetDatSchemeAreaListJson.ListBean>(getActivity(), R.layout.item_spinner, mAreaList) {
            @Override
            public void onUpdate(BaseAdapterHelper helper, GetDatSchemeAreaListJson.ListBean item, int position) {
                helper.setText(R.id.tvItemSpinner, item.getAreaNmae());
            }
        };

        spnCruiseDataAreaMap.setAdapter(mSpnAdapterArea);
        spnCruiseDataAreaMap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GetDatSchemeAreaListJson.ListBean list = (GetDatSchemeAreaListJson.ListBean) parent.getAdapter().getItem(position);
                initSpnMonitor(list.getNewMonitor());
                mPresenter.getNewSchemeMonitorChartsByDateTop(mSchemeID, mAreaList.get(spnCruiseDataAreaMap.getSelectedItemPosition()).getAreaID() + ""
                        ,mNewMonitorList.get(spnCruiseDataMonitorMap.getSelectedItemPosition()).getMonitorID() + "",timeType,tvTimeMap.getText().toString(), UserInfoPref.getUserId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        mAreaList.clear();
        mSpnAdapterArea.clear();
        if (list != null && list.size() != 0)
            mAreaList.addAll(list);
        mSpnAdapterArea.addAll(mAreaList);
        mSpnAdapterArea.notifyDataSetChanged();
        spnCruiseDataAreaMap.setSelection(0);
    }
    /**
     * 初始化监控点的Spinner,并添加默认"全部"选项
     *
     * @param list 数据
     */
    private void initSpnMonitor(List<GetDatSchemeAreaListJson.ListBean.NewMonitorBean> list) {
        mSpnAdapterMonitor = new CommonAdapter<GetDatSchemeAreaListJson.ListBean.NewMonitorBean>(getActivity(), R.layout.item_spinner, mNewMonitorList) {
            @Override
            public void onUpdate(BaseAdapterHelper helper, GetDatSchemeAreaListJson.ListBean.NewMonitorBean item, int position) {
                helper.setText(R.id.tvItemSpinner, item.getMonitorID());
            }
        };

        spnCruiseDataMonitorMap.setAdapter(mSpnAdapterMonitor);
        spnCruiseDataMonitorMap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                mPresenter.getNewSchemeMonitorChartsByDateTop(mSchemeID, mAreaList.get(spnCruiseDataAreaMap.getSelectedItemPosition()).getAreaID() + ""
                        ,mNewMonitorList.get(spnCruiseDataMonitorMap.getSelectedItemPosition()).getMonitorID() + "",timeType,tvTimeMap.getText().toString(), UserInfoPref.getUserId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        mNewMonitorList.clear();
        mSpnAdapterMonitor.clear();
        if (list != null && list.size() != 0)
            mNewMonitorList.addAll(list);
        mSpnAdapterMonitor.addAll(mNewMonitorList);
        mSpnAdapterMonitor.notifyDataSetChanged();
        spnCruiseDataMonitorMap.setSelection(0);
    }
    @Override
    protected void lazyLoadDate() {

    }// 设置显示的样式
    void setupChart() {
        //为图表设置一个选择监听器
        lcAreaMap.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, Highlight highlight) {
                Log.i("Entry selected", entry.toString());

                lcAreaMap.centerViewToAnimated(entry.getX(), entry.getY(), lcAreaMap.getData().getDataSetByIndex(highlight.getDataSetIndex())
                        .getAxisDependency(), 500);

            }

            @Override
            public void onNothingSelected() {
                Log.i("Nothing selected", "Nothing selected.");
            }
        });

        LineChartUtils.setLineInit(lcAreaMap);
        MyMarkerView mv = new MyMarkerView(this.getActivity(), R.layout.custom_marker_view);
        mv.setChartView(lcAreaMap); // For bounds control
        lcAreaMap.setMarker(mv); // Set the marker to the chart
        // add data
       setData(PositiveThresholdList,0,Color.rgb(255,215,0),"阈值");
       setData(NegativeThresholdList,1,Color.rgb(255,215,0),"阈值");
        setData(shiftDataList,2,Color.rgb(255,0,0),"方案1");
        //setData(shiftDataList,2);
        //使用指定的动画时间在x轴上动画显示图表。
        lcAreaMap.animateX(2500);
        // 获取Legend(图例)  （仅在设置数据后才可以）
        LineChartUtils.setLegend(lcAreaMap.getLegend());
        LineChartUtils.setXAxis(lcAreaMap.getXAxis());
        YAxis yYAxis = lcAreaMap.getAxisLeft();
        //yYAxis.setValueFormatter((IAxisValueFormatter) new MyValueFormatter());
        //LineChartUtils.setLeftYAxis(yYAxis,1f,-1f);
        //右侧y轴设置为不使用
        lcAreaMap.getAxisRight().setEnabled(false);
//        rightAxis.set
//        YAxis rightAxis = lcAreaMap.getAxisRight();
////        rightAxis.setTypeface(mTfLight);
//        rightAxis.setTextColor(Color.RED);
//        rightAxis.setAxisMaximum(900);
//        rightAxis.setAxisMinimum(-200);
//        rightAxis.setDrawGridLines(false);
//        //将此设置为true以绘制零线，而不管天气是否启用其他网格线。 默认值：false
//        rightAxis.setDrawZeroLine(false);
//        rightAxis.setGranularityEnabled(false);
        if(timeList.size() != 0){
            MyXFormatter formatter = new MyXFormatter(timeList);
            XAxis xAxis = lcAreaMap.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setDrawAxisLine(false);
            xAxis.setDrawGridLines(false);
            xAxis.setValueFormatter(formatter);
        }


    }
    public class MyXFormatter  implements IAxisValueFormatter {

        private List<String> mValues;

        public MyXFormatter(List<String> values) {
            this.mValues = values;
        }
        private static final String TAG = "MyXFormatter";

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            Log.d(TAG, "----->getFormattedValue: "+value);

            return String.valueOf(mValues.get((int) value));
        }
    }
    private void   setData(List<Double> dataList, int position ,int color,String name ){
        ArrayList<Entry> yVals = new ArrayList<Entry>();

        for (int i = 0; i < dataList.size(); i++) {
            Log.e("1",Float.parseFloat(dataList.get(i)+"")+"");
            yVals.add(new Entry(i, Float.parseFloat(dataList.get(i)+"")));
            LineDataSet set;
            if (lcAreaMap.getData() != null &&
                    lcAreaMap.getData().getDataSetCount() > 0 && lcAreaMap.getData().getDataSetByIndex(position) != null) {
                set = (LineDataSet) lcAreaMap.getData().getDataSetByIndex(position);
                set.setValues(yVals);
                lcAreaMap.getData().notifyDataChanged();
                lcAreaMap.notifyDataSetChanged();
            }else {
                // create a dataset and give it a type
                set = new LineDataSet(yVals, name);

                set.setAxisDependency(YAxis.AxisDependency.LEFT);
                set.setColor(color);
                set.setCircleColor(Color.WHITE);
                set.setLineWidth(2f);
                set.setCircleRadius(3f);
                set.setFillAlpha(65);
                set.setFillColor(color);
                set.setHighLightColor(color);
                set.setDrawCircleHole(false);
                set.setDrawCircles(false);
                set.setDrawValues(false);
                //set1.setFillFormatter(new MyFillFormatter(0f));
                //set1.setDrawHorizontalHighlightIndicator(false);
                //set1.setVisible(false);
                //set1.setCircleHoleColor(Color.WHITE);



                // create a data object with the datasets
                //LineData data = new LineData(set);
                data.addDataSet(set);
                //data.setValueFormatter(new MyValueFormatter());
                data.setValueTextColor(Color.WHITE);
                data.setValueTextSize(9f);

                // set data
                lcAreaMap.setData(data);
            }
        }
    }
    public class MyValueFormatter implements IValueFormatter {

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {

            return com.example.administrator.slopedisplacement.utils.StringUtils.double2String(value, 0);
        }
    }
    @OnClick({R.id.tvTimeMap,R.id.btnTimeForDayMap,R.id.btnTimeForMonthMap,R.id.btnTimeForYearMap})
    void OnClick(View view) {
        if(mIsDataEmpty){
            return;
        }
        switch (view.getId()) {
            case R.id.tvTimeMap:

                break;
            case R.id.btnTimeForDayMap:

                TimePickerUtils.showPickerView(getActivity(),"选择时间",tvTimeMap,true,true,new TimePickerView.OnTimeSelectListener(){

                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvTimeMap.setText(FormatUtils.dateToString(date,true,true));
                        tvMapName.setText("巡航监测点日线图");
                        timeType = 2;
                        mPresenter.getNewSchemeMonitorChartsByDateTop(mSchemeID, mAreaList.get(spnCruiseDataAreaMap.getSelectedItemPosition()).getAreaID() + ""
                                ,mNewMonitorList.get(spnCruiseDataMonitorMap.getSelectedItemPosition()).getMonitorID() + "",timeType,tvTimeMap.getText().toString(), UserInfoPref.getUserId());
                    }
                });

                break;
            case R.id.btnTimeForMonthMap:
                TimePickerUtils.showPickerView(getActivity(),"选择时间",tvTimeMap,true,false,new TimePickerView.OnTimeSelectListener(){

                @Override
                public void onTimeSelect(Date date, View v) {
                    tvTimeMap.setText(FormatUtils.dateToString(date,true,false));
                    tvMapName.setText("巡航监测点月线图");
                    timeType = 1;
                    mPresenter.getNewSchemeMonitorChartsByDateTop(mSchemeID, mAreaList.get(spnCruiseDataAreaMap.getSelectedItemPosition()).getAreaID() + ""
                            ,mNewMonitorList.get(spnCruiseDataMonitorMap.getSelectedItemPosition()).getMonitorID() + "",timeType,tvTimeMap.getText().toString(), UserInfoPref.getUserId());
                }
            });

                break;
            case R.id.btnTimeForYearMap:
                TimePickerUtils.showPickerView(getActivity(),"选择时间",tvTimeMap,false,false,new TimePickerView.OnTimeSelectListener(){

                    @Override
                    public void onTimeSelect(Date date, View v) {
                        tvMapName.setText("巡航监测点年线图");
                        timeType = 0;
                        tvTimeMap.setText(FormatUtils.dateToString(date,false,false));
                        mPresenter.getNewSchemeMonitorChartsByDateTop(mSchemeID, mAreaList.get(spnCruiseDataAreaMap.getSelectedItemPosition()).getAreaID() + ""
                                ,mNewMonitorList.get(spnCruiseDataMonitorMap.getSelectedItemPosition()).getMonitorID() + "",timeType,tvTimeMap.getText().toString(), UserInfoPref.getUserId());
                    }
                });

                break;
        }
    }


    @Override
    public void onGetNewSchemeMonitorChartsByDateTopSuccess(List<AreaMapBean> areaMapBeanList) {
        //this.areaMapBeanList.clear();
        //timeList.clear();
        //PositiveThresholdList.clear();
        //NegativeThresholdList.clear();
        //shiftDataList.clear();
        this.areaMapBeanList = areaMapBeanList;
        if(areaMapBeanList.size() != 0) {

            //obd 距离 shift 阶段 addShift 累计位移 Nowshift 单次位移
            timeList = areaMapBeanList.get(0).getTimeName();
            Log.e("timeList",timeList.get(0));
            //正阈值
            PositiveThresholdList = areaMapBeanList.get(1).getData();
            //负阈值
            NegativeThresholdList = areaMapBeanList.get(2).getData();
            switch (spnCruiseDataTypeMap.getSelectedItemPosition()){
                case 0:
                    //阶段位移
                    shiftDataList =areaMapBeanList.get(0).getShift();

                    break;
                case 1:
                    //累计位移
                    shiftDataList =areaMapBeanList.get(0).getAddShift();
                    break;
                case 2:
                    //单次位移
                    shiftDataList =areaMapBeanList.get(0).getNowShift();
                    break;
                case 3:
                    //距离
                    shiftDataList =areaMapBeanList.get(0).getObd();
                    break;
            }


        }
        setupChart();
    }

    @Override
    public void onGetNewSchemeMonitorChartsByDateTopFail(String msg) {

    }


}