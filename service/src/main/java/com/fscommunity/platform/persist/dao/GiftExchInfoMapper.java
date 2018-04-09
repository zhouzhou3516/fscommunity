package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.GiftExchInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface GiftExchInfoMapper {
    int insert(GiftExchInfo record);

    int insertSelective(GiftExchInfo record);

    List<GiftExchInfo> list(@Param("condition")String condition, RowBounds rowBounds);

    GiftExchInfo selectById(@Param("id")Integer integer);

    int deleteById(@Param("id")Integer integer);

    int updateById(GiftExchInfo gift);

    int getCount();
}