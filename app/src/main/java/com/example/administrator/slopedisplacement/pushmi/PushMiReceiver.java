package com.example.administrator.slopedisplacement.pushmi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.example.administrator.slopedisplacement.MainActivity;
import com.example.administrator.slopedisplacement.R;
import com.example.administrator.slopedisplacement.activity.PlanLayoutOfPanoramaActivity;
import com.example.administrator.slopedisplacement.utils.JumpToUtils;
import com.example.administrator.slopedisplacement.utils.L;
import com.google.gson.Gson;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小米推送接收服务
 */
public class PushMiReceiver extends PushMessageReceiver {
    /**
     * 用来接收服务器向客户端发送的透传消息（非UI线程中）
     *
     * @param context
     * @param message
     */
    @Override
    public void onReceivePassThroughMessage(Context context, MiPushMessage message) {
        Log.e("mipush", "onReceivePassThroughMessage " + message.toString());
    }

    /**
     * @param context
     * @param message
     */
    @Override
    public void onNotificationMessageClicked(Context context, MiPushMessage message) {
        String data = message.getContent();
        Log.e("mipush", "点击通知后收到的推送信息: " + data);
        try {
            PushMiJson json = new Gson().fromJson(data, PushMiJson.class);
            JumpToUtils.toPlanLayoutOfPanoramaActivity((Activity) context,json.getData().getCamId(),json.getData().getSchemeID());
        }catch (Exception e){
            Log.e("mipush", "收到的推选信息解析异常:");
            e.printStackTrace();
        }
    }

    /**
     * 用来接收服务器向客户端发送的通知消息（非UI线程中）
     *
     * @param context
     * @param message
     */
    @Override
    public void onNotificationMessageArrived(Context context, MiPushMessage message) {
        Log.e("mipush", "onNotificationMessageArrived is called. " + message.toString());
    }

    /**
     * 用来接收客户端向服务器发送命令后的响应结果（非UI线程中）
     *
     * @param context
     * @param message
     */
    @Override
    public void onCommandResult(Context context, MiPushCommandMessage message) {
        Log.v("mipush", "onCommandResult is called. " + message.toString());
        String command = message.getCommand();
        List<String> arguments = message.getCommandArguments();
        String cmdArg1 = ((arguments != null && arguments.size() > 0) ? arguments.get(0) : null);
        String cmdArg2 = ((arguments != null && arguments.size() > 1) ? arguments.get(1) : null);
        String log = "";
        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                log = "小米推送-注册成功";
            } else {
                log = "小米推送-注册失败";
            }
        } else if (MiPushClient.COMMAND_SET_ALIAS.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                log = "小米推送-设置Alias成功";
            } else {
                log = "小米推送-设置Alias失败";
            }
        } else if (MiPushClient.COMMAND_UNSET_ALIAS.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                log = "小米推送-撤销Alias成功";
            } else {
                log = "小米推送-撤销Alias失败";
            }
        } else if (MiPushClient.COMMAND_SET_ACCOUNT.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                log = "小米推送-设置account成功";
            } else {
                log = "小米推送-设置account失败";
            }
        } else if (MiPushClient.COMMAND_UNSET_ACCOUNT.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                log = "小米推送-撤销Account成功";
            } else {
                log = "小米推送-撤销Account失败";
            }
        } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                log = "小米推送-设置订阅标签成功";
            } else {
                log = "小米推送-设置订阅标签失败";
            }
        } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                log = "小米推送-撤销订阅标签成功";
            } else {
                log = "小米推送-撤销订阅标签失败";
            }
        } else if (MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command)) {
            if (message.getResultCode() == ErrorCode.SUCCESS) {
                log = "小米推送-设置时间成功";
            } else {
                log = "小米推送-设置时间失败";
            }
        } else
            log = message.getReason();
        Log.e("", log + "");
    }

    /**
     * 用来接收客户端向服务器发送注册命令后的响应结果（非UI线程中）
     *
     * @param context
     * @param message
     */
    @Override
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage message) {
        Log.e("mipush", "onReceiveRegisterResult：" + message.toString());
    }
}
