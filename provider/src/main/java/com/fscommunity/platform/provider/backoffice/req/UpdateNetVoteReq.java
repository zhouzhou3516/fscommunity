package com.fscommunity.platform.provider.backoffice.req;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class UpdateNetVoteReq {
    private int voteId;
    private int articleid;
    private String startDate;
    private String endDate;

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
