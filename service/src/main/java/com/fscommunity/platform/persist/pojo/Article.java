package com.fscommunity.platform.persist.pojo;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 作者id
     */
    private String userId;

    /**
     * 文章名称
     */
    private String name;

    /**
     * 文章类型
     */
    private String type;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 最后更新时间
     */
    private Date updateTime;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public Date getPublishTime() { return publishTime; }

    public void setPublishTime(Date publishTime) { this.publishTime = publishTime; }

    public Date getUpdateTime() { return updateTime; }

    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", content=").append(content);
        sb.append(", putonTime=").append(publishTime);
        sb.append(", pulloffTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


}