package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;
import java.util.Date;

/**
 * @author lixiaoxiong
 * @version 2018-02-01
 */
public class WxTokenItem extends Bean {
    private String value;
    private Date expireTime;

    public WxTokenItem(String value, Date expireTime) {
        this.value = value;
        this.expireTime = expireTime;
    }

    public WxTokenItem() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
