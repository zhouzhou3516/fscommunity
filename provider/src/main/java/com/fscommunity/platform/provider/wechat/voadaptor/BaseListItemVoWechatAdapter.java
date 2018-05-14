package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.AgendaRoomInfo;
import com.fscommunity.platform.persist.pojo.AnnouncementInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.CategoryProjectInfo;
import com.fscommunity.platform.provider.wechat.vo.BaseListItemVo;
import com.lxx.app.common.util.DateFormatUtil;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liqingzhou on 18/5/3
 */
public class BaseListItemVoWechatAdapter {

    /**
     * 通知公告
     */

    public static List<BaseListItemVo> adaptToAnnounceListItemVos(List<AnnouncementInfo> infos,
            Map<Integer, Article> articleMap) {
        return infos.stream().map(info -> adaptToListItemVo(info, articleMap.get(info.getArticleId())))
                .collect(Collectors.toList());
    }

    private static BaseListItemVo adaptToListItemVo(AnnouncementInfo info, Article article) {
        BaseListItemVo vo = new BaseListItemVo();
        vo.setTitle(info.getTitle());
        vo.setId(info.getId());
        vo.setArticleId(info.getArticleId());
        vo.setArticleName(article.getName());
        vo.setCoverUrl(article.getCoverUrl());
        vo.setViewCount(article.getViews());
        vo.setPublishTime(DateFormatUtil.format4y2M2d(article.getPublishTime()));
        vo.setShortContent(StringUtils.abbreviate(article.getContent(), 200));
        vo.setTag(article.getTag());
        return vo;
    }

    /**
     * 议事厅
     */
    public static List<BaseListItemVo> adaptToAgendaRoomListItemVos(List<AgendaRoomInfo> infos,
            Map<Integer, Article> articleMap) {
        return infos.stream().map(info -> adaptToListItemVo(info, articleMap.get(info.getArticleId())))
                .collect(Collectors.toList());
    }

    private static BaseListItemVo adaptToListItemVo(AgendaRoomInfo info, Article article) {
        BaseListItemVo vo = new BaseListItemVo();
        vo.setId(info.getArticleId());
        vo.setTitle(info.getTitle());
        vo.setCoverUrl(article.getCoverUrl());
        vo.setArticleName(article.getName());
        vo.setViewCount(article.getViews());
        vo.setPublishTime(DateFormatUtil.format4y2M2d(article.getPublishTime()));
        vo.setShortContent(StringUtils.abbreviate(article.getContent(), 200));
        vo.setTag(article.getTag());
        return vo;
    }

    public static List<BaseListItemVo> adaptToNewsListItemVos(List<CategoryProjectInfo> infos, Map<Integer, Article> articleMap) {
        return infos.stream().map(info -> adaptToNewsListItemVo(info, articleMap.get(info.getArticleId())))
                .collect(Collectors.toList());
    }

    private static BaseListItemVo adaptToNewsListItemVo(CategoryProjectInfo info, Article article) {
        BaseListItemVo vo = new BaseListItemVo();
        vo.setId(info.getId());
        vo.setArticleId(info.getArticleId());
        vo.setTitle(info.getTitle());
        vo.setArticleName(article.getName());
        vo.setCoverUrl(article.getCoverUrl());
        vo.setViewCount(article.getViews());
        vo.setPublishTime(DateFormatUtil.format4y2M2d(article.getPublishTime()));
        vo.setShortContent(StringUtils.abbreviate(article.getContent(), 200));
        vo.setTag(article.getTag());
        return vo;
    }

    /**
     * 社区资讯
     */

}
