package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.AnnouncementDao;
import com.fscommunity.platform.persist.pojo.AnnouncementInfo;
import com.lxx.app.common.util.page.PageRequest;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

/**
 * @author liqingzhou on 18/4/29.
 */
@Service
public class AnnouncementService {

    @Resource
    AnnouncementDao announcementDao;

    public int saveAnnouncement(AnnouncementInfo info) {
        return announcementDao.saveAnnouncement(info);
    }

    public AnnouncementInfo queryById(int id) {
        return announcementDao.queryById(id);
    }
    public List<AnnouncementInfo> list(String fuzzyName, PageRequest request) {
        return announcementDao.list(fuzzyName, new RowBounds(request.getOffset(), request.getLimit()));
    }
    public int countAnnouncement(String fuzzyName) {
        return announcementDao.countAnnouncement(fuzzyName);
    }

    public int updateAnnouncement(AnnouncementInfo info) {
        return announcementDao.updateAnnouncement(info);
    }

    public void del(int activityId) {
        announcementDao.delById(activityId);
    }
}
