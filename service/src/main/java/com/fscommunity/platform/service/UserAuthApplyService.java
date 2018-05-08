package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.UserAuthApplyDao;
import com.fscommunity.platform.persist.pojo.UserAuditStatus;
import com.fscommunity.platform.persist.pojo.UserAuthApply;
import com.google.common.base.Preconditions;
import com.lxx.app.common.util.page.PageRequest;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@Service
public class UserAuthApplyService {

    @Resource
    UserAuthApplyDao userAuthApplyDao;


    public List<UserAuthApply> list(UserAuditStatus auditStatus, PageRequest request) {
        return userAuthApplyDao.list(auditStatus, new RowBounds(request.getOffset(), request.getLimit()));
    }

    public int count(UserAuditStatus auditStatus) {
        return userAuthApplyDao.count(auditStatus);
    }

    /**
     */
    public void save(UserAuthApply authApply) {
        Preconditions.checkNotNull(authApply);
        userAuthApplyDao.save(authApply);
    }

    public UserAuthApply queryById(int id) {
        return userAuthApplyDao.queryById(id);
    }

}
