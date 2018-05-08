package com.fscommunity.platform.provider.wechat.vo;

import com.fscommunity.platform.persist.pojo.AnnouncementInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.persist.pojo.CommentType;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.wechat.voadaptor.CommentVoAdaptor;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liqingzhou on 18/5/6
 */
public class BasesDetailVoAdapter {

    public static BaseContentDetailVo adaptAnnounce(AnnouncementInfo info, Article article,
            List<Comment> comments, List<UserSimpleInfo> simpleInfos) {
        BaseContentDetailVo vo = new BaseContentDetailVo();
        vo.setArticleId(article.getId());
        vo.setTitle(info.getTitle());
        vo.setContent(article.getContent());
        vo.setComments(adaptComments(comments, simpleInfos));
        return vo;
    }

    private static List<WxCommentVo> adaptComments(List<Comment> comments,
            List<UserSimpleInfo> simpleInfos) {
        Map<Integer, UserSimpleInfo> simpleInfoMap = simpleInfos.stream()
                .collect(Collectors.toMap(UserSimpleInfo::getId, u -> u));
        Map<Integer, WxCommentReplyVo> replys = comments.stream()
                .filter(comment -> comment.getCommentType() == CommentType.COMMENT_COMMENT)
                .map(comment -> {
                    UserSimpleInfo user = simpleInfoMap.getOrDefault(comment.getUserId(), new UserSimpleInfo());
                    return CommentVoAdaptor.adaptToReplyVo(comment, user);
                })
                .collect(Collectors.toMap(c -> c.getTargetCId(), c -> c));
        List<WxCommentVo> articleComments = comments.stream()
                .filter(comment -> comment.getCommentType() == CommentType.COMMENT_ARTICLE)
                .map(comment -> {
                    UserSimpleInfo user = simpleInfoMap.getOrDefault(comment.getUserId(), new UserSimpleInfo());
                    WxCommentReplyVo replyVo = replys.get(comment.getId());
                    return CommentVoAdaptor.adaptToVo(comment, user, replyVo);
                })
                .collect(Collectors.toList());
        return articleComments;
    }


}
