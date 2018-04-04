package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.VerifyBizType;
import com.fscommunity.platform.persist.pojo.VerifyCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lixiaoxiong
 * @version 2018-01-20
 */
@Repository
public interface VerifyCodeDao {
    int saveVerifyCode(VerifyCode code);
    VerifyCode queryValidCode(@Param("phone") String phone,
            @Param("bizType") VerifyBizType bizType);
    int updateStatus(VerifyCode code);
}