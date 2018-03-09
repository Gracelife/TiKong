package com.example.administrator.slopedisplacement.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/3/8.
 */

public class DriverBean {

    /**
     * List : [{"totalTime":772340,"monthTime":0,"dayTime":0,"DevTypeName":"智能测距摄像机","DevTypePic":"/lib/images/dev/zhinengceju.png","CamGUId":"6f09b584-867c-43a3-996e-e50a75758b30","CamTypeGUId":"b09619ff-8b86-d011-b42d-b2c07fa96407","CamContractGUId":"50e53f6c-18b7-4539-91a6-363c2c2b5d92","CamId":1016010,"CamTypeId":103,"CamSeqId":"518011479","CamConId":100114,"CamProjId":10806,"CamDeviceId":"mjdx-001","CamIsPrivate":true,"CamName":"山体模型监测","CamDateInstall":"2014-09-09 00:00:00","CamStockOutDate":null,"CamDateStartUse":"2015-09-24 19:39:51","CamDateEndUse":null,"CamDateCompleted":null,"CamDateDelay":"2015-12-03 00:00:00","CamDateUninstal":null,"CamMapX":-1,"CamMapY":-1,"CamInstalPlace":"汇川物联网8楼展厅","CamMonitorUrl":null,"CamRemark":"Camera101","Cam_DX_VideoId":"","Cam_DX_VideoName":null,"Cam_DX_Memo":null,"CamIsDeafault":true,"Cam_WideAngle_IP":"0000000000200000000000007404950:0000000000200000000000006929153:110.84.128.211:086591","Cam_Ranging_IP":"0000000000200000000000007404949:0000000000200000000000006929153:110.84.128.211:086591","Cam_WA_UserName":null,"Cam_WA_Password":null,"Cam_WA_Port":null,"Cam_Rg_UserName":null,"Cam_Rg_Password":null,"Cam_Rg_Port":null,"Cam_Ranging_Model":null,"CamFlowState":15,"CamIsDeleted":false,"CamIsEnable":true,"Cam_LoginName":"admin","Cam_LoginPsw":"12345","Cam_LoginIp":"10.1.5.182","Cam_LoginPort":"80","Cam_SessionId":null,"SysID":28,"CamPSID":8418,"SrvID":10101,"SdiID":null,"Cam_Config":"<xml><cam><type>12<\/type><naming /><ip>10.1.5.182<\/ip><port>80<\/port><account>admin<\/account><password>12345<\/password><lacId>1035<\/lacId><camSeqId>518011479<\/camSeqId><camId>1016010<\/camId><name>山体模型监测<\/name><showid>1<\/showid><isusinghczc>1<\/isusinghczc><ishxplay>0<\/ishxplay><channelId>1<\/channelId><obdistance /><horizontalAngle /><verticalAngle /><xo /><yo /><zo /><alpha /><lng /><lat /><ccdL /><ccdW /><hidCross1 /><hidTriangle1 /><hidCross2 /><hidTriangle2 /><hidCross3 /><hidTriangle3 /><htIp /><htPort /><htAccount /><htPassword /><url /><positionX>610<\/positionX><positionY>380<\/positionY><devLng /><devLat /><devElevation /><pipNaming /><pipAccount /><pipPassword /><pipIp /><pipPort /><Pm10WarningVal /><Pm25WarningVal /><TemWarningVal /><HumidityWarningVal /><NoiseWarningVal /><MinWorkVal /><MaxWorkVal /><RestWorkVal /><hxPlayAccount /><hxPlayPassword /><hxPlayIp /><hxPlayPort /><hxPlayNaming /><serverIp>192.168.1.85<\/serverIp><serverPort>28888<\/serverPort><devId>518011479<\/devId><camItemId /><sysId>11<\/sysId><\/cam><\/xml>","Cam_JobCode":null,"Cam_JobId":null,"CamLacID":1035,"Cam_Rights":null,"CamDateStartCost":"2015-05-03 00:00:00","CamDateEndCost":null,"CamDxDateCompleted":null,"CamDxDateUninstal":null,"Cam_DxBusiID":null,"Cam_CjBusiID":null,"Cam_IsTest":true,"CamIsKcyDev":true,"Cam_DX_PUID":"86591","CamBusineOrdersDate":null,"CamSetupOrdersDate":null,"CamDevPhoto":null,"CamRenewType":null,"CamStandarWaterLevel":null,"CamFloodWaterLevel":null,"CamItemId":null,"CamHlhtDcPk":null,"SPID":null,"BackupSPID":null},{"totalTime":756820,"monthTime":0,"dayTime":0,"DevTypeName":"智能测距摄像机","DevTypePic":"/lib/images/dev/zhinengceju.png","CamGUId":"4b06b5ba-7c21-4b3a-abed-17c282b470d6","CamTypeGUId":"b09619ff-8b86-d011-b42d-b2c07fa96405","CamContractGUId":"773c75a3-31b9-4792-acb7-b0d37ccbf868","CamId":1016036,"CamTypeId":103,"CamSeqId":"593774000","CamConId":100385,"CamProjId":10806,"CamDeviceId":"mjdx-002","CamIsPrivate":true,"CamName":"热成像测距","CamDateInstall":"2014-12-23 00:00:00","CamStockOutDate":null,"CamDateStartUse":"2015-09-24 19:41:20","CamDateEndUse":null,"CamDateCompleted":null,"CamDateDelay":"2015-09-10 00:00:00","CamDateUninstal":null,"CamMapX":null,"CamMapY":null,"CamInstalPlace":"汇川物联网8楼展厅","CamMonitorUrl":null,"CamRemark":"Camera101","Cam_DX_VideoId":"0000000000200000000000007426683:0000000000200000000000006941852:110.84.128.211:086591","Cam_DX_VideoName":null,"Cam_DX_Memo":null,"CamIsDeafault":true,"Cam_WideAngle_IP":"","Cam_Ranging_IP":"","Cam_WA_UserName":null,"Cam_WA_Password":null,"Cam_WA_Port":null,"Cam_Rg_UserName":null,"Cam_Rg_Password":null,"Cam_Rg_Port":null,"Cam_Ranging_Model":null,"CamFlowState":15,"CamIsDeleted":false,"CamIsEnable":true,"Cam_LoginName":"hxht_admin","Cam_LoginPsw":"123456","Cam_LoginIp":"222.77.183.67","Cam_LoginPort":"80","Cam_SessionId":null,"SysID":11,"CamPSID":8418,"SrvID":10101,"SdiID":null,"Cam_Config":"<xml><cam><type>8<\/type><naming>0000000000200000000000007426683:0000000000200000000000006941852:110.84.128.211:086591<\/naming><name>热成像测距<\/name><url>hx<\/url><ip>222.77.183.67<\/ip><port>80<\/port><account>hxht_admin<\/account><password>123456<\/password><cameraType>C<\/cameraType><camSeqId>593774000<\/camSeqId><rtspLocalPort>554<\/rtspLocalPort><rtspWlanPort>554<\/rtspWlanPort><lacId /><camId>1016036<\/camId><showid>2<\/showid><isusinghczc>1<\/isusinghczc><ishxplay>0<\/ishxplay><channelId>1<\/channelId><obdistance /><horizontalAngle /><verticalAngle /><xo /><yo /><zo /><alpha /><lng /><lat /><ccdL /><ccdW /><hidCross1 /><hidTriangle1 /><hidCross2 /><hidTriangle2 /><hidCross3 /><hidTriangle3 /><htIp /><htPort /><htAccount /><htPassword /><serverIp>120.35.11.49<\/serverIp><serverPort>28888<\/serverPort><positionX>610<\/positionX><positionY>380<\/positionY><devLng /><devLat /><devElevation /><pipNaming>0000000000200000000000007426684:0000000000200000000000006941852:110.84.128.211:086591<\/pipNaming><pipAccount>hxht_admin<\/pipAccount><pipPassword>123456<\/pipPassword><pipIp>222.77.183.67<\/pipIp><pipPort>80<\/pipPort><Pm10WarningVal /><Pm25WarningVal /><TemWarningVal /><HumidityWarningVal /><NoiseWarningVal /><MinWorkVal /><MaxWorkVal /><RestWorkVal /><hxPlayAccount /><hxPlayPassword /><hxPlayIp /><hxPlayPort /><hxPlayNaming /><\/cam><\/xml>","Cam_JobCode":null,"Cam_JobId":null,"CamLacID":0,"Cam_Rights":null,"CamDateStartCost":"2015-02-10 00:00:00","CamDateEndCost":null,"CamDxDateCompleted":null,"CamDxDateUninstal":null,"Cam_DxBusiID":null,"Cam_CjBusiID":null,"Cam_IsTest":true,"CamIsKcyDev":false,"Cam_DX_PUID":"086591-211950983","CamBusineOrdersDate":null,"CamSetupOrdersDate":null,"CamDevPhoto":null,"CamRenewType":null,"CamStandarWaterLevel":null,"CamFloodWaterLevel":null,"CamItemId":null,"CamHlhtDcPk":null,"SPID":null,"BackupSPID":null},{"totalTime":732220,"monthTime":0,"dayTime":0,"DevTypeName":"巡航摄像机","DevTypePic":"/lib/images/dev/xunhang.png","CamGUId":"d59965aa-904d-42ff-97fa-d8a33149878e","CamTypeGUId":"b09619ff-8b86-d011-b42d-b2c07fa96404","CamContractGUId":"50e53f6c-18b7-4539-91a6-363c2c2b5d92","CamId":1016040,"CamTypeId":107,"CamSeqId":"","CamConId":100114,"CamProjId":10806,"CamDeviceId":"mjdx-003","CamIsPrivate":true,"CamName":"钢筋加工成巡航摄像机","CamDateInstall":"2015-09-24 19:43:51","CamStockOutDate":null,"CamDateStartUse":"2017-03-25 17:08:45","CamDateEndUse":null,"CamDateCompleted":null,"CamDateDelay":"2015-12-03 00:00:00","CamDateUninstal":null,"CamMapX":null,"CamMapY":null,"CamInstalPlace":"汇川科技展厅","CamMonitorUrl":null,"CamRemark":"","Cam_DX_VideoId":"0000000000200000000000007426686:0000000000200000000000006941852:110.84.128.211:086591","Cam_DX_VideoName":null,"Cam_DX_Memo":null,"CamIsDeafault":true,"Cam_WideAngle_IP":"","Cam_Ranging_IP":"","Cam_WA_UserName":null,"Cam_WA_Password":null,"Cam_WA_Port":null,"Cam_Rg_UserName":null,"Cam_Rg_Password":null,"Cam_Rg_Port":null,"Cam_Ranging_Model":null,"CamFlowState":15,"CamIsDeleted":false,"CamIsEnable":true,"Cam_LoginName":"hxht_admin","Cam_LoginPsw":"123456","Cam_LoginIp":"222.77.183.67","Cam_LoginPort":"80","Cam_SessionId":null,"SysID":11,"CamPSID":8418,"SrvID":10101,"SdiID":null,"Cam_Config":"<xml><cam><type>2<\/type><naming>0000000000200000000000007426686:0000000000200000000000006941852:110.84.128.211:086591<\/naming><ip>222.77.183.67<\/ip><port>80<\/port><account>hxht_admin<\/account><password>123456<\/password><lacId>1019<\/lacId><camSeqId /><camId>1016040<\/camId><name>钢筋加工成巡航摄像机<\/name><showid>0<\/showid><isusinghczc>0<\/isusinghczc><ishxplay>0<\/ishxplay><channelId>1<\/channelId><obdistance /><horizontalAngle /><verticalAngle /><xo /><yo /><zo /><alpha /><lng /><lat /><ccdL /><ccdW /><hidCross1 /><hidTriangle1 /><hidCross2 /><hidTriangle2 /><hidCross3 /><hidTriangle3 /><htIp /><htPort /><htAccount /><htPassword /><url /><serverIp>120.35.11.49<\/serverIp><serverPort>28888<\/serverPort><positionX>610<\/positionX><positionY>380<\/positionY><devLng /><devLat /><devElevation /><pipNaming /><pipAccount /><pipPassword /><pipIp /><pipPort /><Pm10WarningVal /><Pm25WarningVal /><TemWarningVal /><HumidityWarningVal /><NoiseWarningVal /><MinWorkVal /><MaxWorkVal /><RestWorkVal /><hxPlayAccount /><hxPlayPassword /><hxPlayIp /><hxPlayPort /><hxPlayNaming /><\/cam><\/xml>","Cam_JobCode":null,"Cam_JobId":null,"CamLacID":1019,"Cam_Rights":null,"CamDateStartCost":"2015-05-03 00:00:00","CamDateEndCost":null,"CamDxDateCompleted":null,"CamDxDateUninstal":null,"Cam_DxBusiID":null,"Cam_CjBusiID":null,"Cam_IsTest":true,"CamIsKcyDev":false,"Cam_DX_PUID":"086591--2002838198","CamBusineOrdersDate":null,"CamSetupOrdersDate":null,"CamDevPhoto":null,"CamRenewType":null,"CamStandarWaterLevel":null,"CamFloodWaterLevel":null,"CamItemId":null,"CamHlhtDcPk":null,"SPID":null,"BackupSPID":null},{"totalTime":746050,"monthTime":0,"dayTime":0,"DevTypeName":"智能测距摄像机","DevTypePic":"/lib/images/dev/zhinengceju.png","CamGUId":"1d764d86-95e7-4dd6-9ca9-584c048fab44","CamTypeGUId":"b09619ff-8b86-d011-b42d-b2c07fa96403","CamContractGUId":"50e53f6c-18b7-4539-91a6-363c2c2b5d92","CamId":1016071,"CamTypeId":103,"CamSeqId":"703509462","CamConId":100114,"CamProjId":10806,"CamDeviceId":"mjdx-004","CamIsPrivate":true,"CamName":"智能测距新款","CamDateInstall":"2013-12-19 00:00:00","CamStockOutDate":null,"CamDateStartUse":"2017-03-25 17:30:24","CamDateEndUse":null,"CamDateCompleted":"2013-12-19 09:28:45","CamDateDelay":"2015-12-03 00:00:00","CamDateUninstal":null,"CamMapX":-1,"CamMapY":-1,"CamInstalPlace":"闽江大学汇川物联网研究院","CamMonitorUrl":null,"CamRemark":"Camera101","Cam_DX_VideoId":"","Cam_DX_VideoName":"测距测试20-2","Cam_DX_Memo":"","CamIsDeafault":false,"Cam_WideAngle_IP":"0000000000200000000000007404948:0000000000200000000000006929152:110.84.128.211:086591","Cam_Ranging_IP":"0000000000200000000000007404947:0000000000200000000000006929152:110.84.128.211:086591","Cam_WA_UserName":null,"Cam_WA_Password":null,"Cam_WA_Port":null,"Cam_Rg_UserName":null,"Cam_Rg_Password":null,"Cam_Rg_Port":null,"Cam_Ranging_Model":"模式二","CamFlowState":15,"CamIsDeleted":false,"CamIsEnable":true,"Cam_LoginName":"admin","Cam_LoginPsw":"hckj1234","Cam_LoginIp":"10.1.4.65","Cam_LoginPort":"80","Cam_SessionId":null,"SysID":11,"CamPSID":8418,"SrvID":10101,"SdiID":null,"Cam_Config":"<xml><cam><type>12<\/type><naming /><ip>10.1.4.65<\/ip><port>80<\/port><account>admin<\/account><password>hckj1234<\/password><lacId>1022<\/lacId><camSeqId>703509462<\/camSeqId><camId>1016071<\/camId><name>智能测距新款<\/name><showid>0<\/showid><isusinghczc>1<\/isusinghczc><ishxplay>0<\/ishxplay><channelId>1<\/channelId><obdistance /><horizontalAngle /><verticalAngle /><xo /><yo /><zo /><alpha /><lng /><lat /><ccdL /><ccdW /><hidCross1 /><hidTriangle1 /><hidCross2 /><hidTriangle2 /><hidCross3 /><hidTriangle3 /><htIp /><htPort /><htAccount /><htPassword /><url /><serverIp>120.35.11.49<\/serverIp><serverPort>28888<\/serverPort><positionX>610<\/positionX><positionY>380<\/positionY><devLng /><devLat /><devElevation /><pipNaming /><pipAccount /><pipPassword /><pipIp /><pipPort /><Pm10WarningVal /><Pm25WarningVal /><TemWarningVal /><HumidityWarningVal /><NoiseWarningVal /><MinWorkVal /><MaxWorkVal /><RestWorkVal /><hxPlayAccount /><hxPlayPassword /><hxPlayIp /><hxPlayPort /><hxPlayNaming /><\/cam><\/xml>","Cam_JobCode":null,"Cam_JobId":null,"CamLacID":1022,"Cam_Rights":null,"CamDateStartCost":"2015-05-03 00:00:00","CamDateEndCost":null,"CamDxDateCompleted":null,"CamDxDateUninstal":null,"Cam_DxBusiID":null,"Cam_CjBusiID":null,"Cam_IsTest":true,"CamIsKcyDev":true,"Cam_DX_PUID":"086591-532641487","CamBusineOrdersDate":null,"CamSetupOrdersDate":null,"CamDevPhoto":null,"CamRenewType":null,"CamStandarWaterLevel":null,"CamFloodWaterLevel":null,"CamItemId":null,"CamHlhtDcPk":null,"SPID":null,"BackupSPID":null},{"totalTime":82890,"monthTime":0,"dayTime":0,"DevTypeName":"塔式起重机超视野摄像机","DevTypePic":"/lib/images/dev/chaoshiyenew.png","CamGUId":"7e6f3357-21f7-4b49-8a5f-90de5b9f5e5c","CamTypeGUId":"b09619ff-8b86-d011-b42d-b2c07fa96404","CamContractGUId":"50e53f6c-18b7-4539-91a6-363c2c2b5d92","CamId":1024890,"CamTypeId":115,"CamSeqId":"","CamConId":100114,"CamProjId":10806,"CamDeviceId":"mjdx-003","CamIsPrivate":true,"CamName":"塔式起重机超视野摄像机","CamDateInstall":"2015-09-24 19:43:51","CamStockOutDate":null,"CamDateStartUse":"2017-03-25 17:06:33","CamDateEndUse":null,"CamDateCompleted":null,"CamDateDelay":"2015-12-03 00:00:00","CamDateUninstal":null,"CamMapX":null,"CamMapY":null,"CamInstalPlace":"闽江大学汇川物联网研究院","CamMonitorUrl":null,"CamRemark":"","Cam_DX_VideoId":"0000000000200000000000007426692:0000000000200000000000006928301:110.84.128.211:086591","Cam_DX_VideoName":null,"Cam_DX_Memo":null,"CamIsDeafault":true,"Cam_WideAngle_IP":"","Cam_Ranging_IP":"","Cam_WA_UserName":null,"Cam_WA_Password":null,"Cam_WA_Port":null,"Cam_Rg_UserName":null,"Cam_Rg_Password":null,"Cam_Rg_Port":null,"Cam_Ranging_Model":null,"CamFlowState":15,"CamIsDeleted":false,"CamIsEnable":true,"Cam_LoginName":"hxht_admin","Cam_LoginPsw":"123456","Cam_LoginIp":"222.77.183.67","Cam_LoginPort":"80","Cam_SessionId":null,"SysID":26,"CamPSID":8418,"SrvID":10101,"SdiID":null,"Cam_Config":"<xml><cam><type>2<\/type><ip>222.77.183.67<\/ip><port>80<\/port><account>hxht_admin<\/account><password>123456<\/password><naming>0000000000200000000000007426692:0000000000200000000000006928301:110.84.128.211:086591<\/naming><lacId>1019<\/lacId><camSeqId /><camId>1024890<\/camId><name>塔式起重机超视野摄像机<\/name><showid>0<\/showid><isusinghczc>0<\/isusinghczc><ishxplay>0<\/ishxplay><channelId>1<\/channelId><obdistance /><horizontalAngle /><verticalAngle /><xo /><yo /><zo /><alpha /><lng /><lat /><ccdL /><ccdW /><hidCross1 /><hidTriangle1 /><hidCross2 /><hidTriangle2 /><hidCross3 /><hidTriangle3 /><htIp /><htPort /><htAccount /><htPassword /><url /><serverIp>120.35.11.49<\/serverIp><serverPort>28888<\/serverPort><positionX>610<\/positionX><positionY>380<\/positionY><devLng /><devLat /><devElevation /><pipNaming /><pipAccount /><pipPassword /><pipIp /><pipPort /><Pm10WarningVal /><Pm25WarningVal /><TemWarningVal /><HumidityWarningVal /><NoiseWarningVal /><MinWorkVal /><MaxWorkVal /><RestWorkVal /><hxPlayAccount /><hxPlayPassword /><hxPlayIp /><hxPlayPort /><hxPlayNaming>0000000000200000000000007426692:0000000000200000000000006928301:110.84.128.211:086591<\/hxPlayNaming><isFromSz>0<\/isFromSz><camItemId /><sysId>11<\/sysId><vissPlayAccount /><vissPlayPassword>654321<\/vissPlayPassword><vissPlayIp /><vissPlayPort /><\/cam><\/xml>","Cam_JobCode":null,"Cam_JobId":null,"CamLacID":1019,"Cam_Rights":null,"CamDateStartCost":"2015-05-03 00:00:00","CamDateEndCost":null,"CamDxDateCompleted":null,"CamDxDateUninstal":null,"Cam_DxBusiID":null,"Cam_CjBusiID":null,"Cam_IsTest":true,"CamIsKcyDev":false,"Cam_DX_PUID":"086591--1280812325","CamBusineOrdersDate":null,"CamSetupOrdersDate":null,"CamDevPhoto":null,"CamRenewType":null,"CamStandarWaterLevel":null,"CamFloodWaterLevel":null,"CamItemId":null,"CamHlhtDcPk":null,"SPID":null,"BackupSPID":null},{"totalTime":82890,"monthTime":0,"dayTime":0,"DevTypeName":"巡航摄像机","DevTypePic":"/lib/images/dev/xunhang.png","CamGUId":"1149f59c-590c-4e82-875d-6820f76d8c35","CamTypeGUId":"b09619ff-8b86-d011-b42d-b2c07fa96404","CamContractGUId":"50e53f6c-18b7-4539-91a6-363c2c2b5d92","CamId":1024891,"CamTypeId":107,"CamSeqId":"","CamConId":100114,"CamProjId":10806,"CamDeviceId":"mjdx-003","CamIsPrivate":true,"CamName":"大门出入口（隧道洞内）高清摄像机","CamDateInstall":"2015-09-24 19:43:51","CamStockOutDate":null,"CamDateStartUse":"2017-03-25 17:08:45","CamDateEndUse":null,"CamDateCompleted":null,"CamDateDelay":"2015-12-03 00:00:00","CamDateUninstal":null,"CamMapX":null,"CamMapY":null,"CamInstalPlace":"汇川科技展厅","CamMonitorUrl":null,"CamRemark":"","Cam_DX_VideoId":"0000000000200000000000007426685:0000000000200000000000006941852:110.84.128.211:086591","Cam_DX_VideoName":null,"Cam_DX_Memo":null,"CamIsDeafault":true,"Cam_WideAngle_IP":"","Cam_Ranging_IP":"","Cam_WA_UserName":null,"Cam_WA_Password":null,"Cam_WA_Port":null,"Cam_Rg_UserName":null,"Cam_Rg_Password":null,"Cam_Rg_Port":null,"Cam_Ranging_Model":null,"CamFlowState":15,"CamIsDeleted":false,"CamIsEnable":true,"Cam_LoginName":"hxht_admin","Cam_LoginPsw":"123456","Cam_LoginIp":"222.77.183.67","Cam_LoginPort":"80","Cam_SessionId":null,"SysID":11,"CamPSID":8418,"SrvID":10101,"SdiID":null,"Cam_Config":"<xml><cam><type>2<\/type><ip>222.77.183.67<\/ip><port>80<\/port><account>hxht_admin<\/account><password>123456<\/password><naming>0000000000200000000000007426685:0000000000200000000000006941852:110.84.128.211:086591<\/naming><lacId>1019<\/lacId><camSeqId /><camId>1024891<\/camId><name>大门出入口（隧道洞内）高清摄像机<\/name><showid>0<\/showid><isusinghczc>0<\/isusinghczc><ishxplay>0<\/ishxplay><channelId>1<\/channelId><obdistance /><horizontalAngle /><verticalAngle /><xo /><yo /><zo /><alpha /><lng /><lat /><ccdL /><ccdW /><hidCross1 /><hidTriangle1 /><hidCross2 /><hidTriangle2 /><hidCross3 /><hidTriangle3 /><htIp /><htPort /><htAccount /><htPassword /><url /><serverIp>120.35.11.49<\/serverIp><serverPort>28888<\/serverPort><positionX>610<\/positionX><positionY>380<\/positionY><devLng /><devLat /><devElevation /><pipNaming /><pipAccount /><pipPassword /><pipIp /><pipPort /><Pm10WarningVal /><Pm25WarningVal /><TemWarningVal /><HumidityWarningVal /><NoiseWarningVal /><MinWorkVal /><MaxWorkVal /><RestWorkVal /><hxPlayAccount /><hxPlayPassword /><hxPlayIp /><hxPlayPort /><hxPlayNaming /><\/cam><\/xml>","Cam_JobCode":null,"Cam_JobId":null,"CamLacID":1019,"Cam_Rights":null,"CamDateStartCost":"2015-05-03 00:00:00","CamDateEndCost":null,"CamDxDateCompleted":null,"CamDxDateUninstal":null,"Cam_DxBusiID":null,"Cam_CjBusiID":null,"Cam_IsTest":true,"CamIsKcyDev":false,"Cam_DX_PUID":"086591-1598736393","CamBusineOrdersDate":null,"CamSetupOrdersDate":null,"CamDevPhoto":null,"CamRenewType":null,"CamStandarWaterLevel":null,"CamFloodWaterLevel":null,"CamItemId":null,"CamHlhtDcPk":null,"SPID":null,"BackupSPID":null},{"totalTime":32370,"monthTime":0,"dayTime":0,"DevTypeName":"智能测距摄像机","DevTypePic":"/lib/images/dev/zhinengceju.png","CamGUId":"0879410b-b5a2-4250-b80e-df0146b9ac54","CamTypeGUId":"b09619ff-8b86-d011-b42d-b2c07fa96403","CamContractGUId":"50e53f6c-18b7-4539-91a6-363c2c2b5d92","CamId":1025251,"CamTypeId":103,"CamSeqId":"703509444","CamConId":0,"CamProjId":10806,"CamDeviceId":"mjdx-0050","CamIsPrivate":true,"CamName":"智能测距_238","CamDateInstall":"2013-12-19 00:00:00","CamStockOutDate":null,"CamDateStartUse":"2017-03-25 17:30:24","CamDateEndUse":null,"CamDateCompleted":"2013-12-19 09:28:45","CamDateDelay":"2015-12-03 00:00:00","CamDateUninstal":null,"CamMapX":-1,"CamMapY":-1,"CamInstalPlace":"闽江大学汇川物联网研究院","CamMonitorUrl":null,"CamRemark":"Camera101","Cam_DX_VideoId":"","Cam_DX_VideoName":null,"Cam_DX_Memo":"","CamIsDeafault":false,"Cam_WideAngle_IP":"0000000000200000000000007404948:0000000000200000000000006929152:110.84.128.211:086591","Cam_Ranging_IP":"0000000000200000000000007404947:0000000000200000000000006929152:110.84.128.211:086591","Cam_WA_UserName":null,"Cam_WA_Password":null,"Cam_WA_Port":null,"Cam_Rg_UserName":null,"Cam_Rg_Password":null,"Cam_Rg_Port":null,"Cam_Ranging_Model":null,"CamFlowState":15,"CamIsDeleted":false,"CamIsEnable":true,"Cam_LoginName":"admin","Cam_LoginPsw":"hckj1234","Cam_LoginIp":"10.1.4.238","Cam_LoginPort":"80","Cam_SessionId":null,"SysID":30,"CamPSID":8418,"SrvID":10101,"SdiID":null,"Cam_Config":"<xml><cam><type>12<\/type><ip>10.1.4.238<\/ip><port>80<\/port><account>admin<\/account><password>hckj1234<\/password><naming /><lacId /><camSeqId>703509444<\/camSeqId><camId>1025251<\/camId><name>智能测距_238<\/name><showid>1<\/showid><isusinghczc>1<\/isusinghczc><ishxplay>0<\/ishxplay><channelId>1<\/channelId><obdistance /><horizontalAngle /><verticalAngle /><xo /><yo /><zo /><alpha /><lng /><lat /><ccdL /><ccdW /><hidCross1 /><hidTriangle1 /><hidCross2 /><hidTriangle2 /><hidCross3 /><hidTriangle3 /><htIp /><htPort /><htAccount /><htPassword /><url /><serverIp>119.23.13.32<\/serverIp><serverPort>28888<\/serverPort><positionX>500<\/positionX><positionY>350<\/positionY><devLng /><devLat /><devElevation /><pipNaming /><pipAccount /><pipPassword /><pipIp /><pipPort /><Pm10WarningVal /><Pm25WarningVal /><TemWarningVal /><HumidityWarningVal /><NoiseWarningVal /><MinWorkVal /><MaxWorkVal /><RestWorkVal /><hxPlayAccount /><hxPlayPassword /><hxPlayIp /><hxPlayPort /><hxPlayNaming /><isFromSz>0<\/isFromSz><camItemId /><sysId>30<\/sysId><vissPlayAccount /><vissPlayPassword /><vissPlayIp /><vissPlayPort /><\/cam><\/xml>","Cam_JobCode":null,"Cam_JobId":null,"CamLacID":0,"Cam_Rights":null,"CamDateStartCost":"2015-05-03 00:00:00","CamDateEndCost":null,"CamDxDateCompleted":null,"CamDxDateUninstal":null,"Cam_DxBusiID":null,"Cam_CjBusiID":null,"Cam_IsTest":true,"CamIsKcyDev":true,"Cam_DX_PUID":"086591-532641487","CamBusineOrdersDate":null,"CamSetupOrdersDate":null,"CamDevPhoto":null,"CamRenewType":null,"CamStandarWaterLevel":null,"CamFloodWaterLevel":null,"CamItemId":null,"CamHlhtDcPk":null,"SPID":null,"BackupSPID":null},{"totalTime":32340,"monthTime":0,"dayTime":0,"DevTypeName":"智能测距摄像机","DevTypePic":"/lib/images/dev/zhinengceju.png","CamGUId":"6165768e-0a8b-4385-867e-46cbc1898203","CamTypeGUId":null,"CamContractGUId":null,"CamId":1025252,"CamTypeId":103,"CamSeqId":"7035095300","CamConId":0,"CamProjId":10806,"CamDeviceId":"1","CamIsPrivate":true,"CamName":"1-6智能测距","CamDateInstall":null,"CamStockOutDate":"2017-01-18 14:13:01","CamDateStartUse":"2017-01-19 09:43:01","CamDateEndUse":null,"CamDateCompleted":null,"CamDateDelay":"2017-09-19 09:33:49","CamDateUninstal":null,"CamMapX":1,"CamMapY":-0.508840864440079,"CamInstalPlace":"（测试设备）安装在3#塔吊上监控施工现场","CamMonitorUrl":null,"CamRemark":"","Cam_DX_VideoId":"","Cam_DX_VideoName":null,"Cam_DX_Memo":null,"CamIsDeafault":null,"Cam_WideAngle_IP":null,"Cam_Ranging_IP":null,"Cam_WA_UserName":null,"Cam_WA_Password":null,"Cam_WA_Port":null,"Cam_Rg_UserName":null,"Cam_Rg_Password":null,"Cam_Rg_Port":null,"Cam_Ranging_Model":null,"CamFlowState":15,"CamIsDeleted":false,"CamIsEnable":true,"Cam_LoginName":"admin","Cam_LoginPsw":"hckj1234","Cam_LoginIp":"112.111.41.124","Cam_LoginPort":"10086","Cam_SessionId":null,"SysID":30,"CamPSID":38159,"SrvID":10101,"SdiID":null,"Cam_Config":null,"Cam_JobCode":null,"Cam_JobId":null,"CamLacID":0,"Cam_Rights":null,"CamDateStartCost":"2017-02-19 09:33:49","CamDateEndCost":null,"CamDxDateCompleted":null,"CamDxDateUninstal":null,"Cam_DxBusiID":null,"Cam_CjBusiID":null,"Cam_IsTest":true,"CamIsKcyDev":false,"Cam_DX_PUID":null,"CamBusineOrdersDate":"2017-01-13 18:02:54","CamSetupOrdersDate":"2017-01-17 08:56:28","CamDevPhoto":null,"CamRenewType":null,"CamStandarWaterLevel":null,"CamFloodWaterLevel":null,"CamItemId":null,"CamHlhtDcPk":null,"SPID":null,"BackupSPID":null}]
     * TotalCount : 8
     */

