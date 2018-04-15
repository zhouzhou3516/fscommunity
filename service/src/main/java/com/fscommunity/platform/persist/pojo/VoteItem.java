package com.fscommunity.platform.persist.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 投票选项内容
 * @Author jing.c
 * @Date: 18-4-4
 */
public class VoteItem implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 所属在线投票id
     */
    private Integer voteId;

    /**
     * 选项内容
     */
    private String content;

    /**
     * 投票人列表, id用逗号隔开
     */
    private String voterList;

    /**
     * 投票人数
     */
    private Integer voterSum;

    private Date createTime;
    private Date updateTime;

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

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVoterList() {
        return voterList;
    }

    public void setVoterList(String voterList) {
        this.voterList = voterList;
    }

    public Integer getVoterSum() {
        return voterSum;
    }

    public void setVoterSum(Integer voterSum) {
        this.voterSum = voterSum;
    }

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", voteId=").append(voteId);
        sb.append(", content=").append(content);
        sb.append(", voterList=").append(voterList);
        sb.append(", voterSum=").append(voterSum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
