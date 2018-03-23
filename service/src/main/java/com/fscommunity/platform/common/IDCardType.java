package com.fscommunity.platform.common;

import java.text.MessageFormat;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public enum  IDCardType {
    ID(1, "身份证"),

    OFFICE(2, "中国人民解放军军人证"),

    POLICE(3, "中国人民武装警察身份证"),

    HKT(4, "港澳居民来往大陆通行证"),

    TW(5, "台湾居民来往大陆通行证"),

    PASSPORT(6, "护照"),

    DRIVER_LICENSE(7, "机动车驾驶证"),

    CHINESE_ACCOUNT(8, "户口"),

    OTHER(99, "其他")

            ;

    private final String desc;

    private final int code;

    IDCardType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }

    public static IDCardType of(int code) {
        for (IDCardType cardType : values()) {
            if (cardType.code == code) {
                return cardType;
            }
        }
        throw new IllegalArgumentException(
                MessageFormat.format("unknown idcard type, code: {0}", code));
    }
}
