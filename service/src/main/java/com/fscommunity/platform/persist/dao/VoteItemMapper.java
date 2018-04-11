package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.VoteItem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Description 投票mapper
 * @Author jing.c
 * @Date: 18-3-28
 */
public interface VoteItemMapper {
    int insert(VoteItem record);

    int insertSelective(VoteItem record);

    int getCount();

    List<VoteItem> list(@Param("condition") String conditiion, RowBounds rowBounds);

    VoteItem selectById(@Param("id") Integer id);

    int updateById(VoteItem record);

    int deleteById(@Param("id") Integer id);

    List<VoteItem> selectByVoteId(@Param("vote_id") Integer integer);
}
