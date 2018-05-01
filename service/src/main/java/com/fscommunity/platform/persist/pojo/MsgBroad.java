package com.fscommunity.platform.persist.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-14
 */
public class MsgBroad implements Serializable {
    /*
     * 主键id
    */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 留言内容
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
     * 1：一条留言的回复，0：直接留言
     */
    private Integer isReply;
    /**
     * 1：该评论被回复过，0：该评论未被回复过
     */
    private Integer isReplied;

    /**
     * 1：显示在浏览界面，0：不显示
     */
    private Integer isShowed;

    /**
     * 排序序号Serial Number
     */
    private Integer sid;

    private String treecode;

    private Date createTime;
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTreecode() {
        return treecode;
    }

    public void setTreecode(String treecode) {
        this.treecode = treecode;
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

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getIsReplied() {
        return isReplied;
    }

    public void setIsReplied(Integer isReplied) {
        this.isReplied = isReplied;
    }

    private static final long serialVersionUID = 1L;


}