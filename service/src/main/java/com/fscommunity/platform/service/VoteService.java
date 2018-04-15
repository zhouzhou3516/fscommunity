package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.VoteItemMapper;
import com.fscommunity.platform.persist.dao.VoteMapper;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.persist.pojo.Vote;
import com.fscommunity.platform.persist.pojo.VoteItem;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.lxx.app.common.util.page.PageRequest;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-5
 */
@Service
public class VoteService {

    @Autowired
    VoteMapper voteMapper;

    @Autowired
    VoteItemMapper voteItemMapper;

    public List<Vote> list(String condition, PageRequest pageRequest) {
        return voteMapper.list(condition, new RowBounds(pageRequest.getOffset(), pageRequest.getLimit()));
    }

    public int getCount() {
        return voteMapper.getCount();
    }

    public void add(Vote vote) {
        Preconditions.checkNotNull(vote);
        voteMapper.insert(vote);
    }

    public Vote selectById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        return voteMapper.selectById(Integer.valueOf(id));
    }

    public void updateById(Vote vote) {
        Preconditions.checkNotNull(vote);
        voteMapper.updateById(vote);
    }

    public void delById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        voteMapper.deleteById(Integer.valueOf(id));
    }

    public void updateViewsById(String id, String views) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        voteMapper.updateViewsById(Integer.valueOf(id),Integer.valueOf(views));
    }

    /**
     * user vote
     * @param id voteItem id
     */
    public Vote vote(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        VoteItem voteItem=voteItemMapper.selectById(Integer.valueOf(id));
        //todo 从上下文中获取当前用户
//        UserInfo info = sessionUserHolder.currentStaff();
        UserInfo info=null;
        voteItem.setVoterList(voteItem.getVoterList()+","+info.getRealName());
        voteItem.setVoterSum(voteItem.getVoterSum()+1);
        voteItemMapper.updateById(voteItem);
        return voteMapper.selectById(voteItem.getVoteId());

    }

    /**
     * 更新投票状态
     * @param id
     * @param voteState
     */
    public void updateState(String id, String voteState) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(voteState));
        voteMapper.updateStateById(Integer.valueOf(id),Integer.valueOf(voteState));
    }

    public void addVoteItem(VoteItem voteItem) {
        Preconditions.checkNotNull(voteItem);
        voteItem.setVoterSum(0);

        voteItemMapper.insert(voteItem);
    }

    public void updateVoteItem(VoteItem voteItem) {
        Preconditions.checkNotNull(voteItem);
        voteItemMapper.updateById(voteItem);
    }

    public void delVoteItem(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        voteItemMapper.deleteById(Integer.valueOf(id));
    }


}
