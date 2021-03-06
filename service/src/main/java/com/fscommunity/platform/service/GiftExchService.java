package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.GiftExchInfoMapper;
import com.fscommunity.platform.persist.dao.GiftMapper;
import com.fscommunity.platform.persist.pojo.Gift;
import com.fscommunity.platform.persist.pojo.GiftExchInfo;
import com.fscommunity.platform.persist.pojo.UserBizInfo;
import com.fscommunity.platform.persist.pojo.UserInfo;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.pojo.BizException;
import org.apache.ibatis.session.RowBounds;
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

    //兑换状态：0已兑换，1未兑换
    private static int UNOBTAINED = 1;
    private static int OBTAINED = 0;
    //0积分，1金币
    private static int INTEGRAL = 1;
    private static int GOLD = 0;
    @Autowired
    GiftExchInfoMapper giftExchInfoMapper;

    @Autowired
    GiftMapper giftMapper;

    @Autowired
    UserInfoService userService;

    public List<GiftExchInfo> list(String condition, PageRequest pageRequest) {
        return giftExchInfoMapper.list(condition, new RowBounds(pageRequest.getOffset(), pageRequest.getLimit()));
    }

    public int add(GiftExchInfo exchInfo) {
        Preconditions.checkNotNull(exchInfo);
        return giftExchInfoMapper.insert(exchInfo);
    }

    public int apply(GiftExchInfo exchInfo) {
        Preconditions.checkNotNull(exchInfo);
        exchInfo.setExchState(UNOBTAINED);
        exchInfo.setApplyTime(new Date());
        return add(exchInfo);
    }

    public GiftExchInfo selectById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        return giftExchInfoMapper.selectById(Integer.valueOf(id));
    }

    public void delById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        giftExchInfoMapper.deleteById(Integer.valueOf(id));
    }

    public void updateById(GiftExchInfo exchInfo) {
        Preconditions.checkNotNull(exchInfo);
        giftExchInfoMapper.updateById(exchInfo);
    }

    /**
     * 确认兑换礼品
     *
     * @param id 兑换记录id
     */
    @Transactional
    public void exchConfirm(String id) {
        GiftExchInfo exch = giftExchInfoMapper.selectById(Integer.valueOf(id));
        Gift gift = giftMapper.selectById(exch.getGiftId());
        UserInfo user = userService.queryUserById(exch.getUserId());
        UserBizInfo bizz = user.getBizInfo();
        if (gift.getAvailable() < exch.getExchSum())
            throw new BizException("礼品剩余数量不足！");

        //gift减少
        gift.setAvailable(gift.getAvailable() - exch.getExchSum());

        //user金币/积分扣除
        if (gift.getPayMethod() == GOLD) {
            if (bizz.getIntegral() < gift.getCost() * exch.getExchSum())
                throw new BizException("用户积分不足！");
            else
                bizz.setIntegral(bizz.getIntegral() - gift.getCost() * exch.getExchSum());
        } else if (gift.getPayMethod() == INTEGRAL) {
            if (bizz.getGoldCoin() < gift.getCost())
                throw new BizException("用户金币不足！");
            else
                bizz.setGoldCoin(bizz.getGoldCoin() - gift.getCost() * exch.getExchSum());
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
     * 自动兑换礼品
     *
     * @param exch
     */
    @Transactional
    public void exchBizAuto(GiftExchInfo exch) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(exch.getGiftId().toString()));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(exch.getUserId().toString()));

        Gift gift = giftMapper.selectById(exch.getGiftId());
        UserInfo user = userService.queryUserById(exch.getUserId());
        UserBizInfo bizz = user.getBizInfo();
        if (gift.getAvailable() < exch.getExchSum())
            throw new BizException("礼品剩余数量不足！");

        //gift减少
        gift.setAvailable(gift.getAvailable() - exch.getExchSum());

        //user金币/积分扣除
        if (gift.getPayMethod() == GOLD) {//0积分，1金币
            if (bizz.getIntegral() < gift.getCost() * exch.getExchSum())
                throw new BizException("用户积分不足！");
            else {
                bizz.setIntegral(bizz.getIntegral() - gift.getCost() * exch.getExchSum());
            }
        } else if (gift.getPayMethod() == INTEGRAL) {
            if (bizz.getGoldCoin() < gift.getCost())
                throw new BizException("用户金币不足！");
            else
                bizz.setGoldCoin(bizz.getGoldCoin() - gift.getCost() * exch.getExchSum());
        }
        user.setBizInfo(bizz);

        //兑换状态改变
        exch.setExchState(OBTAINED);
        exch.setApplyTime(new Date());
        exch.setObtainTime(new Date());

        giftExchInfoMapper.insert(exch);
        giftMapper.updateById(gift);
        userService.updateBizInfo(user);

    }


    public int getCount() {
        return giftExchInfoMapper.getCount();
    }
}
