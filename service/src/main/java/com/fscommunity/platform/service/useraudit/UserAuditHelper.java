package com.fscommunity.platform.service.useraudit;

import com.fscommunity.platform.persist.pojo.UserAuditStatus;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.lxx.app.common.util.pojo.BizException;
import org.springframework.stereotype.Service;

/**
 * @author liqingzhou on 18/4/29
 */
@Service
public class UserAuditHelper {

    private UserInfo userInfo;
    private UserAuditStatus auditStatus;
    private AbstractAuditState abstractAuditState;

    public UserAuditHelper(UserInfo userInfo, UserAuditStatus auditStatus) {
        this.userInfo = userInfo;
        this.auditStatus = auditStatus;
        switch (userInfo.getAuditStatus()) {
            case INIT:
                abstractAuditState = new InitState(this);
                break;
            case UN_AUDIT:
                abstractAuditState = new NotAuditState(this);
                break;
            case NOT_PASS:
                abstractAuditState = new AuditNotPassState(this);
                break;
            case AUDITED:
                abstractAuditState = new AuditPassState(this);
                break;
            default:
                throw new BizException("不合法状态:" + userInfo.getAuditStatus());

        }
    }

    public UserInfo handle() {
        switch (auditStatus) {
            case NOT_PASS:
                abstractAuditState.auditReject();
                break;
            case AUDITED:
                abstractAuditState.auditPass();
            default:
                throw new BizException("不合法操作:" + auditStatus);
        }
        return userInfo;
    }


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserAuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(UserAuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public AbstractAuditState getAbstractAuditState() {
        return abstractAuditState;
    }

    public void setAbstractAuditState(AbstractAuditState abstractAuditState) {
        this.abstractAuditState = abstractAuditState;
    }
}
