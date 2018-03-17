package com.example.administrator.slopedisplacement.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.CruiseDataAdapter;
import com.example.administrator.slopedisplacement.base.BaseLazyFragment;
import com.example.administrator.slopedisplacement.utils.FormatUtils;
import com.example.administrator.slopedisplacement.utils.TimePickerUtils;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 巡航曲线区域图
 */

public class CruiseCurveAreaMapFragment extends BaseLazyFragment {
    @BindView(R.id.rvCruiseData)
    RecyclerView mRecyclerView;
    @BindView(R.id.btCruiseDataStart)
    TextView mTvCruiseDataStart;
    @BindView(R.id.btCruiseDataEnd)
    TextView mTvCruiseDataEnd;
    private CruiseDataAdapter adapter;
//    private String mSchemeID;

    public static CruiseCurveAreaMapFragment newInstance() {
        CruiseCurveAreaMapFragment cruiseDataFragment = new CruiseCurveAreaMapFragment();
//        cruiseDataFragment.mSchemeID = schemeID;
        return cruiseDataFragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_cruise_data;
    }

    @Override
    public void initView() {

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

    @OnClick({R.id.btCruiseDataStart, R.id.btCruiseDataEnd})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btCruiseDataStart:
                showTimePickerStart();
                break;
            case R.id.btCruiseDataEnd:
                showTimePickerEnd();
                break;
        }
    }
}