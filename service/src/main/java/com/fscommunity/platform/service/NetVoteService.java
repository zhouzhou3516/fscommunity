package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.NetVoteDao;
import com.fscommunity.platform.persist.pojo.NetVote;
import com.lxx.app.common.util.page.PageRequest;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Service
public class NetVoteService {

    @Resource
    private
    NetVoteDao netVoteDao;

    public int saveNetVote(NetVote vote) {
        if (vote == null) {
            return 0;
        }

        return netVoteDao.saveNetVote(vote);
    }

    public List<NetVote> queryVotesByPage(PageRequest request) {
        return netVoteDao.queryNetVotesByPage(new RowBounds(request.getOffset(), request.getLimit()));
    }

    public NetVote queryNetVoteById(int id) {
        return netVoteDao.queryNetVoteById(id);
    }

    public int countNetVotes() {
        return netVoteDao.countNetVotes();
    }

    public int updateNetVote(NetVote netVote) {
        return netVoteDao.updateNetVote(netVote);
    }
}
