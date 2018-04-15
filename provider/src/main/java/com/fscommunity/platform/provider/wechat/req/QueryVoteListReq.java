package com.fscommunity.platform.provider.wechat.req;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class QueryVoteListReq {
    private int currentPage;
    private int pageSize;

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
