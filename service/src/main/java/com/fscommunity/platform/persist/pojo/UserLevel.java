package com.fscommunity.platform.persist.pojo;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public enum UserLevel {
    LV0(0, "初级"),
    LV1(1, "一级"),
    LV2(2, "二级"),
    LV3(3, "三级"),
    LV4(4, "四级"),
    LV5(5, "五级"),
    LV6(6, "六级"),
    LV7(7, "七级"),
    LV8(8, "八级"),
    LV9(9, "九级"),
    LV10(10, "十级"),
    LV11(11, "十一级"),
    LV12(12, "十二级"),
    LV13(13, "十三级"),
    LV14(14, "十四级"),
    LV15(15, "十五级"),
    LV16(16, "十六级"),
            ;
    private int code;
    private String desc;

    UserLevel(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UserLevel codeOf(int code) {
        for (UserLevel level : values()) {
            if (level.getCode() == code) {
                return level;
            }
        }
        return LV0;
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
