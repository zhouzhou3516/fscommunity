package com.fscommunity.platform.provider.persist.dao;

import com.fscommunity.platform.provider.persist.pojo.IM;

public interface IMMapper {
    int insert(IM record);

    int insertSelective(IM record);
}