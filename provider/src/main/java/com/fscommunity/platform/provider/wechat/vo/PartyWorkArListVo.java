package com.fscommunity.platform.provider.wechat.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-05-12
 */
public class PartyWorkArListVo {
    private int totalCount;
    private List<BaseListItemVo> list = new ArrayList<>();

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<BaseListItemVo> getList() {
        return list;
    }

    public void setList(List<BaseListItemVo> list) {
        this.list = list;
    }
}
