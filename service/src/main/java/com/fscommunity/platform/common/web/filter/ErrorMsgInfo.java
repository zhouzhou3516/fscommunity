package com.fscommunity.platform.common.web.filter;

/**
 * @author liqingzhou on 18/5/7
 */
public class ErrorMsgInfo {

    private Integer code;
    private String msg;

    public ErrorMsgInfo() {
    }

    public ErrorMsgInfo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
