package com.example.administrator.slopedisplacement.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 懒加载的Fragment
 */

public abstract class BaseLazyFragment extends RxFragment {
    private Unbinder mUnbinder;
    private View mParentView;
    private FragmentActivity mActivity;//防止使用getActivity()为空
    // 标志位 标志已经初始化完成。
    protected boolean mIsPrepared;
    //标志位 fragment是否可见
    protected boolean mIsVisible;
    /**
     * 数据是否为空
     */
    protected boolean mIsDataEmpty = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        mParentView = inflater.inflate(getLayoutResId(), container, false);
        mActivity = getSupportActivity();
        return mParentView;
    }

    /**
     * 数据为空
     */
    public void setDataEmpty() {
        this.mIsDataEmpty = true;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        mIsPrepared = true;
        lazyLoad();
    }

    /**
     * 设置布局
     *
     * @return
     */
    @LayoutRes
    public abstract int getLayoutResId();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (FragmentActivity) activity;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        this.mActivity = null;
    }


    public FragmentActivity getSupportActivity() {
        return super.getActivity();
    }


    public android.app.ActionBar getSupportActionBar() {
        return getSupportActivity().getActionBar();
    }


    public Context getApplicationContext() {
        return this.mActivity == null ? (getActivity() == null ?
                null : getActivity().getApplicationContext()) : this.mActivity.getApplicationContext();
    }


    /**
     * Fragment数据的懒加载
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            mIsVisible = true;
            onVisible();
        } else {
            mIsVisible = false;
            onInvisible();
        }
    }

    /**
     * fragment显示时才加载数据
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * fragment懒加载方法
     */
    protected void lazyLoad() {
        if (!mIsPrepared || !mIsVisible) {
            return;
        }
        if (!mIsDataEmpty) {
            initView();
            lazyLoadDate();
            mIsPrepared = false;
        }
    }

    /**
     * 初始化views(完成视图创建后，初始控件)
     */
    public abstract void initView();

    protected void lazyLoadDate() {
    }

    /**
     * fragment隐藏
     */
    protected void onInvisible() {
    }

    /**
     * 显示吐司()
     *
     * @param msg 内容
     */
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}