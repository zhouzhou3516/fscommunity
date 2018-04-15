package com.fscommunity.platform.provider.backoffice.vo;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class MgrVoteListItemVo {
    private int voteId;
    private String voteName;
    private String pubDate;

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}
