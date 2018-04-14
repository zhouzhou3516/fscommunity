package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.persist.pojo.CommentType;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.wechat.req.AddNewCommentReq;

import java.util.Date;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public class CommentVoAdaptor {
    public static Comment adaptToComment(AddNewCommentReq req, UserSimpleInfo currentUser) {
        Comment comment = new Comment();
        comment.setTargetId(req.getArticleId());
        comment.setUserId(currentUser.getId());
        comment.setContent(req.getCommentCth());
        comment.setPublishTime(new Date());
        comment.setTargetCid(req.getCommentedId());
        comment.setTargetUid(req.getCommentedUserId());
        comment.setCommentType(req.getCommentedId() == 0? CommentType.COMMENT_ARTICLE:CommentType.COMMENT_COMMENT);
        comment.setIsReply(0);

        //默认审核不通过
        comment.setIsShowed(0);
        comment.setSid(0);
        return comment;
    }
}
