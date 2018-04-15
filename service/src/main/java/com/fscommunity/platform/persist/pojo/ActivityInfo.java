package com.fscommunity.platform.persist.pojo;

import java.util.Date;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class ActivityInfo {
    private int id;
    private int articleId;

    /**
     * 活动一句话描述
     */
    private String activityDesc;

    /**
     * 活动时间
     */
    private String activityTime;

    /**
     * 报名开始时间
     */
    private String applyStartTime;

    /**
     * 报名结束时间
     */
    private String applyEndTime;

    /**
     * 报名需要支付的类型
     */
    private ActivityApplyCostType costType;

    /**
     * 支付数量
     */
    private int applyCostCount;

    private Date createTime;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
