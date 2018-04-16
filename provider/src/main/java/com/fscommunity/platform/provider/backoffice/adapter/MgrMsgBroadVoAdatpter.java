package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.fscommunity.platform.provider.backoffice.vo.CommentVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrMsgBroadVo;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-11
 */
public class MgrMsgBroadVoAdatpter {
    public static MgrMsgBroadVo adaptToMgrMsgBroadVo(MsgBroad msgBroad,String userAvatar, String userName,
                                                     String targetUname ) {
        MgrMsgBroadVo msgVo=new MgrMsgBroadVo(msgBroad);
        msgVo.setUserAvatar(userAvatar);
        msgVo.setUserName(userName);
        msgVo.setTargetUname(targetUname);
        return null;
    }
}
