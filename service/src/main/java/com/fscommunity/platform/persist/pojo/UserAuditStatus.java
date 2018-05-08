package com.fscommunity.platform.persist.pojo;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public enum UserAuditStatus {
    UN_INIT(-1,"未导入"),
    INIT(0, "未注册"),
    UN_AUDIT(1, "待审核"),
    NOT_PASS(2, "审核不通过"),
    AUDITED(3, "审核通过");
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
