package com.fscommunity.platform.common.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lxx.app.common.util.pojo.Bean;

/**
 * @author lixiaoxiong
 * @version 2018-01-24
 */
public class WxWebAuthToken extends Bean {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private int expire;

    @JsonProperty("refresh_token")
    private String refreshToken;
    private String openid;
    private String scope;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
