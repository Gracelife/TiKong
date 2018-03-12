package com.example.administrator.slopedisplacement.activity;

import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.base.BaseActivity;
import com.example.administrator.slopedisplacement.utils.L;
import com.example.administrator.slopedisplacement.widget.CommonDialog;
import com.example.administrator.slopedisplacement.widget.popupwindow.BindViewHelper;
import com.example.administrator.slopedisplacement.widget.popupwindow.CommonPopupWindow;

import butterknife.OnClick;

/**
 * 测试页面
 */

public class TestActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {

    }

    CommonPopupWindow mPopupWindow;

    private void showPop() {
        mPopupWindow = new CommonPopupWindow.Builder(this) {
            @Override
            public void popBindView(BindViewHelper popupWindowBindView) {
                popupWindowBindView.setText(R.id.tvSchemeAlaramListNum, "改变");
            }
        }.setContentView(R.layout.view_popupwindow_listview)
                .builder()
                .showAtLocation(R.layout.activity_test, Gravity.CENTER, 0, 0);
    }

    @OnClick({R.id.btn_test1, R.id.btn_test2})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test1:
                Toast.makeText(getActivity(), "点击了1", Toast.LENGTH_LONG).show();
                new CommonDialog(getActivity())
                        .setMsg("对话框")
                        .setRightClick(v -> L.e("点击右侧按"))
                        .show();
                break;
            case R.id.btn_test2:
                Toast.makeText(getActivity(), "点击了1", Toast.LENGTH_LONG).show();
                showPop();
                break;
        }
    }
}
