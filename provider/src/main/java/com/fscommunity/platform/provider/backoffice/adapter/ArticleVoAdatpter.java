package com.fscommunity.platform.provider.backoffice.adapter;


import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.req.AddNewArticleReq;
import com.fscommunity.platform.provider.backoffice.vo.ArticleListItemVo;
import com.fscommunity.platform.provider.backoffice.vo.ArticleVo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-4
 */
public class ArticleVoAdatpter {

    public static ArticleVo adaptToArticleVo(Article article, ManUser user) {
        ArticleVo vo = new ArticleVo(article);
        vo.setAuthorName(article.getAuthorName());
        vo.setCoverUrl(article.getCoverUrl());
        vo.setTag(article.getTag());
        return vo;
    }

    public static Article adaptToArticle(AddNewArticleReq req, int userid) {
        Article article = new Article();
        article.setAuthorId(userid);
        article.setName(req.getName());
        article.setContent(req.getContent());
        Date current = new Date();
        article.setPublishTime(current);
        article.setUpdateTime(current);
        article.setViews(0);
        article.setTag(req.getTag());
        article.setAuthorName(req.getAuthor());
        article.setCoverUrl(req.getCoverUrl());
        return article;
    }

    public static ArticleListItemVo adaptToVo(Article article) {
        ArticleListItemVo vo = new ArticleListItemVo();
        vo.setArticleId(article.getId());
        vo.setArticleName(article.getName());
        vo.setArticleAuthor(article.getAuthorName());
        vo.setReplyCount(0);
        vo.setViewCount(article.getViews());
        vo.setTag(article.getTag());
        vo.setCoverUrl(article.getCoverUrl());
        return vo;
    }

    public static List<ArticleListItemVo> adaptToVos(List<Article> articles) {
        if (CollectionUtils.isEmpty(articles)) {
            return Collections.EMPTY_LIST;
        }
        return articles.stream().map(ArticleVoAdatpter::adaptToVo).collect(Collectors.toList());
    }
}
