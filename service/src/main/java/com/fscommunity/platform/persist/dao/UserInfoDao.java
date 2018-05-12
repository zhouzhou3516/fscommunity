package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.CommunityInfo;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.persist.pojo.UserLevel;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
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
     *
     * @param fuzzyName 名字的关键字或者全名
     * @return 返回符合条件的结果
     */
    List<UserInfo> queryByFuzzyName(@Param("fuzzyName") String fuzzyName);

    UserInfo queryByUserId(@Param("id") int id);

    List<UserInfo> queryByRealName(@Param("realName") String realName);

    int updateBizInfo(UserInfo userInfo);

    List<UserSimpleInfo> querySimpleInfoByIds(List<Integer> ids);
    UserSimpleInfo querySimpleInfoById(@Param("id") Integer id);
    int updateLevelByUserId(@Param("id") int id, @Param("level") UserLevel level);

    UserInfo queryUserByOpenId(@Param("openId") String openId);

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
