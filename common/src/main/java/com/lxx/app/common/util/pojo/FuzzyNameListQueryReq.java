package com.lxx.app.common.util.pojo;

/**
 * @author liqingzhou on 18/4/29
 */
public class FuzzyNameListQueryReq extends Bean {

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
