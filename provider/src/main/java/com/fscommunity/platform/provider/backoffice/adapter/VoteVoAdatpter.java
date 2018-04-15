package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.NetVote;
import com.fscommunity.platform.persist.pojo.Vote;
import com.fscommunity.platform.persist.pojo.VoteItem;
import com.fscommunity.platform.provider.backoffice.vo.MgrVoteItemVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrVoteListItemVo;
import com.fscommunity.platform.provider.backoffice.vo.VoteVo;
import com.lxx.app.common.util.DateFormatUtil;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static MgrVoteListItemVo adaptToListItem(NetVote vote, Article article) {
        MgrVoteListItemVo vo = new MgrVoteListItemVo();
        vo.setVoteId(vote.getId());
        vo.setVoteName(article.getName());
        vo.setPubDate(DateFormatUtil.format4y2M2d(vote.getCreateTime()));
        return vo;
    }

    public static List<MgrVoteListItemVo> adaptToListItems(List<NetVote> votes, Map<Integer, Article> articleMap) {
        if (CollectionUtils.isEmpty(votes)) {
            return Collections.EMPTY_LIST;
        }

        return votes.stream().map(r->adaptToListItem(r, articleMap.get(r.getArticleId()))).collect(Collectors.toList());
    }

    public static MgrVoteItemVo adadptVoteItemVo(VoteItem item) {
        MgrVoteItemVo vo = new MgrVoteItemVo();
        vo.setItemId(item.getId());
        vo.setContent(item.getContent());
        return vo;
    }

    public static List<MgrVoteItemVo> adadptVoteItemVos(List<VoteItem> items) {
        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }

        return items.stream().map(VoteVoAdatpter::adadptVoteItemVo).collect(Collectors.toList());
    }
}
