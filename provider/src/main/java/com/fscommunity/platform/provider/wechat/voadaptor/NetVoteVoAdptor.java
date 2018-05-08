package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.NetVote;
import com.fscommunity.platform.persist.pojo.VoteItem;
import com.fscommunity.platform.provider.wechat.vo.NetVoteItemVo;
import com.fscommunity.platform.provider.wechat.vo.NetVoteListItemVo;
import com.lxx.app.common.util.Base64Util;
import com.lxx.app.common.util.DateFormatUtil;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
public class NetVoteVoAdptor {
    public static NetVoteListItemVo adaptItem(NetVote vote, Article voteArticle) {
        NetVoteListItemVo vo = new NetVoteListItemVo();
        vo.setVoteHeader(voteArticle.getName());
        vo.setTag(voteArticle.getTag());
        vo.setOverview(voteArticle.getContent());
        vo.setPubDate(DateFormatUtil.format4y2M2d(vote.getCreateTime()));
        vo.setViewCount(voteArticle.getViews());
        vo.setVoteId(vote.getId());
        return vo;
    }

    public static List<NetVoteListItemVo> adaptItems(List<NetVote> votes, Map<Integer, Article> articleMap) {
        if (CollectionUtils.isEmpty(votes)) {
            return Collections.EMPTY_LIST;
        }
        return votes.stream().map(r->adaptItem(r, articleMap.get(r.getArticleId()))).collect(Collectors.toList());
    }

    public static NetVoteItemVo adaptToItemVo(VoteItem item) {
        NetVoteItemVo vo = new NetVoteItemVo();
        vo.setItemId(item.getId());
        vo.setItemContent(item.getContent());
        vo.setVoteCount(item.getVoterSum());
        return vo;
    }

    public static List<NetVoteItemVo> adaptToItemVos(List<VoteItem> items) {
        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }

        return items.stream().map(r->adaptToItemVo(r)).collect(Collectors.toList());
    }
}
