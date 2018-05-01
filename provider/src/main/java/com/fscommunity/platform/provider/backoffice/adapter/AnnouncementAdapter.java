package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.AnnouncementInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.req.AddAnnounceReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrAnnouncementItemVo;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liqingzhou on 18/4/29
 */
public class AnnouncementAdapter {

    public static AnnouncementInfo adaptToInfo(AddAnnounceReq req) {
        AnnouncementInfo info = new AnnouncementInfo();
        info.setId(req.getId());
        info.setArticleId(req.getArticleId());
        info.setTitle(req.getTitle());

        return info;
    }

    public static MgrAnnouncementItemVo adaptVo(AnnouncementInfo info, Article article) {
        MgrAnnouncementItemVo vo = new MgrAnnouncementItemVo();
        vo.setId(info.getId());
        vo.setArticleId(article.getId());
        vo.setArticleName(article.getName());
        vo.setTitle(info.getTitle());
        return vo;
    }

    public static List<MgrAnnouncementItemVo> adaptItemVos(List<AnnouncementInfo> announcementInfoList,
            Map<Integer, Article> articleMap) {
        return announcementInfoList.stream().map(item -> adaptVo(item, articleMap.get(item.getArticleId())))
                .collect(Collectors.toList());

    }
}
