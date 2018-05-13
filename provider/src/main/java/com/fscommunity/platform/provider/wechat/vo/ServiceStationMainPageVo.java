package com.fscommunity.platform.provider.wechat.vo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-05-12
 */
public class ServiceStationMainPageVo {

    /**
     * 办事指南
     */
    public List<String> guides = new ArrayList<>();


    /**
     * 常办事项
     */
    private List<BaseListItemVo> transactions = Lists.newArrayList();

    public List<String> getGuides() {
        return guides;
    }

    public void setGuides(List<String> guides) {
        this.guides = guides;
    }

    public List<BaseListItemVo> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<BaseListItemVo> transactions) {
        this.transactions = transactions;
    }
}
