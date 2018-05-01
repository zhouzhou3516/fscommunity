package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.provider.backoffice.vo.MgrUserInfoVo;
import com.google.common.base.Preconditions;

/**
 * @author liqingzhou on 18/4/29
 */
public class MgrUserInfoVoAdaptor {

    public static MgrUserInfoVo adapt(UserInfo userInfo) {
        Preconditions.checkNotNull(userInfo);
        MgrUserInfoVo vo = new MgrUserInfoVo();
        vo.setAuditStatus(userInfo.getAuditStatus());
        vo.setAuditDesc(userInfo.getAuditStatus().getDesc());
        vo.setRealName(userInfo.getRealName());
        vo.setCellPhone(userInfo.getCellPhone());
        vo.setBuilding(userInfo.getAddressInfo().getAddress1());
        vo.setUnit(userInfo.getAddressInfo().getAddress2());
        vo.setRoot(userInfo.getAddressInfo().getAddress3());
        return vo;
    }

}
