package com.example.administrator.slopedisplacement.widget;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by administration on 2017/10/10.
 */

public class FocuseTextView extends android.support.v7.widget.AppCompatTextView {

    public FocuseTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean isFocused() {
        // TODO Auto-generated method stub
        return true;
    }
}
