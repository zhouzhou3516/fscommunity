package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.ProjectSubTypeDao;
import com.fscommunity.platform.persist.pojo.ProjectSubTypeInfo;
import com.lxx.app.common.util.page.PageRequest;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

/**
 * @author liqingzhou on 18/4/29.
 */
@Service
public class ProjectSubTypeService {

    @Resource
    ProjectSubTypeDao projectSubTypeDao;

    public int saveProjectSubType(ProjectSubTypeInfo info) {
        return projectSubTypeDao.saveProjectSubType(info);
    }

    public ProjectSubTypeInfo queryById(int id) {
        return projectSubTypeDao.queryById(id);
    }

    public List<ProjectSubTypeInfo> list(String projectType) {
        return projectSubTypeDao.list(projectType);
    }

    public void del(int activityId) {
        projectSubTypeDao.delById(activityId);
    }
}
