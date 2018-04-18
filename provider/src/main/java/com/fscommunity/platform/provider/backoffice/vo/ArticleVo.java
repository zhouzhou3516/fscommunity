package com.fscommunity.platform.provider.backoffice.vo;

import com.fscommunity.platform.persist.pojo.Article;

import java.util.Date;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-4
 */
public class ArticleVo {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 作者名称
     */
    private String authorName;

    /**
     * 文章名称
     */
    private String name;

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

    private String coverUrl;

    private String tag;

    public ArticleVo(){}

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

    public ArticleVo(Article article){
        this.id=article.getId();
        this.name=article.getName();
        this.content=article.getContent();
        this.publishTime=article.getPublishTime();
        this.updateTime=article.getUpdateTime();
        this.views=article.getViews();
    }

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

    public String getAuthorName() { return authorName; }

    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public Integer getViews() { return views; }

    public void setViews(Integer views) { this.views = views; }
}
