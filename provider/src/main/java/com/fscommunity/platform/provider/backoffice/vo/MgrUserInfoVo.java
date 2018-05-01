package com.fscommunity.platform.provider.backoffice.vo;

import com.fscommunity.platform.persist.pojo.UserAuditStatus;
import com.lxx.app.common.util.pojo.Bean;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public class MgrUserInfoVo extends Bean{

    private String realName;
    private String cellPhone;
    private UserAuditStatus auditStatus;
    private String auditDesc;
    private String building;
    private String unit;
    private String root;//室

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public UserAuditStatus getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(UserAuditStatus auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }
}
