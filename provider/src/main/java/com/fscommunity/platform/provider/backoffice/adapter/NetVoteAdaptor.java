package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.*;
import com.fscommunity.platform.provider.backoffice.req.AddNewVoteItemReq;
import com.fscommunity.platform.provider.backoffice.req.AddNewVoteReq;
import com.fscommunity.platform.provider.backoffice.vo.VoteItemVo;
import com.google.common.base.Joiner;
import org.apache.commons.collections.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class NetVoteAdaptor {
    public static NetVote adaptToVote(AddNewVoteReq req) {
        NetVote netVote = new NetVote();
        netVote.setVoteName(req.getVoteName());
        netVote.setArticleId(req.getArticleId());
        netVote.setVoteStatus(NetVoteStatus.VALID);
        netVote.setStartDate(req.getStartDate());
        netVote.setEndDate(req.getEndDate());
        Date current = new Date();
        netVote.setCreateTime(current);
        netVote.setUpdateTime(current);
        netVote.setSelectType(NetVoteSelectType.RADIO);

        List<VoteItemVo> items = req.getItems();
        if (CollectionUtils.isNotEmpty(items)) {
            List<Integer> ids = items.stream().map(VoteItemVo::getId).collect(Collectors.toList());
            String join = Joiner.on(",").join(ids);
            netVote.setItemIds(join);
        }
        return netVote;
    }

    public static VoteItem adaptToVoteItem(AddNewVoteItemReq req) {
        VoteItem item = new VoteItem();
        item.setVoteId(req.getVoteId());
        item.setContent(req.getItemContent());
        item.setVoterList("");
        item.setVoterSum(0);

        Date current = new Date();
        item.setCreateTime(current);
        item.setUpdateTime(current);
        return item;
    }


}
