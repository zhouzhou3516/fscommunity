package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.NetVoteRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Repository
public interface NetVoteRecordDao {

    int save(NetVoteRecord voteRecord);

    NetVoteRecord selectOne(@Param("voteId") int voteId, @Param("userId") int userId);
}
