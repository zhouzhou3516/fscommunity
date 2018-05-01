package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.ConsultListeningInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * @author liqingzhou on 18/5/1.
 */
@Repository
public interface ConsultListeningDao {

    int saveConsultListening(ConsultListeningInfo info);

    ConsultListeningInfo queryById(int id);

    int delById(int id);

    List<ConsultListeningInfo> list(@Param("channelType") String channel, @Param("consultType") String consultType,
            RowBounds rowBounds);

    int countList(@Param("channelType") String channel, @Param("consultType") String consultType);

    void reply(@Param("id") int id, @Param("replyContent") String replyContent, @Param("replyUserId") int userId);
}
