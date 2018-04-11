package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.Vote;
import com.fscommunity.platform.persist.pojo.VoteItem;
import com.fscommunity.platform.provider.backoffice.vo.VoteVo;

import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-9
 */
public class VoteVoAdatpter {

    public static VoteVo adaptToVoteVo(Vote vote,List<VoteItem> itemList) {
        VoteVo vo = new VoteVo(vote);
        vo.setOptionList(itemList);
        return vo;
    }
}
