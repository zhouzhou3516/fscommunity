package com.fscommunity.platform.provider.wechat.req;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/4/30.
 */
public class WxMsgBroadListQueryReq extends Bean {

    private int currentPage =1;
    private int pageSize=10;


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
