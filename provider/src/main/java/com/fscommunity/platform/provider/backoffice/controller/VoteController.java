package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.dao.VoteItemMapper;
import com.fscommunity.platform.persist.pojo.Vote;
import com.fscommunity.platform.persist.pojo.VoteItem;
import com.fscommunity.platform.provider.backoffice.adapter.VoteVoAdatpter;
import com.fscommunity.platform.provider.backoffice.vo.VoteVo;
import com.fscommunity.platform.service.UserInfoService;
import com.fscommunity.platform.service.VoteService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.page.PageResp;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description 在线投票控制器
 * @Author jing.c
 * @Date: 18-4-4
 */
@RequestMapping("/fscommunity/vote")
@Controller
public class VoteController {
    private final static Logger logger = LoggerFactory.getLogger(VoteController.class);
    @Resource
    VoteService voteService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/list")
    @JsonBody
    public PageResp list(HttpServletRequest request) {
        logger.info("list");
        List<Vote> rows = voteService.list(request.getParameter("condition"),
                new PageRequest(Integer.valueOf(request.getParameter("currentPage")), Integer.valueOf(request.getParameter("pageSize")))
        );
        int count = voteService.getCount();
        PageResp resp = new PageResp<Vote>(rows, count);
        return resp;
    }

    @RequestMapping("/new")
    @JsonBody
    public void add(@RequestBody Vote vote) {
        logger.info("new");
        voteService.add(vote);
    }

    @RequestMapping("/info")
    @JsonBody
    public VoteVo info(HttpServletRequest request) {
        logger.info("info");
        Vote vote = voteService.selectById(request.getParameter("id"));
        return VoteVoAdatpter.adaptToVoteVo(vote,voteService.getVoteItems(request.getParameter("id")));
    }

    @RequestMapping("/update")
    @JsonBody
    public void update(@RequestBody Vote vote) {
        logger.info("update");
        voteService.updateById(vote);

    }

    @RequestMapping("/del")
    @JsonBody
    public void delete(HttpServletRequest request) {
        logger.info("delete");
        voteService.delById(request.getParameter("id"));
    }

    /**
     * 更新投票浏览量
     *
     * @param request
     */
    @RequestMapping("/updateViews")
    @JsonBody
    public void updateViews(HttpServletRequest request) {
        logger.info("updateViewsById");
        voteService.updateViewsById(request.getParameter("id"),request.getParameter("views"));
    }

    /**
     * 更新投票状态
     *
     * @param request
     */
    @RequestMapping("/updateState")
    @JsonBody
    public void updateState(HttpServletRequest request) {
        logger.info("updateStateById");
        voteService.updateState(request.getParameter("id"),request.getParameter("voteState"));
    }

    /**
     * 当前用户投票
     *
     * @param request
     */
    @RequestMapping("/vote")
    @JsonBody
    public VoteVo vote(HttpServletRequest request) {
        logger.info("vote");
        Vote vote=voteService.vote(request.getParameter("id"));
        return VoteVoAdatpter.adaptToVoteVo(vote,voteService.getVoteItems(vote.getId().toString()));
    }

    /**
     * 新增投票选项
     *
     */
    @RequestMapping("/voteItem/new")
    @JsonBody
    public void addVoteItem(@RequestBody VoteItem voteItem) {
        logger.info("addVoteItem");
        voteService.addVoteItem(voteItem);
    }

    /**
     * 更新投票选项
     *
     */
    @RequestMapping("/voteItem/update")
    @JsonBody
    public void updateVoteItem(@RequestBody VoteItem voteItem) {
        logger.info("addVoteItem");
        voteService.updateVoteItem(voteItem);
    }

    /**
     * 删除投票选项
     *
     */
    @RequestMapping("/voteItem/del")
    @JsonBody
    public void delVoteItem(HttpServletRequest request) {
        logger.info("addVoteItem");
        voteService.delVoteItem(request.getParameter("id"));
    }

}
