package com.fscommunity.platform.common.web.filter;

import com.fscommunity.platform.common.pojo.SessionUserAdapter;
import com.fscommunity.platform.common.pojo.SessionUserInfo;
import com.fscommunity.platform.common.web.CookieManager;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.common.web.WxInvoker;
import com.fscommunity.platform.persist.pojo.UserAuditStatus;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.persist.pojo.WxUser;
import com.fscommunity.platform.service.UserInfoService;
import com.fscommunity.platform.service.WxUserService;
import com.google.common.collect.Maps;
import com.lxx.app.common.util.json.JsonUtil;
import com.lxx.app.common.util.pojo.APIResponse;
import java.util.Map;
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
 * @version 2018-01-24
 */
public class WxWebAuthFilter implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(WxWebAuthFilter.class);
    private static Map<UserAuditStatus, ErrorMsgInfo> errorCodeMap = Maps.newHashMap();

    static {
        errorCodeMap.put(UserAuditStatus.UN_INIT, new ErrorMsgInfo(103, "还未注册"));//未导入->前端阻止用户进入
        errorCodeMap.put(UserAuditStatus.INIT, new ErrorMsgInfo(102, "还未注册"));//未审核->前端跳转注册接口
        errorCodeMap.put(UserAuditStatus.UN_AUDIT, new ErrorMsgInfo(104, "还未审核"));//未审核->前端跳转注册接口
        errorCodeMap.put(UserAuditStatus.NOT_PASS, new ErrorMsgInfo(105, "审核不通过"));//审核不通过->前端阻止用户进入
    }

    @Resource
    WxInvoker wxInvoker;
    @Resource
    UserInfoService userInfoService;
    @Resource
    WxUserService wxUserService;
    @Resource
    SessionHolder sessionHolder;
    @Value("${local.debug}")
    private String localDebug;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        logger.info("进入微信验证检测filter");
        if ("true".equals(localDebug)) {
            SessionUserInfo userInfo = new SessionUserInfo();
            userInfo.setOpenId("testopenid");
            userInfo.setCellPhone("1231");
            userInfo.setWxNickname("lqz");
            userInfo.setUserId(1);
            sessionHolder.setUser(userInfo);
            return true;
        }
        String openid = CookieManager.SESSION.getCookieValue();
        UserInfo info = userInfoService.queryUserInfoByOpenId(openid);
        if(info == null){
            info = new UserInfo();
            info.setAuditStatus(UserAuditStatus.UN_INIT);
        }
        if (info.getAuditStatus() != UserAuditStatus.AUDITED) {
            ErrorMsgInfo error = errorCodeMap.get(info.getAuditStatus());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            JsonUtil.instance().writeValue(response.getWriter(),
                    APIResponse.error(error.getCode(), error.getMsg()));
            return false;
        }
        WxUser wxUser = wxUserService.queryWxUserByOpenid(openid);
        sessionHolder.setUser(SessionUserAdapter.adapt(info, wxUser));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        sessionHolder.removeUser();
    }
}
