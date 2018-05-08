package com.fscommunity.platform.common.web.filter;

import com.fscommunity.platform.common.web.CookieManager;
import com.fscommunity.platform.common.web.LocalOpenidCache;
import com.fscommunity.platform.common.web.SessionHolder;
import com.google.common.base.Strings;
import com.lxx.app.common.util.json.JsonUtil;
import com.lxx.app.common.util.pojo.APIResponse;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lixiaoxiong
 * @version 2018-01-29
 */
public class WxOpenidAuthFilter implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(WxOpenidAuthFilter.class);

    @Resource
    SessionHolder sessionHolder;

    @Resource
    LocalOpenidCache localOpenidCache;
    @Value("${local.debug}")
    private String localDebug;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        logger.info("进入微信openid检测filter");
        String cookieValue = CookieManager.SESSION.getCookieValue();
        if ("true".equals(localDebug)) {
            sessionHolder.setOpenid("testOpenId");
            return true;
        }
        if (Strings.isNullOrEmpty(cookieValue) || Strings.isNullOrEmpty(localOpenidCache.queryOpenId(cookieValue))) {
            logger.info("没有openid cookie, 向微信请求code,进行微信认证");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            JsonUtil.instance().writeValue(response.getWriter(), APIResponse.error(101, "没有openid"));
            return false;
        }

        sessionHolder.setOpenid(cookieValue);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        sessionHolder.removeOpenid();
    }
}
