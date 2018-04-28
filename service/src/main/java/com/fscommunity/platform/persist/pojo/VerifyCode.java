package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;
import java.util.Date;

/**
 * @author lixiaoxiong
 * @version 2018-01-20
 */
public class VerifyCode extends Bean {
    private int id;

    /**
     * 发送的电话号码
     */
    private String phone;

    /**
     * 验证码
     */
    private String code;

    /**
     * 业务类型
     */
    private VerifyBizType bizType;

    /**
     * 验证码状态
     */
    private VerifyCodeStatus codeStatus;

    /**
     * 创建时间
     */
    private Date createTime;
    private Date updateTime;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public VerifyBizType getBizType() {
        return bizType;
    }

    public void setBizType(VerifyBizType bizType) {
        this.bizType = bizType;
    }

    public VerifyCodeStatus getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(VerifyCodeStatus codeStatus) {
        this.codeStatus = codeStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
