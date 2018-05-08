package com.fscommunity.platform.common.pojo;

import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.persist.pojo.WxUser;

/**
 * @author liqingzhou on 18/5/6
 */
public class SessionUserAdapter {

    public static SessionUserInfo adapt(UserInfo userInfo, WxUser wxUser) {
        SessionUserInfo sessionUserInfo = new SessionUserInfo();
        sessionUserInfo.setWxNickname(wxUser.getNickname());
        sessionUserInfo.setUserId(userInfo.getId());
        sessionUserInfo.setCellPhone(userInfo.getCellPhone());
        sessionUserInfo.setAvatarUrl(wxUser.getHeadimgurl());
        sessionUserInfo.setOpenId(wxUser.getOpenid());
        sessionUserInfo.setIntegral(userInfo.getBizInfo().getIntegral());
        sessionUserInfo.setGoldCoin(userInfo.getBizInfo().getGoldCoin());
        return sessionUserInfo;
    }

}
