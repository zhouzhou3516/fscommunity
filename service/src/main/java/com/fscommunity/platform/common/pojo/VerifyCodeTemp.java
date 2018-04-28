package com.fscommunity.platform.common.pojo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author lixiaoxiong
 * @version 2018-01-20
 */
public class VerifyCodeTemp extends Bean {

    private String code;

    public VerifyCodeTemp(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
