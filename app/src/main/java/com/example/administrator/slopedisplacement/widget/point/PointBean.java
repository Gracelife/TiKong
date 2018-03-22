package com.example.administrator.slopedisplacement.widget.point;

/**
 * 点
 */

public class PointBean {
    /**
     * 点的id
     */
    private String mPointId;
    /**
     * 点上方显示的字
     */
    private String mPointName;
    /**
     * 标记点相对于X轴方向上的比例
     */
    private double mXScale;
    /**
     * 标记点相对于Y轴方向上的比例
     */
    private double mYScale;
    /**
     * 点在容器里面跟左侧的间距
     */
    private int mMarginLeft;
    /**
     * 点在容器里面跟上方的间距
     */
    private int mMarginTop;
    /**
     * 点在图里 跟左侧的间距
     */
    private int mShowMarginLeft;
    /**
     * 点在图里 跟上方的间距
     */
    private int mShowMarginTop;
    /**
     * 是否播放动画
     */
    private boolean isPlayAnimation;

    public String getPointId() {
        return mPointId;
    }

    public void setPointId(String mPointId) {
        this.mPointId = mPointId;
    }

    public double getXScale() {
        return mXScale;
    }

    public void setXScale(double mXScale) {
        this.mXScale = mXScale;
    }

    public double getYScale() {
        return mYScale;
    }

    public void setYScale(double mYScale) {
        this.mYScale = mYScale;
    }

    public boolean isPlayAnimation() {
        return isPlayAnimation;
    }

    public void setPlayAnimation(boolean PlayAnimation) {
        isPlayAnimation = PlayAnimation;
    }

    public int getMarginLeft() {
        return mMarginLeft;
    }

    public void setMarginLeft(int mMarginLeft) {
        this.mMarginLeft = mMarginLeft;
    }

    public int getMarginTop() {
        return mMarginTop;
    }

    public void setMarginTop(int mMarginTop) {
        this.mMarginTop = mMarginTop;
    }

    public String getPointName() {
        return mPointName;
    }

    public void setPointName(String pointName) {
        this.mPointName = pointName;
    }

    public int getShowMarginLeft() {
        return mShowMarginLeft;
    }

    public void setShowMarginLeft(int showMarginLeft) {
        this.mShowMarginLeft = showMarginLeft;
    }

    public int getShowMarginTop() {
        return mShowMarginTop;
    }

    public void setShowMarginTop(int showMarginTop) {
        this.mShowMarginTop = showMarginTop;
    }
}
