package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.CategoryProjectInfo;
import com.fscommunity.platform.persist.pojo.ProjectSubTypeInfo;
import com.fscommunity.platform.provider.backoffice.adapter.CategoryProjectAdapter;
import com.fscommunity.platform.provider.backoffice.req.AddCategoryProjectReq;
import com.fscommunity.platform.provider.backoffice.req.AddNewProjectSubTypeReq;
import com.fscommunity.platform.provider.backoffice.req.CategoryProjectListQueryReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrCategoryProjectItemVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrCategoryProjectListVo;
import com.fscommunity.platform.provider.backoffice.vo.ProjectSubTypeVo;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.CategoryProjectService;
import com.fscommunity.platform.service.ProjectSubTypeService;
import com.google.common.collect.Lists;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 社区咨询，党建工作，服务工作站 的 man 接口都用该controller
 *
 * @author liqingzhou on 18/4/29
 */
@Component
@RequestMapping("/fscommunity/man/categoryProject")
public class MgrCategoryProjectController {


    @Resource
    private CategoryProjectService categoryProjectService;
    @Resource
    private ArticleService articleService;
    @Resource
    private ProjectSubTypeService subTypeService;

    //both support update save
    @RequestMapping("/save")
    @JsonBody
    public void save(@RequestBody AddCategoryProjectReq req) {
        Article article = articleService.selectById(req.getArticleId());
        if (article == null) {
            throw new BizException("文章链接不存在");
        }
        if (req.getId() <= 0) {
            categoryProjectService.saveCategoryProject(CategoryProjectAdapter.adaptToInfo(req));
        } else {
            categoryProjectService.updateCategoryProject(CategoryProjectAdapter.adaptToInfo(req));
        }
    }

    @RequestMapping("/list")
    @JsonBody
    public MgrCategoryProjectListVo list(@RequestBody CategoryProjectListQueryReq req) {
        List<CategoryProjectInfo> agendaRoomInfoList = categoryProjectService
                .list(req.getProjectType().name(), req.getSubType(),
                        new PageRequest(req.getCurrentPage(), req.getPageSize()));
        MgrCategoryProjectListVo vo = new MgrCategoryProjectListVo();
        if (CollectionUtils.isEmpty(agendaRoomInfoList)) {
            vo.setCount(0);
            vo.setItems(Collections.EMPTY_LIST);
            return vo;
        }
        List<Integer> aids = agendaRoomInfoList.stream().map(info -> Integer.valueOf(info.getArticleId()))
                .collect(Collectors.toList());
        List<Article> articleList = articleService.selectByIds(aids);
        Map<Integer, Article> articleMap = articleList.stream().collect(Collectors.toMap(a -> a.getId(), a -> a));
        List<MgrCategoryProjectItemVo> listVos = CategoryProjectAdapter.adaptItemVos(agendaRoomInfoList, articleMap);
        vo.setCount(categoryProjectService.countCategoryProject(req.getProjectType().name(), req.getSubType()));
        vo.setItems(listVos);
        return vo;
    }


    @RequestMapping("/del")
    @JsonBody
    public void del(int id) {
        categoryProjectService.del(id);
    }

    @RequestMapping("/addType")
    @JsonBody
    public void addType(@RequestBody AddNewProjectSubTypeReq req) {
        ProjectSubTypeInfo info = new ProjectSubTypeInfo();
        info.setProjectType(req.getProjectType());
        info.setSubType(req.getSubType());
        info.setOrders(req.getOrders());
        subTypeService.saveProjectSubType(info);
    }

    @RequestMapping("/typeList")
    @JsonBody
    public List<ProjectSubTypeVo> typeList(String projectType) {
        List<ProjectSubTypeInfo> list = subTypeService.list(projectType);
        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        return list.stream().map(projectSubTypeInfo -> new ProjectSubTypeVo(projectSubTypeInfo.getSubType()))
                .collect(Collectors.toList());

    }

    /**
     * status:1置顶 0取消置顶
     * @param
     */
    @RequestMapping("stickypost")
    @JsonBody
    public void stickyPost(int projectId,int status){

        CategoryProjectInfo projectInfo = categoryProjectService.queryById(projectId);
        if(projectInfo == null){
            throw new BizException("置顶内容不存在");
        }
        if(projectInfo.getStickyStatus() == status){
            return ;
        }
        categoryProjectService.sticky(projectId, status);
    }


}
