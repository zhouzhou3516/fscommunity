package com.fscommunity.platform.service.useraudit;

import com.fscommunity.platform.persist.pojo.UserAuditStatus;
import com.lxx.app.common.util.pojo.BizException;

/**
 * @author liqingzhou on 18/4/29
 */
public class InitState extends AbstractAuditState {

    public InitState(UserAuditHelper context) {
        this.context = context;
    }

    @Override
    public void register() {
        context.getUserInfo().setAuditStatus(UserAuditStatus.UN_AUDIT);
    }

    @Override
    public void auditPass() {
        throw new BizException("未导入用户不能审核");
    }

    @Override
    public void auditReject() {
        throw new BizException("未导入用户不能审核");
    }
}
