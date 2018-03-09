package com.example.administrator.slopedisplacement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.adapter.SelectDriverAdapter;
import com.example.administrator.slopedisplacement.adapter.SelectProjectAdapter;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.LoginBean;
import com.example.administrator.slopedisplacement.bean.ProjectBean;
import com.example.administrator.slopedisplacement.bean.SchemeBean;
import com.example.administrator.slopedisplacement.db.UserInfoPref;
import com.example.administrator.slopedisplacement.mvp.contact.SelectDriverContact;
import com.example.administrator.slopedisplacement.mvp.presenter.SelectDriverPresenter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;

public class SelectDriverActivity extends BaseMvpActivity<SelectDriverPresenter> implements SelectDriverContact.View{
    Intent intent;
    SelectDriverAdapter selectDriverAdapter;
    ArrayList<DriverBean.ListBean> dataList = new ArrayList<DriverBean.ListBean>();
    @BindView(R.id.rvDriver)
    RecyclerView rvDriver;
    DriverBean.ListBean driverBean;

    @Override
    protected SelectDriverPresenter loadPresenter() {
        return new SelectDriverPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_driver;
    }

    @Override
    protected void initView() {
        rvDriver.setLayoutManager(new LinearLayoutManager(this));
        selectDriverAdapter = new SelectDriverAdapter(R.layout.item_select_drivier,dataList);
        rvDriver.setAdapter(selectDriverAdapter);
        selectDriverAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //Toast.makeText(MainActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
                driverBean = dataList.get(position);
                mPresenter.getSchemeList(dataList.get(position).getCamId()+"",UserInfoPref.getUserId());

            }
        });

    }
    @Override
    protected void initData(Bundle savedInstanceState) {
        intent = getIntent();
        mPresenter.getVideoCamList(((ProjectBean.ListBean)intent.getSerializableExtra("Project")).getProjID()+"", UserInfoPref.getUserId());


    }

    @Override
    public void onGetVideoCamListSuccess(DriverBean driverBean) {
        if(driverBean.getList().size() == 0){
            showToast("暂无数据！");
        }else{
            showToast("数据加载成功！");
        }
        dataList.addAll(driverBean.getList());
        selectDriverAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetVideoCamListFail(String msg) {
        showToast(msg);
    }

    @Override
    public void onGetSchemeListSuccess(SchemeBean schemeBean) {
        SchemeBean.ListBean listBean = null;
        for (SchemeBean.ListBean list:schemeBean.getList()) {
            if(list.getStates()==1 ){
                listBean = list;
            }
        }
        try {
        if(listBean != null){
            //全景图页面
            intent.setClass(SelectDriverActivity.this,PlanLayoutOfPanoramaActivity.class);
            intent.putExtra("SchemeBean",listBean);
            intent.putExtra("DriverBean",driverBean);
            startActivity(intent);
        }else{
            intent.setClass(SelectDriverActivity.this,SelectSchemeActivity.class);
            intent.putExtra("DriverBean",driverBean);
            intent.putExtra("SchemeList",schemeBean);
            startActivity(intent);


        }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onGetSchemeListFail(String msg) {
        showToast(msg);
    }
}
