package com.fscommunity.platform.persist.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.fscommunity.platform.persist.pojo.ApplyActivityInfo;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Repository
public interface ApplyActivityDao {
    int saveApply(ApplyActivityInfo info);
    ApplyActivityInfo queryById(int id);
    List<ApplyActivityInfo> queryByActivityId(int activityId);
    ApplyActivityInfo queryByAIdAndUid(@Param("activityId") int activityId, @Param("userId") int userId);
}
