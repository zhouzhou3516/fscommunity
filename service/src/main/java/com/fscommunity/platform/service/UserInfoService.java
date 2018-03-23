package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.UserInfoDao;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@Service
public class UserInfoService {

    @Resource
    UserInfoDao userInfoDao;

    public void saveUserInfo(UserInfo userInfo) {
        Preconditions.checkNotNull(userInfo);
        userInfoDao.saveUser(userInfo);
    }

    public List<UserInfo> queryUserInfoByFuzzyName(String fuzzyName) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(fuzzyName));
        return userInfoDao.queryByFuzzyName(fuzzyName);
    }

    public UserInfo queryUserById(int id) {
        return userInfoDao.queryByUserId(id);
    }

    public UserInfo queryUserByRealName(String realName) {
        Preconditions.checkNotNull(!Strings.isNullOrEmpty(realName));
        return userInfoDao.queryByRealName(realName);
    }
}
