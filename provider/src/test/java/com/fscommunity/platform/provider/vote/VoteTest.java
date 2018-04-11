package com.fscommunity.platform.provider.vote;

import com.fscommunity.platform.persist.dao.VoteItemMapper;
import com.fscommunity.platform.persist.dao.VoteMapper;
import com.fscommunity.platform.persist.pojo.Vote;
import com.fscommunity.platform.persist.pojo.VoteItem;
import com.fscommunity.platform.provider.BaseJunit;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-11
 */
public class VoteTest extends BaseJunit {
    @Autowired
    VoteMapper voteMapper;

    @Autowired
    VoteItemMapper voteItemMapper;

    @Test
    public void listTest() {
        List<Vote> votes = voteMapper.list(null,new RowBounds(0,6));
        for(Vote vote:votes)
            System.out.println(vote.toString());
        assertTrue(votes.size() > 0);
    }

    @Test
    public void getCountTest() {
        int rslt = voteMapper.getCount();
        System.out.println(rslt);
    }

    @Test
    public void getTest() {
        Vote voteInfo = voteMapper.selectById(3);
        System.out.println(voteInfo.toString());
    }

    @Test
    public void insertTest() {
        Vote vote=new Vote();
        vote.setId(1);
        vote.setName("fedwa");
        vote.setContent("反对萨风格为");
        int rslt = voteMapper.insert(vote);
        System.out.println(rslt);
    }

    @Test
    public void updateTest() {
        Vote article=new Vote();
        article.setId(5);
        article.setName("FDSA");
        article.setContent("faewtreqw");
        int rslt = voteMapper.updateById(article);
        System.out.println(rslt);
    }
    @Test
    public void updateStateTest() {
        int rslt = voteMapper.updateStateById(5,0);
        System.out.println(rslt);
    }

    @Test
    public void updateViewsTest() {
        int rslt = voteMapper.updateViewsById(3,24);
        System.out.println(rslt);
    }

    @Test
    public void delTest() {
        int rslt = voteMapper.deleteById(5);
        System.out.println(rslt);
    }

    @Test
    public void selectByVoteIdTest() {
        List<VoteItem> votes = voteItemMapper.selectByVoteId(1);
        for(VoteItem vote:votes)
            System.out.println(vote.toString());
    }
}
