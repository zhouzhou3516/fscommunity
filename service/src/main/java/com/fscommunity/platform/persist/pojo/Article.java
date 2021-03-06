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
    private Integer authorId;

    private String authorName;

    private String coverUrl;

    /**
     * 文章名称
     */
    private String name;

    private String tag;

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

    /**
     * 浏览次数
     */
    private Integer views;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

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

    public Date getPublishTime() { return publishTime; }

    public void setPublishTime(Date publishTime) { this.publishTime = publishTime; }

    public Date getUpdateTime() { return updateTime; }

    public void setUpdateTime(Date updateTime) { this.updateTime = updateTime; }

    public Integer getAuthorId() { return authorId; }

    public void setAuthorId(Integer authorId) { this.authorId = authorId; }

    public Integer getViews() { return views; }

    public void setViews(Integer views) { this.views = views; }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}