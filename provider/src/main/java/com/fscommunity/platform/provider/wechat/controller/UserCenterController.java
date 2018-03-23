package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.provider.wechat.vo.UserDetailVo;
import com.fscommunity.platform.provider.wechat.voadaptor.UserInfoVoAdaptor;
import com.fscommunity.platform.service.UserInfoService;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@RequestMapping("/fscommunity/user")
@Controller
public class UserCenterController {

    @Resource
    UserInfoService userInfoService;


    /**
     * 用户中心信息详情
     * @return 返回当前验证用户
     */
    @RequestMapping("/detail")
    @JsonBody
    public UserDetailVo queryUserDetail() {
        //todo 从上下文中获取当前用户
        UserInfo userInfo = userInfoService.queryUserById(1);
        return UserInfoVoAdaptor.adaptToDetailVo(userInfo);
    }
}
