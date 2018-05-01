package com.fscommunity.platform.provider.backoffice.req;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/4/29.
 */
public class NewCommentReplyReq extends Bean {

    private int articleId;
    private int targetId;
    private String replyContent;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
}
