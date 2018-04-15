package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.ActivityInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Repository
public interface ActivityDao {
    int saveActivity(ActivityInfo info);
    ActivityInfo queryById(int id);
    List<ActivityInfo> queryByIds(List<Integer> ids);
    List<ActivityInfo> queryByPage(RowBounds rowBounds);
    int delById(int id);
    int countActivity();
    int updateActivity(ActivityInfo info);
}
