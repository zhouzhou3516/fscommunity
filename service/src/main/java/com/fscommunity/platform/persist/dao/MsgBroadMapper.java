package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.MsgBroad;
import org.apache.ibatis.annotations.Param;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
public interface MsgBroadMapper {
    int insert(MsgBroad record);
    MsgBroad queryById(int id);
    int updateTreeCode(@Param("id") int id, @Param("treecode") String treecode);
    int lockForUpdate(int id);
}
