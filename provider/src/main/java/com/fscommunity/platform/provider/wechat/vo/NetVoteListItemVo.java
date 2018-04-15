package com.fscommunity.platform.provider.wechat.vo;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class NetVoteListItemVo {
    private int voteId;
    private String voteHeader;
    private String overview;
    private String tag;
    private int viewCount;
    private String pubDate;

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getVoteHeader() {
        return voteHeader;
    }

    public void setVoteHeader(String voteHeader) {
        this.voteHeader = voteHeader;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}
