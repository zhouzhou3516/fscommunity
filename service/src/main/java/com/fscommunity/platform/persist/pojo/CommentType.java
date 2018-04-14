package com.fscommunity.platform.persist.pojo;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public enum CommentType {
    COMMENT_ARTICLE(0, "评论文章"),
    COMMENT_COMMENT(1, "评论评论");
    private int code;
    private String desc;

    CommentType(int code, String desc) {
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
