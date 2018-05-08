package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.common.pojo.SessionUserInfo;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.wechat.voadaptor.CommentVoAdaptor;
import com.fscommunity.platform.service.CommentService;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fscommunity.platform.provider.wechat.req.AddNewCommentReq;

import javax.annotation.Resource;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
@RequestMapping("/fscommunity/wechat/comment")
@Controller
public class CommentController {

    @Resource
    CommentService commentService;
    @Resource
    SessionHolder sessionHolder;

    @RequestMapping("/add")
    @JsonBody
    public void newComment(@RequestBody AddNewCommentReq req) {
        SessionUserInfo userInfo = sessionHolder.currentUser();
        commentService.add(CommentVoAdaptor.adaptToComment(req, userInfo));
    }
}
