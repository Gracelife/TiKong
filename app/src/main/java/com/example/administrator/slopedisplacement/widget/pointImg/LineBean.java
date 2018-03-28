package com.example.administrator.slopedisplacement.widget.pointImg;

/**
 * 线(点的下标)
 */

public class LineBean {
    private int startIndex;
    private int endIndex;

    public LineBean(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

}
