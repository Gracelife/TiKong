package com.example.administrator.slopedisplacement.mvp;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by GaoSheng on 2016/11/26.
 * 17:20
 *
 * @VERSION V1.4
 * com.example.gs.mvpdemo.base
 * mvp之v
 */

public interface IView {
    /**
     * 显示加载
     */
    void showLoading(String msg);

    /**
     * 隐藏加载
     */
    void hideLoading();
    /**
     * 显示信息
     */
    void showMsg(String msg);

    LifecycleTransformer bindLifecycle();
}
