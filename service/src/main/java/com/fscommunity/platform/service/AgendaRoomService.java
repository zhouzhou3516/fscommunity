package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.AgendaRoomDao;
import com.fscommunity.platform.persist.pojo.AgendaRoomInfo;
import com.lxx.app.common.util.page.PageRequest;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

/**
 * @author liqingzhou on 18/4/29.
 */
@Service
public class AgendaRoomService {

    @Resource
    AgendaRoomDao agendaRoomDao;

    public int saveAgendaRoom(AgendaRoomInfo info) {
        return agendaRoomDao.saveAgendaRoom(info);
    }

    public AgendaRoomInfo queryById(int id) {
        return agendaRoomDao.queryById(id);
    }

    public List<AgendaRoomInfo> list(String fuzzyName, PageRequest request) {
        return agendaRoomDao.list(fuzzyName, new RowBounds(request.getOffset(), request.getLimit()));
    }

    public int countAgendaRoom(String fuzzyName) {
        return agendaRoomDao.countAgendaRoom(fuzzyName);
    }

    public int updateAgendaRoom(AgendaRoomInfo info) {
        return agendaRoomDao.updateAgendaRoom(info);
    }

    public void del(int activityId) {
        agendaRoomDao.delById(activityId);
    }
}
