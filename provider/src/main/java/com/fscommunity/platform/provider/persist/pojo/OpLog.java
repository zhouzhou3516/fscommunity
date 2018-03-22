package com.fscommunity.platform.provider.persist.pojo;

import java.io.Serializable;
import java.util.Date;

public class OpLog implements Serializable {
    private Integer opId;

    private String userName;

    private Integer targetId;

    private String targetType;

    private String opType;

    private Date opTime;

    private static final long serialVersionUID = 1L;

    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType == null ? null : targetType.trim();
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType == null ? null : opType.trim();
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
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
        OpLog other = (OpLog) that;
        return (this.getOpId() == null ? other.getOpId() == null : this.getOpId().equals(other.getOpId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
            && (this.getTargetType() == null ? other.getTargetType() == null : this.getTargetType().equals(other.getTargetType()))
            && (this.getOpType() == null ? other.getOpType() == null : this.getOpType().equals(other.getOpType()))
            && (this.getOpTime() == null ? other.getOpTime() == null : this.getOpTime().equals(other.getOpTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOpId() == null) ? 0 : getOpId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getTargetType() == null) ? 0 : getTargetType().hashCode());
        result = prime * result + ((getOpType() == null) ? 0 : getOpType().hashCode());
        result = prime * result + ((getOpTime() == null) ? 0 : getOpTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", opId=").append(opId);
        sb.append(", userName=").append(userName);
        sb.append(", targetId=").append(targetId);
        sb.append(", targetType=").append(targetType);
        sb.append(", opType=").append(opType);
        sb.append(", opTime=").append(opTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}