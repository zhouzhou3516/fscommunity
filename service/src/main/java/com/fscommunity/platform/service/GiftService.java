package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.GiftMapper;
import com.fscommunity.platform.persist.pojo.Gift;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-25
 */
@Service
public class GiftService {
    @Autowired
    GiftMapper giftMapper;

    public List<Gift> list(String condition) {
        return giftMapper.list(condition);
    }

    public void add(Gift gift) {
        Preconditions.checkNotNull(gift);
        giftMapper.insert(gift);
    }

    public Gift selectById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        return giftMapper.selectById(Integer.valueOf(id));
    }

    public void delById(String id) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(id));
        giftMapper.deleteById(Integer.valueOf(id));
    }

    public void updateById(Gift gift) {
        Preconditions.checkNotNull(gift);
        giftMapper.updateById(gift);
    }
}
