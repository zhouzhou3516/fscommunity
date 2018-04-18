package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.adapter.ArticleVoAdatpter;
import com.fscommunity.platform.provider.backoffice.req.AddNewArticleReq;
import com.fscommunity.platform.provider.backoffice.req.ArticleListQueryReq;
import com.fscommunity.platform.provider.backoffice.req.UpdateArticleReq;
import com.fscommunity.platform.provider.backoffice.vo.ArticleListItemVo;
import com.fscommunity.platform.provider.backoffice.vo.ArticleVo;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.ManUserService;
import com.google.common.base.Strings;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.page.PageResp;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
@RequestMapping("/fscommunity/man/article")
@Controller
public class ArticleController {
    private final static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Resource
    ArticleService articleService;

    @Resource
    ManUserService manUserService;

    @RequestMapping("/list")
    @JsonBody
    public PageResp list(@RequestBody ArticleListQueryReq req) {
        List<Article> rows = articleService.list(req.getFuzzyName(),
                new PageRequest(req.getCurrentPage(), req.getPageSize())
        );
        int count = articleService.getCount(req.getFuzzyName());
        PageResp<ArticleListItemVo> resp = new PageResp<>();
        resp.setTotalCount(count);
        resp.setRows(ArticleVoAdatpter.adaptToVos(rows));
        return resp;
    }

    @RequestMapping("/new")
    @JsonBody
    public void add(@RequestBody AddNewArticleReq req) {
        //todo 获取当前登录用户
        if (req.getId() == 0) {
            articleService.add(ArticleVoAdatpter.adaptToArticle(req, 1));
        } else {
            Article old = articleService.selectById(req.getId());
            old.setCoverUrl(req.getCoverUrl());
            old.setAuthorName(req.getAuthor());
            old.setTag(req.getTag());
            old.setContent(req.getContent());
            old.setName(req.getName());
            articleService.add(old);
        }
    }

    @RequestMapping("/info")
    @JsonBody
    public ArticleVo info(int id) {
        Article article = articleService.selectById(id);

        //增加一次阅读数
        articleService.incrArtileViewsById(id);
        return ArticleVoAdatpter.adaptToArticleVo(article,manUserService.queryUserById(article.getAuthorId()));
    }

    @RequestMapping("/update")
    @JsonBody
    public void update(@RequestBody UpdateArticleReq article) {
        Article old = articleService.selectById(article.getId());
        if (old == null) {
            return;
        }

        if (!Strings.isNullOrEmpty(article.getArticleName())) {
            old.setName(article.getArticleName());
        }
        old.setContent(article.getContent());
        articleService.updateById(old);
    }

    @RequestMapping("/del")
    @JsonBody
    public void delete(int id) {
        articleService.delById(id);
    }

//    /**
//     * 更新文章浏览量（更新文章浏览量，哪有前端接口调用的）
//     *
//     * @param request
//     */
//    @RequestMapping("/updateViews")
//    @JsonBody
//    public void updateViews(HttpServletRequest request) {
//        logger.info("updateViewsById");
//        articleService.updateViewsById(request.getParameter("id"),request.getParameter("views"));
//    }
}
