package com.fscommunity.platform.provider.persist.pojo;

import java.io.Serializable;
import java.util.Date;

public class GiftExchInfo implements Serializable {
    private Integer id;

    private Integer giftId;

    private Integer userId;

    private String userName;

    private Date applyTime;

    private Integer exchState;

    private Date obtainTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

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
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GiftExchInfo other = (GiftExchInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGiftId() == null ? other.getGiftId() == null : this.getGiftId().equals(other.getGiftId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getExchState() == null ? other.getExchState() == null : this.getExchState().equals(other.getExchState()))
            && (this.getObtainTime() == null ? other.getObtainTime() == null : this.getObtainTime().equals(other.getObtainTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGiftId() == null) ? 0 : getGiftId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getExchState() == null) ? 0 : getExchState().hashCode());
        result = prime * result + ((getObtainTime() == null) ? 0 : getObtainTime().hashCode());
        return result;
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
        sb.append(", userName=").append(userName);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", exchState=").append(exchState);
        sb.append(", obtainTime=").append(obtainTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}