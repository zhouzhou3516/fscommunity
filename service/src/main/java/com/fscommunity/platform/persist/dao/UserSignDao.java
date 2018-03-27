package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.UserSignInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lixiaoxiong
 * @version 2018-03-28
 */
@Repository
public interface UserSignDao {
    int saveUserSign(UserSignInfo info);
    UserSignInfo querySignInfo(@Param("userId") int userId,
            @Param("dayTime") String dayTime);
    int countUserSign(int userId);
}
