package com.fscommunity.platform.provider.gift;

import com.fscommunity.platform.persist.dao.GiftMapper;
import com.fscommunity.platform.persist.pojo.Gift;
import com.fscommunity.platform.provider.BaseJunit;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-27
 */
public class GiftTest extends BaseJunit {
    @Autowired
    GiftMapper giftMapper;

    @Test
    public void blackBoardTest() {
        List<Gift> gifts = giftMapper.list(null,new RowBounds(0,2));
        for(Gift gift:gifts)
            System.out.println(gift.toString());
        assertTrue(gifts.size() > 0);
    }

    @Test
    public void getTest() {
        Gift gift = giftMapper.selectById(1);
        System.out.println(gift.toString());
    }

    @Test
    public void insertTest() {
        Gift gift=new Gift();
        gift.setName("fewqer");
        gift.setAvailable(4);
        int rslt = giftMapper.insert(gift);
        System.out.println(rslt);
    }

    @Test
    public void updateTest() {
        Gift gift=new Gift();
        gift.setId(2);
        gift.setName("dsa");
        gift.setAvailable(64);
        int rslt = giftMapper.updateById(gift);
        System.out.println(rslt);
    }

    @Test
    public void delTest() {
        int rslt = giftMapper.deleteById(3);
        System.out.println(rslt);
    }

}
