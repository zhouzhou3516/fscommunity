package com.fscommunity.platform.provider.wechat.vo;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class NetVoteDetailVo {

    private int voteId;
    private String voteName;
    private String voteContent;
    private boolean isVoted;
    private boolean expire;
    private List<NetVoteItemVo> items;

    public boolean isExpire() {
        return expire;
    }

    public void setExpire(boolean expire) {
        this.expire = expire;
    }

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

    public String getVoteContent() {
        return voteContent;
    }

    public void setVoteContent(String voteContent) {
        this.voteContent = voteContent;
    }

    public List<NetVoteItemVo> getItems() {
        return items;
    }

    public void setItems(List<NetVoteItemVo> items) {
        this.items = items;
    }

    public boolean isVoted() {
        return isVoted;
    }

    public void setVoted(boolean voted) {
        isVoted = voted;
    }
}
