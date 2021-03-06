package com.fscommunity.platform.provider.backoffice.req;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public class QueryCommentListReq {
    private int articleId;
    private boolean authStatus;
    private int currentPage;
    private int pageSize;

    public boolean isAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(boolean authStatus) {
        this.authStatus = authStatus;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
