package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;
import java.util.Date;

/**
 * 服务工作站，党建工作，社区咨询统一用一个
 *
 * @author liqingzhou on 18/4/29.
 */
public class CategoryProjectInfo extends Bean {

    private int id;
    // 项目类型
    private ProjectType projectType;
    // 具体类型
    private String subType;
    private int articleId;
    /**
     * 通知公告标题
     */
    private String title;
    private Date createTime;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

