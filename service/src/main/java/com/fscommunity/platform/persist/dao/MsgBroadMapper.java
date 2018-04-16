package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.MsgBroad;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
public interface MsgBroadMapper {
    int insert(MsgBroad record);

    int getCount();

    List<MsgBroad> list(@Param("condition") String conditiion, RowBounds rowBounds);

    MsgBroad selectById(@Param("id") Integer id);

    int updateById(MsgBroad record);

    int deleteById(@Param("id") Integer id);

    int displayMsg(@Param("id")Integer id);

    List<MsgBroad> wxlist(RowBounds rowBounds);

    int directCount();

    MsgBroad getReplyMsg(@Param("targetCid") Integer id,@Param("targetUid") Integer userid);
}
