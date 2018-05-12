package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.CategoryProjectInfo;
import com.fscommunity.platform.persist.pojo.ProjectSubTypeInfo;
import com.fscommunity.platform.persist.pojo.ProjectType;
import com.fscommunity.platform.provider.wechat.vo.BaseListItemVo;
import com.fscommunity.platform.provider.wechat.vo.ChannelSubTypeVo;
import com.fscommunity.platform.provider.wechat.vo.PartyWorkMainPageVo;
import com.fscommunity.platform.provider.wechat.voadaptor.ChannelSubTypeVoAdapter;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.CategoryProjectService;
import com.fscommunity.platform.service.ProjectSubTypeService;
import com.lxx.app.common.util.DateFormatUtil;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-05-12
 */
@RequestMapping("/fscommunity/wechat/party")
@Controller
public class PartyWorkController {

    @Resource
    private ProjectSubTypeService subTypeService;

    @Resource
    private CategoryProjectService categoryProjectService;

    @Resource
    private ArticleService articleService;

    /**
     * 办事指南
     * @return 指南列表
     */
    @JsonBody
    @RequestMapping("/guide")
    public List<ChannelSubTypeVo> types() {
        List<ProjectSubTypeInfo> list = subTypeService.list(ProjectType.PARTY_WORK.name());
        return ChannelSubTypeVoAdapter.adapt(list);
    }

    @JsonBody
    @RequestMapping("/index")
    public PartyWorkMainPageVo index() {
        PartyWorkMainPageVo vo = new PartyWorkMainPageVo();
        List<ProjectSubTypeInfo> types = subTypeService.list(ProjectType.PARTY_WORK.name());
        if (CollectionUtils.isEmpty(types)) {
            return vo;
        }

        //1. 办事指南
        vo.setGuides(types.stream().map(ProjectSubTypeInfo::getSubType)
            .collect(Collectors.toList()));

        //2. 热点追踪
        List<CategoryProjectInfo> infos = categoryProjectService.listTopByProjectType(ProjectType.PARTY_WORK.name());
        List<BaseListItemVo> vos = new ArrayList<>();
        for (CategoryProjectInfo info : infos) {
            Article article = articleService.selectById(info.getArticleId());
            if (article == null) {
                continue;
            }

            vos.add(buildItemFromArticle(article));
        }
        vo.setHotspots(vos);
        return vo;
    }

    private BaseListItemVo buildItemFromArticle(Article article) {
        BaseListItemVo vo = new BaseListItemVo();
        vo.setId(article.getId());
        vo.setTitle(article.getAuthorName());
        vo.setShortContent(article.getContent());
        vo.setPublishTime(DateFormatUtil.format4y2M2d(article.getPublishTime()));
        vo.setTag(article.getTag());
        vo.setCoverUrl(article.getCoverUrl());
        vo.setViewCount(article.getViews());
        return vo;
    }
}
