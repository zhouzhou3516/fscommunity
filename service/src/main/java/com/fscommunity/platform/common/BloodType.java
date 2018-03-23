package com.fscommunity.platform.common;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public enum BloodType {
    A(0, "A"),
    B(1, "B"),
    AB(2, "C"),
    O(3, "D");
    private int code;
    private String desc;

    BloodType(int code, String desc) {
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
