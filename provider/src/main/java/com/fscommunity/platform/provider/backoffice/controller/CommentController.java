package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.provider.backoffice.adapter.CommentVoAdatpter;
import com.fscommunity.platform.provider.backoffice.vo.CommentVo;
import com.fscommunity.platform.service.CommentService;
import com.fscommunity.platform.service.UserInfoService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.page.PageResp;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description 评论controller
 * @Author jing.c
 * @Date: 18-3-28
 */
@RequestMapping("/fscommunity/comment")
@Controller
public class CommentController {
    private final static Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Resource
    CommentService commentService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/list")
    @JsonBody
    public PageResp list(HttpServletRequest request) {
        logger.info("list");
        List<Comment> rows = commentService.list(request.getParameter("condition"),
                new PageRequest(Integer.valueOf(request.getParameter("currentPage")), Integer.valueOf(request.getParameter("pageSize")))
        );
        int count = commentService.getCount();
        PageResp resp = new PageResp<Comment>(rows, count);
        return resp;
    }

    @RequestMapping("/getByArticleId")
    @JsonBody
    public PageResp getByArticleId(HttpServletRequest request) {
        logger.info("getByArticleId");
        List<Comment> rows = commentService.getByArticleId(request.getParameter("condition"),request.getParameter("target_id"),
                new PageRequest(Integer.valueOf(request.getParameter("currentPage")), Integer.valueOf(request.getParameter("pageSize")))
        );
        int count = commentService.getCount();
        PageResp resp = new PageResp<Comment>(rows, count);
        return resp;
    }

    @RequestMapping("/new")
    @JsonBody
    public void add(@RequestBody Comment comment) {
        logger.info("new");
        commentService.add(comment);
    }

    @RequestMapping("/info")
    @JsonBody
    public CommentVo info(HttpServletRequest request) {
        logger.info("info");
        Comment comment = commentService.selectById(request.getParameter("id"));
        return CommentVoAdatpter.adaptToCommentVo(comment);
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

    /**
     * 公开显示评论
     *
     * @param request
     */
    @RequestMapping("/display")
    @JsonBody
    public void display(HttpServletRequest request) {
        logger.info("display");
        commentService.displayCmmt(request.getParameter("id"));
    }
}
