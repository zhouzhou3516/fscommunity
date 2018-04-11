package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.Vote;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Description 投票mapper
 * @Author jing.c
 * @Date: 18-3-28
 */
public interface VoteMapper {
    int insert(Vote record);

    int insertSelective(Vote record);

    int getCount();

    List<Vote> list(@Param("condition") String conditiion, RowBounds rowBounds);

    Vote selectById(@Param("id") Integer id);

    int updateById(Vote record);

    int deleteById(@Param("id") Integer id);

    int updateViewsById(@Param("id") Integer integer, @Param("views") Integer views);

    int updateStateById(@Param("id")Integer id, @Param("voteState")Integer state);
}
