package com.fscommunity.platform.provider;

import com.fscommunity.platform.persist.dao.GiftMapper;
import com.fscommunity.platform.persist.pojo.Gift;
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
        List<Gift> gifts = giftMapper.list(null);
        assertTrue(gifts.size() > 0);
    }

}
