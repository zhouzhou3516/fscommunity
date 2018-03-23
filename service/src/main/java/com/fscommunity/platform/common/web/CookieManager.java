package com.fscommunity.platform.common.web;

import com.google.common.collect.Lists;
import com.lxx.app.common.util.XXTEAUtil;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public enum CookieManager {
    SESSION("openid_session"),
    MAN_SESSION("man_login_session");
    private String name;

    CookieManager(String name) {
        this.name = name;
    }

    public String getCookieValue() {
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes()))
                .getRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            return null;
        }
        Optional<Cookie> first = Lists.newArrayList(cookies).parallelStream()
                .filter(cookie -> StringUtils.equals(cookie.getName(),
                        XXTEAUtil.encrypt(this.name))).findFirst();
        return first.isPresent()?first.get().getValue():null;
    }

    public void setCookieValue(HttpServletResponse response, String value) {
        Cookie cookie = new Cookie(XXTEAUtil.encrypt(this.name), value);
        cookie.setPath("/");
        cookie.setDomain("community-cloud.cn");
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
    }
}
