package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.persist.pojo.UserLevel;
import java.util.List;

import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import org.springframework.stereotype.Repository;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@Repository
public interface UserInfoDao {
    int saveUser(UserInfo userInfo);

    /**
     * 模糊查询
     * @param fuzzyName 名字的关键字或者全名
     * @return 返回符合条件的结果
     */
    List<UserInfo> queryByFuzzyName(String fuzzyName);

    UserInfo queryByUserId(int id);

    List<UserInfo> queryByRealName(String realName);

    int updateBizInfo(UserInfo userInfo);

    List<UserSimpleInfo> querySimpleInfoByIds(List<Integer> ids);

    int updateLevelByUserId(int id, UserLevel level);

    UserInfo queryUserByOpenId(String openId);
}
