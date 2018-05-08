package com.fscommunity.platform.common.web;

import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.common.pojo.SessionUserInfo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@Service
public class SessionHolder {

    private static ThreadLocal<String> openidHolder = new ThreadLocal<>();
    private static ThreadLocal<SessionUserInfo> userHolder = new ThreadLocal<>();

    private static ThreadLocal<ManUser> manUserHolder = new ThreadLocal<>();
    private static ConcurrentMap<String, ManUser> manUserSession = new ConcurrentHashMap<>();

    public void setOpenid(String openid) {
        openidHolder.set(openid);
    }

    public void removeOpenid() {
        openidHolder.remove();
    }

    public String currentOpenId() {
        return openidHolder.get();
    }


    public void setManUser(ManUser manUser) {
        manUserHolder.set(manUser);
    }

    public void setManUser(String key, ManUser manUser) {
        manUserSession.put(key, manUser);
    }

    public void removeManUser() {
        manUserHolder.remove();
    }

    public void removeUserSession(String key) {
        manUserSession.remove(key);
    }

    public ManUser currentManUser() {
        return manUserHolder.get();
    }

    public ManUser getSessionUser(String key) {
        return manUserSession.get(key);
    }

    // wechat
    public void setUser(SessionUserInfo user) {
        userHolder.set(user);
    }

    public SessionUserInfo currentUser() {
        return userHolder.get();
    }

    public void removeUser() {
        userHolder.remove();
    }
}
