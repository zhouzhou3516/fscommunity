package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.persist.pojo.CommentType;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.backoffice.req.NewCommentReplyReq;
import com.fscommunity.platform.provider.backoffice.vo.CommentVo;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-11
 */
public class CommentVoAdatpter {

    public static CommentVo adaptToCommentVo(Comment comment, String articleName,
            Map<Integer, UserSimpleInfo> userSimpleInfoMap,
            Map<Integer, Comment> commentMap) {
        CommentVo vo = new CommentVo();
        vo.setId(comment.getId());
        vo.setArticleId(comment.getTargetId());
        vo.setArticleName(articleName);
        vo.setCommentUserId(comment.getUserId());
        vo.setCommentUserName(userSimpleInfoMap.get(comment.getUserId()).getRealName());
        vo.setCommentType(comment.getCommentType());

        if (vo.getCommentType() == CommentType.COMMENT_COMMENT) {
            vo.setCommentedUserid(comment.getTargetUid());
            vo.setCommentedUserName(userSimpleInfoMap.get(comment.getTargetUid()).getRealName());
            vo.setCommentedContent(commentMap.get(comment.getTargetCid()).getContent());
        }
        vo.setContent(comment.getContent());
        vo.setPublishTime(comment.getPublishTime());
        vo.setAuthStatus(comment.getIsShowed());
        return vo;
    }

    public static List<CommentVo> adaptToCommentVos(List<Comment> comments, String articleName,
            Map<Integer, UserSimpleInfo> userSimpleInfoMap,
            Map<Integer, Comment> commentMap) {
        return comments.stream().map(r -> adaptToCommentVo(r, articleName, userSimpleInfoMap, commentMap))
                .collect(Collectors.toList());
    }

    public static Comment adaptToComment(Comment comment, NewCommentReplyReq req, int userId) {
        Comment newCmt = new Comment();
        newCmt.setContent(req.getReplyContent());
        newCmt.setCommentType(CommentType.COMMENT_COMMENT);
        newCmt.setIsReplied(0);
        newCmt.setIsShowed(1);
        newCmt.setPublishTime(new Date());
        newCmt.setTargetCid(comment.getId());
        newCmt.setTargetUid(comment.getUserId());
        newCmt.setUserId(userId);
        return newCmt;
    }
}
