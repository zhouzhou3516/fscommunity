package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.ConsultListeningDao;
import com.fscommunity.platform.persist.pojo.ConsultListeningInfo;
import com.lxx.app.common.util.page.PageRequest;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

/**
 * @author liqingzhou on 18/5/1
 */
@Service
public class ConsultListeningService {

    @Resource
    ConsultListeningDao consultListeningDao;

    public int saveConsultListening(ConsultListeningInfo info) {
        return consultListeningDao.saveConsultListening(info);
    }

    public ConsultListeningInfo queryById(int id) {
        return consultListeningDao.queryById(id);
    }

    public List<ConsultListeningInfo> list(String channelType, String consultType, PageRequest request) {
        return consultListeningDao
                .list(channelType, consultType, new RowBounds(request.getOffset(), request.getLimit()));
    }

    public int countList(String channelType, String consultType) {
        return consultListeningDao.countList(channelType, consultType);
    }

    public void del(int activityId) {
        consultListeningDao.delById(activityId);
    }

    public void reply(int id, String replyContent, int userId) {
        consultListeningDao.reply(id, replyContent, userId);
    }
}
