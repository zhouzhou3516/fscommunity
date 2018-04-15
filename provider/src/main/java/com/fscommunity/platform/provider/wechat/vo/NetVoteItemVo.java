package com.fscommunity.platform.provider.wechat.vo;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class NetVoteItemVo {
    private int itemId;
    private String itemContent;
    private int voteCount;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
