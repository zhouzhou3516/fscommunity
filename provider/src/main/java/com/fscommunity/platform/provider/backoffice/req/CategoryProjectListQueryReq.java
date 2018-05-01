package com.fscommunity.platform.provider.backoffice.req;

import com.fscommunity.platform.persist.pojo.ProjectType;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public class CategoryProjectListQueryReq {

    private ProjectType projectType;
    private String subType;
    private int currentPage;
    private int pageSize;

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

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
