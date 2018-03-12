package com.example.administrator.slopedisplacement.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.slopedisplacement.R;

/**
 * 通用的对话框
 */
public class CommonDialog extends Dialog {
    private TextView mTitleView; //标题
    private TextView mContentView; //内容
    private Button mLeftBtn;
    private Button mRightBtn;
    private RightClick mRightClick;
    private LeftClick mLeftClick;
    private SingleClick mSingleListener;

    public CommonDialog(Context context) {
        this(context, R.style.CommonDialogStyle);
    }

    public CommonDialog(Context context, int theme) {
        super(context, theme);
        initViews(context);
    }

    private void initViews(Context context) {
        setContentView(R.layout.widget_dialog);
        mTitleView = (TextView) findViewById(R.id.dialog_title);
        mContentView = (TextView) findViewById(R.id.dialog_content);
        mLeftBtn = (Button) findViewById(R.id.dialog_confirm);
        mRightBtn = (Button) findViewById(R.id.dialog_cancel);

        //设置对话框位置大小
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        dialogWindow.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setAttributes(lp);//此处暂未设置偏移量
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        mLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mLeftClick != null) {
                    mLeftClick.onClick(v);
                } else if (mSingleListener != null) {
                    mSingleListener.OnClick(v);
                }
            }
        });
        mRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mRightClick != null) {
                    mRightClick.onClick(v);
                }
            }
        });
    }

    public CommonDialog showSingle() {
        mRightBtn.setVisibility(View.GONE);
        this.show();
        return this;
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public CommonDialog setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            mTitleView.setVisibility(View.VISIBLE);
            mTitleView.setText(title);
        }
        return this;
    }

    /**
     * 设置提示语
     */
    public CommonDialog setMsg(String msg) {
        if (!TextUtils.isEmpty(msg))
            mContentView.setText(msg);
        return this;
    }

    /**
     * 设置左侧按钮字符串
     */
    public CommonDialog setLeftBtnText(String text) {
        if (!TextUtils.isEmpty(text))
            mLeftBtn.setText(text);
        return this;
    }


    /**
     * 设置右侧按钮字符串
     *
     * @param text
     */
    public CommonDialog setRightBtnText(String text) {
        if (!TextUtils.isEmpty(text))
            mRightBtn.setText(text);
        return this;
    }

    /**
     * 设置当只有一个按钮时，按钮点击事件
     *
     * @param singleClick
     */
    public CommonDialog setSingleClick(SingleClick singleClick) {
        mSingleListener = singleClick;
        return this;
    }

    /**
     * 设置左侧按钮点击事件
     *
     * @param leftClick
     * @return
     */
    public CommonDialog setLeftClick(LeftClick leftClick) {
        mLeftClick = leftClick;
        return this;
    }

    /**
     * 设置右侧按钮点击事件
     *
     * @param rightClick
     * @return
     */
    public CommonDialog setRightClick(RightClick rightClick) {
        mRightClick = rightClick;
        return this;
    }

    //    public interface OnDialogListener {
//        void OnLeftClick();
//
//        void OnRightClick();
//    }
    public interface RightClick {
        void onClick(View v);
    }

    public interface LeftClick {
        void onClick(View v);
    }

    public interface SingleClick {
        void OnClick(View v);
    }
}
