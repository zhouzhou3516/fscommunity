package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public class UserAddressInfo extends Bean {

    /**
     * 国家
     */
    private String country;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 户籍地址
     */
    private String registerAddress;

    /**
     * 居住地址1
     */
    private String address1;

    /**
     * 居住地址2
     */
    private String address2;

    /**
     * 居住地址3
     */
    private String address3;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }
}
