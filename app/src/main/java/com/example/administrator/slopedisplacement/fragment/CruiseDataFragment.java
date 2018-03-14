package com.example.administrator.slopedisplacement.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.bigkoo.pickerview.TimePickerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.CruiseDataAdapter;
import com.example.administrator.slopedisplacement.base.BaseLazyFragment;
import com.example.administrator.slopedisplacement.utils.TimePickerUtils;
import com.example.administrator.slopedisplacement.widget.CustomLoadMoreView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 巡航流水数据
 */

public class CruiseDataFragment extends BaseLazyFragment {
    @BindView(R.id.rvCruiseData)
    RecyclerView mRecyclerView;
    @BindView(R.id.btCruiseDataStart)
    Button mBtCruiseDataStart;
    @BindView(R.id.btCruiseDataEnd)
    Button mBtCruiseDataEnd;
    private CruiseDataAdapter adapter;
    private String mSchemeID;

    public static CruiseDataFragment newInstance(String schemeID) {
        CruiseDataFragment cruiseDataFragment = new CruiseDataFragment();
        cruiseDataFragment.mSchemeID = schemeID;
        return cruiseDataFragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_cruise_data;
    }

    @Override
    public void initView(Bundle state) {
        mIsPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoadDate() {
        List<String> data = new ArrayList<>();
        data.add("111");
        data.add("112");
        data.add("113");
        data.add("114");
        adapter = new CruiseDataAdapter(R.layout.item_cruise_data, data);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);
        adapter.setLoadMoreView(new CustomLoadMoreView());
        //加载更多
        adapter.setOnLoadMoreListener(() -> {
//                mRecyclerView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if(pageIndex > sumPage){
//                            showToast("已经是最后一页了");
//                            selectProjectAdapter.loadMoreEnd();
//                        }else {
//                            mPresenter.getVideoMonitorList(etProjectName.getText().toString(), pageIndex + "", "10", UserInfoPref.getUserId());
//                        }

//                    }
//
//                }, 1000);
        }, mRecyclerView);
        adapter.disableLoadMoreIfNotFullPage();
        adapter.setOnItemClickListener((BaseQuickAdapter adapter, View view, int position) -> {
            //Toast.makeText(MainActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
//                try {
//                    intent = getIntent();
//                    intent.setClass(SelectProjectActivity.this, SelectDriverActivity.class);
//                    intent.putExtra("Project", dataList.get(position));
//                    startActivity(intent);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }

        });
    }

    private TimePickerView mTimePickerStart;
    private Date mDateStart;
    private TimePickerView mTimePickerEnd;
    private Date mDateEnd;

    private void showTimePickerStart() {
        if (mTimePickerStart == null) {
            mTimePickerStart = TimePickerUtils.createPickerView(getActivity(), (Date date, View view) -> {
                mDateStart = date;
                mBtCruiseDataStart.setText(TimePickerUtils.dateToString(date));
            });
        } else {
            mTimePickerStart.setDate(TimePickerUtils.dataToCalendar(mDateStart));
        }
        mTimePickerStart.show();
    }

    private void showTimePickerEnd() {
        if (mTimePickerEnd == null) {
            mTimePickerEnd = TimePickerUtils.createPickerView(getActivity(), (Date date, View view) -> {
                mDateEnd = date;
                mBtCruiseDataEnd.setText(TimePickerUtils.dateToString(date));
            });
        } else {
            mTimePickerEnd.setDate(TimePickerUtils.dataToCalendar(mDateEnd));
        }
        mTimePickerEnd.show();
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