package com.example.administrator.slopedisplacement.mvp;

import java.lang.ref.WeakReference;

/**
 * 基类 Presenter
 */

public class BasePresenter<V extends IView> implements IPresenter {

    private WeakReference actReference;

    @Override
    public void attachView(IView view) {
        actReference = new WeakReference(view);
    }

    public V getIView() {
        return (V) actReference.get();
    }

    @Override
    public void detachView() {
        if (actReference != null) {
            actReference.clear();
            actReference = null;
        }
    }
}
