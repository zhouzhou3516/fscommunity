package com.fscommunity.platform.persist.pojo;

import com.fscommunity.platform.common.BloodType;
import com.fscommunity.platform.common.IDCardType;
import com.fscommunity.platform.common.NationalityType;
import com.fscommunity.platform.common.Sex;
import java.util.Date;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public class UserInfo {

    /**
     * 数据库唯一id标识
     */
    private int id;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机
     */
    private String cellPhone;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 证件类型
     */
    private IDCardType idCardType;

    /**
     * 证件编码
     */
    private String idNo;

    /**
     * 性别
     */
    private Sex sex;

    /**
     * 出生日志 yyyy-MM-dd
     */
    private String birthday;

    /**
     * 年龄
     */
    private int age;

    /**
     * 民族
     */
    private NationalityType nation;

    /**
     * 政治面貌
     */
    private String politiceStatus;

    /**
     * 户口类别
     */
    private String registerType;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 是否是社区直管党员
     */
    private boolean partyMemOfCommunity;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 身高
     */
    private int height;


    /**
     * 血型
     */
    private BloodType bloodType;


    /**
     * 兵役情况
     */
    private String militaryService;

    private String remark;

    private UserBaseinfo baseinfo;

    private UserAddressInfo addressInfo;

    private Date createTime;

    private Date updateTime;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public IDCardType getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(IDCardType idCardType) {
        this.idCardType = idCardType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public NationalityType getNation() {
        return nation;
    }

    public void setNation(NationalityType nation) {
        this.nation = nation;
    }

    public String getPoliticeStatus() {
        return politiceStatus;
    }

    public void setPoliticeStatus(String politiceStatus) {
        this.politiceStatus = politiceStatus;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public boolean isPartyMemOfCommunity() {
        return partyMemOfCommunity;
    }

    public void setPartyMemOfCommunity(boolean partyMemOfCommunity) {
        this.partyMemOfCommunity = partyMemOfCommunity;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public String getMilitaryService() {
        return militaryService;
    }

    public void setMilitaryService(String militaryService) {
        this.militaryService = militaryService;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public UserBaseinfo getBaseinfo() {
        return baseinfo;
    }

    public void setBaseinfo(UserBaseinfo baseinfo) {
        this.baseinfo = baseinfo;
    }

    public UserAddressInfo getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(UserAddressInfo addressInfo) {
        this.addressInfo = addressInfo;
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
