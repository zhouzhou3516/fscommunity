package com.fscommunity.platform.provider.backoffice.vo;

import com.fscommunity.platform.persist.pojo.CommentType;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-11
 */
public class CommentVo implements Serializable {
    /*
      * 主键id
     */
    private Integer id;

    /**
     * 文章id
     */
    private Integer articleId;

    private String articleName;

    /**
     * 评论人的id
     */
    private int commentUserId;

    /**
     * 评论人姓名
     */
    private String commentUserName;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 被评论的评论内容, commentType=COMMENT_COMMENT有效
     */
    private String commentedContent;

    /**
     * 被评论的评论id，commentType=COMMENT_COMMENT有效
     */
    private String commentedId;

    /**
     * 评论时间
     */
    private Date publishTime;

    /**
     * 被评论用户id, is_reply=1次值有效
     */
    private Integer commentedUserid;

    /**
     * 被评论用户姓名
     */
    private String commentedUserName;

    /**
     * 评论类型：针对文章的评论还是针对评论的评论
     */
    private CommentType commentType;

    /**
     * 审核状态
     */
    private boolean authStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
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

    public Integer getCommentedUserid() {
        return commentedUserid;
    }

    public void setCommentedUserid(Integer commentedUserid) {
        this.commentedUserid = commentedUserid;
    }

    public String getCommentedUserName() {
        return commentedUserName;
    }

    public void setCommentedUserName(String commentedUserName) {
        this.commentedUserName = commentedUserName;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    public boolean isAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(boolean authStatus) {
        this.authStatus = authStatus;
    }

    public String getCommentedContent() {
        return commentedContent;
    }

    public void setCommentedContent(String commentedContent) {
        this.commentedContent = commentedContent;
    }
}
