package com.fscommunity.platform.common.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lxx.app.common.util.pojo.Bean;

/**
 * @author lixiaoxiong
 * @version 2018-01-24
 */
public class WxAccessToken extends Bean{
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private int expire;

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
}
