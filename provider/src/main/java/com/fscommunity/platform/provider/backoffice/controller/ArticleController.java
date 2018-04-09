package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.adapter.ArticleVoAdatpter;
import com.fscommunity.platform.provider.backoffice.vo.ArticleVo;
import com.fscommunity.platform.service.ArticleService;
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
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
@RequestMapping("/fscommunity/article")
@Controller
public class ArticleController {
    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Resource
    ArticleService articleService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/list")
    @JsonBody
    public PageResp list(HttpServletRequest request) {
        logger.info("list");
        List<Article> rows = articleService.list(request.getParameter("condition"),
                new PageRequest(Integer.valueOf(request.getParameter("currentPage")), Integer.valueOf(request.getParameter("pageSize")))
        );
        int count = articleService.getCount();
        PageResp resp = new PageResp<Article>(rows, count);
        return resp;
    }

    @RequestMapping("/new")
    @JsonBody
    public void add(@RequestBody Article article) {
        logger.info("new");
        articleService.add(article);
    }

    @RequestMapping("/info")
    @JsonBody
    public ArticleVo info(HttpServletRequest request) {
        logger.info("info");
        Article article = articleService.selectById(request.getParameter("id"));
        return ArticleVoAdatpter.adaptToArticleVo(article,userInfoService.queryUserById(article.getAuthorId()));
    }

    @RequestMapping("/update")
    @JsonBody
    public void update(@RequestBody Article article) {
        logger.info("update");
        articleService.updateById(article);

    }

    @RequestMapping("/del")
    @JsonBody
    public void delete(HttpServletRequest request) {
        logger.info("delete");
        articleService.delById(request.getParameter("id"));
    }

    /**
     * 更新文章浏览量
     *
     * @param request
     */
    @RequestMapping("/updateViews")
    @JsonBody
    public void updateViews(HttpServletRequest request) {
        logger.info("updateViewsById");
        articleService.updateViewsById(request.getParameter("id"),request.getParameter("views"));
    }
}
