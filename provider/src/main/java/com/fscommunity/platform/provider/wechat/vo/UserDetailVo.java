package com.fscommunity.platform.provider.wechat.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public class UserDetailVo {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 头像url
     */
    private String avatarUrl;

    /**
     * 微信昵称
     */
    private String wxNickname;

    /**
     * 等级
     */
    private String level;

    /**
     * 金币
     */
    private int goldCoins;

    /**
     * 积分
     */
    private int integral;

    private String signRule;

    /**
     * 系统消息
     */
    private List<String> systemMsgs = new ArrayList<>();

    /**
     * 用户我的消息
     */
    private List<String> userMsgs = new ArrayList<>();

    /**
     * 发送的评论(数据结构待定)
     */
    private List<String> sendComments = new ArrayList<>();

    /**
     * 收到的评论(数据结构待定)
     */
    private List<String> recvComments = new ArrayList<>();

    public String getSignRule() {
        return signRule;
    }

    public void setSignRule(String signRule) {
        this.signRule = signRule;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public List<String> getSystemMsgs() {
        return systemMsgs;
    }

    public void setSystemMsgs(List<String> systemMsgs) {
        this.systemMsgs = systemMsgs;
    }

    public List<String> getUserMsgs() {
        return userMsgs;
    }

    public void setUserMsgs(List<String> userMsgs) {
        this.userMsgs = userMsgs;
    }

    public List<String> getSendComments() {
        return sendComments;
    }

    public void setSendComments(List<String> sendComments) {
        this.sendComments = sendComments;
    }

    public List<String> getRecvComments() {
        return recvComments;
    }

    public void setRecvComments(List<String> recvComments) {
        this.recvComments = recvComments;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }
}
