package com.fscommunity.platform.service;

import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.persist.dao.ManUserDao;
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
}
