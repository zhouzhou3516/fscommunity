package com.fscommunity.platform.provider.wechat.vo;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class NetVoteListVo {
    private int count;
    private List<NetVoteListItemVo> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<NetVoteListItemVo> getItems() {
        return items;
    }

    public void setItems(List<NetVoteListItemVo> items) {
        this.items = items;
    }
}
