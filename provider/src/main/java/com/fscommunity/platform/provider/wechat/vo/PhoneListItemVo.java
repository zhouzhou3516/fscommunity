package com.fscommunity.platform.provider.wechat.vo;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class PhoneListItemVo {
    private int id;
    private String phone;
    private String owner;
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
