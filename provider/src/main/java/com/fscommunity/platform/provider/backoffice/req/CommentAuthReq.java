package com.fscommunity.platform.provider.backoffice.req;

import com.fscommunity.platform.persist.pojo.CommentAuthStatus;
import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/4/29.
 */
public class CommentAuthReq extends Bean {

    private int articleId;
    private int commentId;
    private CommentAuthStatus authStatus;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public CommentAuthStatus getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(CommentAuthStatus authStatus) {
        this.authStatus = authStatus;
    }
}
