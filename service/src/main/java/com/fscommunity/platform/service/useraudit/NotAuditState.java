package com.fscommunity.platform.service.useraudit;

import com.fscommunity.platform.persist.pojo.UserAuditStatus;
import com.lxx.app.common.util.pojo.BizException;

/**
 * @author liqingzhou on 18/4/29
 */
public class NotAuditState extends AbstractAuditState {

    public NotAuditState(UserAuditHelper context) {
        this.context = context;
    }

    @Override
    public void register() {
        throw new BizException("用户以注册");
    }

    @Override
    public void auditPass() {
        context.getUserInfo().setAuditStatus(UserAuditStatus.AUDITED);
        logger.info("审核通过,name={}", context.getUserInfo().getRealName());
    }

    @Override
    public void auditReject() {
        context.getUserInfo().setAuditStatus(UserAuditStatus.NOT_PASS);
        logger.info("审核审核不通过,name={}", context.getUserInfo().getRealName());
    }
}
