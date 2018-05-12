package com.fscommunity.platform.persist.dao;

import com.fscommunity.platform.persist.pojo.CategoryProjectInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

/**
 * @author liqingzhou on 18/4/29.
 */
@Repository
public interface CategoryProjectDao {

    int saveCategoryProject(CategoryProjectInfo info);

    CategoryProjectInfo queryById(int id);

    int delById(int id);

    int countCategoryProject(@Param("projectType") String projectType, @Param("subType") String subType);

    int updateCategoryProject(CategoryProjectInfo info);

    List<CategoryProjectInfo> list(@Param("projectType") String projectType, @Param("subType") String subType,
            RowBounds rowBounds);

    /**
     * 置顶
     */
    void stick(@Param("projectId") int projectId, @Param("status") int status);

    List<CategoryProjectInfo> listSticky(String projectType, RowBounds rowBounds);
}
