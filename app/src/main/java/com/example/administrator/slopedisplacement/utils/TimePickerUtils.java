package com.example.administrator.slopedisplacement.utils;

import android.content.Context;
import android.view.View;

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

    public static TimePickerView createPickerView(Context context, TimePickerView.OnTimeSelectListener onTimeSelectListener, Calendar calendar) {
        //时间选择器
        TimePickerView pvTime = new TimePickerView.Builder(context, onTimeSelectListener)
                .setType(new boolean[]{true, true, true, false, false, false})// 默认全部显示
                .isCyclic(true)//是否循环滚动
                .build();
        pvTime.setDate(calendar);//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        return pvTime;
    }

    /**
     * 将Date类型格式化成String yyyy-MM-dd
     * @param date  时间
     * @return
     */
    public static String dateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    /**
     * 将Date类型格式化成Calendar
     * @param date  时间
     * @return
     */
    public static Calendar dataToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
