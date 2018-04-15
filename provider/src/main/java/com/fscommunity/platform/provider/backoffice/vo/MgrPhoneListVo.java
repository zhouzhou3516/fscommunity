package com.fscommunity.platform.provider.backoffice.vo;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class MgrPhoneListVo {
    private int count;
    private List<MgrPhoneListItemVo> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MgrPhoneListItemVo> getItems() {
        return items;
    }

    public void setItems(List<MgrPhoneListItemVo> items) {
        this.items = items;
    }
}
