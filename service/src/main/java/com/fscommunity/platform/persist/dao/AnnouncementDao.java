package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.AnnouncementInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * @author liqingzhou on 18/4/29.
 */
@Repository
public interface AnnouncementDao {
    int saveAnnouncement(AnnouncementInfo info);
    AnnouncementInfo queryById(int id);
    int delById(int id);
    int countAnnouncement(@Param("fuzzyName") String fuzzyName);
    int updateAnnouncement(AnnouncementInfo info);
    List<AnnouncementInfo> list(@Param("fuzzyName") String fuzzyName, RowBounds rowBounds);

}
