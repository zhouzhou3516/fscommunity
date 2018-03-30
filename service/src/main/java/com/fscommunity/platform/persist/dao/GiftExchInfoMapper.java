package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.GiftExchInfo;

import java.util.List;

public interface GiftExchInfoMapper {
    int insert(GiftExchInfo record);

    int insertSelective(GiftExchInfo record);

    List<GiftExchInfo> list(String condition);

    GiftExchInfo selectById(Integer integer);

    int deleteById(Integer integer);

    int updateById(GiftExchInfo gift);
}