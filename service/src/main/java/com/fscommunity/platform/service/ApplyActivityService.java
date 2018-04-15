package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.ApplyActivityDao;
import com.fscommunity.platform.persist.pojo.ApplyActivityInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Service
public class ApplyActivityService {

    @Resource
    ApplyActivityDao applyActivityDao;

    public int saveApply(ApplyActivityInfo info) {
        return applyActivityDao.saveApply(info);
    }

    public List<ApplyActivityInfo> queryByActivityId(int activityId) {
        return applyActivityDao.queryByActivityId(activityId);
    }

    public ApplyActivityInfo queryByActivityIdAndUid(int aid, int uid) {
        return applyActivityDao.queryByAIdAndUid(aid, uid);
    }
}
