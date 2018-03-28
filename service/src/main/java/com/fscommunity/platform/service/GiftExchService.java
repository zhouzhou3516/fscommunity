package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.GiftExchInfoMapper;
import com.fscommunity.platform.persist.dao.GiftMapper;
import com.fscommunity.platform.persist.pojo.Gift;
import com.fscommunity.platform.persist.pojo.GiftExchInfo;
import com.fscommunity.platform.persist.pojo.UserBizInfo;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.lxx.app.common.util.pojo.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/* @Description
 * @Author jing.c
 * @Date: 18-3-25
 */
@Service
public class GiftExchService {
    @Autowired
    GiftExchInfoMapper giftExchInfoMapper;

    @Autowired
    GiftMapper giftMapper;

    @Autowired
    UserInfoService userService;

    public List<GiftExchInfo> list(String condition) {
        return giftExchInfoMapper.list(condition);
    }

    public void add(GiftExchInfo gift) {
        Preconditions.checkNotNull(gift);
        giftExchInfoMapper.insert(gift);
    }

    public GiftExchInfo selectById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        return giftExchInfoMapper.selectById(Integer.valueOf(id));
    }

    public void delById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        giftExchInfoMapper.deleteById(Integer.valueOf(id));
    }

    public void updateById(GiftExchInfo gift) {
        Preconditions.checkNotNull(gift);
        giftExchInfoMapper.updateById(gift);
    }

    /**
     * 确认兑换礼品
     * @param id 兑换记录id
     */
    @Transactional
    public void exchConfirm(String id) {
        GiftExchInfo exch = giftExchInfoMapper.selectById(Integer.valueOf(id));
        Gift gift= giftMapper.selectById(exch.getGiftId());
        UserInfo user=userService.queryUserById(exch.getUserId());
        UserBizInfo bizz=user.getBizInfo();
        if(gift.getAvailable()==0)
            throw new BizException("礼品已兑换完！");

        //gift减少
        gift.setAvailable(gift.getAvailable()-1);

        //user金币/积分扣除
        if(gift.getPayMethod()==0){//0积分，1金币
            if(bizz.getIntegral()<gift.getCost())
                throw new BizException("用户积分不足！");
            else
                bizz.setIntegral(bizz.getIntegral()-gift.getCost());
        }else{
            if(bizz.getGoldCoin()<gift.getCost())
                throw new BizException("用户金币不足！");
            else
                bizz.setGoldCoin(bizz.getGoldCoin()-gift.getCost());
        }
        user.setBizInfo(bizz);

        //兑换状态改变
        exch.setExchState(0);
        exch.setObtainTime(new Date());

        giftExchInfoMapper.updateById(exch);
        giftMapper.updateById(gift);
        userService.updateBizInfo(user);
    }

    /**
     * 自动
     * @param id
     */
    @Transactional
    public void exchBizAuto(String id) {

    }
}
