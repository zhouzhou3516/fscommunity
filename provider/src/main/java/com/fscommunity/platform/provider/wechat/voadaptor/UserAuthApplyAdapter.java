package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.UserAuthApply;
import com.fscommunity.platform.provider.wechat.req.UserAuthReq;
import com.fscommunity.platform.provider.wechat.vo.UserAuthVo;

/**
 * @author liqingzhou on 18/5/7
 */
public class UserAuthApplyAdapter {

    public static UserAuthApply adapter(UserAuthReq req) {
        UserAuthApply apply = new UserAuthApply();
        apply.setRealName(req.getRealName());
        apply.setIdCard(req.getIdCard());
        apply.setPhone(req.getPhone());
        apply.setVerifyCode(req.getVerifyCode());
        apply.setStreet(req.getStreet());
        apply.setCommunity(req.getCommunity());
        apply.setBuilding(req.getBuilding());
        apply.setUnit(req.getUnit());
        apply.setRoom(req.getRoom());
        return apply;
    }
    public static UserAuthVo adapterToVo(UserAuthReq req) {
        UserAuthVo apply = new UserAuthVo();
        apply.setIdCard(req.getIdCard());
        apply.setPhone(req.getPhone());
        apply.setVerifyCode(req.getVerifyCode());
        apply.setStreet(req.getStreet());
        apply.setCommunity(req.getCommunity());
        apply.setBuilding(req.getBuilding());
        apply.setUnit(req.getUnit());
        apply.setRoom(req.getRoom());
        apply.setRealName(req.getRealName());
        return apply;
    }

}
