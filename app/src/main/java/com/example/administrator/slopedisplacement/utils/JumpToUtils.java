package com.example.administrator.slopedisplacement.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.administrator.slopedisplacement.activity.DataReportActivity;
import com.example.administrator.slopedisplacement.activity.PlanLayoutOfPanoramaActivity;
import com.example.administrator.slopedisplacement.activity.SelectDriverActivity;
import com.example.administrator.slopedisplacement.activity.SelectProjectActivity;
import com.example.administrator.slopedisplacement.activity.SelectSchemeActivity;
import com.example.administrator.slopedisplacement.activity.ShowMonitoringImgActivity;
import com.example.administrator.slopedisplacement.bean.SchemeBean;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeAreaListJson;
import com.example.administrator.slopedisplacement.bean.json.GetDatSchemeFixedListJson;

/**
 * Activity跳转
 */

public class JumpToUtils {
    public static final String KEY_AREAL_LIST = "key_areal_list";
    public static final String KEY_FIXED_LIST = "key_fixed_list";
    public static final String KEY_SCHEME_ID = "key_scheme_id";

    /**
     * 跳转到数据报表页面
     *
     * @param activity
     */
    public static void toDataReportActivity(Activity activity, GetDatSchemeAreaListJson arealListJson, GetDatSchemeFixedListJson fixedListJson, String schemeID) {
        Intent intent = new Intent(activity, DataReportActivity.class);
        intent.putExtra(KEY_AREAL_LIST, arealListJson);
        intent.putExtra(KEY_FIXED_LIST, fixedListJson);
        intent.putExtra(KEY_SCHEME_ID, schemeID);
        activity.startActivity(intent);
    }

    public static final String KEY_WIDE_ANGLE_IMG = "key_wide_angle_img";
    public static final String KEY_LONG_FOCAL_IMG = "key_long_focal_img";
    public static final String KEY_TITLE = "key_title";

    /**
     * 跳转到显示检测图(长焦图和广角图)页面
     *
     * @param activity
     * @param wideAngleImg 广角图
     * @param longFocalImg 长焦图
     * @param recordID     序号
     * @param monitorID    监测点
     * @param nowShift     本次位移
     */
    public static void toShowMonitoringImgActivity(Activity activity, String wideAngleImg, String longFocalImg, int recordID, int monitorID, double nowShift) {
        Intent intent = new Intent(activity, ShowMonitoringImgActivity.class);
        intent.putExtra(KEY_TITLE, "监测图查看(序号:" + recordID + ",监测点:" + monitorID + ")本次位移:" + FormatUtils.format2(nowShift));
        intent.putExtra(KEY_WIDE_ANGLE_IMG, wideAngleImg);
        intent.putExtra(KEY_LONG_FOCAL_IMG, longFocalImg);
        activity.startActivity(intent);
    }


    public static final String KEY_CAMID = "key_camId";
    public static final String KEY_SCHEMEID = "key_schemeID";

    /**
     * 跳转到主页面页面
     *
     * @param activity
     * @param camId    设备id
     * @param schemeID 方案id
     */
    public static void toPlanLayoutOfPanoramaActivity(Activity activity, String camId, String schemeID) {
        Intent intent = new Intent(activity, PlanLayoutOfPanoramaActivity.class);
        intent.putExtra(KEY_CAMID, camId);
        intent.putExtra(KEY_SCHEMEID, schemeID);
        intent.putExtra(KEY_FROM_PUSH, false);//是否来至推送
        activity.startActivity(intent);
    }

    public static final String KEY_FROM_PUSH = "key_from_push";

    /**
     * 推送跳转到主页面页面
     *
     * @param context
     * @param camId    设备id
     * @param schemeID 方案id
     */
    public static void toPlanLayoutOfPanoramaActivity(Context context, String camId, String schemeID) {
        ActivityUtils.INSTANCE.finishOthersActivity(SelectProjectActivity.class);
        Intent intent = new Intent(context, PlanLayoutOfPanoramaActivity.class);
        intent.putExtra(KEY_CAMID, camId);
        intent.putExtra(KEY_SCHEMEID, schemeID);
        intent.putExtra(KEY_FROM_PUSH, true);//是否来至推送
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static final String KEY_SCHEMEBEAN = "key_schemeBean";

    /**
     * 跳转到选择方案页面
     *
     * @param activity
     * @param camId      设备id
     * @param schemeBean 方案列表数据
     */
    public static void toSelectSchemeActivity(Activity activity, String camId, SchemeBean schemeBean) {
        Intent intent = new Intent(activity, SelectSchemeActivity.class);
        intent.putExtra(KEY_CAMID, camId);
        intent.putExtra(KEY_SCHEMEBEAN, schemeBean);
        activity.startActivity(intent);
    }

}
