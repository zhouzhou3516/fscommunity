package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.OpLog;

public interface OpLogMapper {
    int deleteByPrimaryKey(Integer opId);

    int insert(OpLog record);

    int insertSelective(OpLog record);

    OpLog selectByPrimaryKey(Integer opId);

    int updateByPrimaryKeySelective(OpLog record);

    int updateByPrimaryKey(OpLog record);
}