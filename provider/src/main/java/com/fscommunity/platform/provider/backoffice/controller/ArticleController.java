package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.Gift;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.GiftExchService;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping("/list")
    @JsonBody
    public List<Article> list(HttpServletRequest request) {
        logger.info("list");
        return articleService.list(request.getParameter("condition"));
    }

    @RequestMapping("/new")
    @JsonBody
    public void add(@RequestBody Article article) {
        logger.info("new");
        articleService.add(article);
    }

    @RequestMapping("/info")
    @JsonBody
    public Article info(HttpServletRequest request) {
        logger.info("info");
        return articleService.selectById(request.getParameter("id"));
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
}
