package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.UserAuditStatus;
import com.fscommunity.platform.persist.pojo.UserAuthApply;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@Repository
public interface UserAuthApplyDao {

    int save(UserAuthApply authApply);

    List<UserAuthApply> list(UserAuditStatus auditStatus, RowBounds rowBounds);

    int count(UserAuditStatus auditStatus);


    UserAuthApply queryById(@Param("id") int id);
}
