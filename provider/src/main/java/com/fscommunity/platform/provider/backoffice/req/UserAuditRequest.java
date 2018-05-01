package com.fscommunity.platform.provider.backoffice.req;

import com.fscommunity.platform.persist.pojo.UserAuditStatus;
import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/4/29
 */
public class UserAuditRequest extends Bean {

    private int id;
    private UserAuditStatus auditStatus;

    public UserAuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(UserAuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
