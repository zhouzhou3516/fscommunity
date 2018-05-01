package com.fscommunity.platform.provider.backoffice.req;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/5/1
 */
public class ConsultListeningListQueryReq extends Bean {

    private String channelType;
    private String consultType;
    private int currentPage;
    private int pageSize;

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getConsultType() {
        return consultType;
    }

    public void setConsultType(String consultType) {
        this.consultType = consultType;
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