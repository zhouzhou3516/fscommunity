package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.CategoryProjectInfo;
import com.fscommunity.platform.provider.wechat.vo.CommunityNewsVo;
import org.apache.commons.lang3.StringUtils;

/**
 * @author liqingzhou on 18/5/12
 */
public class CommunityNewsVoAdapter {

    public static CommunityNewsVo adapt(CategoryProjectInfo topNews, Article topArticle, int replyCount) {
        CommunityNewsVo vo = new CommunityNewsVo();
        vo.setArticleId(topNews.getArticleId());
        vo.setCommunityNewsId(topNews.getId());
        vo.setTitle(topNews.getTitle());
        vo.setType(topNews.getSubType());
        vo.setShortContent(StringUtils.abbreviate( topArticle.getContent(),200));
        vo.setCoverUrl(topArticle.getCoverUrl());
        vo.setViewCount(topArticle.getViews());
        vo.setPublishTime(topArticle.getPublishTime());
        vo.setReplyCount(replyCount);
        return vo;
    }


}
