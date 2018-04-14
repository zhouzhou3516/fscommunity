package com.fscommunity.platform.common.constant;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public enum ArticleType {
    ACTIVITY_INFO(0, "活动信息"),
    NETWORK_VOTING(1, "网络投票");
    private int code;
    private String desc;

    ArticleType(int code, String desc) {
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
