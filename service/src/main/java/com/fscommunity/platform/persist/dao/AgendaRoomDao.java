package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.AgendaRoomInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * @author liqingzhou on 18/4/29.
 */
@Repository
public interface AgendaRoomDao {
    int saveAgendaRoom(AgendaRoomInfo info);
    AgendaRoomInfo queryById(int id);
    int delById(int id);
    int countAgendaRoom(@Param("fuzzyName") String fuzzyName);
    int updateAgendaRoom(AgendaRoomInfo info);
    List<AgendaRoomInfo> list(@Param("fuzzyName") String fuzzyName, RowBounds rowBounds);

}
