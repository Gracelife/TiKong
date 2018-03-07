package com.example.administrator.slopedisplacement.server;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.example.administrator.slopedisplacement.application.ProApplication;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.GTServiceManager;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.orhanobut.logger.Logger;

public class GeTuiIntentService extends GTIntentService {
    public GeTuiIntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Logger.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
        sendMessage(clientid, 1);
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
    }

    @Override
    public void onNotificationMessageArrived(Context context, GTNotificationMessage msg) {
    }

    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage msg) {
    }
    private void sendMessage(String data, int what) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.obj = data;
        ProApplication.sendMessage(msg);
    }
}
