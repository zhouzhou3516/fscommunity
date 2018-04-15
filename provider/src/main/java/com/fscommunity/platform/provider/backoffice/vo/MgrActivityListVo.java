package com.fscommunity.platform.provider.backoffice.vo;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class MgrActivityListVo {
    private int count;
    private List<MgrActivityListItemVo> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MgrActivityListItemVo> getItems() {
        return items;
    }

    public void setItems(List<MgrActivityListItemVo> items) {
        this.items = items;
    }
}
