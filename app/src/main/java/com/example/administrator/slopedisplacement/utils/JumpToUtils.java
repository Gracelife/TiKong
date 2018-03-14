package com.example.administrator.slopedisplacement.utils;

import android.app.Activity;
import android.content.Intent;

import com.example.administrator.slopedisplacement.activity.DataReportActivity;

/**
 * Activity跳转
 */

public class JumpToUtils {
    /**
     * Activity之间传递的标示
     */
    public static final String SCHEME_ID = "schemeID";

    /**
     * 跳转到数据报表页面
     *
     * @param activity
     */
    public static void toDataReportActivity(Activity activity, int schemeID) {
        Intent intent = new Intent(activity, DataReportActivity.class);
        intent.putExtra(SCHEME_ID, schemeID+"");
//        intent.putExtra(Constants.PROJECT_ID_INDEX,projectId);
//        intent.putExtra(Constants.PROJECT_NAME_INDEX,projectName);
        activity.startActivity(intent);
    }
}
