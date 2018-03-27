package com.example.administrator.slopedisplacement.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.classic.adapter.BaseAdapterHelper;
import com.classic.adapter.CommonAdapter;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.CruiseDataAdapter;
import com.example.administrator.slopedisplacement.base.BaseLazyFragment;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeAreaListJson;
import com.example.administrator.slopedisplacement.utils.FormatUtils;
import com.example.administrator.slopedisplacement.utils.TimePickerUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 巡航曲线区域图
 */

public class CruiseCurveAreaMapFragment extends BaseLazyFragment {
    private GetDatSchemeAreaListJson mArealListJson;
    private CruiseDataAdapter adapter;
    @BindView(R.id.spnCruiseDataAreaMap)
    Spinner spnCruiseDataAreaMap;
    @BindView(R.id.spnCruiseDataMonitorMap)
    Spinner spnCruiseDataMonitorMap;
    /**
     * 区域下拉列表里显示的数据
     */
    List<GetDatSchemeAreaListJson.ListBean> mAreaList = new ArrayList<>();
    /**
     * 监测点下拉列表里显示的数据
     */
    List<GetDatSchemeAreaListJson.ListBean.NewMonitorBean> mNewMonitorList = new ArrayList<>();
//    private String mSchemeID;
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
    public int getLayoutResId() {
        return R.layout.fragment_fixed_point_curve_area_map;
    }

    @Override
    public void initView() {
        initSpnArea(mArealListJson.getList());
        if(mArealListJson.getList().size() != 0){
            spnCruiseDataAreaMap.setSelection(0);
            initSpnMonitor(mArealListJson.getList().get(spnCruiseDataAreaMap.getSelectedItemPosition()).getNewMonitor());
        }


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

        spnCruiseDataMonitorMap.setAdapter(mSpnAdapterArea);
        spnCruiseDataMonitorMap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                GetDatSchemeAreaListJson.ListBean list = (GetDatSchemeAreaListJson.ListBean) parent.getAdapter().getItem(position);
                initSpnMonitor(list.getNewMonitor());
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
        spnCruiseDataMonitorMap.setSelection(0);
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
        spnCruiseDataAreaMap.setAdapter(mSpnAdapterMonitor);
        mNewMonitorList.clear();
        mSpnAdapterMonitor.clear();
        if (list != null && list.size() != 0)
            mNewMonitorList.addAll(list);
        mSpnAdapterMonitor.addAll(mNewMonitorList);
        mSpnAdapterMonitor.notifyDataSetChanged();
        spnCruiseDataAreaMap.setSelection(0);
    }
    @Override
    protected void lazyLoadDate() {

    }

    private void showTimePickerStart() {
//        TimePickerUtils.showPickerView(getActivity(),"开始时间",mTvCruiseDataStart,"1234-10-11",mTvCruiseDataEnd.getText().toString());
    }

    private void showTimePickerEnd() {
//        TimePickerUtils.showPickerView(getActivity(),"结束时间",mTvCruiseDataEnd,mTvCruiseDataStart.getText().toString(),mTvCruiseDataEnd.getText().toString());
    }


}