package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.NetVote;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Repository
public interface NetVoteDao {
    int saveNetVote(NetVote vote);
    List<NetVote> queryNetVotesByPage(RowBounds rowBounds);
    NetVote queryNetVoteById(int id);
    int countNetVotes();
    int updateNetVote(NetVote netVote);
}
