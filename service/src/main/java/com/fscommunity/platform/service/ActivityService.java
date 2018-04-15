package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.ActivityDao;
import com.fscommunity.platform.persist.pojo.ActivityInfo;
import com.lxx.app.common.util.page.PageRequest;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Service
public class ActivityService {

    @Resource
    ActivityDao activityDao;

    public int saveActivity(ActivityInfo info) {
        return activityDao.saveActivity(info);
    }

    public ActivityInfo queryById(int id) {
        return activityDao.queryById(id);
    }

    public List<ActivityInfo> queryByPage(PageRequest request) {
        return activityDao.queryByPage(new RowBounds(request.getOffset(), request.getLimit()));
    }

    public int countActivity() {
        return activityDao.countActivity();
    }

    public int updateActivity(ActivityInfo info) {
        return activityDao.updateActivity(info);
    }
}
