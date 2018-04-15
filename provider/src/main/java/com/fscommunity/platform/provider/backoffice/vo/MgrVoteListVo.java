package com.fscommunity.platform.provider.backoffice.vo;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class MgrVoteListVo {
    private List<MgrVoteListItemVo> items;
    private int count;

    public List<MgrVoteListItemVo> getItems() {
        return items;
    }

    public void setItems(List<MgrVoteListItemVo> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
