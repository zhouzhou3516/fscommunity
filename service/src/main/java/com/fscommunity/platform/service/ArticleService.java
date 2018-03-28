package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.ArticleMapper;
import com.fscommunity.platform.persist.pojo.Article;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Article> list(String condition) {
        return articleMapper.list(condition);
    }

    public void add(Article article) {
        Preconditions.checkNotNull(article);
        articleMapper.insert(article);
    }

    public Article selectById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        return articleMapper.selectById(Integer.valueOf(id));
    }

    public void delById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        articleMapper.deleteById(Integer.valueOf(id));
    }

    public void updateById(Article article) {
        Preconditions.checkNotNull(article);
        articleMapper.updateById(article);
    }
}
