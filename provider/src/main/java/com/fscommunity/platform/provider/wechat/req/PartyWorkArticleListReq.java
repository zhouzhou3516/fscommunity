package com.fscommunity.platform.provider.wechat.req;

/**
 * @author chao.zhu
 * @version 2018-05-12
 */
public class PartyWorkArticleListReq {
    private int currentPage;
    private int pageSize;
    private String subType;

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

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
