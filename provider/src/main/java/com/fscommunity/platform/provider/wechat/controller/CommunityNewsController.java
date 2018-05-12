package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.provider.wechat.vo.CommunityNewsListVo;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqingzhou on 18/5/2
 */
@Controller
@RequestMapping("/fscommunity/wechat/communitynews")
public class CommunityNewsController {

    @RequestMapping("list")
    @JsonBody
    public CommunityNewsListVo list() {
        return null;
    }
}
