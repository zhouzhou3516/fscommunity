package com.fscommunity.platform.provider.backoffice.vo;


import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class MgrVoteListItemVo {

    private int voteId;
    private String voteName;
    private String pubDate;
    private String articleName;
    private String articleId;
    private List<MgrVoteItemVo> voteItems = Lists.newArrayList();

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

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public List<MgrVoteItemVo> getVoteItems() {
        return voteItems;
    }

    public void setVoteItems(List<MgrVoteItemVo> voteItems) {
        this.voteItems = voteItems;
    }
}
