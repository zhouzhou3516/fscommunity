package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.ActivityInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.backoffice.adapter.ActivityAdaptor;
import com.fscommunity.platform.provider.backoffice.req.AddNewActivityReq;
import com.fscommunity.platform.provider.backoffice.req.UpdateActivityReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrActivityDetailVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrActivityListItemVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrActivityListVo;
import com.fscommunity.platform.service.ActivityService;
import com.fscommunity.platform.service.ArticleService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@RequestMapping("/fscommunity/man/activity")
@Controller
public class MgrActivityController {
    @Resource
    ActivityService activityService;

    @Resource
    ArticleService articleService;

    @RequestMapping("/add")
    @JsonBody
    public void addActivity(@RequestBody AddNewActivityReq req) {
        activityService.saveActivity(ActivityAdaptor.adaptToInfo(req));
    }

    @RequestMapping("/list")
    @JsonBody
    public MgrActivityListVo listActivity(int currentPage, int pageSize) {
        List<ActivityInfo> infos = activityService.queryByPage(new PageRequest(currentPage, pageSize));
        MgrActivityListVo vo = new MgrActivityListVo();
        if (CollectionUtils.isEmpty(infos)) {
            vo.setCount(0);
            vo.setItems(Collections.EMPTY_LIST);
        }

        List<Integer> alist = infos.stream().map(ActivityInfo::getArticleId).collect(Collectors.toList());
        List<Article> articles = articleService.selectByIds(alist);
        Map<Integer, Article> articleMap = articles.stream().collect(Collectors.toMap(Article::getId, r -> r));
        List<MgrActivityListItemVo> itemVos = ActivityAdaptor.adaptListItemVos(infos, articleMap);

        vo.setCount(activityService.countActivity());
        vo.setItems(itemVos);
        return vo;
    }

    @RequestMapping("/detail")
    @JsonBody
    public MgrActivityDetailVo queryDetail(int activityId) {
        ActivityInfo activityInfo = activityService.queryById(activityId);

        Article article = articleService.selectById(activityInfo.getArticleId());
        return ActivityAdaptor.adaptToDetailVo(activityInfo, article);
    }

    @RequestMapping("/update")
    @JsonBody
    public void updateActivity(@RequestBody UpdateActivityReq req) {
        ActivityInfo activityInfo = activityService.queryById(req.getActivityId());

        activityInfo.setArticleId(req.getArticleId());
        activityInfo.setActivityDesc(req.getActivityDesc());
        activityInfo.setActivityTime(req.getActivityTime());
        activityInfo.setApplyStartTime(req.getApplyStartTime());
        activityInfo.setApplyEndTime(req.getApplyEndTime());
        activityInfo.setApplyCostCount(req.getApplyCostCount());
        activityInfo.setCostType(req.getCostType());
        activityService.updateActivity(activityInfo);
    }
}
