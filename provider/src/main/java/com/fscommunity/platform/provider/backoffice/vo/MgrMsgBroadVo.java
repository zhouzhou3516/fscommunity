package com.fscommunity.platform.provider.backoffice.vo;

import com.fscommunity.platform.persist.pojo.MsgBroad;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 留言板
 * @Author jing.c
 * @Date: 18-4-11
 */
public class MgrMsgBroadVo implements Serializable {
    /*
      * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 留言时间
     */
    private Date publishTime;

    /**
     * 被回复的留言id, 如果是回复一条留言，则需要填写，is_reply==1
     */
    private Integer targetCid;

    /**
     * 被回复的留言作者id,如果是回复一条留言，则需要填写，is_reply==1 exists
     */
    private Integer targetUid;

    /**
     * 被回复的留言作者名字,如果是回复一条留言，则需要填写 is_reply==1 exists
     */
    private String targetUname;

    /**
     * 1：一条留言的回复，0：直接留言文章
     */
    private Integer isReply;

    /**
     * 1：留言显示在浏览界面，0：不显示
     */
    private Integer isShowed;

    private String authStatus;

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public MgrMsgBroadVo(MsgBroad msgBroad) {
        this.id = msgBroad.getId();
        this.content = msgBroad.getContent();
        this.userId = msgBroad.getUserId();
        this.publishTime = msgBroad.getPublishTime();
        this.targetCid = msgBroad.getTargetCid();
        this.targetUid = msgBroad.getTargetUid();
        this.isReply = msgBroad.getIsReply();
        this.isShowed = msgBroad.getIsShowed();
        this.authStatus = msgBroad.getIsShowed() == 1? "已审核通过" : "未审核通过";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getTargetCid() {
        return targetCid;
    }

    public void setTargetCid(Integer targetCid) {
        this.targetCid = targetCid;
    }

    public Integer getTargetUid() {
        return targetUid;
    }

    public void setTargetUid(Integer targetUid) {
        this.targetUid = targetUid;
    }

    public String getTargetUname() {
        return targetUname;
    }

    public void setTargetUname(String targetUname) {
        this.targetUname = targetUname;
    }

    public Integer getIsReply() {
        return isReply;
    }

    public void setIsReply(Integer isReply) {
        this.isReply = isReply;
    }

    public Integer getIsShowed() {
        return isShowed;
    }

    public void setIsShowed(Integer isShowed) {
        this.isShowed = isShowed;
    }

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userAvatar=").append(userAvatar);
        sb.append(", content=").append(content);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", targetCid=").append(targetCid);
        sb.append(", targetUname=").append(targetUname);
        sb.append(", isReply=").append(isReply);
        sb.append(", isShowed=").append(isShowed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
