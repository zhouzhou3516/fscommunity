package com.fscommunity.platform.provider.backoffice.vo;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class MgrVoteDetailVo {
    private int voteId;
    private int articleId;
    private String articleName;
    private String startDate;
    private String endDate;
    private List<MgrVoteItemVo> items;

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
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

    public List<MgrVoteItemVo> getItems() {
        return items;
    }

    public void setItems(List<MgrVoteItemVo> items) {
        this.items = items;
    }
}
