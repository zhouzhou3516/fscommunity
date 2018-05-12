package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.common.pojo.SessionUserInfo;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.persist.pojo.ActivityApplyCostType;
import com.fscommunity.platform.persist.pojo.ActivityInfo;
import com.fscommunity.platform.persist.pojo.ApplyActivityInfo;
import com.fscommunity.platform.persist.pojo.ApplyStatus;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.provider.wechat.vo.ActivityDetailVo;
import com.fscommunity.platform.provider.wechat.vo.ActivityListItemVo;
import com.fscommunity.platform.provider.wechat.vo.ActivityListVo;
import com.fscommunity.platform.provider.wechat.voadaptor.ActivityWechatAdaptor;
import com.fscommunity.platform.service.ActivityService;
import com.fscommunity.platform.service.ApplyActivityService;
import com.fscommunity.platform.service.ArticleService;
import com.lxx.app.common.util.DateFormatUtil;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@RequestMapping("/fscommunity/wechat/activity")
@Controller
public class ActivityController {

    @Resource
    ActivityService activityService;

    @Resource
    ArticleService articleService;

    @Resource
    ApplyActivityService applyActivityService;
    @Resource
    SessionHolder sessionHolder;

    @RequestMapping("/list")
    @JsonBody
    public ActivityListVo listActivity(int currentPage, int pageSize) {
        List<ActivityInfo> infos = activityService.queryByPage(new PageRequest(currentPage, pageSize));

        ActivityListVo vo = new ActivityListVo();
        if (CollectionUtils.isEmpty(infos)) {
            vo.setCount(0);
            vo.setItems(Collections.EMPTY_LIST);
        }

        List<Integer> alist = infos.stream().map(ActivityInfo::getArticleId).collect(Collectors.toList());
        List<Article> articles = articleService.selectByIds(alist);
        Map<Integer, Article> articleMap = articles.stream().collect(Collectors.toMap(Article::getId, r -> r));

        List<ActivityListItemVo> itemVos = ActivityWechatAdaptor.adaptToListItemVos(infos, articleMap);
        vo.setCount(activityService.countActivity());
        vo.setItems(itemVos);
        return vo;
    }

    @RequestMapping("/detail")
    @JsonBody
    public ActivityDetailVo queryDetail(int activityId) {
        ActivityInfo activityInfo = activityService.queryById(activityId);
        Article article = articleService.selectById(activityInfo.getArticleId());
        //update article views
        articleService.updateViewsById(article.getId(),article.getViews()+1);
        return ActivityWechatAdaptor.adaptToDetail(activityInfo, article);
    }

    @RequestMapping("/apply")
    @JsonBody
    public void apply(int activityId) {
        SessionUserInfo info = sessionHolder.currentUser();
        ApplyActivityInfo exist = applyActivityService.queryByActivityIdAndUid(activityId, info.getUserId());
        if (exist != null) {
            throw new BizException("您已经报名成功");
        }

        ActivityInfo activityInfo = activityService.queryById(activityId);
        Date current = new Date();
        if (current.before(DateFormatUtil.parse4y2M2d(activityInfo.getApplyStartTime())) ||
                current.after(DateFormatUtil.parse4y2M2d(activityInfo.getApplyEndTime()))) {
            throw new BizException("不在有效报名时间内");
        }

        if (activityInfo.getCostType() == ActivityApplyCostType.COST_COIN) {
            if (activityInfo.getApplyCostCount() > info.getGoldCoin()) {
                throw new BizException("金币不够，无法报名");
            }
        }

        if (activityInfo.getCostType() == ActivityApplyCostType.COST_INTERVAL) {
            if (activityInfo.getApplyCostCount() > info.getIntegral()) {
                throw new BizException("积分不够，无法报名");
            }
        }
        applyActivityService.saveApply(buildApply(activityId, info));
    }

    private ApplyActivityInfo buildApply(int activityId, SessionUserInfo info) {
        ApplyActivityInfo ainfo = new ApplyActivityInfo();
        ainfo.setActivityId(activityId);
        ainfo.setApplyStatus(ApplyStatus.AUTH_SUCC);
        ainfo.setUserId(info.getUserId());
        Date current = new Date();
        ainfo.setCreateTime(current);
        ainfo.setUpdateTime(current);
        return ainfo;
    }
}
