package com.fscommunity.platform.provider.wechat.vo;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class ActivityListVo {
    private int count;
    private List<ActivityListItemVo> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<ActivityListItemVo> getItems() {
        return items;
    }

    public void setItems(List<ActivityListItemVo> items) {
        this.items = items;
    }
}
