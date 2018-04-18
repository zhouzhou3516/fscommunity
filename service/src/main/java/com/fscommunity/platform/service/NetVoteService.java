package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.NetVoteDao;
import com.fscommunity.platform.persist.pojo.NetVote;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.lxx.app.common.util.page.PageRequest;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Service
public class NetVoteService {
    private final static Splitter COMM_SPLITTER = Splitter.on(",");
    @Resource
    private
    NetVoteDao netVoteDao;

    public NetVote saveNetVote(NetVote vote) {
        if (vote == null) {
            return null;
        }

        netVoteDao.saveNetVote(vote);
        return vote;
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

    public List<Integer> idsFromStr(String ids) {
        if (Strings.isNullOrEmpty(ids)) {
            return Collections.EMPTY_LIST;
        }

        return Lists.newArrayList(COMM_SPLITTER.split(ids)).stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}
