package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.persist.pojo.AgendaRoomInfo;
import com.fscommunity.platform.persist.pojo.AnnouncementInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.backoffice.adapter.AgendaRoomAdapter;
import com.fscommunity.platform.provider.backoffice.req.AddAgendaRoomReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrAgendaRoomItemVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrAgendaRoomListVo;
import com.fscommunity.platform.provider.wechat.vo.BaseContentDetailVo;
import com.fscommunity.platform.provider.wechat.vo.BaseListItemVo;
import com.fscommunity.platform.provider.wechat.vo.BaseListVo;
import com.fscommunity.platform.provider.wechat.vo.BasesDetailVoAdapter;
import com.fscommunity.platform.provider.wechat.voadaptor.BaseListItemVoWechatAdapter;
import com.fscommunity.platform.service.AgendaRoomService;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.CommentService;
import com.fscommunity.platform.service.UserInfoService;
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
@RequestMapping("/fscommunity/wechat/agendaroom")
public class ArgendaRoomController {


    @Resource
    private AgendaRoomService agendaRoomService;
    @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;
    @Resource
    private UserInfoService userInfoService;

    @JsonBody
    @RequestMapping("list")
    public BaseListVo listActivity(int currentPage, int pageSize) {
        List<AgendaRoomInfo> infos = agendaRoomService.list(null, new PageRequest(currentPage, pageSize));
        BaseListVo vo = new BaseListVo();
        if (CollectionUtils.isEmpty(infos)) {
            vo.setCount(0);
            vo.setItems(Collections.EMPTY_LIST);
        }
        List<Integer> alist = infos.stream().map(AgendaRoomInfo::getArticleId).collect(Collectors.toList());
        List<Article> articles = articleService.selectByIds(alist);
        Map<Integer, Article> articleMap = articles.stream().collect(Collectors.toMap(Article::getId, r -> r));
        List<BaseListItemVo> itemVos = BaseListItemVoWechatAdapter.adaptToAgendaRoomListItemVos(infos, articleMap);
        vo.setCount(agendaRoomService.countAgendaRoom(null));
        vo.setItems(itemVos);
        return vo;
    }

    /**
     * @param id 议事厅id
     */
    @JsonBody
    @RequestMapping("detail")
    public BaseContentDetailVo detailVo(int id) {
        AgendaRoomInfo info =agendaRoomService.queryById(id);
        Article article = articleService.selectById(info.getArticleId());
        List<Comment> comments = commentService.getByArticleId(article.getId(), new PageRequest(1, 500));
        List<Integer> userIds = comments.stream().map(comment -> comment.getUserId()).distinct()
                .collect(Collectors.toList());
        List<UserSimpleInfo> simpleInfos = userInfoService.querySimpleUsersByIds(userIds);
        BaseContentDetailVo detailVo = BasesDetailVoAdapter.adaptAgendaRoom(info, article, comments, simpleInfos);
        //update article views
        articleService.updateViewsById(article.getId(),article.getViews()+1);
        return detailVo;
    }


}