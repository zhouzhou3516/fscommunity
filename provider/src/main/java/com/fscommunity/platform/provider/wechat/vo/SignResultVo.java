package com.fscommunity.platform.provider.wechat.vo;

/**
 * @author lixiaoxiong
 * @version 2018-01-29
 */
public class SignResultVo {

    /**
     * 增加积分数
     */
    private int addIntegral;

    /**
     * 当前积分数
     */
    private int integral;

    /**
     * 当前等级
     */
    private String level;

    /**
     * 当前金币
     */
    private int coins;

    /**
     * 连续签到天数
     */
    private int continuous;

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getAddIntegral() {
        return addIntegral;
    }

    public void setAddIntegral(int addIntegral) {
        this.addIntegral = addIntegral;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getContinuous() {
        return continuous;
    }

    public void setContinuous(int continuous) {
        this.continuous = continuous;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }
}
