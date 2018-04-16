package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.fscommunity.platform.provider.backoffice.vo.MgrMsgBroadVo;
import com.fscommunity.platform.provider.wechat.vo.MsgBroadVo;

import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-16
 */
public class MsgBroadVoAdatpter {
    public static MsgBroadVo adaptToMsgBroadVo(MsgBroad msg,String userAvatar, String userName,
                                               String targetUname ,List<MgrMsgBroadVo> replyMsgList) {
        MsgBroadVo msgVo = new MsgBroadVo(msg);
        msgVo.setUserAvatar(userAvatar);
        msgVo.setUserName(userName);
        msgVo.setTargetUname(targetUname);
        msgVo.setReplyMsg(replyMsgList);
        return null;
    }
}
