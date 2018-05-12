package com.fscommunity.platform.provider.backoffice.req;

import com.fscommunity.platform.persist.pojo.ProjectType;
import com.lxx.app.common.util.pojo.Bean;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class AddNewProjectSubTypeReq extends Bean {

    private ProjectType projectType;
    private String subType;
    private int orders;

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

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }
}
