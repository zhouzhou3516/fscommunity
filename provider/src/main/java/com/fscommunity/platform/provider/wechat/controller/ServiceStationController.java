package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.CategoryProjectInfo;
import com.fscommunity.platform.persist.pojo.ProjectSubTypeInfo;
import com.fscommunity.platform.persist.pojo.ProjectType;
import com.fscommunity.platform.provider.backoffice.adapter.ArticleVoAdatpter;
import com.fscommunity.platform.provider.backoffice.vo.ArticleVo;
import com.fscommunity.platform.provider.wechat.req.PartyWorkArticleListReq;
import com.fscommunity.platform.provider.wechat.vo.BaseListItemVo;
import com.fscommunity.platform.provider.wechat.vo.LabelVo;
import com.fscommunity.platform.provider.wechat.vo.PartyWorkArListVo;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.CategoryProjectService;
import com.fscommunity.platform.service.ProjectSubTypeService;
import com.fscommunity.platform.service.UserInfoService;
import com.lxx.app.common.util.DateFormatUtil;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liqingzhou on 18/5/3
 */
@Component
@RequestMapping("/fscommunity/wechat/servicestation")
public class ServiceStationController {

    @Resource
    private CategoryProjectService categoryProjectService;
    @Resource
    private ProjectSubTypeService subTypeService;
    @Resource
    private ArticleService articleService;
    @Resource
    private UserInfoService userInfoService;

    @JsonBody
    @RequestMapping("/index")
    public List<LabelVo> types() {
        List<LabelVo> vos = new ArrayList<>();
        List<ProjectSubTypeInfo> list = subTypeService.list(ProjectType.SERVICE_STATION.name());
        if (CollectionUtils.isEmpty(list)) {
            return vos;
        }
        for (ProjectSubTypeInfo typeInfo : list) {
            LabelVo vo = new LabelVo();
            vo.setText(typeInfo.getSubType());
            vo.setValue(typeInfo.getSubType());
            vos.add(vo);
        }
        return vos;
    }

    @JsonBody
    @RequestMapping("/list")
    public PartyWorkArListVo listSubTypeArticleList(@RequestBody PartyWorkArticleListReq req) {
        PartyWorkArListVo vo = new PartyWorkArListVo();
        List<CategoryProjectInfo> list = categoryProjectService.list(ProjectType.SERVICE_STATION.name(), req.getSubType(),
                new PageRequest(req.getCurrentPage(), req.getPageSize()));

        if (CollectionUtils.isEmpty(list)) {
            return vo;
        }

        List<BaseListItemVo> vos = new ArrayList<>();
        for (CategoryProjectInfo info : list) {
            Article article = articleService.selectById(info.getArticleId());
            if (article == null) {
                continue;
            }
            vos.add(buildItemFromArticle(article));
        }

        vo.setList(vos);
        vo.setTotalCount(categoryProjectService.countCategoryProject(ProjectType.SERVICE_STATION.name(),
                req.getSubType()));
        return vo;
    }

    /**
     * @param id 服务工作站内容id
     */
//    @JsonBody
//    @RequestMapping("detail")
//    public BaseContentDetailVo detailVo(int id) {
//        /Article article = articleService.selectById(id);
//        //增加一次阅读数
//        articleService.incrArtileViewsById(id);
//        return ArticleVoAdatpter.adaptToArticleVo(article);
//    }

    @RequestMapping("/detail")
    @JsonBody
    public ArticleVo info(int id) {
        Article article = articleService.selectById(id);
        //增加一次阅读数
        articleService.incrArtileViewsById(id);
        return ArticleVoAdatpter.adaptToArticleVo(article);
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
        vo.setArticleId(article.getId());
        return vo;
    }

}