    private int TotalCount;
    private java.util.List<ListBean> List;

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount) {
        this.TotalCount = TotalCount;
    }

    public List<ListBean> getList() {
        return List;
    }

    public void setList(List<ListBean> List) {
        this.List = List;
    }

    public static class ListBean implements Serializable{
        /**
         * totalTime : 772340
         * monthTime : 0
         * dayTime : 0
         * DevTypeName : 智能测距摄像机
         * DevTypePic : /lib/images/dev/zhinengceju.png
         * CamGUId : 6f09b584-867c-43a3-996e-e50a75758b30
         * CamTypeGUId : b09619ff-8b86-d011-b42d-b2c07fa96407
         * CamContractGUId : 50e53f6c-18b7-4539-91a6-363c2c2b5d92
         * CamId : 1016010
         * CamTypeId : 103
         * CamSeqId : 518011479
         * CamConId : 100114
         * CamProjId : 10806
         * CamDeviceId : mjdx-001
         * CamIsPrivate : true
         * CamName : 山体模型监测
         * CamDateInstall : 2014-09-09 00:00:00
         * CamStockOutDate : null
         * CamDateStartUse : 2015-09-24 19:39:51
         * CamDateEndUse : null
         * CamDateCompleted : null
         * CamDateDelay : 2015-12-03 00:00:00
         * CamDateUninstal : null
         * CamMapX : -1.0
         * CamMapY : -1.0
         * CamInstalPlace : 汇川物联网8楼展厅
         * CamMonitorUrl : null
         * CamRemark : Camera101
         * Cam_DX_VideoId :
         * Cam_DX_VideoName : null
         * Cam_DX_Memo : null
         * CamIsDeafault : true
         * Cam_WideAngle_IP : 0000000000200000000000007404950:0000000000200000000000006929153:110.84.128.211:086591
         * Cam_Ranging_IP : 0000000000200000000000007404949:0000000000200000000000006929153:110.84.128.211:086591
         * Cam_WA_UserName : null
         * Cam_WA_Password : null
         * Cam_WA_Port : null
         * Cam_Rg_UserName : null
         * Cam_Rg_Password : null
         * Cam_Rg_Port : null
         * Cam_Ranging_Model : null
         * CamFlowState : 15
         * CamIsDeleted : false
         * CamIsEnable : true
         * Cam_LoginName : admin
         * Cam_LoginPsw : 12345
         * Cam_LoginIp : 10.1.5.182
         * Cam_LoginPort : 80
         * Cam_SessionId : null
         * SysID : 28
         * CamPSID : 8418
         * SrvID : 10101
         * SdiID : null
         * Cam_Config : <xml><cam><type>12</type><naming /><ip>10.1.5.182</ip><port>80</port><account>admin</account><password>12345</password><lacId>1035</lacId><camSeqId>518011479</camSeqId><camId>1016010</camId><name>山体模型监测</name><showid>1</showid><isusinghczc>1</isusinghczc><ishxplay>0</ishxplay><channelId>1</channelId><obdistance /><horizontalAngle /><verticalAngle /><xo /><yo /><zo /><alpha /><lng /><lat /><ccdL /><ccdW /><hidCross1 /><hidTriangle1 /><hidCross2 /><hidTriangle2 /><hidCross3 /><hidTriangle3 /><htIp /><htPort /><htAccount /><htPassword /><url /><positionX>610</positionX><positionY>380</positionY><devLng /><devLat /><devElevation /><pipNaming /><pipAccount /><pipPassword /><pipIp /><pipPort /><Pm10WarningVal /><Pm25WarningVal /><TemWarningVal /><HumidityWarningVal /><NoiseWarningVal /><MinWorkVal /><MaxWorkVal /><RestWorkVal /><hxPlayAccount /><hxPlayPassword /><hxPlayIp /><hxPlayPort /><hxPlayNaming /><serverIp>192.168.1.85</serverIp><serverPort>28888</serverPort><devId>518011479</devId><camItemId /><sysId>11</sysId></cam></xml>
         * Cam_JobCode : null
         * Cam_JobId : null
         * CamLacID : 1035
         * Cam_Rights : null
         * CamDateStartCost : 2015-05-03 00:00:00
         * CamDateEndCost : null
         * CamDxDateCompleted : null
         * CamDxDateUninstal : null
         * Cam_DxBusiID : null
         * Cam_CjBusiID : null
         * Cam_IsTest : true
         * CamIsKcyDev : true
         * Cam_DX_PUID : 86591
         * CamBusineOrdersDate : null
         * CamSetupOrdersDate : null
         * CamDevPhoto : null
         * CamRenewType : null
         * CamStandarWaterLevel : null
         * CamFloodWaterLevel : null
         * CamItemId : null
         * CamHlhtDcPk : null
         * SPID : null
         * BackupSPID : null
         */

        private int totalTime;
        private int monthTime;
        private int dayTime;
        private String DevTypeName;
        private String DevTypePic;
        private String CamGUId;
        private String CamTypeGUId;
        private String CamContractGUId;
        private int CamId;
        private int CamTypeId;
        private String CamSeqId;
        private int CamConId;
        private int CamProjId;
        private String CamDeviceId;
        private boolean CamIsPrivate;
        private String CamName;
        private String CamDateInstall;
        private Object CamStockOutDate;
        private String CamDateStartUse;
        private Object CamDateEndUse;
        private Object CamDateCompleted;
        private String CamDateDelay;
        private Object CamDateUninstal;
        private double CamMapX;
        private double CamMapY;
        private String CamInstalPlace;
        private Object CamMonitorUrl;
        private String CamRemark;
        private String Cam_DX_VideoId;
        private Object Cam_DX_VideoName;
        private Object Cam_DX_Memo;
        private boolean CamIsDeafault;
        private String Cam_WideAngle_IP;
        private String Cam_Ranging_IP;
        private Object Cam_WA_UserName;
        private Object Cam_WA_Password;
        private Object Cam_WA_Port;
        private Object Cam_Rg_UserName;
        private Object Cam_Rg_Password;
        private Object Cam_Rg_Port;
        private Object Cam_Ranging_Model;
        private int CamFlowState;
        private boolean CamIsDeleted;
        private boolean CamIsEnable;
        private String Cam_LoginName;
        private String Cam_LoginPsw;
        private String Cam_LoginIp;
        private String Cam_LoginPort;
        private Object Cam_SessionId;
        private int SysID;
        private int CamPSID;
        private int SrvID;
        private Object SdiID;
        private String Cam_Config;
        private Object Cam_JobCode;
        private Object Cam_JobId;
        private int CamLacID;
        private Object Cam_Rights;
        private String CamDateStartCost;
        private Object CamDateEndCost;
        private Object CamDxDateCompleted;
        private Object CamDxDateUninstal;
        private Object Cam_DxBusiID;
        private Object Cam_CjBusiID;
        private boolean Cam_IsTest;
        private boolean CamIsKcyDev;
        private String Cam_DX_PUID;
        private Object CamBusineOrdersDate;
        private Object CamSetupOrdersDate;
        private Object CamDevPhoto;
        private Object CamRenewType;
        private Object CamStandarWaterLevel;
        private Object CamFloodWaterLevel;
        private Object CamItemId;
        private Object CamHlhtDcPk;
        private Object SPID;
        private Object BackupSPID;

        public int getTotalTime() {
            return totalTime;
        }

        public void setTotalTime(int totalTime) {
            this.totalTime = totalTime;
        }

        public int getMonthTime() {
            return monthTime;
        }

        public void setMonthTime(int monthTime) {
            this.monthTime = monthTime;
        }

        public int getDayTime() {
            return dayTime;
        }

        public void setDayTime(int dayTime) {
            this.dayTime = dayTime;
        }

        public String getDevTypeName() {
            return DevTypeName;
        }

        public void setDevTypeName(String DevTypeName) {
            this.DevTypeName = DevTypeName;
        }

        public String getDevTypePic() {
            return DevTypePic;
        }

        public void setDevTypePic(String DevTypePic) {
            this.DevTypePic = DevTypePic;
        }

        public String getCamGUId() {
            return CamGUId;
        }

        public void setCamGUId(String CamGUId) {
            this.CamGUId = CamGUId;
        }

        public String getCamTypeGUId() {
            return CamTypeGUId;
        }

        public void setCamTypeGUId(String CamTypeGUId) {
            this.CamTypeGUId = CamTypeGUId;
        }

        public String getCamContractGUId() {
            return CamContractGUId;
        }

        public void setCamContractGUId(String CamContractGUId) {
            this.CamContractGUId = CamContractGUId;
        }

        public int getCamId() {
            return CamId;
        }

        public void setCamId(int CamId) {
            this.CamId = CamId;
        }

        public int getCamTypeId() {
            return CamTypeId;
        }

        public void setCamTypeId(int CamTypeId) {
            this.CamTypeId = CamTypeId;
        }

        public String getCamSeqId() {
            return CamSeqId;
        }

        public void setCamSeqId(String CamSeqId) {
            this.CamSeqId = CamSeqId;
        }

        public int getCamConId() {
            return CamConId;
        }

        public void setCamConId(int CamConId) {
            this.CamConId = CamConId;
        }

        public int getCamProjId() {
            return CamProjId;
        }

        public void setCamProjId(int CamProjId) {
            this.CamProjId = CamProjId;
        }

        public String getCamDeviceId() {
            return CamDeviceId;
        }

        public void setCamDeviceId(String CamDeviceId) {
            this.CamDeviceId = CamDeviceId;
        }

        public boolean isCamIsPrivate() {
            return CamIsPrivate;
        }

        public void setCamIsPrivate(boolean CamIsPrivate) {
            this.CamIsPrivate = CamIsPrivate;
        }

        public String getCamName() {
            return CamName;
        }

        public void setCamName(String CamName) {
            this.CamName = CamName;
        }

        public String getCamDateInstall() {
            return CamDateInstall;
        }

        public void setCamDateInstall(String CamDateInstall) {
            this.CamDateInstall = CamDateInstall;
        }

        public Object getCamStockOutDate() {
            return CamStockOutDate;
        }

        public void setCamStockOutDate(Object CamStockOutDate) {
            this.CamStockOutDate = CamStockOutDate;
        }

        public String getCamDateStartUse() {
            return CamDateStartUse;
        }

        public void setCamDateStartUse(String CamDateStartUse) {
            this.CamDateStartUse = CamDateStartUse;
        }

        public Object getCamDateEndUse() {
            return CamDateEndUse;
        }

        public void setCamDateEndUse(Object CamDateEndUse) {
            this.CamDateEndUse = CamDateEndUse;
        }

        public Object getCamDateCompleted() {
            return CamDateCompleted;
        }

        public void setCamDateCompleted(Object CamDateCompleted) {
            this.CamDateCompleted = CamDateCompleted;
        }

        public String getCamDateDelay() {
            return CamDateDelay;
        }

        public void setCamDateDelay(String CamDateDelay) {
            this.CamDateDelay = CamDateDelay;
        }

        public Object getCamDateUninstal() {
            return CamDateUninstal;
        }

        public void setCamDateUninstal(Object CamDateUninstal) {
            this.CamDateUninstal = CamDateUninstal;
        }

        public double getCamMapX() {
            return CamMapX;
        }

        public void setCamMapX(double CamMapX) {
            this.CamMapX = CamMapX;
        }

        public double getCamMapY() {
            return CamMapY;
        }

        public void setCamMapY(double CamMapY) {
            this.CamMapY = CamMapY;
        }

        public String getCamInstalPlace() {
            return CamInstalPlace;
        }

        public void setCamInstalPlace(String CamInstalPlace) {
            this.CamInstalPlace = CamInstalPlace;
        }

        public Object getCamMonitorUrl() {
            return CamMonitorUrl;
        }

        public void setCamMonitorUrl(Object CamMonitorUrl) {
            this.CamMonitorUrl = CamMonitorUrl;
        }

        public String getCamRemark() {
            return CamRemark;
        }

        public void setCamRemark(String CamRemark) {
            this.CamRemark = CamRemark;
        }

        public String getCam_DX_VideoId() {
            return Cam_DX_VideoId;
        }

        public void setCam_DX_VideoId(String Cam_DX_VideoId) {
            this.Cam_DX_VideoId = Cam_DX_VideoId;
        }

        public Object getCam_DX_VideoName() {
            return Cam_DX_VideoName;
        }

        public void setCam_DX_VideoName(Object Cam_DX_VideoName) {
            this.Cam_DX_VideoName = Cam_DX_VideoName;
        }

        public Object getCam_DX_Memo() {
            return Cam_DX_Memo;
        }

        public void setCam_DX_Memo(Object Cam_DX_Memo) {
            this.Cam_DX_Memo = Cam_DX_Memo;
        }

        public boolean isCamIsDeafault() {
            return CamIsDeafault;
        }

        public void setCamIsDeafault(boolean CamIsDeafault) {
            this.CamIsDeafault = CamIsDeafault;
        }

        public String getCam_WideAngle_IP() {
            return Cam_WideAngle_IP;
        }

        public void setCam_WideAngle_IP(String Cam_WideAngle_IP) {
            this.Cam_WideAngle_IP = Cam_WideAngle_IP;
        }

        public String getCam_Ranging_IP() {
            return Cam_Ranging_IP;
        }

        public void setCam_Ranging_IP(String Cam_Ranging_IP) {
            this.Cam_Ranging_IP = Cam_Ranging_IP;
        }

        public Object getCam_WA_UserName() {
            return Cam_WA_UserName;
        }

        public void setCam_WA_UserName(Object Cam_WA_UserName) {
            this.Cam_WA_UserName = Cam_WA_UserName;
        }

        public Object getCam_WA_Password() {
            return Cam_WA_Password;
        }

        public void setCam_WA_Password(Object Cam_WA_Password) {
            this.Cam_WA_Password = Cam_WA_Password;
        }

        public Object getCam_WA_Port() {
            return Cam_WA_Port;
        }

        public void setCam_WA_Port(Object Cam_WA_Port) {
            this.Cam_WA_Port = Cam_WA_Port;
        }

        public Object getCam_Rg_UserName() {
            return Cam_Rg_UserName;
        }

        public void setCam_Rg_UserName(Object Cam_Rg_UserName) {
            this.Cam_Rg_UserName = Cam_Rg_UserName;
        }

        public Object getCam_Rg_Password() {
            return Cam_Rg_Password;
        }

        public void setCam_Rg_Password(Object Cam_Rg_Password) {
            this.Cam_Rg_Password = Cam_Rg_Password;
        }

        public Object getCam_Rg_Port() {
            return Cam_Rg_Port;
        }

        public void setCam_Rg_Port(Object Cam_Rg_Port) {
            this.Cam_Rg_Port = Cam_Rg_Port;
        }

        public Object getCam_Ranging_Model() {
            return Cam_Ranging_Model;
        }

        public void setCam_Ranging_Model(Object Cam_Ranging_Model) {
            this.Cam_Ranging_Model = Cam_Ranging_Model;
        }

        public int getCamFlowState() {
            return CamFlowState;
        }

        public void setCamFlowState(int CamFlowState) {
            this.CamFlowState = CamFlowState;
        }

        public boolean isCamIsDeleted() {
            return CamIsDeleted;
        }

        public void setCamIsDeleted(boolean CamIsDeleted) {
            this.CamIsDeleted = CamIsDeleted;
        }

        public boolean isCamIsEnable() {
            return CamIsEnable;
        }

        public void setCamIsEnable(boolean CamIsEnable) {
            this.CamIsEnable = CamIsEnable;
        }

        public String getCam_LoginName() {
            return Cam_LoginName;
        }

        public void setCam_LoginName(String Cam_LoginName) {
            this.Cam_LoginName = Cam_LoginName;
        }

        public String getCam_LoginPsw() {
            return Cam_LoginPsw;
        }

        public void setCam_LoginPsw(String Cam_LoginPsw) {
            this.Cam_LoginPsw = Cam_LoginPsw;
        }

        public String getCam_LoginIp() {
            return Cam_LoginIp;
        }

        public void setCam_LoginIp(String Cam_LoginIp) {
            this.Cam_LoginIp = Cam_LoginIp;
        }

        public String getCam_LoginPort() {
            return Cam_LoginPort;
        }

        public void setCam_LoginPort(String Cam_LoginPort) {
            this.Cam_LoginPort = Cam_LoginPort;
        }

        public Object getCam_SessionId() {
            return Cam_SessionId;
        }

        public void setCam_SessionId(Object Cam_SessionId) {
            this.Cam_SessionId = Cam_SessionId;
        }

        public int getSysID() {
            return SysID;
        }

        public void setSysID(int SysID) {
            this.SysID = SysID;
        }

        public int getCamPSID() {
            return CamPSID;
        }

        public void setCamPSID(int CamPSID) {
            this.CamPSID = CamPSID;
        }

        public int getSrvID() {
            return SrvID;
        }

        public void setSrvID(int SrvID) {
            this.SrvID = SrvID;
        }

        public Object getSdiID() {
            return SdiID;
        }

        public void setSdiID(Object SdiID) {
            this.SdiID = SdiID;
        }

        public String getCam_Config() {
            return Cam_Config;
        }

        public void setCam_Config(String Cam_Config) {
            this.Cam_Config = Cam_Config;
        }

        public Object getCam_JobCode() {
            return Cam_JobCode;
        }

        public void setCam_JobCode(Object Cam_JobCode) {
            this.Cam_JobCode = Cam_JobCode;
        }

        public Object getCam_JobId() {
            return Cam_JobId;
        }

        public void setCam_JobId(Object Cam_JobId) {
            this.Cam_JobId = Cam_JobId;
        }

        public int getCamLacID() {
            return CamLacID;
        }

        public void setCamLacID(int CamLacID) {
            this.CamLacID = CamLacID;
        }

        public Object getCam_Rights() {
            return Cam_Rights;
        }

        public void setCam_Rights(Object Cam_Rights) {
            this.Cam_Rights = Cam_Rights;
        }

        public String getCamDateStartCost() {
            return CamDateStartCost;
        }

        public void setCamDateStartCost(String CamDateStartCost) {
            this.CamDateStartCost = CamDateStartCost;
        }

        public Object getCamDateEndCost() {
            return CamDateEndCost;
        }

        public void setCamDateEndCost(Object CamDateEndCost) {
            this.CamDateEndCost = CamDateEndCost;
        }

        public Object getCamDxDateCompleted() {
            return CamDxDateCompleted;
        }

        public void setCamDxDateCompleted(Object CamDxDateCompleted) {
            this.CamDxDateCompleted = CamDxDateCompleted;
        }

        public Object getCamDxDateUninstal() {
            return CamDxDateUninstal;
        }

        public void setCamDxDateUninstal(Object CamDxDateUninstal) {
            this.CamDxDateUninstal = CamDxDateUninstal;
        }

        public Object getCam_DxBusiID() {
            return Cam_DxBusiID;
        }

        public void setCam_DxBusiID(Object Cam_DxBusiID) {
            this.Cam_DxBusiID = Cam_DxBusiID;
        }

        public Object getCam_CjBusiID() {
            return Cam_CjBusiID;
        }

        public void setCam_CjBusiID(Object Cam_CjBusiID) {
            this.Cam_CjBusiID = Cam_CjBusiID;
        }

        public boolean isCam_IsTest() {
            return Cam_IsTest;
        }

        public void setCam_IsTest(boolean Cam_IsTest) {
            this.Cam_IsTest = Cam_IsTest;
        }

        public boolean isCamIsKcyDev() {
            return CamIsKcyDev;
        }

        public void setCamIsKcyDev(boolean CamIsKcyDev) {
            this.CamIsKcyDev = CamIsKcyDev;
        }

        public String getCam_DX_PUID() {
            return Cam_DX_PUID;
        }

        public void setCam_DX_PUID(String Cam_DX_PUID) {
            this.Cam_DX_PUID = Cam_DX_PUID;
        }

        public Object getCamBusineOrdersDate() {
            return CamBusineOrdersDate;
        }

        public void setCamBusineOrdersDate(Object CamBusineOrdersDate) {
            this.CamBusineOrdersDate = CamBusineOrdersDate;
        }

        public Object getCamSetupOrdersDate() {
            return CamSetupOrdersDate;
        }

        public void setCamSetupOrdersDate(Object CamSetupOrdersDate) {
            this.CamSetupOrdersDate = CamSetupOrdersDate;
        }

        public Object getCamDevPhoto() {
            return CamDevPhoto;
        }

        public void setCamDevPhoto(Object CamDevPhoto) {
            this.CamDevPhoto = CamDevPhoto;
        }

        public Object getCamRenewType() {
            return CamRenewType;
        }

        public void setCamRenewType(Object CamRenewType) {
            this.CamRenewType = CamRenewType;
        }

        public Object getCamStandarWaterLevel() {
            return CamStandarWaterLevel;
        }

        public void setCamStandarWaterLevel(Object CamStandarWaterLevel) {
            this.CamStandarWaterLevel = CamStandarWaterLevel;
        }

        public Object getCamFloodWaterLevel() {
            return CamFloodWaterLevel;
        }

        public void setCamFloodWaterLevel(Object CamFloodWaterLevel) {
            this.CamFloodWaterLevel = CamFloodWaterLevel;
        }

        public Object getCamItemId() {
            return CamItemId;
        }

        public void setCamItemId(Object CamItemId) {
            this.CamItemId = CamItemId;
        }

        public Object getCamHlhtDcPk() {
            return CamHlhtDcPk;
        }

        public void setCamHlhtDcPk(Object CamHlhtDcPk) {
            this.CamHlhtDcPk = CamHlhtDcPk;
        }

        public Object getSPID() {
            return SPID;
        }

        public void setSPID(Object SPID) {
            this.SPID = SPID;
        }

        public Object getBackupSPID() {
            return BackupSPID;
        }

        public void setBackupSPID(Object BackupSPID) {
            this.BackupSPID = BackupSPID;
        }
    }
}
