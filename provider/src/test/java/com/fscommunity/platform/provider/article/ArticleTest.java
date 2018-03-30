package com.fscommunity.platform.provider.article;

import com.fscommunity.platform.persist.dao.ArticleMapper;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.GiftExchInfo;
import com.fscommunity.platform.provider.BaseJunit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
public class ArticleTest extends BaseJunit {
    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void listTest() {
        List<Article> articleList = articleMapper.list(null);
        for(Article article:articleList)
            System.out.println(article.toString());
        assertTrue(articleList.size() > 0);
    }

    @Test
    public void getTest() {
        Article article = articleMapper.selectById(3);
        System.out.println(article.toString());
    }

    @Test
    public void insertTest() {
        Article article=new Article();
        article.setUserId(1);
        article.setName("fedwa");
        article.setContent("反对萨风格为");
        int rslt = articleMapper.insert(article);
        System.out.println(rslt);
    }

    @Test
    public void updateTest() {
        Article article=new Article();
        article.setId(3);
        article.setUserId(1);
        article.setName("FDSA");
        article.setContent("faewtreqw");
        int rslt = articleMapper.updateById(article);
        System.out.println(rslt);
    }

    @Test
    public void delTest() {
        int rslt = articleMapper.deleteById(3);
        System.out.println(rslt);
    }
}
