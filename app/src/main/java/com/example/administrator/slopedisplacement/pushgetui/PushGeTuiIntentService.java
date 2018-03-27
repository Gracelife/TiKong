package com.example.administrator.slopedisplacement.pushgetui;

import android.content.Context;
import android.util.Log;

import com.example.administrator.slopedisplacement.bean.IVMS_8700_Bean;
import com.example.administrator.slopedisplacement.db.UserInfoPref;
import com.example.administrator.slopedisplacement.utils.JumpToUtils;
import com.google.gson.Gson;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;

/**
 * 继承 GTIntentService 接收来自个推的消息, 所有消息在线程中回调, 如果注册了该服务, 则务必要在 AndroidManifest中声明, 否则无法接受消息<br>
 * onReceiveMessageData 处理透传消息<br>
 * onReceiveClientId 接收 cid <br>
 * onReceiveOnlineState cid 离线上线通知 <br>
 * onReceiveCommandResult 各种事件处理回执 <br>
 */
public class PushGeTuiIntentService extends GTIntentService {
    public PushGeTuiIntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
    }

    /**
     * 处理透传消息（在onNotificationMessageClicked()后才会触发）
     *
     * @param context
     * @param msg
     */
    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        String messageid = msg.getMessageId();
        byte[] payload = msg.getPayload();
        if (payload == null) {
            Log.e("getui", "aaa  receiver payload = null");
        } else {
            String data = new String(payload);
            Log.e("getui", "aaa  个推接收到的信息 = " + data);
            try {
                PushGeTuiMsgJson json = new Gson().fromJson(data, PushGeTuiMsgJson.class);
                IVMS_8700_Bean ivms_8700_bean = new IVMS_8700_Bean(json.getData().getMUserName(),json.getData().getMPassword()
                        ,json.getData().getMsysCode(),json.getData().getMIp(),json.getData().getMPort(),json.getData().getMType()
                        ,json.getData().getCam_Dx_Puid(),json.getData().getCamId(),json.getData().getCamName(),json.getData().getCamFlowState());
                JumpToUtils.toPlanLayoutOfPanoramaActivity(context,json.getData().getCamId(),json.getData().getSchemeID(),ivms_8700_bean);
            }catch (Exception e){
                Log.e("getui", "收到的推选信息解析异常:");
                e.printStackTrace();
            }

        }
    }

    /**
     * 接收clientid
     * @param context
     * @param clientid
     */
    @Override
    public void onReceiveClientId(Context context, String clientid) {
        UserInfoPref.setGeTuiClientId(clientid);
     //   Log.e("getui", "aaa  onReceiveClientId -> " + "clientid = " + clientid);
    }

    /**
     * cid 离线上线通知
     * @param context
     * @param online
     */
    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
    //    Log.e("getui", "aaa  onReceiveOnlineState -> " + "online = " + online);
    }

    /**
     * 各种事件处理回执
     * @param context
     * @param cmdMessage
     */
    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
      //  Log.e("getui", "aaa  onReceiveCommandResult -> " + "cmdMessage = " + cmdMessage.getAction());
    }

    /**
     * 接收推送通知
     *
     * @param context
     * @param msg
     */
    @Override
    public void onNotificationMessageArrived(Context context, GTNotificationMessage msg) {
      //  Log.e("getui", "aaa  onNotificationMessageArrived = " + msg.getTitle()+""+msg.getContent());
    }

    /**
     * 用户点击通知栏里的消息时触发
     * @param context
     * @param msg
     */
    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage msg) {
      //  Log.e("getui", "aaa  onNotificationMessageClicked = " + msg.getTitle()+""+msg.getContent()+" "+msg.toString());
    }
}
