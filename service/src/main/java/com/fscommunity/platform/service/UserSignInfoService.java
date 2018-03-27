package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.UserSignDao;
import com.fscommunity.platform.persist.pojo.UserSignInfo;
import com.google.common.base.Strings;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-03-28
 */
@Service
public class UserSignInfoService {

    @Resource
    UserSignDao userSignDao;

    public int saveUserSign(UserSignInfo info) {
        if (info == null) {
            return 0;
        }
        return userSignDao.saveUserSign(info);
    }

    public UserSignInfo queryStaffSign(int staffId, String dayTime) {
        if (staffId <= 0 || Strings.isNullOrEmpty(dayTime)) {
            return null;
        }

        return userSignDao.querySignInfo(staffId, dayTime);
    }

    public int countStaffSign(int staffId) {
        if (staffId <= 0) {
            return 0;
        }

        return userSignDao.countUserSign(staffId);
    }
}
