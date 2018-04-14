package com.fscommunity.platform.persist.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 评论
 * @Author jing.c
 * @Date: 18-4-11
 */
public class Comment implements Serializable {
     /*
      * 主键id
     */
    private Integer id;

    /**
     * 文章id
     */
    private Integer targetId;

    /**
     * 用户id
     */
    private int userId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Date publishTime;

    /**
     * 被回复的评论id, 如果是回复一条评论，则需要填写，is_reply==1
     */
    private Integer targetCid;

    /**
     * 被回复的评论作者id,如果是回复一条评论，则需要填写，is_reply==1 exists
     */
    private Integer targetUid;

    /**
     * 1：一条评论的回复，0：直接评论文章
     */
    private CommentType commentType;

    private int isReply;

    /**
     * 1：评论显示在浏览界面，0：不显示
     */
    private Integer isShowed;

    /**
     * 排序序号Serial Number
     */
    private Integer sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
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

    public int getIsReply() {
        return isReply;
    }

    public void setIsReply(int isReply) {
        this.isReply = isReply;
    }

    private static final long serialVersionUID = 1L;
}
