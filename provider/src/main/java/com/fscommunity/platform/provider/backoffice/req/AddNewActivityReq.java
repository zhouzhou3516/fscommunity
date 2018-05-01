package com.fscommunity.platform.provider.backoffice.req;

import com.fscommunity.platform.persist.pojo.ActivityApplyCostType;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class AddNewActivityReq {
    private int id;
    private int articleId;
    private String desc;
    private String activityTime;
    private String applyStartTime="";
    private String applyEndTime="";
    private ActivityApplyCostType costType;
    private int costCount;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public int getCostCount() {
        return costCount;
    }

    public void setCostCount(int costCount) {
        this.costCount = costCount;
    }
}
