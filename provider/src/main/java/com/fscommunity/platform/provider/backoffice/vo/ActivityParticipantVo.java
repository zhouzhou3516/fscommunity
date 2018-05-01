package com.fscommunity.platform.provider.backoffice.vo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/4/29
 */
public class ActivityParticipantVo extends Bean {

    private String name;
    private String cellPhone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
