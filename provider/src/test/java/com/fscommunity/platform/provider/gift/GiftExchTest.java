package com.fscommunity.platform.provider.gift;

import com.fscommunity.platform.persist.dao.GiftExchInfoMapper;
import com.fscommunity.platform.persist.pojo.GiftExchInfo;
import com.fscommunity.platform.provider.BaseJunit;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-28
 */
public class GiftExchTest extends BaseJunit {
    @Autowired
    GiftExchInfoMapper exchInfoMapper;

    @Test
    public void blackBoardTest() {
        List<GiftExchInfo> gifts = exchInfoMapper.list(null,new RowBounds(0,2));
        for(GiftExchInfo gift:gifts)
            System.out.println(gift.toString());
        assertTrue(gifts.size() > 0);
    }

    @Test
    public void getTest() {
        GiftExchInfo gift = exchInfoMapper.selectById(2);
        System.out.println(gift.toString());
    }

    @Test
    public void insertTest() {
        GiftExchInfo gift=new GiftExchInfo();
        gift.setUserId(1);
        gift.setGiftId(1);
        int rslt = exchInfoMapper.insert(gift);
        System.out.println(rslt);
    }

    @Test
    public void updateTest() {
        GiftExchInfo gift=new GiftExchInfo();
        gift.setId(4);
        gift.setUserId(1);
        gift.setExchState(1);
        int rslt = exchInfoMapper.updateById(gift);
        System.out.println(rslt);
    }

    @Test
    public void delTest() {
        int rslt = exchInfoMapper.deleteById(4);
        System.out.println(rslt);
    }
}
