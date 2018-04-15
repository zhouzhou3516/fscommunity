package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.VoteItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 投票mapper
 * @Author jing.c
 * @Date: 18-3-28
 */
public interface VoteItemMapper {
    int insert(VoteItem record);

    List<VoteItem> queryItemsByIds(List<Integer> ids);
    List<VoteItem> queryItemsByVoteId(int voteId);

    int getCount();

    void lockForLock(int id);

    VoteItem selectById(@Param("id") Integer id);

    int updateById(VoteItem record);

    int updateCountById(@Param("id") int id, @Param("count") int count);

    int deleteById(@Param("id") Integer id);
}
