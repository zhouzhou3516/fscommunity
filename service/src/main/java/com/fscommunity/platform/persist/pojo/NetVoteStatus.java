package com.fscommunity.platform.persist.pojo;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public enum NetVoteStatus {
    VALID(0, "有效的"),
    INVALID(1, "无效的");
    private int code;
    private String desc;

    NetVoteStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
