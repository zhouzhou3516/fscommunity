package com.fscommunity.platform.provider.backoffice.req;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class AddNewVoteItemReq {
    private int voteId;
    private String itemContent;

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }
}
