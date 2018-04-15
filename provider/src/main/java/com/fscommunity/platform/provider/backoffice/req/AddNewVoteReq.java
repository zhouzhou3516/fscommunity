package com.fscommunity.platform.provider.backoffice.req;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class AddNewVoteReq {
    /**
     * 投票文章id
     */
    private int articleId;

    /**
     * 失效日期
     */
    private String startDate;

    /**
     * 失效日期
     */
    private String endDate;

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

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
