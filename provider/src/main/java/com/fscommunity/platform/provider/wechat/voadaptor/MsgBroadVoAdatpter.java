package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.fscommunity.platform.provider.backoffice.vo.MgrMsgBroadVo;
import com.fscommunity.platform.provider.wechat.req.AddLeaveMsgReq;
import com.fscommunity.platform.provider.wechat.vo.MsgBroadVo;

import java.util.Date;
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


    public static MsgBroad adaptBroad(AddLeaveMsgReq req, int userId) {
        MsgBroad broad = new MsgBroad();
        broad.setUserId(userId);
        broad.setContent(req.getContent());

        Date current = new Date();
        broad.setPublishTime(current);
        if (req.isNewMsg()) {
            broad.setTargetCid(0);
            broad.setTargetUid(0);
        } else  {
            broad.setTargetCid(req.getReplyedId());
            broad.setTargetUid(req.getReplyedUserid());
        }

        broad.setIsReply(req.isNewMsg() ?0:1);
        broad.setIsShowed(0);
        broad.setSid(100);
        broad.setTreecode("");
        broad.setCreateTime(current);
        broad.setUpdateTime(current);
        return broad;
    }
}
