package com.example.administrator.slopedisplacement.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.SelectProjectAdapter;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.bean.ProjectBean;
import com.example.administrator.slopedisplacement.db.UserInfoPref;
import com.example.administrator.slopedisplacement.mvp.contact.SelectProjectContact;
import com.example.administrator.slopedisplacement.mvp.presenter.SelectProjectPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class SelectProjectActivity extends BaseMvpActivity<SelectProjectPresenter> implements SelectProjectContact.View{
    @BindView(R.id.etProjectName)
    EditText etProjectName;
    @BindView(R.id.btnProjectSearch)
    Button btnProjectSearch;
    @BindView(R.id.rvProject)
    RecyclerView rvProject;
    int pageIndex = 0;
    int totalCount ;
    SelectProjectAdapter selectProjectAdapter;
    ArrayList<ProjectBean.ListBean> dataList = new ArrayList<ProjectBean.ListBean>();
    @Override
    protected SelectProjectPresenter loadPresenter() {
        return new SelectProjectPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_selec_project;
    }

    @Override
    protected void initView() {
        rvProject.setLayoutManager(new LinearLayoutManager(this));
        selectProjectAdapter = new SelectProjectAdapter(R.layout.item_select_project,dataList);
        rvProject.setAdapter(selectProjectAdapter);
    }



    @OnClick({R.id.btnProjectSearch})
    void OnClick(View view){
        switch (view.getId()){
            case R.id.btnProjectSearch:
                mPresenter.getVideoMonitorList(etProjectName.getText().toString(),pageIndex+"","10", UserInfoPref.getUserId());
                break;
        }
    }

    @Override
    public void onGetVideoMonitorListSuccess(ProjectBean projectBean) {
        totalCount = projectBean.getTotalCount();
        dataList.addAll(projectBean.getList());
        Log.e("dataList.size",dataList.size()+"");
        selectProjectAdapter.notifyDataSetChanged();

    }

    @Override
    public void onGetVideoMonitorListFail(String msg) {

    }
}
