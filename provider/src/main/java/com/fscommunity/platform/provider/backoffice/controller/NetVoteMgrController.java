package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.NetVote;
import com.fscommunity.platform.persist.pojo.VoteItem;
import com.fscommunity.platform.provider.backoffice.adapter.NetVoteAdaptor;
import com.fscommunity.platform.provider.backoffice.adapter.VoteVoAdatpter;
import com.fscommunity.platform.provider.backoffice.req.AddNewVoteItemReq;
import com.fscommunity.platform.provider.backoffice.req.AddNewVoteReq;
import com.fscommunity.platform.provider.backoffice.req.UpdateNetVoteReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrVoteDetailVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrVoteItemVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrVoteListItemVo;
import com.fscommunity.platform.provider.backoffice.vo.MgrVoteListVo;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.NetVoteItemService;
import com.fscommunity.platform.service.NetVoteService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Controller
@RequestMapping("/fscommunity/backoffice/netvote")
public class NetVoteMgrController {

    @Resource
    NetVoteService netVoteService;

    @Resource
    NetVoteItemService netVoteItemService;

    @Resource
    ArticleService articleService;

    @RequestMapping("/add")
    @JsonBody
    public void addNewVote(@RequestBody AddNewVoteReq req) {
        Article article = articleService.selectById(req.getArticleId());
        netVoteService.saveNetVote(NetVoteAdaptor.adaptToVote(req));
    }

    @RequestMapping("/item/add")
    @JsonBody
    public void addNewVoteItem(@RequestBody AddNewVoteItemReq req) {
        netVoteItemService.addNewItem(NetVoteAdaptor.adaptToVoteItem(req));
    }

    @RequestMapping("/item/del")
    @JsonBody
    public void delVoteItem(int itemId) {
        netVoteItemService.delVoteItem(itemId);
    }

    @RequestMapping("/list")
    @JsonBody
    public MgrVoteListVo voteList(int currentPage, int pageSize) {
        List<NetVote> netVotes = netVoteService.queryVotesByPage(new PageRequest(currentPage, pageSize));

        MgrVoteListVo vo = new MgrVoteListVo();
        if (CollectionUtils.isEmpty(netVotes)) {
            vo.setItems(Collections.EMPTY_LIST);
            vo.setCount(0);
            return vo;
        }

        List<Integer> alist = netVotes.stream().map(NetVote::getArticleId).collect(Collectors.toList());
        List<Article> articles = articleService.selectByIds(alist);
        Map<Integer, Article> articleMap = articles.stream().collect(Collectors.toMap(Article::getId, r -> r));
        List<MgrVoteListItemVo> listItemVos = VoteVoAdatpter.adaptToListItems(netVotes, articleMap);
        vo.setCount(netVoteService.countNetVotes());
        vo.setItems(listItemVos);
        return vo;
    }

    @RequestMapping("/detail")
    @JsonBody
    public MgrVoteDetailVo voteDetail(int voteId) {
        NetVote netVote = netVoteService.queryNetVoteById(voteId);
        Article article = articleService.selectById(netVote.getArticleId());
        MgrVoteDetailVo vo = new MgrVoteDetailVo();
        vo.setArticleId(article.getId());
        vo.setArticleName(article.getName());
        vo.setVoteId(voteId);
        vo.setStartDate(netVote.getStartDate());
        vo.setEndDate(netVote.getEndDate());

        List<VoteItem> voteItems = netVoteItemService.queryItemsByVoteId(voteId);
        List<MgrVoteItemVo> itemVos = VoteVoAdatpter.adadptVoteItemVos(voteItems);
        vo.setItems(itemVos);
        return vo;
    }

    @RequestMapping("/update")
    @JsonBody
    public void updateVote(@RequestBody UpdateNetVoteReq req) {
        NetVote netVote = netVoteService.queryNetVoteById(req.getVoteId());
        if (netVote == null) {
            throw new BizException("错误的投票id");
        }

        netVote.setStartDate(req.getStartDate());
        netVote.setEndDate(req.getEndDate());
        netVote.setArticleId(req.getArticleid());
        netVoteService.updateNetVote(netVote);
    }
}
