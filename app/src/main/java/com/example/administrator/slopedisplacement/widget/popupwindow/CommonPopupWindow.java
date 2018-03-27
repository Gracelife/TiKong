package com.example.administrator.slopedisplacement.widget.popupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/**
 *
 */

public class CommonPopupWindow {
    private PopupWindow mPopupWindow;
    private View contentview;
    private static Context mContext;

    public CommonPopupWindow(Builder builder) {
        contentview = LayoutInflater.from(mContext).inflate(builder.mConvertViewId, null);
        mPopupWindow = new PopupWindow(contentview, builder.width, builder.height, builder.fouse);
        //需要跟 setBackGroundDrawable 结合
        mPopupWindow.setOutsideTouchable(builder.outsidecancel);
//        setBackgroundAlpha(0.5f);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        builder.popBindView(new BindViewHelper(contentview, mContext));
        if (builder.animstyle != -1)
            mPopupWindow.setAnimationStyle(builder.animstyle);
    }

    /**
     * popup 消失
     */
    public void dismiss() {
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        }
    }

    /**
     * 根据id获取view
     *
     * @param viewid
     * @return
     */
    public View getItemView(int viewid) {
        if (mPopupWindow != null) {
            return this.contentview.findViewById(viewid);
        }
        return null;
    }

    /**
     * 根据父布局，显示位置
     *
     * @param rootviewid
     * @param gravity
     * @param x
     * @param y
     * @return
     */
    public CommonPopupWindow showAtLocation(int rootviewid, int gravity, int x, int y) {
        if (mPopupWindow != null) {
            View rootview = LayoutInflater.from(mContext).inflate(rootviewid, null);
            mPopupWindow.showAtLocation(rootview, gravity, x, y);
        }
        return this;
    }

    /**
     * 根据id获取view ，并显示在该view的位置
     *
     * @param targetviewId
     * @param gravity
     * @param offx
     * @param offy
     * @return
     */
    public CommonPopupWindow showAsLaction(int targetviewId, int gravity, int offx, int offy) {
        if (mPopupWindow != null) {
            View targetview = LayoutInflater.from(mContext).inflate(targetviewId, null);
            mPopupWindow.showAsDropDown(targetview, gravity, offx, offy);
        }
        return this;
    }

    /**
     * 显示在 targetview 的不同位置
     *
     * @param targetview
     * @param gravity
     * @param offx
     * @param offy
     * @return
     */
    public CommonPopupWindow showAsLaction(View targetview, int gravity, int offx, int offy) {
        if (mPopupWindow != null) {
            mPopupWindow.showAsDropDown(targetview, gravity, offx, offy);
        }
        return this;
    }

    /**
     * 根据id设置焦点监听
     *
     * @param viewid
     * @param listener
     */
    public void setOnFocusListener(int viewid, View.OnFocusChangeListener listener) {
        View view = getItemView(viewid);
        view.setOnFocusChangeListener(listener);
    }

    /**
     * builder 类
     */
    public abstract static class Builder implements IPopupWindowBindView {
        private int mConvertViewId;
        private int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        private int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        private boolean fouse = true;//获取焦点
        private boolean outsidecancel = true;//获取外部触摸事件
        private int animstyle = -1;//动画的资源id 默认-1为没有

        public Builder(Context context) {
            mContext = context;
        }

        public Builder setContentView(@LayoutRes int convertViewId) {
            this.mConvertViewId = convertViewId;
            return this;
        }


        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setFocusable(boolean fouse) {
            this.fouse = fouse;
            return this;

        }

        public Builder setOutsideTouchable(boolean outsidecancel) {
            this.outsidecancel = outsidecancel;
            return this;
        }

        public Builder setAnimationStyle(@IdRes int animstyle) {
            this.animstyle = animstyle;
            return this;
        }
        public CommonPopupWindow builder() {
            return new CommonPopupWindow(this);
        }
    }
}