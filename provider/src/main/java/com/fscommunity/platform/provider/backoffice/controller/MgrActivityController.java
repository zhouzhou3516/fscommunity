package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.ActivityInfo;
import com.fscommunity.platform.persist.pojo.ApplyActivityInfo;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.backoffice.adapter.ActivityAdaptor;
import com.fscommunity.platform.provider.backoffice.req.ActivityListQueryReq;
import com.fscommunity.platform.provider.backoffice.req.AddNewActivityReq;
import com.fscommunity.platform.provider.backoffice.vo.ActivityParticipantVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrActivityDetailVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrActivityListItemVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrActivityListVo;
import com.fscommunity.platform.service.ActivityService;
import com.fscommunity.platform.service.ApplyActivityService;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.UserInfoService;
import com.google.common.collect.Lists;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @Resource
    ApplyActivityService applyActivityService;
    @Resource
    UserInfoService userInfoService;

    @RequestMapping("/add")
    @JsonBody
    public void addActivity(@RequestBody AddNewActivityReq req) {
        if (req.getId()<=0) {
            activityService.saveActivity(ActivityAdaptor.adaptToInfo(req));
        }else {
            ActivityInfo activityInfo = activityService.queryById(req.getId());
            activityInfo.setArticleId(req.getArticleId());
            activityInfo.setActivityDesc(req.getDesc());
            activityInfo.setActivityTime(req.getActivityTime());
            activityInfo.setApplyStartTime(req.getApplyStartTime());
            activityInfo.setApplyEndTime(req.getApplyEndTime());
            activityInfo.setApplyCostCount(req.getCostCount());
            activityInfo.setCostType(req.getCostType());
            activityService.updateActivity(activityInfo);
        }
    }

    @RequestMapping("/list")
    @JsonBody
    public MgrActivityListVo listActivity(@RequestBody ActivityListQueryReq req) {
        List<ActivityInfo> infos = activityService
                .list(req.getFuzzyName(), new PageRequest(req.getCurrentPage(), req.getPageSize()));
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

    @RequestMapping("/del")
    @JsonBody
    public String del(int activityId) {
        activityService.del(activityId);
        return "success";
    }

    @RequestMapping("/detail")
    @JsonBody
    public MgrActivityDetailVo queryDetail(int activityId) {
        ActivityInfo activityInfo = activityService.queryById(activityId);
        Article article = articleService.selectById(activityInfo.getArticleId());
        MgrActivityDetailVo vo = ActivityAdaptor.adaptToDetailVo(activityInfo, article);
        List<ApplyActivityInfo> apply = applyActivityService.queryByActivityId(activityId);
        if(CollectionUtils.isEmpty(apply)){
            vo.setParticipantList(Lists.newArrayList());
            return vo;
        }
        List<Integer> uIds = apply.stream().map(item->Integer.valueOf(item.getUserId())).collect(Collectors.toList());
        List<UserSimpleInfo> simpleInfos = userInfoService.querySimpleUsersByIds(uIds);
        vo.setParticipantList(ActivityAdaptor.adaptToParticipantVos(simpleInfos));
        return vo;
    }
}
