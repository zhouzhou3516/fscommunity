package com.fscommunity.platform.common.web.filter;

import com.fscommunity.platform.common.web.WxInvoker;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lixiaoxiong
 * @version 2018-01-24
 */
public class WxWebAuthFilter implements HandlerInterceptor{
    private final static Logger logger  = LoggerFactory.getLogger(WxWebAuthFilter.class);
    @Resource
    WxInvoker wxInvoker;

    @Resource
    StaffInfoService staffInfoService;

    @Resource
    SessionUserHolder sessionUserHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        logger.info("进入微信验证检测filter");
        String cookieValue = CookieManager.SESSION.getCookieValue();
        StaffInfo info = staffInfoService.queryStaffByOpenid(cookieValue);
        if (info ==  null || info.getVerifyStatus() != StaffVerifyStatus.VERIFIED) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            JsonUtil.instance().writeValue(response.getWriter(), APIResponse.error(102, "该用户未验证"));
            return false;
        }
        sessionUserHolder.setSession(cookieValue, staffInfoService.queryStaffByOpenid(cookieValue));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        sessionUserHolder.removeSession();
        sessionUserHolder.removeOpenid();
    }
}
