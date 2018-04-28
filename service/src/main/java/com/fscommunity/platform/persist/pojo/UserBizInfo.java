package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public class UserBizInfo extends Bean {

    /**
     * 积分
     */
    private int integral;


    /**
     * 金币
     */
    private int goldCoin;

    /**
     * 用户等级
     */
    private UserLevel level;

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getGoldCoin() {
        return goldCoin;
    }

    public void setGoldCoin(int goldCoin) {
        this.goldCoin = goldCoin;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }
}
