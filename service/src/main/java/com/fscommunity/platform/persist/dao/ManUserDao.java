package com.fscommunity.platform.persist.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fscommunity.platform.common.pojo.ManUser;


/**
 * @author lixiaoxiong
 * @version 2018-01-29
 */
@Repository
public interface ManUserDao {
    int saveManUser(ManUser user);
    ManUser queryUserByNamePass(@Param("userName") String userName,
                                @Param("password") String password);
    ManUser queryUserByUsername(String userName);
    ManUser queryUserById(int id);
}
