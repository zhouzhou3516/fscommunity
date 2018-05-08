package com.fscommunity.platform.provider.wechat.vo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/5/6
 */
public class ChannelSubTypeVo extends Bean {

    private String typeName;

    public ChannelSubTypeVo() {
    }

    public ChannelSubTypeVo(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
