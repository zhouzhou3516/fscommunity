package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.CategoryProjectDao;
import com.fscommunity.platform.persist.pojo.CategoryProjectInfo;
import com.lxx.app.common.util.page.PageRequest;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

/**
 * @author liqingzhou on 18/4/29.
 */
@Service
public class CategoryProjectService {

    @Resource
    CategoryProjectDao categoryProjectDao;

    public int saveCategoryProject(CategoryProjectInfo info) {
        return categoryProjectDao.saveCategoryProject(info);
    }

    public CategoryProjectInfo queryById(int id) {
        return categoryProjectDao.queryById(id);
    }

    public List<CategoryProjectInfo> list(String projectType, String subType, PageRequest request) {
        return categoryProjectDao.list(projectType, subType, new RowBounds(request.getOffset(), request.getLimit()));
    }

    public int countCategoryProject(String projectType, String subType) {
        return categoryProjectDao.countCategoryProject(projectType, subType);
    }

    public int updateCategoryProject(CategoryProjectInfo info) {
        return categoryProjectDao.updateCategoryProject(info);
    }

    public void del(int activityId) {
        categoryProjectDao.delById(activityId);
    }
}
