package com.fscommunity.platform.provider.backoffice.vo;

import com.fscommunity.platform.persist.pojo.ActivityApplyCostType;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class MgrActivityDetailVo {

    private int activityId;

    private String activityName;
    private String activityContent;

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

    private List<ActivityParticipantVo> participantList = Lists.newArrayList();

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
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

    public List<ActivityParticipantVo> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(
            List<ActivityParticipantVo> participantList) {
        this.participantList = participantList;
    }
}
