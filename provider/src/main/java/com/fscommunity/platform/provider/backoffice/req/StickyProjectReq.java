package com.fscommunity.platform.provider.backoffice.req;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/5/12
 */
public class StickyProjectReq extends Bean {

    private int projectId;
    private int status;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
