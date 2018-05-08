package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.NetVoteRecordDao;
import com.fscommunity.platform.persist.pojo.NetVoteRecord;
import com.google.common.base.Splitter;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Service
public class NetVoteRecordService {

    @Resource
    private
    NetVoteRecordDao netVoteRecordDao;

    public NetVoteRecord saveVoteRecord(NetVoteRecord record) {
        if (record == null) {
            return null;
        }
        netVoteRecordDao.save(record);
        return record;
    }

    public boolean hasVoted(int voteId, int userId) {
        NetVoteRecord record = netVoteRecordDao.selectOne(voteId, userId);
        return record == null ? false : true;
    }
}
