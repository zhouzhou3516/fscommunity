package com.fscommunity.platform.provider.wechat.vo;

import com.fscommunity.platform.persist.pojo.UserAuditStatus;
import com.fscommunity.platform.provider.wechat.req.UserAuthReq;

/**
 * @author liqingzhou on 18/5/2
 */
public class UserAuthVo extends UserAuthReq {

    private UserAuditStatus userAuditStatus;

    public UserAuditStatus getUserAuditStatus() {
        return userAuditStatus;
    }

    public void setUserAuditStatus(UserAuditStatus userAuditStatus) {
        this.userAuditStatus = userAuditStatus;
    }
}
