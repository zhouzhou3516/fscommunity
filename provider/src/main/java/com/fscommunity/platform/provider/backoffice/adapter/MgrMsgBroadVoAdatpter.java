package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.backoffice.req.NewCommentReplyReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrMsgBroadVo;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-11
 */
public class MgrMsgBroadVoAdatpter {

    public static MgrMsgBroadVo adaptToMgrMsgBroadVo(MsgBroad msgBroad, UserSimpleInfo user,
            UserSimpleInfo targetUser) {
        MgrMsgBroadVo msgVo = new MgrMsgBroadVo(msgBroad);
        msgVo.setUserAvatar(user.getUserAvatar());
        msgVo.setUserName(user.getUserName());
        // 如果是回复
        if(msgBroad.getIsReply()==1) {
            msgVo.setTargetUname(targetUser.getUserName());
        }
        return msgVo;
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

    public static List<MgrMsgBroadVo> adaptToMgrMsgBroadVos(List<MsgBroad> rows, Map<Integer, UserSimpleInfo> userMap) {
        return rows.stream()
                .map(r -> adaptToMgrMsgBroadVo(r, userMap.get(r.getUserId()), userMap.get(r.getTargetUid()))).collect(
                        Collectors.toList());
    }
}
