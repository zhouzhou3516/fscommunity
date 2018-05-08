package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.persist.pojo.ProjectSubTypeInfo;
import com.fscommunity.platform.persist.pojo.ProjectType;
import com.fscommunity.platform.provider.wechat.vo.BaseContentDetailVo;
import com.fscommunity.platform.provider.wechat.vo.ChannelSubTypeVo;
import com.fscommunity.platform.provider.wechat.voadaptor.ChannelSubTypeVoAdapter;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.CategoryProjectService;
import com.fscommunity.platform.service.ProjectSubTypeService;
import com.fscommunity.platform.service.UserInfoService;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqingzhou on 18/5/3
 */
@Component
@RequestMapping("/fscommunity/wechat/servicestation")
public class ServiceStationController {

    @Resource
    private CategoryProjectService categoryProjectService;
    @Resource
    private ProjectSubTypeService subTypeService;
    @Resource
    private ArticleService articleService;
    @Resource
    private UserInfoService userInfoService;

    @JsonBody
    @RequestMapping("/types")
    public List<ChannelSubTypeVo> types() {
        List<ProjectSubTypeInfo> list = subTypeService.list(ProjectType.SERVICE_STATION.name());
        return ChannelSubTypeVoAdapter.adapt(list);
    }

    /**
     * @param id 服务工作站内容id
     */
    @JsonBody
    @RequestMapping("detail")
    public BaseContentDetailVo detailVo(int id) {
        //todo
        return null;
    }

}
