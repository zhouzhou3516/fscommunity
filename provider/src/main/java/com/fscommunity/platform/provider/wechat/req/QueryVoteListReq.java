package com.fscommunity.platform.provider.wechat.req;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class QueryVoteListReq {
    private String fuzzyName;
    private int currentPage;
    private int pageSize;

    public String getFuzzyName() {
        return fuzzyName;
    }

    public void setFuzzyName(String fuzzyName) {
        this.fuzzyName = fuzzyName;
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
