package com.fscommunity.platform.provider.wechat.vo;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class PhoneListVo {
    private int count;
    private List<PhoneListItemVo> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PhoneListItemVo> getItems() {
        return items;
    }

    public void setItems(List<PhoneListItemVo> items) {
        this.items = items;
    }
}
