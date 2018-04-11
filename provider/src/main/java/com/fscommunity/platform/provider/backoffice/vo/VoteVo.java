package com.fscommunity.platform.provider.backoffice.vo;

import com.fscommunity.platform.persist.pojo.Vote;
import com.fscommunity.platform.persist.pojo.VoteItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-5
 */
public class VoteVo {
    /**
     * 投票id
     */
    private Integer id;

    /**
     * 投票名称
     */
    private String name;

    /**
     * 投票描述
     */
    private String content;

    /**
     * 投票类型：0单选，1多选
     */
    private Integer voteType;

    /**
     * 投票状态：0已关闭，1开放
     */
    private Integer voteState;

    /**
     * 投票选项
     */
    private List<VoteItem> optionList = new ArrayList<>();

    public VoteVo(){}

    public VoteVo(Vote vote) {
        this.id=vote.getId();
        this.name=vote.getName();
        this.content=vote.getContent();
        this.voteType=vote.getVoteType();
        this.voteState=vote.getVoteState();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer voteId) {
        this.id = voteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getVoteType() {
        return voteType;
    }

    public void setVoteType(Integer voteType) {
        this.voteType = voteType;
    }

    public Integer getVoteState() {
        return voteState;
    }

    public void setVoteState(Integer voteState) {
        this.voteState = voteState;
    }

    public List<VoteItem> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<VoteItem> optionList) {
        this.optionList = optionList;
    }
}
