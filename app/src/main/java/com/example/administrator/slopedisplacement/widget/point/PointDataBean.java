package com.example.administrator.slopedisplacement.widget.point;

import java.util.List;

/**
 *  绘制点的相关信息类
 */

public class PointDataBean {
    private List<PointBean> pointBeanList;
    private List<LineBean> lineList;

    public List<PointBean> getPointBeanList() {
        return pointBeanList;
    }

    public void setPointBeanList(List<PointBean> pointBeanList) {
        this.pointBeanList = pointBeanList;
    }

    public List<LineBean> getLineList() {
        return lineList;
    }

    public void setLineList(List<LineBean> lineList) {
        this.lineList = lineList;
    }
}
