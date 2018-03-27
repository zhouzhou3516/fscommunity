package com.fscommunity.platform.persist.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String openid;

    private String avatar;

    private String nickname;

    private String wechat;

    private Integer status;

    private String realname;

    private String usedname;

    private String mobile;

    private String tel;

    private String email;

    private Integer sex;

    private Date birthday;

    private Date lastLoginDate;

    private String relation;

    private String domicileStatus;

    private String domicileAddr;

    private String domicileType;

    private String reason;

    private String adress1;

    private String adress2;

    private String adress3;

    private String country;

    private String domicileOrigin;

    private String ethnicity;

    private String politicalStatus;

    private String education;

    private String maritalStatus;

    private String foreignMarriage;

    private String height;

    private String bloodType;

    private String religion;

    private String militaryStatus;

    private String specialties;

    private String partTimeJob;

    private String tips;

    private byte[] lcp;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getUsedname() {
        return usedname;
    }

    public void setUsedname(String usedname) {
        this.usedname = usedname == null ? null : usedname.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public String getDomicileStatus() {
        return domicileStatus;
    }

    public void setDomicileStatus(String domicileStatus) {
        this.domicileStatus = domicileStatus == null ? null : domicileStatus.trim();
    }

    public String getDomicileAddr() {
        return domicileAddr;
    }

    public void setDomicileAddr(String domicileAddr) {
        this.domicileAddr = domicileAddr == null ? null : domicileAddr.trim();
    }

    public String getDomicileType() {
        return domicileType;
    }

    public void setDomicileType(String domicileType) {
        this.domicileType = domicileType == null ? null : domicileType.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1 == null ? null : adress1.trim();
    }

    public String getAdress2() {
        return adress2;
    }

    public void setAdress2(String adress2) {
        this.adress2 = adress2 == null ? null : adress2.trim();
    }

    public String getAdress3() {
        return adress3;
    }

    public void setAdress3(String adress3) {
        this.adress3 = adress3 == null ? null : adress3.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getDomicileOrigin() {
        return domicileOrigin;
    }

    public void setDomicileOrigin(String domicileOrigin) {
        this.domicileOrigin = domicileOrigin == null ? null : domicileOrigin.trim();
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity == null ? null : ethnicity.trim();
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus == null ? null : politicalStatus.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    public String getForeignMarriage() {
        return foreignMarriage;
    }

    public void setForeignMarriage(String foreignMarriage) {
        this.foreignMarriage = foreignMarriage == null ? null : foreignMarriage.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion == null ? null : religion.trim();
    }

    public String getMilitaryStatus() {
        return militaryStatus;
    }

    public void setMilitaryStatus(String militaryStatus) {
        this.militaryStatus = militaryStatus == null ? null : militaryStatus.trim();
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties == null ? null : specialties.trim();
    }

    public String getPartTimeJob() {
        return partTimeJob;
    }

    public void setPartTimeJob(String partTimeJob) {
        this.partTimeJob = partTimeJob == null ? null : partTimeJob.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public byte[] getLcp() {
        return lcp;
    }

    public void setLcp(byte[] lcp) {
        this.lcp = lcp;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getWechat() == null ? other.getWechat() == null : this.getWechat().equals(other.getWechat()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRealname() == null ? other.getRealname() == null : this.getRealname().equals(other.getRealname()))
            && (this.getUsedname() == null ? other.getUsedname() == null : this.getUsedname().equals(other.getUsedname()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getLastLoginDate() == null ? other.getLastLoginDate() == null : this.getLastLoginDate().equals(other.getLastLoginDate()))
            && (this.getRelation() == null ? other.getRelation() == null : this.getRelation().equals(other.getRelation()))
            && (this.getDomicileStatus() == null ? other.getDomicileStatus() == null : this.getDomicileStatus().equals(other.getDomicileStatus()))
            && (this.getDomicileAddr() == null ? other.getDomicileAddr() == null : this.getDomicileAddr().equals(other.getDomicileAddr()))
            && (this.getDomicileType() == null ? other.getDomicileType() == null : this.getDomicileType().equals(other.getDomicileType()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getAdress1() == null ? other.getAdress1() == null : this.getAdress1().equals(other.getAdress1()))
            && (this.getAdress2() == null ? other.getAdress2() == null : this.getAdress2().equals(other.getAdress2()))
            && (this.getAdress3() == null ? other.getAdress3() == null : this.getAdress3().equals(other.getAdress3()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getDomicileOrigin() == null ? other.getDomicileOrigin() == null : this.getDomicileOrigin().equals(other.getDomicileOrigin()))
            && (this.getEthnicity() == null ? other.getEthnicity() == null : this.getEthnicity().equals(other.getEthnicity()))
            && (this.getPoliticalStatus() == null ? other.getPoliticalStatus() == null : this.getPoliticalStatus().equals(other.getPoliticalStatus()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getMaritalStatus() == null ? other.getMaritalStatus() == null : this.getMaritalStatus().equals(other.getMaritalStatus()))
            && (this.getForeignMarriage() == null ? other.getForeignMarriage() == null : this.getForeignMarriage().equals(other.getForeignMarriage()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getBloodType() == null ? other.getBloodType() == null : this.getBloodType().equals(other.getBloodType()))
            && (this.getReligion() == null ? other.getReligion() == null : this.getReligion().equals(other.getReligion()))
            && (this.getMilitaryStatus() == null ? other.getMilitaryStatus() == null : this.getMilitaryStatus().equals(other.getMilitaryStatus()))
            && (this.getSpecialties() == null ? other.getSpecialties() == null : this.getSpecialties().equals(other.getSpecialties()))
            && (this.getPartTimeJob() == null ? other.getPartTimeJob() == null : this.getPartTimeJob().equals(other.getPartTimeJob()))
            && (this.getTips() == null ? other.getTips() == null : this.getTips().equals(other.getTips()))
            && (Arrays.equals(this.getLcp(), other.getLcp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getWechat() == null) ? 0 : getWechat().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRealname() == null) ? 0 : getRealname().hashCode());
        result = prime * result + ((getUsedname() == null) ? 0 : getUsedname().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getLastLoginDate() == null) ? 0 : getLastLoginDate().hashCode());
        result = prime * result + ((getRelation() == null) ? 0 : getRelation().hashCode());
        result = prime * result + ((getDomicileStatus() == null) ? 0 : getDomicileStatus().hashCode());
        result = prime * result + ((getDomicileAddr() == null) ? 0 : getDomicileAddr().hashCode());
        result = prime * result + ((getDomicileType() == null) ? 0 : getDomicileType().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getAdress1() == null) ? 0 : getAdress1().hashCode());
        result = prime * result + ((getAdress2() == null) ? 0 : getAdress2().hashCode());
        result = prime * result + ((getAdress3() == null) ? 0 : getAdress3().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getDomicileOrigin() == null) ? 0 : getDomicileOrigin().hashCode());
        result = prime * result + ((getEthnicity() == null) ? 0 : getEthnicity().hashCode());
        result = prime * result + ((getPoliticalStatus() == null) ? 0 : getPoliticalStatus().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getMaritalStatus() == null) ? 0 : getMaritalStatus().hashCode());
        result = prime * result + ((getForeignMarriage() == null) ? 0 : getForeignMarriage().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getBloodType() == null) ? 0 : getBloodType().hashCode());
        result = prime * result + ((getReligion() == null) ? 0 : getReligion().hashCode());
        result = prime * result + ((getMilitaryStatus() == null) ? 0 : getMilitaryStatus().hashCode());
        result = prime * result + ((getSpecialties() == null) ? 0 : getSpecialties().hashCode());
        result = prime * result + ((getPartTimeJob() == null) ? 0 : getPartTimeJob().hashCode());
        result = prime * result + ((getTips() == null) ? 0 : getTips().hashCode());
        result = prime * result + (Arrays.hashCode(getLcp()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", openid=").append(openid);
        sb.append(", avatar=").append(avatar);
        sb.append(", nickname=").append(nickname);
        sb.append(", wechat=").append(wechat);
        sb.append(", status=").append(status);
        sb.append(", realname=").append(realname);
        sb.append(", usedname=").append(usedname);
        sb.append(", mobile=").append(mobile);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", lastLoginDate=").append(lastLoginDate);
        sb.append(", relation=").append(relation);
        sb.append(", domicileStatus=").append(domicileStatus);
        sb.append(", domicileAddr=").append(domicileAddr);
        sb.append(", domicileType=").append(domicileType);
        sb.append(", reason=").append(reason);
        sb.append(", adress1=").append(adress1);
        sb.append(", adress2=").append(adress2);
        sb.append(", adress3=").append(adress3);
        sb.append(", country=").append(country);
        sb.append(", domicileOrigin=").append(domicileOrigin);
        sb.append(", ethnicity=").append(ethnicity);
        sb.append(", politicalStatus=").append(politicalStatus);
        sb.append(", education=").append(education);
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", foreignMarriage=").append(foreignMarriage);
        sb.append(", height=").append(height);
        sb.append(", bloodType=").append(bloodType);
        sb.append(", religion=").append(religion);
        sb.append(", militaryStatus=").append(militaryStatus);
        sb.append(", specialties=").append(specialties);
        sb.append(", partTimeJob=").append(partTimeJob);
        sb.append(", tips=").append(tips);
        sb.append(", lcp=").append(lcp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}