package com.fscommunity.platform.provider.backoffice.vo;

import com.fscommunity.platform.persist.pojo.UserAuditStatus;
import com.lxx.app.common.util.pojo.Bean;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public class MgrUserInfoVo extends Bean{
    private int id;
    private String realName;
    private String cellPhone;
    private UserAuditStatus auditStatus;
    private String auditDesc;
    private String street;
    private String community;
    private String building;
    private String unit;
    private String room;//室

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
