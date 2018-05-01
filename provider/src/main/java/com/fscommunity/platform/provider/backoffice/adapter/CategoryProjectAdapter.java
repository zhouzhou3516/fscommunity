package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.CategoryProjectInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.req.AddCategoryProjectReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrCategoryProjectItemVo;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liqingzhou on 18/4/29
 */
public class CategoryProjectAdapter {

    public static CategoryProjectInfo adaptToInfo(AddCategoryProjectReq req) {
        CategoryProjectInfo info = new CategoryProjectInfo();
        info.setProjectType(req.getProjectType());
        info.setSubType(req.getSubType());
        info.setId(req.getId());
        info.setArticleId(req.getArticleId());
        info.setTitle(req.getTitle());
        return info;
    }

    public static MgrCategoryProjectItemVo adaptVo(CategoryProjectInfo info, Article article) {
        MgrCategoryProjectItemVo vo = new MgrCategoryProjectItemVo();
        vo.setId(info.getId());
        vo.setType(info.getSubType());
        vo.setArticleId(article.getId());
        vo.setArticleName(article.getName());
        vo.setTitle(info.getTitle());
        return vo;
    }

    public static List<MgrCategoryProjectItemVo> adaptItemVos(List<CategoryProjectInfo> categoryProjectInfoList,
            Map<Integer, Article> articleMap) {
        return categoryProjectInfoList.stream().map(item -> adaptVo(item, articleMap.get(item.getArticleId())))
                .collect(Collectors.toList());

    }

}
