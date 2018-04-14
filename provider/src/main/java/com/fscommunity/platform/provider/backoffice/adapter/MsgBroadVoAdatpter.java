package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.provider.backoffice.vo.CommentVo;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-11
 */
public class CommentVoAdatpter {
    public static CommentVo adaptToCommentVo(Comment comment) {
        //TODO
        CommentVo vo = new CommentVo(comment);
        vo.setTargetUname("");
        vo.setUserAvatar("");
        vo.setUserName("");
        return vo;
    }
}
