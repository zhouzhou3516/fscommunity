package com.fscommunity.platform.persist.pojo;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public enum CommentReplyStatus {
    NOT_REPLY(0, "未回复"),
    REPLIED(1, "已回复");
    private int code;
    private String desc;

    CommentReplyStatus(int code, String desc) {
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
