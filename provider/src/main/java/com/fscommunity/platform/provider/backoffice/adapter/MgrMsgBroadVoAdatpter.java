package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.fscommunity.platform.provider.backoffice.req.NewCommentReplyReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrMsgBroadVo;
import java.util.Date;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-11
 */
public class MgrMsgBroadVoAdatpter {

    public static MgrMsgBroadVo adaptToMgrMsgBroadVo(MsgBroad msgBroad, String userAvatar, String userName,
            String targetUname) {
        MgrMsgBroadVo msgVo = new MgrMsgBroadVo(msgBroad);
        msgVo.setUserAvatar(userAvatar);
        msgVo.setUserName(userName);
        msgVo.setTargetUname(targetUname);
        return null;
    }

    public static MsgBroad adaptToBroad(MsgBroad targetMsgBroad, NewCommentReplyReq req, int userId) {
        MsgBroad msgBroad = new MsgBroad();
        msgBroad.setContent(req.getReplyContent());
        msgBroad.setIsReply(1);
        msgBroad.setIsReplied(0);
        msgBroad.setIsShowed(1);
        msgBroad.setPublishTime(new Date());
        msgBroad.setTargetCid(targetMsgBroad.getId());
        msgBroad.setTargetUid(targetMsgBroad.getUserId());
        msgBroad.setUserId(userId);
        return msgBroad;

    }
}
