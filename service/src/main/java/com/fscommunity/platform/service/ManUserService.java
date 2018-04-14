package com.fscommunity.platform.service;

import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.persist.dao.ManUserDao;
import com.google.common.base.Strings;
import com.lxx.app.common.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
@Service
public class ManUserService {
    @Resource
    ManUserDao manUserDao;

    public ManUser queryUserById(int id) {
        return manUserDao.queryUserById(id);
    }

    public ManUser authUser(String userName, String password) {
        if (Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password)) {
            return null;
        }

        return manUserDao.queryUserByNamePass(userName, MD5Util.MD5(password));
    }
}
