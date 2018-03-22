package com.fscommunity.platform.provider.persist.dao;

import com.fscommunity.platform.provider.persist.pojo.MgrType;

public interface MgrTypeMapper {
    int insert(MgrType record);

    int insertSelective(MgrType record);
}