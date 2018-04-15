package com.fscommunity.platform.persist.pojo;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public enum  ActivityApplyCostType {
    COST_INTERVAL(0, "积分支付"),
    COST_COIN(1, "金币支付"),
    EARN_INTERVAL(2, "奖励积分"),
    EARN_COIN(3, "奖励金币");
    private int code;
    private String desc;
    ActivityApplyCostType(int code, String desc) {
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
