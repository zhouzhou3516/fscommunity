package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.MsgBroad;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
@Repository
public interface MsgBroadMapper {
    int insert(MsgBroad record);
    MsgBroad queryById(int id);
    int updateTreeCode(@Param("id") int id, @Param("treecode") String treecode);
    int lockForUpdate(int id);
    int updateIsReplied(@Param("id") int id);

    List<MsgBroad> list(@Param("authStatus") int authStatus, @Param("replyStatus") int replyStatus, RowBounds rowBounds);

    int countList(@Param("authStatus") int authStatus, @Param("replyStatus") int replyStatus);

    int updateAuthStatus(@Param("id") Integer id,@Param("status") Integer authStatus);

    List<MsgBroad> queryByRootCId(@Param("rootCid") int targetId, RowBounds rowBounds);
    List<MsgBroad> wxlist( RowBounds rowBounds);

    List<MsgBroad> queryReplyByRootCids(List<Integer> ids);

}
