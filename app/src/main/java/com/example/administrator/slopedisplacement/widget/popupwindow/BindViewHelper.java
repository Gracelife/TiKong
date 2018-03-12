package com.example.administrator.slopedisplacement.widget.popupwindow;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *
 */

public class BindViewHelper {
    private View mConvertView;
    private Context mContext;

    BindViewHelper(View convertView, Context context) {
        this.mContext = context;
        mConvertView = convertView;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public BindViewHelper setBackground(@IdRes int viewId, @NonNull Drawable drawable) {
        retrieveView(viewId).setBackground(drawable);
        return this;
    }

    public BindViewHelper setBackgroundColor(@IdRes int viewId, @ColorInt int color) {
        retrieveView(viewId).setBackgroundColor(color);
        return this;
    }

    public BindViewHelper setBackgroundRes(@IdRes int viewId, @DrawableRes int backgroundRes) {
        retrieveView(viewId).setBackgroundResource(backgroundRes);
        return this;
    }

    public BindViewHelper setText(@IdRes int viewId, CharSequence value) {
        ((TextView) retrieveView(viewId)).setText(value);
        return this;
    }

    public BindViewHelper setTextRes(@IdRes int viewId, @StringRes int resId) {
        ((TextView) retrieveView(viewId)).setText(resId);
        return this;
    }

    public BindViewHelper setTextColor(@IdRes int viewId, @ColorInt int textColor) {
        ((TextView) retrieveView(viewId)).setTextColor(textColor);
        return this;
    }

    public BindViewHelper setTextColorRes(@IdRes int viewId, @ColorRes int textColorRes) {
        //noinspection deprecation
        ((TextView) retrieveView(viewId)).setTextColor(mContext.getResources().getColor(textColorRes));
        return this;
    }

    public BindViewHelper setImageResource(@IdRes int viewId, @DrawableRes int imageResId) {
        ((ImageView) retrieveView(viewId)).setImageResource(imageResId);
        return this;
    }

    public BindViewHelper setVisible(@IdRes int viewId, int visibility) {
        retrieveView(viewId).setVisibility(visibility);
        return this;
    }

    public BindViewHelper setEnabled(@IdRes int viewId, boolean enabled) {
        retrieveView(viewId).setEnabled(enabled);
        return this;
    }

    public BindViewHelper setChecked(@IdRes int viewId, boolean checked) {
        View view = retrieveView(viewId);
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setChecked(checked);
        } else if (view instanceof CheckedTextView) {
            ((CheckedTextView) view).setChecked(checked);
        }
        return this;
    }

    public <T extends View> T getView(@IdRes int viewId) {
        return retrieveView(viewId);
    }

    @SuppressWarnings("unchecked")
    private <T extends View> T retrieveView(@IdRes int viewId) {
        View view = mConvertView.findViewById(viewId);
        return (T) view;
    }
}