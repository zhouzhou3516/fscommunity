package com.fscommunity.platform.common.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author lixiaoxiong
 * @version 2018-02-02
 */
public class WxUserExt extends WxUser {
    private int subscribe;

    @JsonProperty("subscribe_time")
    private long subscribeTime;

    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

    public long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }
}
