package com.fscommunity.platform.provider.backoffice.req;

import com.fscommunity.platform.provider.backoffice.vo.VoteItemVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class AddNewVoteReq {
    private int id;

    private String voteName;
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

    /**
     * 投票选项，用逗号隔开
     */
    private List<VoteItemVo> items = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }

    public List<VoteItemVo> getItems() {
        return items;
    }

    public void setItems(List<VoteItemVo> items) {
        this.items = items;
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

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
