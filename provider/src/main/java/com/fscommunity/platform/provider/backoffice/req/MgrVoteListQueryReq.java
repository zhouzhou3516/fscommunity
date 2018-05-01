package com.fscommunity.platform.provider.backoffice.req;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public class MgrVoteListQueryReq extends Bean {

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
