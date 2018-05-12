package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.CategoryProjectInfo;
import com.fscommunity.platform.persist.pojo.ProjectSubTypeInfo;
import com.fscommunity.platform.persist.pojo.ProjectType;
import com.fscommunity.platform.provider.wechat.vo.CommunityNewsListVo;
import com.fscommunity.platform.provider.wechat.vo.CommunityNewsVo;
import com.fscommunity.platform.provider.wechat.voadaptor.CommunityNewsVoAdapter;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.CategoryProjectService;
import com.fscommunity.platform.service.CommentService;
import com.fscommunity.platform.service.ProjectSubTypeService;
import com.google.common.collect.Lists;
import com.lxx.app.common.util.Safes;
import com.lxx.app.common.util.page.PageRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqingzhou on 18/5/2
 */
@Component
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

    @RequestMapping("/list")
    public CommunityNewsListVo list(int currentPage, int pageSize) {
        List<CategoryProjectInfo> list = categoryProjectService.listSticky(
                ProjectType.CONSULT.name(), new PageRequest(currentPage, pageSize));
        Map<String, List<CategoryProjectInfo>> map = Safes.of(list).stream()
                .collect(Collectors.groupingBy(CategoryProjectInfo::getSubType));

        List<ProjectSubTypeInfo> typeInfoList = projectSubTypeService.list(ProjectType.CONSULT.name());
        List<CommunityNewsVo> voList = Lists.newArrayList();
        /*Safes.of(typeInfoList).stream().forEach(type->{
            findTopNews(type,)
        });*/

        return null;
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
        return CommunityNewsVoAdapter.adapt(topNews, topArticle,100);
    }
}
