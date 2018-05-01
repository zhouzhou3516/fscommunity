package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.AgendaRoomInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.adapter.AgendaRoomAdapter;
import com.fscommunity.platform.provider.backoffice.req.AddAgendaRoomReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrAgendaRoomItemVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrAgendaRoomListVo;
import com.fscommunity.platform.service.AgendaRoomService;
import com.fscommunity.platform.service.ArticleService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.util.pojo.FuzzyNameListQueryReq;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqingzhou on 18/4/29
 */
@Component
@RequestMapping("/fscommunity/man/agendaroom")
public class MgArgendaRoomController {


    @Resource
    private AgendaRoomService agendaRoomService;
    @Resource
    private ArticleService articleService;

    //both support update save
    @RequestMapping("/save")
    @JsonBody
    public void addPhone(@RequestBody AddAgendaRoomReq req) {
        Article article = articleService.selectById(req.getArticleId());
        if (article == null) {
            throw new BizException("文章链接不存在");
        }
        if(req.getId()<=0) {
            agendaRoomService.saveAgendaRoom(AgendaRoomAdapter.adaptToInfo(req));
        }else{
            agendaRoomService.updateAgendaRoom(AgendaRoomAdapter.adaptToInfo(req));
        }
    }

    @RequestMapping("/list")
    @JsonBody
    public MgrAgendaRoomListVo queryPhoneList(@RequestBody FuzzyNameListQueryReq req) {
        List<AgendaRoomInfo> agendaRoomInfoList = agendaRoomService
                .list(req.getFuzzyName(), new PageRequest(req.getCurrentPage(), req.getPageSize()));

        MgrAgendaRoomListVo vo = new MgrAgendaRoomListVo();
        if (CollectionUtils.isEmpty(agendaRoomInfoList)) {
            vo.setCount(0);
            vo.setItems(Collections.EMPTY_LIST);
            return vo;
        }
        List<Integer> aids = agendaRoomInfoList.stream().map(info -> Integer.valueOf(info.getArticleId()))
                .collect(Collectors.toList());
        List<Article> articleList = articleService.selectByIds(aids);
        Map<Integer, Article> articleMap = articleList.stream().collect(Collectors.toMap(a -> a.getId(), a -> a));
        List<MgrAgendaRoomItemVo> listVos = AgendaRoomAdapter.adaptItemVos(agendaRoomInfoList, articleMap);
        vo.setCount(agendaRoomService.countAgendaRoom(req.getFuzzyName()));
        vo.setItems(listVos);
        return vo;
    }


    @RequestMapping("/del")
    @JsonBody
    public void delPhone(int id) {
        agendaRoomService.del(id);
    }
}
