package com.fscommunity.platform.common.web.filter;

import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.common.pojo.SessionUserInfo;
import com.fscommunity.platform.common.web.CookieManager;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.service.ManUserService;
import com.google.common.base.Strings;
import com.lxx.app.common.util.Base64Util;
import com.lxx.app.common.util.json.JsonUtil;
import com.lxx.app.common.util.pojo.APIResponse;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lixiaoxiong
 * @version 2018-01-29
 */
public class ManAuthFilter implements HandlerInterceptor {

    @Resource
    ManUserService manUserService;

    @Resource
    SessionHolder sessionHolder;
    @Value("${local.debug}")
    private String localDebug;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        String cookieValue = CookieManager.MAN_SESSION.getCookieValue();
        if ("true".equals(localDebug)) {
            ManUser userInfo = new ManUser();
            userInfo.setId(1);
            userInfo.setRealName("lxx");
            userInfo.setUserName("lxx");
            sessionHolder.setManUser(userInfo);
            return true;
        }
        if (Strings.isNullOrEmpty(cookieValue)
                || sessionHolder.getSessionUser(Base64Util.decode(cookieValue)) == null) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            JsonUtil.instance().writeValue(response.getWriter(), APIResponse.error(102, "该用户未登录"));
            return false;
        }
        ManUser manUser = sessionHolder.getSessionUser(Base64Util.decode(cookieValue));
        sessionHolder.setManUser(manUser);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        sessionHolder.removeManUser();
    }
}
