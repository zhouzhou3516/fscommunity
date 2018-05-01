package com.fscommunity.platform.persist.pojo;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public enum CommentAuthStatus {
    NOT_AUTH(0, "未审核"),
    AUTH_PASS(1, "审核通过"),
    NOT_PASS(2, "审核不通过");
    private int code;
    private String desc;

    CommentAuthStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
