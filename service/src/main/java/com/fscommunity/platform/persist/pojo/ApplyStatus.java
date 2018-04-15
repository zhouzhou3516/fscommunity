package com.fscommunity.platform.persist.pojo;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public enum ApplyStatus {
    NEW(0, "报名成功"),
    AUTH_SUCC(1, "报名审核成功"),
    AUTH_FAIL(2, "报名审核失败");
    private int code;
    private String desc;

    ApplyStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
