package com.fscommunity.platform.persist.pojo;

/**
 * @author lixiaoxiong
 * @version 2018-01-20
 */
public enum VerifyBizType {
    FILL_DETAIL_INFO_CODE(0, "填充会员相信信息的验证码");
    private int id;
    private String desc;

    VerifyBizType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
