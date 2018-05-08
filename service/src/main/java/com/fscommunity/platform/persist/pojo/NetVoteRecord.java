package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;
import java.util.Date;

/**
 * @Description 在线投票记录
 * @Author jing.c
 * @Date: 18-4-4
 */
public class NetVoteRecord extends Bean {

    /**
     * 主键id
     */
    private Integer id;
    private Integer voteId;
    private Integer voteItemId;
    private Integer userId;

    private Date createTime;
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Integer getVoteItemId() {
        return voteItemId;
    }

    public void setVoteItemId(Integer voteItemId) {
        this.voteItemId = voteItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
