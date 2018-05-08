package com.fscommunity.platform.provider.wechat.vo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/5/6.
 */
public class WxCommentVo extends Bean {

    /**
     * comment id
     */
    private int id;
    /**
     * 用户名,应该是昵称吧
     */
    private String userName;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 发布时间
     */
    private String publishTime;

    private WxCommentReplyVo reply;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public WxCommentReplyVo getReply() {
        return reply;
    }

    public void setReply(WxCommentReplyVo reply) {
        this.reply = reply;
    }
}
