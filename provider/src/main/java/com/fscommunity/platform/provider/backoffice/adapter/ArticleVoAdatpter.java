package com.fscommunity.platform.provider.backoffice.adapter;


import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.req.AddNewArticleReq;
import com.fscommunity.platform.provider.backoffice.vo.ArticleVo;

import java.util.Date;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-4
 */
public class ArticleVoAdatpter {

    public static ArticleVo adaptToArticleVo(Article article, ManUser user) {
        ArticleVo vo = new ArticleVo(article);
        vo.setAuthorName(user.getRealName());
        return vo;
    }

    public static Article adaptToArticle(AddNewArticleReq req, int userid) {
        Article article = new Article();
        article.setAuthorId(userid);
        article.setName(req.getName());
        article.setType(req.getType());
        article.setContent(req.getContent());
        Date current = new Date();
        article.setPublishTime(current);
        article.setUpdateTime(current);
        article.setViews(0);
        return article;
    }
}
