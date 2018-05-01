package com.fscommunity.platform.provider.backoffice.vo;

import com.fscommunity.platform.persist.pojo.ActivityApplyCostType;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class MgrActivityListItemVo {

    private int id;//activityId
    private int articleId;
    private String articleName;
    private String activityName;
    private String activityTime;
    private String applyStartTime;
    private String applyEndTime;

    /**
     * 报名需要支付的类型
     */
    private ActivityApplyCostType costType;
    private String costTypeDesc;

    /**
     * 支付数量
     */
    private int applyCostCount;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public String getApplyStartTime() {
        return applyStartTime;
    }

    public void setApplyStartTime(String applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    public String getApplyEndTime() {
        return applyEndTime;
    }

    public void setApplyEndTime(String applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    public ActivityApplyCostType getCostType() {
        return costType;
    }

    public void setCostType(ActivityApplyCostType costType) {
        this.costType = costType;
    }

    public int getApplyCostCount() {
        return applyCostCount;
    }

    public void setApplyCostCount(int applyCostCount) {
        this.applyCostCount = applyCostCount;
    }

    public String getCostTypeDesc() {
        return costTypeDesc;
    }

    public void setCostTypeDesc(String costTypeDesc) {
        this.costTypeDesc = costTypeDesc;
    }
}
