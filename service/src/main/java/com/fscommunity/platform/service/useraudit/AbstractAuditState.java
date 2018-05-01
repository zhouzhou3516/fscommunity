package com.fscommunity.platform.service.useraudit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liqingzhou on 18/4/29
 */
public abstract class AbstractAuditState {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected UserAuditHelper context;

    public abstract void register();

    public abstract void auditPass();

    public abstract void auditReject();

}
