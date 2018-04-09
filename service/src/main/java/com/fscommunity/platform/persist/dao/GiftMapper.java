package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.Gift;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface GiftMapper {
    int insert(Gift record);

    int insertSelective(Gift record);

    List<Gift> list(@Param("condition") String conditiion, RowBounds rowBounds);

    Gift selectById(@Param("id")Integer id);

    int updateById(Gift record);

    int pulloffById(@Param("id")Integer id);

    int deleteById(@Param("id")Integer id);

    int getCount();
}