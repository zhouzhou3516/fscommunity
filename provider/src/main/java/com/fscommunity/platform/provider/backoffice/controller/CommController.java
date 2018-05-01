package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.persist.pojo.CommentAuthStatus;
import com.fscommunity.platform.persist.pojo.CommentReplyStatus;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.backoffice.adapter.CommentVoAdatpter;
import com.fscommunity.platform.provider.backoffice.req.CommentAuthReq;
import com.fscommunity.platform.provider.backoffice.req.NewCommentReplyReq;
import com.fscommunity.platform.provider.backoffice.req.QueryCommentListReq;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.CommentService;
import com.fscommunity.platform.service.UserInfoService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.page.PageResp;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
@RequestMapping("/fscommunity/man/comment")
@Controller
public class CommController {

    private final static Logger logger = LoggerFactory.getLogger(CommController.class);

    @Resource
    CommentService commentService;

    @Autowired
    UserInfoService userInfoService;

    @Resource
    ArticleService articleService;
    @Resource
    SessionHolder sessionHolder;


    @RequestMapping("/getByArcticalId")
    @JsonBody
    public PageResp getByArticleId(@RequestBody QueryCommentListReq req) {
        Integer authStatus = StringUtils.isBlank(req.getAuthStatus()) ? -1
                : CommentAuthStatus.valueOf(req.getAuthStatus()).getCode();
        Integer replyStatus = StringUtils.isBlank(req.getReplyStatus()) ? -1
                : CommentReplyStatus.valueOf(req.getReplyStatus()).getCode();
        List<Comment> rows = commentService
                .list(req.getArticleId(), authStatus, replyStatus,
                        new PageRequest(req.getCurrentPage(), req.getPageSize()));

        if (CollectionUtils.isEmpty(rows)) {
            return new PageResp(Collections.EMPTY_LIST, 0);
        }

        //  rows = rows.stream().filter(r->r.getIsShowed() == (req.isAuthStatus()?1:0)).collect(Collectors.toList());
        //评论用户
        List<Integer> userIds = rows.stream().map(Comment::getUserId).filter(id -> id != 0).distinct()
                .collect(Collectors.toList());
        //被评论用户id，去除评论文章的情况
        List<Integer> commedIds = rows.stream().map(Comment::getTargetUid).filter(id -> id != 0).distinct()
                .collect(Collectors.toList());
        userIds.addAll(commedIds);
        List<UserSimpleInfo> simpleInfos = userInfoService.querySimpleUsersByIds(userIds);
        if (CollectionUtils.isEmpty(simpleInfos)) {
            throw new BizException("用户信息有误");
        }
        Map<Integer, UserSimpleInfo> userMap = simpleInfos.stream()
                .collect(Collectors.toMap(UserSimpleInfo::getId, r -> r));

        //评论信息
        List<Integer> cids = rows.stream().map(r -> r.getTargetCid()).filter(cid -> cid != 0)
                .collect(Collectors.toList());
        List<Comment> comments = commentService.queryCommentsByIds(cids);
        if (CollectionUtils.isEmpty(comments)) {
            throw new BizException("评论信息有误");
        }
        Map<Integer, Comment> commentMap = comments.stream().collect(Collectors.toMap(Comment::getId, r -> r));
        int articleId = rows.get(0).getTargetId();
        Article article = articleService.selectById(articleId);

        int count = commentService.getCount(req.getArticleId());
        PageResp resp = new PageResp<>(
                CommentVoAdatpter.adaptToCommentVos(rows, article.getName(), userMap, commentMap), count);
        return resp;
    }

//    @RequestMapping("/info")
//    @JsonBody
//    public CommentVo info(HttpServletRequest request) {
//        logger.info("info");
//        Comment comment = commentService.selectById(request.getParameter("id"));
//        return CommentVoAdatpter.adaptToCommentVo(comment);
//    }


    @RequestMapping("/auth")
    @JsonBody
    public void authComment(@RequestBody CommentAuthReq req) {
        commentService.updateAuthStatus(req.getCommentId(), req.getAuthStatus().getCode());
    }

    @RequestMapping("/reply")
    @JsonBody
    @Transactional
    public void replyComment(@RequestBody NewCommentReplyReq req) {
        Comment targetCmt = commentService.getByCommentId(req.getTargetId());
        if (targetCmt.getIsReplied() == 1) {
            throw new BizException("已经被评论过");
        }
        // 更新被评论的评论状态为已评论
        targetCmt.setIsReplied(1);
        commentService.updateById(targetCmt);
        ManUser user = sessionHolder.currentManUser();
        Comment newCmt = CommentVoAdatpter.adaptToComment(targetCmt, req, user.getId());
        commentService.add(newCmt);
    }


    @RequestMapping("/update")
    @JsonBody
    public void update(@RequestBody Comment comment) {
        logger.info("update");
        commentService.updateById(comment);

    }

    @RequestMapping("/del")
    @JsonBody
    public void delete(HttpServletRequest request) {
        logger.info("delete");
        commentService.delById(request.getParameter("id"));
    }

//    /**
//     * 公开显示评论
//     *
//     * @param request
//     */
//    @RequestMapping("/display")
//    @JsonBody
//    public void display(HttpServletRequest request) {
//        logger.info("display");
//        commentService.displayCmmt(request.getParameter("id"));
//    }
}
