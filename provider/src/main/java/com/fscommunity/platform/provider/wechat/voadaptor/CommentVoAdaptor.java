package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.common.pojo.SessionUserInfo;
import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.persist.pojo.CommentType;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.wechat.req.AddNewCommentReq;
import com.fscommunity.platform.provider.wechat.vo.WxCommentReplyVo;
import com.fscommunity.platform.provider.wechat.vo.WxCommentVo;
import com.lxx.app.common.util.DateFormatUtil;
import java.util.Date;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public class CommentVoAdaptor {

    public static Comment adaptToComment(AddNewCommentReq req, SessionUserInfo currentUser) {
        Comment comment = new Comment();
        comment.setTargetId(req.getArticleId());
        comment.setUserId(currentUser.getUserId());
        comment.setContent(req.getCommentCth());
        comment.setPublishTime(new Date());
        if (req.getCommentedId() == 0) {
            comment.setTargetCid(0);
            comment.setTargetUid(0);
            comment.setCommentType(CommentType.COMMENT_ARTICLE);
        } else {
            comment.setTargetCid(req.getCommentedId());
            comment.setTargetUid(req.getCommentedUserId());
            comment.setCommentType(CommentType.COMMENT_COMMENT);
        }
        comment.setIsReplied(0);
        //默认审核不通过
        comment.setIsShowed(0);
        comment.setSid(0);
        return comment;
    }

    public static WxCommentVo adaptToVo(Comment comment, UserSimpleInfo user, WxCommentReplyVo reply) {
        WxCommentVo vo = new WxCommentVo();
        vo.setId(comment.getId());
        vo.setUserName(user.getRealName());
        vo.setPublishTime(DateFormatUtil.format4y2M2d2h2m(comment.getPublishTime()));
        vo.setContent(comment.getContent());
        vo.setReply(reply);
        return vo;
    }

    public static WxCommentReplyVo adaptToReplyVo(Comment comment, UserSimpleInfo user) {
        WxCommentReplyVo vo = new WxCommentReplyVo();
        vo.setTargetCId(comment.getTargetCid());
        vo.setId(comment.getId());
        vo.setUserName(user.getRealName());
        vo.setPublishTime(DateFormatUtil.format4y2M2d2h2m(comment.getPublishTime()));
        vo.setContent(comment.getContent());
        return vo;
    }
}
