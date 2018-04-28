package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public class UserBaseinfo extends Bean {

    /**
     * 曾用名
     */
    private String usedName;

    /**
     * 户主关系
     */
    private String relationOfHouseholder;


    /**
     * 户籍状态
     */
    private String registerStatus;

    /**
     * 没迁户口原因
     */
    private String noMigrationReason;

    /**
     * 文化程度
     */
    private String degreeOfEducation;

    /**
     * 健康状况
     */
    private String healthStatus;

    /**
     * 宗教信仰
     */
    private String faith;

    /**
     * 微信昵称
     */
    private String wxNickName;

    /**
     * 微信头像url
     */
    private String avatarUrl;

    public String getUsedName() {
        return usedName;
    }

    public void setUsedName(String usedName) {
        this.usedName = usedName;
    }

    public String getRelationOfHouseholder() {
        return relationOfHouseholder;
    }

    public void setRelationOfHouseholder(String relationOfHouseholder) {
        this.relationOfHouseholder = relationOfHouseholder;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getNoMigrationReason() {
        return noMigrationReason;
    }

    public void setNoMigrationReason(String noMigrationReason) {
        this.noMigrationReason = noMigrationReason;
    }

    public String getDegreeOfEducation() {
        return degreeOfEducation;
    }

    public void setDegreeOfEducation(String degreeOfEducation) {
        this.degreeOfEducation = degreeOfEducation;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getFaith() {
        return faith;
    }

    public void setFaith(String faith) {
        this.faith = faith;
    }

    public String getWxNickName() {
        return wxNickName;
    }

    public void setWxNickName(String wxNickName) {
        this.wxNickName = wxNickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
