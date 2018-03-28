package com.example.administrator.slopedisplacement.utils;

import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeAreaListJson;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeFixedListJson;
import com.example.administrator.slopedisplacement.widget.pointImg.LineBean;
import com.example.administrator.slopedisplacement.widget.pointImg.PointBean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class PointImgHelper {
    /**
     * 区域 状态为面 点偏移百分比
     */
    private final static int pointOffsetScale = 4;

    /**
     * 添加巡航(区域)相关点、线、面
     *
     * @param areaList
     * @param pointBeanList
     * @param lineBeanList
     * @param dottedLineList
     */
    public static void areaPoint(List<GetDatSchemeAreaListJson.ListBean> areaList, ArrayList<PointBean> pointBeanList, List<LineBean> lineBeanList, List<LineBean> dottedLineList) {
        if (areaList == null || areaList.size() == 0)
            return;
        //区域列表里的点线
        for (GetDatSchemeAreaListJson.ListBean area : areaList) {
            if (area == null)
                continue;
            switch (area.getAreaType()) {
                case "1": {//区域
                    double startX = Double.parseDouble(area.getOx1());
                    double startY = Double.parseDouble(area.getOy1());
                    double endX = Double.parseDouble(area.getOx2());
                    double endY = Double.parseDouble(area.getOy2());
                    if (area.getNewMonitor() == null || area.getNewMonitor().size() == 0) {//为空只花两个点
                        String areaName = area.getAreaNmae();
                        PointBean pointStart = new PointBean();
                        pointStart.setXScale(startX);
                        pointStart.setYScale(startY);
                        PointBean pointEnd = new PointBean();
                        pointEnd.setXScale(endX);
                        pointEnd.setYScale(endY);

                        if (startX < endX || (startX == endX && startY > endY)) {
                            pointStart.setPointName(areaName);
                        } else {
                            pointEnd.setPointName(areaName);
                        }
                        //添加newMonitorId用于启动和关闭点的动画
                        List<GetDatSchemeAreaListJson.ListBean.NewMonitorBean> newMonitorBeanList = area.getNewMonitor();
                        if (newMonitorBeanList != null && newMonitorBeanList.size() >= 2) {
                            pointStart.setmMonitorID(area.getNewMonitor().get(0).getMonitorID());
                            pointEnd.setmMonitorID(area.getNewMonitor().get(1).getMonitorID());
                        }

                        pointStart.setPointIndex(pointBeanList.size());
                        pointBeanList.add(pointStart);

                        pointEnd.setPointIndex(pointBeanList.size());
                        pointBeanList.add(pointEnd);
                        lineBeanList.add(new LineBean(pointStart.getPointIndex(), pointEnd.getPointIndex()));
                        return;
                    }
                    int num = area.getNewMonitor().size();
                    boolean isPointVertical = isPointVertical(startX, startY, endX, endY);
                    int pointBeanListIndex = pointBeanList.size();
                    for (int i = 0; i < num / 2; i++) {
                        PointBean pointBean1 = new PointBean();
                        double scaleX = pointDistance(startX, endX, i, num / 2 - 1);
                        double scaleY = pointDistance(startY, endY, i, num / 2 - 1);
                        pointBean1.setXScale(scaleX);
                        pointBean1.setYScale(scaleY);
                        pointBean1.setmMonitorID(area.getNewMonitor().get(i * 2).getMonitorID());
                        if (i == 0) {
                            pointBean1.setPointName(area.getAreaNmae());
                        }
                        pointBean1.setPointIndex(pointBeanListIndex + i * 2);

                        PointBean pointBean2 = new PointBean();
                        if (isPointVertical) {
                            pointBean2.setXScale(scaleX + pointOffsetScale);
                            pointBean2.setYScale(scaleY);
                        } else {
                            pointBean2.setXScale(scaleX);
                            pointBean2.setYScale(scaleY + pointOffsetScale);
                        }
                        pointBean2.setmMonitorID(area.getNewMonitor().get(i * 2 + 1).getMonitorID());
                        pointBean2.setPointIndex(pointBeanListIndex + i * 2 + 1);
                        pointBeanList.add(pointBean1);
                        pointBeanList.add(pointBean2);
                    }
                    if (num > 2) {
                        dottedLineList.add(new LineBean(pointBeanList.get(pointBeanListIndex).getPointIndex(), pointBeanList.get(pointBeanListIndex + 1).getPointIndex()));
                        dottedLineList.add(new LineBean(pointBeanList.get(pointBeanListIndex + num - 2).getPointIndex(), pointBeanList.get(pointBeanListIndex + num - 1).getPointIndex()));
                    }
                    lineBeanList.add(new LineBean(pointBeanList.get(pointBeanListIndex).getPointIndex(), pointBeanList.get(pointBeanListIndex + num - 2).getPointIndex()));
                    break;
                }
                case "2": {//线
                    String areaName = area.getAreaNmae();
                    double startX = Double.parseDouble(area.getOx1());
                    double startY = Double.parseDouble(area.getOy1());
                    double endX = Double.parseDouble(area.getOx2());
                    double endY = Double.parseDouble(area.getOy2());

                    PointBean pointStart = new PointBean();
                    pointStart.setXScale(startX);
                    pointStart.setYScale(startY);
                    PointBean pointEnd = new PointBean();
                    pointEnd.setXScale(endX);
                    pointEnd.setYScale(endY);

                    if (startX < endX || (startX == endX && startY > endY)) {
                        pointStart.setPointName(areaName);
                    } else {
                        pointEnd.setPointName(areaName);
                    }
                    //添加newMonitorId用于启动和关闭点的动画
                    List<GetDatSchemeAreaListJson.ListBean.NewMonitorBean> newMonitorBeanList = area.getNewMonitor();
                    if (newMonitorBeanList != null && newMonitorBeanList.size() >= 2) {
                        pointStart.setmMonitorID(area.getNewMonitor().get(0).getMonitorID());
                        pointEnd.setmMonitorID(area.getNewMonitor().get(1).getMonitorID());
                    }

                    pointStart.setPointIndex(pointBeanList.size());
                    pointBeanList.add(pointStart);

                    pointEnd.setPointIndex(pointBeanList.size());
                    pointBeanList.add(pointEnd);
                    lineBeanList.add(new LineBean(pointStart.getPointIndex(), pointEnd.getPointIndex()));
                    break;
                }
                case "3": {//点
                    List<GetDatSchemeAreaListJson.ListBean.NewMonitorBean> newMonitorBeanList = area.getNewMonitor();
                    int num = newMonitorBeanList.size();
                    String areaName = area.getAreaNmae();
                    for (int i = 0; i < num; i++) {
                        PointBean pointBean = new PointBean();
                        pointBean.setXScale(Double.parseDouble(newMonitorBeanList.get(i).getOx()));
                        pointBean.setYScale(Double.parseDouble(newMonitorBeanList.get(i).getOy()));
                        pointBean.setPointIndex(pointBeanList.size());
                        pointBean.setPointName(areaName + "_" + (i + 1));
                        pointBean.setmMonitorID(newMonitorBeanList.get(i).getMonitorID());
                        pointBeanList.add(pointBean);
                    }
                    break;
                }
            }
        }
    }

    /**
     * 添加定点相关的点
     *
     * @param fixedList
     * @param pointBeanList
     */
    public static void fixedPoint(List<GetDatSchemeFixedListJson.ListBean> fixedList, ArrayList<PointBean> pointBeanList) {
        if (fixedList == null || fixedList.size() == 0)
            return;
        PointBean pointBean;
        for (GetDatSchemeFixedListJson.ListBean fixed : fixedList) {
            pointBean = new PointBean();
            pointBean.setXScale(Double.parseDouble(fixed.getOx()));
            pointBean.setYScale(Double.parseDouble(fixed.getOy()));
            pointBean.setPointIndex(pointBeanList.size());
            pointBean.setPointName(fixed.getFixedName());
            pointBean.setmMonitorID(fixed.getFixedID());
            pointBeanList.add(pointBean);
        }
    }

    /**
     * 点的方向
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return true 向右 false 向下
     */
    private static boolean isPointVertical(double x1, double y1, double x2, double y2) {
        if (x1 == x2) {
            return true;
        }
        if (y1 == y2) {
            return false;
        }
        return Math.abs((y2 - y1) / (x2 - x1)) > 1;
    }

    /**
     * 计算两个点之间n/m处点的坐标 (在start点和end点之间的n/m处点的坐标)
     *
     * @param start 起始位置
     * @param end   结束位置
     * @param n     分子
     * @param m     分母
     * @return      坐标
     */
    private static double pointDistance(double start, double end, int n, int m) {
        return (end - start) * n / m + start;
    }
}
