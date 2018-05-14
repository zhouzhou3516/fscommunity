package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.UserInfo;
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
        vo.setSignRule("1-3天每天领10积分\n"
                + "连续签到3天以上每天领12积分\n"
                + "连续签到7天以上每天领17积分\n"
                + "连续签到30天以上每天领30积分\n"
                + "等级：Lv1-Lv4 每100积分升一级，Lv5-Lv8 每200积分升一级，Lv9-Lv12 每400积分升一级；即每4级每升一级积分翻一倍\n");
        return vo;
    }

    public static UserInfo adaptToUserInfo(UserInfo old, UserAuthReq req, String openId) {
        old.setOpenId(openId);

        return old;
    }
}
