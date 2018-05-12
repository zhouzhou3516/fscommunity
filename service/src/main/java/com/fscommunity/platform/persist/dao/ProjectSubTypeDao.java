package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.ProjectSubTypeInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * @author liqingzhou on 18/4/29.
 */
@Repository
public interface ProjectSubTypeDao {

    int saveProjectSubType(ProjectSubTypeInfo info);

    ProjectSubTypeInfo queryById(int id);

    int delById(int id);


    List<ProjectSubTypeInfo> list(@Param("projectType") String projectType);

}
