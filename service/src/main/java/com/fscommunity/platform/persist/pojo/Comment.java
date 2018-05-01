package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description 评论
 * @Author jing.c
 * @Date: 18-4-11
 */
public class Comment extends Bean {
     /*
      * 主键id
     */
    private Integer id;

    /**
     * 文章id
     */
    private Integer targetId;

    /**
     * 评论人的用户id
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
     * 被回复的评论id, 如果是回复一条评论(commentType=COMMENT_COMMENT)，则需要填写
     */
    private Integer targetCid;

    /**
     * 被回复的评论作者id,如果是回复一条评论(commentType=COMMENT_COMMENT)，则需要填写
     */
    private Integer targetUid;

    /**
     * 1：回复一条评论，0：直接评论文章
     */
    private CommentType commentType;

    /**
     * 1:该条评论被回复过;0:该条评论还未回复过
     */
    private int isReplied;

    /**
     * 1:评论显示在浏览界面,0:不显示,2:审核不通过
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

    public int getIsReplied() {
        return isReplied;
    }

    public void setIsReplied(int isReplied) {
        this.isReplied = isReplied;
    }

    private static final long serialVersionUID = 1L;
}
