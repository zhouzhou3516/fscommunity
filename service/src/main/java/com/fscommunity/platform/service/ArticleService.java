package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.ArticleMapper;
import com.fscommunity.platform.persist.pojo.Article;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.lxx.app.common.util.Base64Util;
import com.lxx.app.common.util.page.PageRequest;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
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

    public List<Article> list(String condition, PageRequest pageRequest) {

        List<Article> listArticle = articleMapper.list(condition,
                new RowBounds(pageRequest.getOffset(),pageRequest.getLimit())
        );
        for(Article article: listArticle){
            article.setContent(Base64Util.encode(article.getContent()));
        }
        return listArticle;
    }

    public void add(Article article) {
        Preconditions.checkNotNull(article);
        article.setContent(Base64Util.encode(article.getContent()));
        article.setViews(0);
        article.setPublishTime(new Date());
        article.setUpdateTime(new Date());
        articleMapper.insert(article);
    }

    public Article selectById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        Article article = articleMapper.selectById(Integer.valueOf(id));
        article.setContent(Base64Util.decode(article.getContent()));
        return article;
    }

    public void delById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        articleMapper.deleteById(Integer.valueOf(id));
    }

    public void updateById(Article article) {
        Preconditions.checkNotNull(article);
        article.setContent(Base64Util.encode(article.getContent()));
        articleMapper.updateById(article);
    }

    public void updateViewsById(String id,String views) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        articleMapper.updateViewsById(Integer.valueOf(id),Integer.valueOf(views));
    }

    public int getCount() {
        return articleMapper.getCount();
    }
}
