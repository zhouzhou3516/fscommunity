package com.fscommunity.platform.provider.persist.dao;

import com.fscommunity.platform.provider.persist.pojo.Gift;

public interface GiftMapper {
    int insert(Gift record);

    int insertSelective(Gift record);
}