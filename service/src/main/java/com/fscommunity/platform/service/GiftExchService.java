package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.GiftExchInfoMapper;
import com.fscommunity.platform.persist.pojo.GiftExchInfo;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* @Description
 * @Author jing.c
 * @Date: 18-3-25
 */
@Service
public class GiftExchService {
    @Autowired
    GiftExchInfoMapper giftMapper;

    public List<GiftExchInfo> list(String condition) {
        return giftMapper.list(condition);
    }

    public void add(GiftExchInfo gift) {
        Preconditions.checkNotNull(gift);
        giftMapper.insert(gift);
    }

    public GiftExchInfo selectById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        return giftMapper.selectById(Integer.valueOf(id));
    }

    public void delById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        giftMapper.deleteById(Integer.valueOf(id));
    }

    public void updateById(GiftExchInfo gift) {
        Preconditions.checkNotNull(gift);
        giftMapper.updateById(gift);
    }
}
