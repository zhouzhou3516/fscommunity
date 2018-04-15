package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.ActivityInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.req.AddNewActivityReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrActivityDetailVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrActivityListItemVo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class ActivityAdaptor {
    public static ActivityInfo adaptToInfo(AddNewActivityReq req) {
        ActivityInfo info = new ActivityInfo();
        info.setArticleId(req.getArticleId());
        info.setActivityDesc(req.getDesc());
        info.setActivityTime(req.getActivityTime());
        info.setApplyStartTime(req.getApplyStartTime());
        info.setApplyEndTime(req.getApplyEndTime());
        info.setCostType(req.getCostType());
        info.setApplyCostCount(req.getCostCount());
        Date current = new Date();
        info.setCreateTime(current);
        info.setUpdateTime(current);
        return info;
    }

    public static MgrActivityListItemVo adaptListItemVo(ActivityInfo info, Article article) {
        MgrActivityListItemVo vo = new MgrActivityListItemVo();
        vo.setActivityId(info.getId());
        vo.setActivityName(article.getName());
        vo.setActivityTime(info.getActivityTime());
        vo.setApplyStartTime(info.getApplyStartTime());
        vo.setApplyEndTime(info.getApplyEndTime());
        return vo;
    }

    public static List<MgrActivityListItemVo> adaptListItemVos(List<ActivityInfo> infos, Map<Integer, Article> articleMap) {
        if (CollectionUtils.isEmpty(infos)) {
            return Collections.EMPTY_LIST;
        }

        return infos.stream().map(r->adaptListItemVo(r, articleMap.get(r.getArticleId()))).collect(Collectors.toList());
    }

    public static MgrActivityDetailVo adaptToDetailVo(ActivityInfo info, Article article) {
        MgrActivityDetailVo vo = new MgrActivityDetailVo();
        vo.setActivityId(info.getId());
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
