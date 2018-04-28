package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;
import java.util.Date;

/**
 * @author lixiaoxiong
 * @version 2018-03-27
 */
public class UserSignInfo extends Bean {
    private int id;

    /**
     * 用户id
     */
    private int userId;

    /**
     * 签到日期
     */
    private String dayTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否连续签到
     */
    private boolean continuous;

    /**
     * 完成连续签到的天数
     */
    private int finishConDays;

    /**
     * 获得积分
     */
    private int earnIntegral;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
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

    public boolean isContinuous() {
        return continuous;
    }

    public void setContinuous(boolean continuous) {
        this.continuous = continuous;
    }

    public int getEarnIntegral() {
        return earnIntegral;
    }

    public void setEarnIntegral(int earnIntegral) {
        this.earnIntegral = earnIntegral;
    }

    public int getFinishConDays() {
        return finishConDays;
    }

    public void setFinishConDays(int finishConDays) {
        this.finishConDays = finishConDays;
    }
}
