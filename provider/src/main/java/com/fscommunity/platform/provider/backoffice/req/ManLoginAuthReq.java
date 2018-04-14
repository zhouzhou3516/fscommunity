package com.fscommunity.platform.provider.backoffice.req;

/**
 * @author lixiaoxiong
 * @version 2018-01-30
 */
public class ManLoginAuthReq {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
