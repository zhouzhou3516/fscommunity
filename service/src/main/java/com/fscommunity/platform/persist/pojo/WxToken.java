package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;
import java.util.Date;

/**
 * @author lixiaoxiong
 * @version 2018-02-01
 */
public class WxToken extends Bean {

    /**
     * 公众号code
     */
    private String wxCode;
    private WxTokenItem interfaceToken;
    private WxTokenItem webAuthToken;
    private WxTokenItem webAuthRefreshToken;
    private WxTokenItem jsApiTicket;
    private Date createTime;
    private Date updateTime;

    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }

    public WxTokenItem getInterfaceToken() {
        return interfaceToken;
    }

    public void setInterfaceToken(WxTokenItem interfaceToken) {
        this.interfaceToken = interfaceToken;
    }

    public WxTokenItem getWebAuthToken() {
        return webAuthToken;
    }

    public void setWebAuthToken(WxTokenItem webAuthToken) {
        this.webAuthToken = webAuthToken;
    }

    public WxTokenItem getWebAuthRefreshToken() {
        return webAuthRefreshToken;
    }

    public void setWebAuthRefreshToken(WxTokenItem webAuthRefreshToken) {
        this.webAuthRefreshToken = webAuthRefreshToken;
    }

    public WxTokenItem getJsApiTicket() {
        return jsApiTicket;
    }

    public void setJsApiTicket(WxTokenItem jsApiTicket) {
        this.jsApiTicket = jsApiTicket;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
