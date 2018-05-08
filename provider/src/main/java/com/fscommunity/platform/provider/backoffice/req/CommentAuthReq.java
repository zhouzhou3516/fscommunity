package com.fscommunity.platform.provider.backoffice.req;

import com.fscommunity.platform.persist.pojo.CommentAuthStatus;
import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/4/29.
 */
public class CommentAuthReq extends Bean {

    private int articleId;
    private int id;
    private CommentAuthStatus authStatus;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CommentAuthStatus getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(CommentAuthStatus authStatus) {
        this.authStatus = authStatus;
    }
}
