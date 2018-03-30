package com.fscommunity.platform.persist.pojo;

import java.io.Serializable;
import java.util.Date;

public class GiftExchInfo implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * gift id
     */
    private Integer giftId;

    /**
     * user id
     */
    private Integer userId;

    /**
     * 申请兑换时间
     */
    private Date applyTime;

    /**
     * 兑换数量
     */
    private Integer exchSum;

    /**
     * 兑换状态：0已兑换，1未兑换
     */
    private Integer exchState;

    /**
     * 实现兑换日期
     */
    private Date obtainTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGiftId() { return giftId; }

    public void setGiftId(Integer giftId) { this.giftId = giftId; }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getExchSum() { return exchSum; }

    public void setExchSum(Integer exchSum) { this.exchSum = exchSum; }

    public Integer getExchState() {
        return exchState;
    }

    public void setExchState(Integer exchState) {
        this.exchState = exchState;
    }

    public Date getObtainTime() {
        return obtainTime;
    }

    public void setObtainTime(Date obtainTime) {
        this.obtainTime = obtainTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", giftId=").append(giftId);
        sb.append(", userId=").append(userId);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", exchState=").append(exchState);
        sb.append(", obtainTime=").append(obtainTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}