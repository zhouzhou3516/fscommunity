package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.NetVote;
import com.fscommunity.platform.persist.pojo.VoteItem;
import com.fscommunity.platform.provider.backoffice.adapter.NetVoteAdaptor;
import com.fscommunity.platform.provider.backoffice.adapter.VoteItemAdaptor;
import com.fscommunity.platform.provider.backoffice.adapter.VoteVoAdatpter;
import com.fscommunity.platform.provider.backoffice.req.AddNewVoteItemReq;
import com.fscommunity.platform.provider.backoffice.req.AddNewVoteReq;
import com.fscommunity.platform.provider.backoffice.req.UpdateNetVoteReq;
import com.fscommunity.platform.provider.backoffice.vo.*;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.NetVoteItemService;
import com.fscommunity.platform.service.NetVoteService;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.lxx.app.common.util.json.JsonUtil;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chao.zhu
 * @version 2018-04-15
 */
@Controller
@RequestMapping("/fscommunity/man/netvote")
public class NetVoteMgrController {
    private final static Splitter COMM_SPLITTER = Splitter.on(",");
    private final static Joiner COMM_JOINER = Joiner.on(",");
    @Resource
    NetVoteService netVoteService;

    @Resource
    NetVoteItemService netVoteItemService;

    @Resource
    ArticleService articleService;

    @RequestMapping("/add")
    @JsonBody
    @Transactional
    public void addNewVote(@RequestBody AddNewVoteReq req) {
        //新增
        if (req.getId() == 0) {
            //保存投票信息
            NetVote netVote = NetVoteAdaptor.adaptToVote(req);
            NetVote saved = netVoteService.saveNetVote(netVote);

            //保存投票选项信息
            List<VoteItem> needSave = VoteItemAdaptor.adaptToVoteItems(req.getItems(), saved.getId());
            netVoteItemService.addNewItems(needSave);

            //更新关联关系
            if (CollectionUtils.isNotEmpty(needSave)) {
                String join = COMM_JOINER.join(needSave.stream().map(r -> r.getId()).collect(Collectors.toList()));
                netVote.setItemIds(join);
                netVoteService.updateNetVote(netVote);
            }
        } else {
            //更新投票信息
            NetVote netVote = netVoteService.queryNetVoteById(req.getId());
            List<Integer> oldIds = netVoteService.idsFromStr(netVote.getItemIds());

            List<VoteItemVo> items = req.getItems();
            List<Integer> reqIds = items.stream().map(VoteItemVo::getId).collect(Collectors.toList());

            //更新投票选项信息
            List<Integer> delIds = Lists.newArrayList(oldIds);
            delIds.removeAll(reqIds);
            List<Integer> addIds = Lists.newArrayList(reqIds);
            addIds.removeAll(oldIds);

            List<VoteItemVo> adds = req.getItems().stream().filter(r->addIds.contains(r.getId())).collect(Collectors.toList());
            List<VoteItem> needSave = VoteItemAdaptor.adaptToVoteItems(adds, netVote.getId());
            List<VoteItem> voteItems = netVoteItemService.addNewItems(needSave);
            netVoteItemService.delVoteItems(delIds);

            List<Integer> hasAddIds = voteItems.stream().map(VoteItem::getId).collect(Collectors.toList());
            List<Integer> updatdIds = reqIds.stream().filter(r -> r != 0).collect(Collectors.toList());
            updatdIds.addAll(hasAddIds);
            netVote.setItemIds(Joiner.on(",").join(updatdIds));
            netVoteService.updateNetVote(netVote);
        }
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

    public static void main(String[] args) {
        List<String> ori = new ArrayList<>();
        ori.add("a");
        ori.add("b");
        ArrayList<String> oriiii = Lists.newArrayList(ori);

        List<String> nn = new ArrayList<>();
        nn.add("a");
        nn.add("e");
        nn.add("f");
        nn.add("c");
        ArrayList<String> nnn = Lists.newArrayList(nn);

        //oriiii.removeAll(nnn);
        nnn.removeAll(oriiii);
        System.out.println(JsonUtil.of(nnn));
    }
}
