package com.fscommunity.platform.service.useraudit;

import com.lxx.app.common.util.pojo.BizException;

/**
 * @author liqingzhou on 18/4/29
 */
public class AuditNotPassState extends AbstractAuditState {

    public AuditNotPassState(UserAuditHelper context) {
        this.context = context;
    }

    @Override
    public void register() {
        throw new BizException("用户已审核");
    }

    @Override
    public void auditPass() {
        throw new BizException("用户已审核");
    }

    @Override
    public void auditReject() {
        throw new BizException("用户已审核");
    }
}