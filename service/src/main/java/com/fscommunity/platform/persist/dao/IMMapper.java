package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.IM;

public interface IMMapper {
    int insert(IM record);

    int insertSelective(IM record);
}