package com.fscommunity.platform.provider.wechat.req;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public class AddNewCommentReq {
    /**
     * 文章id
     */
    private int articleId;

    /**
     * 评论内容
     */
    private String commentCth;

    /**
     * 被评论的用户id， 当评论文章的评论是有效
     */
    private int commentedUserId;

    /**
     * 被评论的评论id， 当评论文章的评论是有效
     */
    private int commentedId;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getCommentCth() {
        return commentCth;
    }

    public void setCommentCth(String commentCth) {
        this.commentCth = commentCth;
    }

    public int getCommentedUserId() {
        return commentedUserId;
    }

    public void setCommentedUserId(int commentedUserId) {
        this.commentedUserId = commentedUserId;
    }

    public int getCommentedId() {
        return commentedId;
    }

    public void setCommentedId(int commentedId) {
        this.commentedId = commentedId;
    }
}
