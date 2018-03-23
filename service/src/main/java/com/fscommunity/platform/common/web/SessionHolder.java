package com.fscommunity.platform.common.web;

import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@Service
public class SessionHolder {
    private static ThreadLocal<String> openidHolder = new ThreadLocal<>();

    public void setOpenid(String openid) {
        openidHolder.set(openid);
    }

    public void removeOpenid() {
        openidHolder.remove();
    }

    public String currentOpenId() {
        return openidHolder.get();
    }
}
