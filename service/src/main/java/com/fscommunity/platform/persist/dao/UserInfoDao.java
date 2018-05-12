package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.CommunityInfo;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.persist.pojo.UserLevel;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@Repository
public interface UserInfoDao {

    int saveUser(UserInfo userInfo);

    /**
     * 模糊查询
     *
     * @param fuzzyName 名字的关键字或者全名
     * @return 返回符合条件的结果
     */
    List<UserInfo> queryByFuzzyName(String fuzzyName);

    UserInfo queryByUserId(int id);

    List<UserInfo> queryByRealName(String realName);

    int updateBizInfo(UserInfo userInfo);

    List<UserSimpleInfo> querySimpleInfoByIds(List<Integer> ids);
    UserSimpleInfo querySimpleInfoById(Integer id);
    int updateLevelByUserId(int id, UserLevel level);

    UserInfo queryUserByOpenId(String openId);

    List<UserInfo> list(@Param("fuzzyName") String fuzzyName,
        @Param("phone") String phone,
        @Param("auditStatus") String auditStatus, RowBounds rowBounds);

    int count(@Param("fuzzyName") String fuzzyName,
              @Param("phone") String phone,
              @Param("auditStatus") String auditStatus);

    UserInfo queryByIdCard(String idCard);

    List<String> queryAllStreats();

    List<CommunityInfo> queryCommunityInfoByStreat(String streat);
}
