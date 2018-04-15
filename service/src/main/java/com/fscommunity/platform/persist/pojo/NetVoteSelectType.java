package com.fscommunity.platform.persist.pojo;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public enum NetVoteSelectType {
    RADIO(0,"单选"),
    ELECTION(1, "多选");
    private int code;
    private String desc;

    NetVoteSelectType(int code, String desc) {
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
