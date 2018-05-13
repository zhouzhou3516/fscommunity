package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.CategoryProjectInfo;
import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.persist.pojo.ProjectSubTypeInfo;
import com.fscommunity.platform.persist.pojo.ProjectType;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.wechat.vo.BaseContentDetailVo;
import com.fscommunity.platform.provider.wechat.vo.BaseListItemVo;
import com.fscommunity.platform.provider.wechat.vo.BaseListVo;
import com.fscommunity.platform.provider.wechat.vo.BasesDetailVoAdapter;
import com.fscommunity.platform.provider.wechat.vo.CommunityNewsListVo;
import com.fscommunity.platform.provider.wechat.vo.CommunityNewsVo;
import com.fscommunity.platform.provider.wechat.voadaptor.BaseListItemVoWechatAdapter;
import com.fscommunity.platform.provider.wechat.voadaptor.CommunityNewsVoAdapter;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.CategoryProjectService;
import com.fscommunity.platform.service.CommentService;
import com.fscommunity.platform.service.ProjectSubTypeService;
import com.fscommunity.platform.service.UserInfoService;
import com.google.common.collect.Lists;
import com.lxx.app.common.util.Safes;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqingzhou on 18/5/2
 */
@Controller
@RequestMapping("/fscommunity/wechat/communitynews")
public class CommunityNewsController {

    @Resource
    private CategoryProjectService categoryProjectService;
    @Resource
    private ProjectSubTypeService projectSubTypeService;
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/list")
    public CommunityNewsListVo list(int currentPage, int pageSize) {
        List<CategoryProjectInfo> list = categoryProjectService.listSticky(
                ProjectType.CONSULT.name(), new PageRequest(currentPage, pageSize));
        Map<String, List<CategoryProjectInfo>> map = Safes.of(list).stream()
                .collect(Collectors.groupingBy(CategoryProjectInfo::getSubType));

        List<ProjectSubTypeInfo> typeInfoList = projectSubTypeService.list(ProjectType.CONSULT.name());
        List<CommunityNewsVo> voList = Lists.newArrayList();

        Safes.of(typeInfoList).stream().forEach(type -> {
            CommunityNewsVo vo = findTopNews(type.getSubType(), map.get(type));
            if (vo != null) {
                voList.add(vo);
            }
        });
        CommunityNewsListVo listVo = new CommunityNewsListVo();
        listVo.setList(voList);
        return listVo;
    }

    @JsonBody
    @RequestMapping("listByType")
    public BaseListVo listByType( String type, int currentPage, int pageSize) {
        List<CategoryProjectInfo> infos = categoryProjectService
                .list(ProjectType.CONSULT.name(), type, new PageRequest(currentPage, pageSize));
        BaseListVo vo = new BaseListVo();
        if (CollectionUtils.isEmpty(infos)) {
            vo.setCount(0);
            vo.setItems(Collections.EMPTY_LIST);
        }
        List<Integer> alist = infos.stream().map(CategoryProjectInfo::getArticleId).collect(Collectors.toList());
        List<Article> articles = articleService.selectByIds(alist);
        Map<Integer, Article> articleMap = articles.stream().collect(Collectors.toMap(Article::getId, r -> r));
        List<BaseListItemVo> itemVos = BaseListItemVoWechatAdapter.adaptToNewsListItemVos(infos, articleMap);
        vo.setCount(categoryProjectService.countCategoryProject(ProjectType.CONSULT.name(), type));
        vo.setItems(itemVos);
        return vo;
    }

    private CommunityNewsVo findTopNews(String type, List<CategoryProjectInfo> infos) {

        List<Integer> aIds = Safes.of(infos).stream().map(info -> info.getArticleId()).collect(Collectors.toList());
        List<Article> articles = articleService.selectByIds(aIds);
        Optional<Article> articleOptional = articles.stream().max((o1, o2) -> o2.getViews() - o1.getViews());
        CategoryProjectInfo topNews = null;
        Article topArticle = null;
        if (articleOptional.isPresent()) {
            topNews = infos.stream().filter(info -> info.getArticleId() == articleOptional.get().getId()).findFirst()
                    .get();
            topArticle = articleOptional.get();
        } else {
            List<CategoryProjectInfo> list = categoryProjectService
                    .list(ProjectType.CONSULT.name(), type, new PageRequest(1, 1));
            if (CollectionUtils.isNotEmpty(list)) {
                topNews = list.get(0);
                topArticle = articleService.selectById(topNews.getArticleId());
            }
        }

        if (topNews == null) {
            return null;
        }
        int count = commentService.getCount(topArticle.getId());
        return CommunityNewsVoAdapter.adapt(topNews, topArticle, count);
    }

    /**
     * 社区咨询id
     */
    @JsonBody
    @RequestMapping("detail")
    public BaseContentDetailVo detailVo(int id) {
        CategoryProjectInfo info = categoryProjectService.queryById(id);
        Article article = articleService.selectById(info.getArticleId());
        List<Comment> comments = commentService.getByArticleId(article.getId(), new PageRequest(1, 500));
        List<Integer> userIds = comments.stream().map(comment -> comment.getUserId()).distinct()
                .collect(Collectors.toList());
        List<UserSimpleInfo> simpleInfos = userInfoService.querySimpleUsersByIds(userIds);
        BaseContentDetailVo detailVo = BasesDetailVoAdapter.adaptNews(info, article, comments, simpleInfos);
        //update article views
        articleService.updateViewsById(article.getId(), article.getViews() + 1);
        return detailVo;
    }
}
