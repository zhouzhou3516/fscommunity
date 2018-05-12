package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.common.pojo.SessionUserInfo;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.NetVote;
import com.fscommunity.platform.persist.pojo.NetVoteRecord;
import com.fscommunity.platform.persist.pojo.VoteItem;
import com.fscommunity.platform.provider.wechat.vo.NetVoteDetailVo;
import com.fscommunity.platform.provider.wechat.vo.NetVoteItemVo;
import com.fscommunity.platform.provider.wechat.vo.NetVoteListItemVo;
import com.fscommunity.platform.provider.wechat.vo.NetVoteListVo;
import com.fscommunity.platform.provider.wechat.vo.VoteResultVo;
import com.fscommunity.platform.provider.wechat.voadaptor.NetVoteVoAdptor;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.NetVoteItemService;
import com.fscommunity.platform.service.NetVoteRecordService;
import com.fscommunity.platform.service.NetVoteService;
import com.lxx.app.common.util.DateFormatUtil;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqingzhou on 18/5/6.
 */
@RequestMapping("/fscommunity/wechat/netvote")
@Controller
public class NetVoteController {

    @Resource
    NetVoteService netVoteService;

    @Resource
    ArticleService articleService;


    @Resource
    NetVoteItemService netVoteItemService;
    @Resource
    NetVoteRecordService netVoteRecordService;

    @Resource
    SessionHolder sessionHolder;

    @RequestMapping("/list")
    @JsonBody
    public NetVoteListVo voteList(int currentPage, int pageSize) {
        List<NetVote> netVotes = netVoteService.queryVotesByPage(null, new PageRequest(currentPage,
                pageSize));

        NetVoteListVo vo = new NetVoteListVo();
        if (CollectionUtils.isEmpty(netVotes)) {
            vo.setCount(0);
            vo.setItems(Collections.EMPTY_LIST);
            return vo;
        }
        List<Integer> alist = netVotes.stream().map(NetVote::getArticleId).collect(Collectors.toList());
        List<Article> articles = articleService.selectByIds(alist);
        Map<Integer, Article> articleMap = articles.stream().collect(Collectors.toMap(Article::getId, r -> r));
        List<NetVoteListItemVo> itemVos = NetVoteVoAdptor.adaptItems(netVotes, articleMap);
        vo.setItems(itemVos);
        vo.setCount(netVoteService.countNetVotes());
        return vo;
    }

    @RequestMapping("/detail")
    @JsonBody
    public NetVoteDetailVo voteDetail(int voteId) {
        NetVote netVote = netVoteService.queryNetVoteById(voteId);
        if (netVote == null) {
            throw new BizException("不存在该投票");
        }
        Article article = articleService.selectById(netVote.getArticleId());
        NetVoteDetailVo vo = new NetVoteDetailVo();
        vo.setVoteId(netVote.getId());
        vo.setVoteName(article.getName());
        vo.setVoteContent(article.getContent());

        SessionUserInfo userInfo = sessionHolder.currentUser();
        if (netVoteRecordService.hasVoted(voteId, userInfo.getUserId())) {
            vo.setVoted(true);
        }
        Date current = new Date();
        vo.setExpire(false);
        try {
            if (current.before(DateFormatUtil.parse4y2M2d(netVote.getStartDate())) ||
                    current.after(DateFormatUtil.parse4y2M2d(netVote.getEndDate()))) {
                vo.setExpire(true);
            }
        }catch (Exception e){
            vo.setExpire(true);
        }

        List<VoteItem> voteItems = netVoteItemService.queryItemsByVoteId(netVote.getId());
        List<NetVoteItemVo> itemVos = NetVoteVoAdptor.adaptToItemVos(voteItems);
        vo.setItems(itemVos);
        //update article views
        articleService.updateViewsById(article.getId(),article.getViews()+1);
        return vo;
    }

    @RequestMapping("/vote")
    @JsonBody
    @Transactional(rollbackFor = Throwable.class)
    public VoteResultVo vote(int voteId, int voteItemId) {
        SessionUserInfo userInfo = sessionHolder.currentUser();
        if (netVoteRecordService.hasVoted(voteId, userInfo.getUserId())) {
            throw new BizException("您已经投过");
        }

        netVoteItemService.voteOnce(voteItemId);
        NetVoteRecord voteRecord = new NetVoteRecord();
        voteRecord.setUserId(userInfo.getUserId());
        voteRecord.setVoteId(voteId);
        voteRecord.setVoteItemId(voteItemId);
        netVoteRecordService.saveVoteRecord(voteRecord);
        List<VoteItem> voteItems = netVoteItemService.queryItemsByVoteId(voteId);
        List<NetVoteItemVo> itemVos = NetVoteVoAdptor.adaptToItemVos(voteItems);
        VoteResultVo vo = new VoteResultVo();
        vo.setItems(itemVos);
        return vo;
    }
}
