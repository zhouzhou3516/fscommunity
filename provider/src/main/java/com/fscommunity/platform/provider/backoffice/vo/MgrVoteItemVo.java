package com.fscommunity.platform.provider.backoffice.vo;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class MgrVoteItemVo {

    private int itemId;
    private String content;
    private int voteSum;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getVoteSum() {
        return voteSum;
    }

    public void setVoteSum(int voteSum) {
        this.voteSum = voteSum;
    }
}
