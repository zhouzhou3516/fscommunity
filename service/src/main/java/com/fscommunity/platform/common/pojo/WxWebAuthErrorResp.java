package com.fscommunity.platform.common.pojo;

/**
 * @author lixiaoxiong
 * @version 2018-01-24
 */
public class WxWebAuthErrorResp {
    private int errcode;
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
