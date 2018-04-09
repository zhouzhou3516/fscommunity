package com.fscommunity.platform.persist.pojo;

/**
 * @author lixiaoxiong
 * @version 2018-01-20
 */
public enum VerifyCodeStatus {
    NEW(0, "新生成, 未使用"),
    USED(1, "已使用"),
    DISCARD(2, "废弃");
    private int id;
    private String desc;

    VerifyCodeStatus(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }
}
