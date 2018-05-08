package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.AnnouncementInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.wechat.vo.BaseListItemVo;
import com.lxx.app.common.util.DateFormatUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;

/**
 * @author liqingzhou on 18/5/3
 */
public class BaseListItemVoWechatAdapter {


    public static List<BaseListItemVo> adaptToListItemVos(List<AnnouncementInfo> infos,
            Map<Integer, Article> articleMap) {
        return infos.stream().map(info -> adaptToListItemVo(info, articleMap.get(info.getArticleId())))
                .collect(Collectors.toList());
    }

    private static BaseListItemVo adaptToListItemVo(AnnouncementInfo info, Article article) {
        BaseListItemVo vo = new BaseListItemVo();
        vo.setId(info.getId());
        vo.setTitle(info.getTitle());
        vo.setArticleName(article.getName());
        vo.setCoverUrl(article.getCoverUrl());
        vo.setViewCount(article.getViews());
        vo.setPublishTime(DateFormatUtil.format4y2M2d(article.getPublishTime()));
        vo.setShortContent(StringUtils.abbreviate(article.getContent(), 200));
        vo.setTag(article.getTag());
        return vo;
    }
}
