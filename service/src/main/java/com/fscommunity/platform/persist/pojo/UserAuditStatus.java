package com.fscommunity.platform.persist.pojo;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public enum UserAuditStatus {
    NO_AUDIT(0, "未审核"),
    AUDIT_SUCC(1, "审核成功"),
    AUDIT_FAIL(2, "审核失败");
    private int code;
    private String desc;

    UserAuditStatus(int code, String desc) {
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
