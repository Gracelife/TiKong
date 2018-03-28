package com.example.administrator.slopedisplacement.utils;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间选择器工具类
 */

public class TimePickerUtils {
    public static TimePickerView createPickerView(Context context, TimePickerView.OnTimeSelectListener onTimeSelectListener) {
        //时间选择器
        TimePickerView pvTime = new TimePickerView.Builder(context, onTimeSelectListener)
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                .isCyclic(true)//是否循环滚动
                .build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        return pvTime;
    }

    public static void showPickerView(Context context, String title, TextView textView ,boolean month,boolean day,TimePickerView.OnTimeSelectListener onTimeSelectListener) {
        //时间选择器
        //.Builder(context, (Date date, View view) -> textView.setText(FormatUtils.dateToString(date,month,day)))
        TimePickerView timePickerView = new TimePickerView
                .Builder(context, onTimeSelectListener)
                .setTitleText(title)
                .setType(new boolean[]{true, month, day, false, false, false})// 默认全部显示
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setRangDate(FormatUtils.stringToCalendar("1234-10-11"), Calendar.getInstance())//起始终止年月日设定
                .isCyclic(false)//是否循环滚动
                .build();
        timePickerView.setDate(Calendar.getInstance());
        timePickerView.show();
    }
    public static void showPickerView(Context context, String title, TextView textView, String  defaultCalendar, String rangStartTime, String rangEndTime) {
        //时间选择器
        TimePickerView timePickerView = new TimePickerView
                .Builder(context, (Date date, View view) -> textView.setText(FormatUtils.dateToString(date)))
                .setTitleText(title)
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setRangDate(FormatUtils.stringToCalendar(rangStartTime), FormatUtils.stringToCalendar(rangEndTime))//起始终止年月日设定
                .isCyclic(false)//是否循环滚动
                .build();
        timePickerView.setDate(FormatUtils.stringToCalendar(defaultCalendar));
        timePickerView.show();
    }

    /**
     * 退出Activity或者Fragment时调用，防止内存泄露
     *
     * @param timePickerView
     */
    public static void destroy(TimePickerView timePickerView) {
        if (timePickerView != null && timePickerView.isShowing())
            timePickerView.dismiss();
    }
}
