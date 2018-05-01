package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.AgendaRoomInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.req.AddAgendaRoomReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrAgendaRoomItemVo;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liqingzhou on 18/4/29
 */
public class AgendaRoomAdapter {

    public static AgendaRoomInfo adaptToInfo(AddAgendaRoomReq req) {
        AgendaRoomInfo info = new AgendaRoomInfo();
        info.setId(req.getId());
        info.setArticleId(req.getArticleId());
        info.setTitle(req.getTitle());

        return info;
    }

    public static MgrAgendaRoomItemVo adaptVo(AgendaRoomInfo info, Article article) {
        MgrAgendaRoomItemVo vo = new MgrAgendaRoomItemVo();
        vo.setId(info.getId());
        vo.setArticleId(article.getId());
        vo.setArticleName(article.getName());
        vo.setTitle(info.getTitle());
        return vo;
    }

    public static List<MgrAgendaRoomItemVo> adaptItemVos(List<AgendaRoomInfo> announcementInfoList,
            Map<Integer, Article> articleMap) {
        return announcementInfoList.stream().map(item -> adaptVo(item, articleMap.get(item.getArticleId())))
                .collect(Collectors.toList());

    }
}
