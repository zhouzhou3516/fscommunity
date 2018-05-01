package com.fscommunity.platform.provider.backoffice.vo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/4/29
 */
public class ProjectSubTypeVo extends Bean {

    private String type;

    public ProjectSubTypeVo() {
    }

    public ProjectSubTypeVo(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
