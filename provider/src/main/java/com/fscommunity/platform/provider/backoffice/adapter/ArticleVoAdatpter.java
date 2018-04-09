package com.fscommunity.platform.provider.backoffice.adapter;


import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.provider.backoffice.vo.ArticleVo;
import com.fscommunity.platform.service.UserInfoService;

import javax.annotation.Resource;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-4
 */
public class ArticleVoAdatpter {

    public static ArticleVo adaptToArticleVo(Article article,UserInfo user) {
        ArticleVo vo = new ArticleVo(article);
        vo.setAuthorName(user.getRealName());
        return vo;
    }
}
