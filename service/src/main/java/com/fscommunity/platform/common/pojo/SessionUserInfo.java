package com.fscommunity.platform.common.pojo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/5/2
 */
public class SessionUserInfo extends Bean {

    /**
     * openId
     */
    private String openId;
    /**
     * 手机号
     */
    private String cellPhone;

    /**
     * 用户id
     */
    private int userId;

    /**
     * 头像id
     */
    private String avatarUrl;

    /**
     * 微信昵称
     */
    private String wxNickname;
    /**
     * 积分
     */
    private int integral;


    /**
     * 金币
     */
    private int goldCoin;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getWxNickname() {
        return wxNickname;
    }

    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname;
    }

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
}
