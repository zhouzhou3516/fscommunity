package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.common.web.CookieManager;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.provider.backoffice.req.ManLoginAuthReq;
import com.fscommunity.platform.service.ManUserService;
import com.lxx.app.common.util.Base64Util;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
@RequestMapping("/fscommunity/man/auth")
@Controller
public class BackOfficeAuthController {

    @Resource
    ManUserService manUserService;

    @Resource
    SessionHolder sessionHolder;

    @RequestMapping("/login")
    @JsonBody
    public ManUser auth(@RequestBody ManLoginAuthReq req, HttpServletResponse response) {
        ManUser manUser = manUserService.authUser(req.getUserName(), req.getPassword());
        if (manUser == null) {
            throw new BizException("用户名或密码错误");
        }

        CookieManager.MAN_SESSION.setCookieValue(response, Base64Util.encode(manUser.getUserName()));
        sessionHolder.setManUser(req.getUserName(), manUser);
        return manUser;
    }

    @RequestMapping("/currentUser")
    @JsonBody
    public ManUser currentUser() {
        return sessionHolder.currentManUser();
    }

    @RequestMapping("/logout")
    @JsonBody
    public void logout() {
        ManUser manUser = sessionHolder.currentManUser();
        sessionHolder.removeUserSession(manUser.getUserName());
    }
}
