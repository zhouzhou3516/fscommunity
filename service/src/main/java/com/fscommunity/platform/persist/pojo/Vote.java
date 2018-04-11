package com.fscommunity.platform.persist.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 在线投票
 * @Author jing.c
 * @Date: 18-4-4
 */
public class Vote implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 投票名称
     */
    private String name;

    /**
     * 投票描述
     */
    private String content;

    /**
     * 投票类型：0单选，1多选
     */
    private Integer voteType;

    /**
     * 投票状态：0已关闭，1开放
     */
    private Integer voteState;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 浏览次数
     */
    private Integer views;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteType() {
        return voteType;
    }

    public void setVoteType(Integer voteType) {
        this.voteType = voteType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getVoteState() {
        return voteState;
    }

    public void setVoteState(Integer voteState) {
        this.voteState = voteState;
    }

    public Integer getViews() { return views; }

    public void setViews(Integer views) { this.views = views; }

    public Date getPublishTime() { return publishTime; }

    public void setPublishTime(Date publishTime) { this.publishTime = publishTime; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", content=").append(content);
        sb.append(", voteType=").append(voteType);
        sb.append(", voteState=").append(voteState);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", views=").append(views);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
