package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.ActivityInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.wechat.vo.ActivityDetailVo;
import com.fscommunity.platform.provider.wechat.vo.ActivityListItemVo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class ActivityWechatAdaptor {
    public static ActivityListItemVo adaptToListItemVo(ActivityInfo info, Article article) {
        ActivityListItemVo vo = new ActivityListItemVo();
        vo.setActivityId(info.getId());
        vo.setActivityName(article.getName());
        vo.setActivityContent(article.getContent());
        vo.setTag(article.getTag());
        vo.setActivityTime(info.getActivityTime());
        vo.setViewCount(article.getViews());
        return vo;
    }

    public static List<ActivityListItemVo> adaptToListItemVos(List<ActivityInfo> infos, Map<Integer, Article> articleMap) {
        if (CollectionUtils.isEmpty(infos)) {
            return Collections.EMPTY_LIST;
        }

        return infos.stream().map(r->adaptToListItemVo(r, articleMap.get(r.getArticleId()))).collect(Collectors.toList());
    }

    public static ActivityDetailVo adaptToDetail(ActivityInfo info, Article article) {
        ActivityDetailVo vo = new ActivityDetailVo();
        vo.setArticleId(info.getArticleId());
        vo.setActivityName(article.getName());
        vo.setActivityContent(article.getContent());
        vo.setActivityDesc(info.getActivityDesc());
        vo.setActivityTime(info.getActivityTime());
        vo.setApplyStartTime(info.getApplyStartTime());
        vo.setApplyEndTime(info.getApplyEndTime());
        vo.setCostType(info.getCostType());
        vo.setApplyCostCount(info.getApplyCostCount());
        return vo;
    }
}
