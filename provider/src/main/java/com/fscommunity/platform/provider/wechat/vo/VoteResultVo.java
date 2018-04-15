package com.fscommunity.platform.provider.wechat.vo;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class VoteResultVo {
    List<NetVoteItemVo> items;

    public List<NetVoteItemVo> getItems() {
        return items;
    }

    public void setItems(List<NetVoteItemVo> items) {
        this.items = items;
    }
}
