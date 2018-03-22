package com.fscommunity.platform.provider.persist.dao;

import com.fscommunity.platform.provider.persist.pojo.GiftExchInfo;

public interface GiftExchInfoMapper {
    int insert(GiftExchInfo record);

    int insertSelective(GiftExchInfo record);
}