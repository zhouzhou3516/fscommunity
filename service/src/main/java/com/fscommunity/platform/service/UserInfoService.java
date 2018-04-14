package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.UserInfoDao;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.persist.pojo.UserLevel;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.lxx.app.common.util.pojo.BizException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@Service
public class UserInfoService {

    @Resource
    UserInfoDao userInfoDao;

    /**
     * 保存一个用户
     * @param userInfo 用户对象
     */
    public void saveUserInfo(UserInfo userInfo) {
        Preconditions.checkNotNull(userInfo);
        userInfoDao.saveUser(userInfo);
    }

    /**
     * 更新用户BizInfo
     * @param userInfo 用户
     * @return 返回成功与否
     */
    public int updateBizInfo(UserInfo userInfo) {
        Preconditions.checkNotNull(userInfo);
        return userInfoDao.updateBizInfo(userInfo);
    }

    /**
     * 模糊查询
     * @param fuzzyName 名字的部分或者全部字符
     * @return 返回符合要求的用户列表, 可能为空
     */
    public List<UserInfo> queryUserInfoByFuzzyName(String fuzzyName) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(fuzzyName));
        return userInfoDao.queryByFuzzyName(fuzzyName);
    }

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 返回指定用户
     */
    public UserInfo queryUserById(int id) {
        return userInfoDao.queryByUserId(id);
    }

    public List<UserSimpleInfo> querySimpleUsersByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.EMPTY_LIST;
        }

        return userInfoDao.querySimpleInfoByIds(ids);
    }

    /**
     * 根据名称查询用户, 完全匹配
     * @param realName 真实姓名
     * @return 返回该姓名的用户
     */
    public List<UserInfo> queryUserByRealName(String realName) {
        Preconditions.checkNotNull(!Strings.isNullOrEmpty(realName));
        return userInfoDao.queryByRealName(realName);
    }

    /**
     * 更新用户的积分
     * @param id 用户id
     * @param intergral 新积分值
     * @return 返回成功与否
     */
    public int updateIntegralByUserId(int id, int intergral) {
        UserInfo info = queryUserById(id);
        if (info == null) {
            return 0;
        }
        info.getBizInfo().setIntegral(intergral);
        return userInfoDao.updateBizInfo(info);
    }

    /**
     * 更新用户的金币
     * @param id 用户id
     * @param coins 新金币值
     * @return 返回成功与否
     */
    public int updateGoldCoinByUserId(int id, int coins) {
        UserInfo info = queryUserById(id);
        if (info == null) {
            return 0;
        }
        info.getBizInfo().setGoldCoin(coins);
        return userInfoDao.updateBizInfo(info);
    }

    /**
     * 更新用户的等级信息
     * @param id 用户id
     * @param level 用户的等级
     * @return 返回成功与否
     */
    public int updateUserLevel(int id, UserLevel level) {
        return userInfoDao.updateLevelByUserId(id, level);
    }

    /**
     * 将用户金币加1
     * @param id 用户id
     * @return 返回更新结果
     */
    public int increUserGoldCoin(int id) {
        UserInfo userInfo = queryUserById(id);
        userInfo.getBizInfo().setGoldCoin(userInfo.getBizInfo().getGoldCoin() + 1);
        return userInfoDao.updateBizInfo(userInfo);
    }

    /**
     * 将用金币增加指定个数
     * @param id 用户id
     * @param count 可以为负数
     * @return 返回更新结果
     */
    public int increUserGoldCoinByCount(int id, int count) {
        UserInfo userInfo = queryUserById(id);

        if (userInfo == null) {
            return 0;
        }

        if (count < 0 && Math.abs(count) > userInfo.getBizInfo().getGoldCoin()) {
            throw new BizException("当前用户金币不足");
        }

        userInfo.getBizInfo().setGoldCoin(userInfo.getBizInfo().getGoldCoin() + count);
        return userInfoDao.updateBizInfo(userInfo);
    }

    public UserInfo queryUserInfoByOpenId(String openId) {
        if (Strings.isNullOrEmpty(openId)) {
            return null;
        }

        return userInfoDao.queryUserByOpenId(openId);
    }
}
