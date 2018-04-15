package com.fscommunity.platform.persist.pojo;

import java.util.Date;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class NetVote {
    private int id;
    private int articleId;
    private NetVoteStatus voteStatus;
    private NetVoteSelectType selectType;
    private String startDate;
    private String endDate;
    private Date createTime;
    private Date updateTime;

    public NetVoteSelectType getSelectType() {
        return selectType;
    }

    public void setSelectType(NetVoteSelectType selectType) {
        this.selectType = selectType;
    }

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

    public NetVoteStatus getVoteStatus() {
        return voteStatus;
    }

    public void setVoteStatus(NetVoteStatus voteStatus) {
        this.voteStatus = voteStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
