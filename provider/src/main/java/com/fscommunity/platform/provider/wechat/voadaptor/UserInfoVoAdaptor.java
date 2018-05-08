package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.persist.pojo.WxUser;
import com.fscommunity.platform.provider.wechat.req.UserAuthReq;
import com.fscommunity.platform.provider.wechat.vo.UserDetailVo;
import com.google.common.base.Preconditions;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
public class UserInfoVoAdaptor {

    public static UserDetailVo adaptToDetailVo(UserInfo userInfo) {
        Preconditions.checkNotNull(userInfo);
        UserDetailVo vo = new UserDetailVo();
        vo.setUserId(String.valueOf(userInfo.getId()));
        vo.setAvatarUrl(userInfo.getBaseinfo().getAvatarUrl());
        vo.setWxNickname(userInfo.getBaseinfo().getWxNickName());
        vo.setLevel(userInfo.getLevel().getDesc());
        vo.setGoldCoins(userInfo.getBizInfo().getGoldCoin());
        return vo;
    }

    public static UserInfo adaptToUserInfo(UserInfo old, UserAuthReq req, String openId) {
        old.setOpenId(openId);

        return old;
    }
}
