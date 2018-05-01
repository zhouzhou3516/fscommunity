package com.fscommunity.platform.provider.backoffice.req;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/4/30.
 */
public class MsgBroadListQueryReq extends Bean {

    private int authStatus; // -1无效 0未审核 1审核通过 2审核不通过
    private int replyStatus;// -1无效 0未回复 1已回复
    private int currentPage;
    private int pageSize;

    public int getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }

    public int getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(int replyStatus) {
        this.replyStatus = replyStatus;
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
