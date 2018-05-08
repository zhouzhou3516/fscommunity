package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public class UserSimpleInfo extends Bean {

    /**
     * 数据库唯一id标识
     */
    private int id;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机
     */
    private String cellPhone;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 公众号openid
     */
    private String openId;

    /**
     * 积分
     */
    private int integral;


    /**
     * 金币
     */
    private int goldCoin;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
}
