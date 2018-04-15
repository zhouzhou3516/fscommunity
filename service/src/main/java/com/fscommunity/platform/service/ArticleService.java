package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.ArticleMapper;
import com.fscommunity.platform.persist.pojo.Article;
import com.google.common.base.Preconditions;
import com.lxx.app.common.util.Base64Util;
import com.lxx.app.common.util.page.PageRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    public List<Article> list(String fuzzyName, PageRequest pageRequest) {
        List<Article> listArticle = articleMapper.list(fuzzyName,
                new RowBounds(pageRequest.getOffset(),pageRequest.getLimit())
        );

        if (CollectionUtils.isEmpty(listArticle)) {
            return Collections.EMPTY_LIST;
        }

        for(Article article: listArticle){
            article.setContent(Base64Util.decode(article.getContent()));
        }
        return listArticle;
    }

    public void add(Article article) {
        Preconditions.checkNotNull(article);
        article.setContent(Base64Util.encode(article.getContent()));
        articleMapper.insert(article);
    }

    public Article selectById(int id) {
        Article article = articleMapper.selectById(id);
        article.setContent(Base64Util.decode(article.getContent()));
        return article;
    }

    public List<Article> selectByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }

        List<Article> articles = articleMapper.selectByIds(ids);
        for (Article article : articles) {
            article.setContent(Base64Util.decode(article.getContent()));
        }
        return articles;
    }

    public void delById(int id) {
        articleMapper.deleteById(id);
    }

    public void updateById(Article article) {
        Preconditions.checkNotNull(article);
        article.setContent(Base64Util.encode(article.getContent()));
        articleMapper.updateById(article);
    }

    public void updateViewsById(int id,int views) {
        articleMapper.updateViewsById(id, views);
    }

    public void incrArtileViewsById(int id) {
        Article article = selectById(id);
        updateViewsById(id, article.getViews() + 1);
    }

    public int getCount(String fuzzyName) {
        return articleMapper.getCount(fuzzyName);
    }
}
