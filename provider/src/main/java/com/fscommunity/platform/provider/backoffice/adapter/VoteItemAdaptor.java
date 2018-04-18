package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.VoteItem;
import com.fscommunity.platform.provider.backoffice.vo.VoteItemVo;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-18
 */
public class VoteItemAdaptor {
    public static VoteItem adaptToVoteItem(VoteItemVo vo, int voteId){
        VoteItem item = new VoteItem();
        item.setVoteId(voteId);
        item.setContent(vo.getName());
        item.setVoterList("");
        item.setVoterSum(0);

        Date current = new Date();
        item.setCreateTime(current);
        item.setUpdateTime(current);
        return item;
    }

    public static List<VoteItem> adaptToVoteItems(List<VoteItemVo> vos, int voteId) {
        if (CollectionUtils.isEmpty(vos)) {
            return Collections.EMPTY_LIST;
        }
        return vos.stream().map(r->adaptToVoteItem(r, voteId)).collect(Collectors.toList());
    }
}
