package com.fscommunity.platform.provider.backoffice.req;

import com.fscommunity.platform.persist.pojo.ProjectType;
import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/4/29
 */
public class AddCategoryProjectReq extends Bean {

    private int id;
    private ProjectType projectType;
    private String subType;
    private int articleId;
    private String title;

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
}
