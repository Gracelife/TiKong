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
import com.example.administrator.slopedisplacement.adapter.SelectSchemeAdapter;
import com.example.administrator.slopedisplacement.base.BaseMvpActivity;
import com.example.administrator.slopedisplacement.bean.DriverBean;
import com.example.administrator.slopedisplacement.bean.SchemeBean;
import com.example.administrator.slopedisplacement.db.UserInfoPref;
import com.example.administrator.slopedisplacement.mvp.contact.SelectDriverContact;
import com.example.administrator.slopedisplacement.mvp.contact.SelectSchemeContact;
import com.example.administrator.slopedisplacement.mvp.presenter.SelectDriverPresenter;
import com.example.administrator.slopedisplacement.mvp.presenter.SelectSchemePresenter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

public class SelectSchemeActivity extends BaseMvpActivity<SelectSchemePresenter> implements SelectSchemeContact.View{
    Intent intent;
    SchemeBean schemeBean;
    SelectSchemeAdapter selectSchemeAdapter;
    @BindView(R.id.rvScheme)
    RecyclerView rvScheme;
    @Override
    protected SelectSchemePresenter loadPresenter() {
        return new SelectSchemePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_scheme;
    }
    @Override
    protected void initData(Bundle savedInstanceState) {
        intent = getIntent();
        schemeBean = (SchemeBean) intent.getSerializableExtra("SchemeList");
        rvScheme.setLayoutManager(new LinearLayoutManager(this));
        selectSchemeAdapter = new SelectSchemeAdapter(R.layout.item_select_scheme,schemeBean.getList());
        Log.e("schemeBean.getList()",schemeBean.getList().size()+"");
        rvScheme.setAdapter(selectSchemeAdapter);
        selectSchemeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //Toast.makeText(MainActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
                intent.setClass(SelectSchemeActivity.this,PlanLayoutOfPanoramaActivity.class);
                intent.putExtra("SchemeList",schemeBean.getList().get(position));
                startActivity(intent);
            }
        });

    }
    @Override
    protected void initView() {

    }

}
