package com.example.administrator.slopedisplacement.utils;

import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ColorTemplate;

/**
 * LineChart(图表)工具类
 */

public class LineChartUtils {

    public static void setLineInit(LineChart chart) {
        // 图标右下角没有描述文本相关信息
        chart.getDescription().setEnabled(false);
        // 手势能否触摸图表
        chart.setTouchEnabled(true);
        //减速摩擦系数[0,1]之间，0立刻停止，1，自动转换为0.999f
        chart.setDragDecelerationFrictionCoef(0.9f);

        // 将其设置为true以启用图表的拖动（用手指移动图表）（这不会影响缩放）。
        chart.setDragEnabled(true);
        //将其设置为true以在X轴和Y轴上为图表启用缩放（通过手势放大和缩小）（这不影响拖动）
        chart.setScaleEnabled(true);
        //将此设置为true以绘制网格背景，否则为false
        chart.setDrawGridBackground(true);
        //将其设置为true以允许在完全缩小时拖动图表曲面时突出显示。 默认值：true
        chart.setHighlightPerDragEnabled(true);

        // 如果设置为true，则可以用2个手指同时缩放x和y轴，如果为false，则可以分别缩放x和y轴。 默认值：false
        chart.setPinchZoom(true);

        // 设置替代背景颜色
        chart.setBackgroundColor(Color.LTGRAY);
    }

    public static void setLegend(Legend l) {
        // 设置图例形式的形状 (线)
        l.setForm(Legend.LegendForm.LINE);
        //字体大小
        l.setTextSize(11f);
        //字体颜色
        l.setTextColor(Color.WHITE);
        //设置图例的垂直对齐
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        //设置图例的水平对齐
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        //设置图例的方向
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //设置图例是否绘制在图表内部或外部
        l.setDrawInside(false);
//        l.setYOffset(11f);
    }

    public static void setXAxis(XAxis xAxis) {
//        xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(11f);
        xAxis.setTextColor(Color.WHITE);
        //将其设置为true以启用绘制该轴的网格线。
        xAxis.setDrawGridLines(false);
        //x轴在下方
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(false);
    }

    public static void setLeftYAxis(YAxis leftAxis, float maxNum, float minNum) {
//        leftAxis.setTypeface(mTfLight);
        leftAxis.setTextColor(ColorTemplate.getHoloBlue());
        //通过调用此方法，先前设置的任何自定义最大值将被重置，并且计算会自动完成。
        leftAxis.setAxisMaximum(maxNum);
        //通过调用此方法，先前设置的任何自定义最小值将被重置，并自动完成计算。
        leftAxis.setAxisMinimum(minNum);
        leftAxis.setDrawGridLines(true);
        //在轴值间隔上启用/禁用粒度控制。
        leftAxis.setGranularityEnabled(true);
    }
}
