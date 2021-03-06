package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.Gift;
import com.fscommunity.platform.persist.pojo.GiftExchInfo;
import com.fscommunity.platform.service.GiftExchService;
import com.fscommunity.platform.service.GiftService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.page.PageResp;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-25
 */
@RequestMapping("/fscommunity/man/gift")
@Controller
public class GiftController {
    private final static Logger logger = LoggerFactory.getLogger(GiftController.class);

    @Resource
    GiftService giftService;

    @Resource
    GiftExchService giftExchService;

    @RequestMapping("/list")
    @JsonBody
    public PageResp list(HttpServletRequest request) {
        logger.info("list");
        List<Gift> rows = giftService.list(request.getParameter("condition"),
                new PageRequest(Integer.valueOf(request.getParameter("currentPage")), Integer.valueOf(request.getParameter("pageSize")))
        );
        int count = giftService.getCount();
        PageResp resp = new PageResp<Gift>(rows, count);
        return resp;
    }

    @RequestMapping("/new")
    @JsonBody
    public void add(@RequestBody Gift gift) {
        logger.info("new");
        giftService.add(gift);
    }

    @RequestMapping("/info")
    @JsonBody
    public Gift info(HttpServletRequest request) {
        logger.info("info");
        return giftService.selectById(request.getParameter("id"));
    }

    @RequestMapping("/update")
    @JsonBody
    public void update(@RequestBody Gift gift) {
        logger.info("update");
        giftService.updateById(gift);

    }

    @RequestMapping("/del")
    @JsonBody
    public void delete(HttpServletRequest request) {
        logger.info("delete");
        giftService.delById(request.getParameter("id"));
    }

    @RequestMapping("/apply")
    @JsonBody
    public void apply(@RequestBody GiftExchInfo giftExchInfo) {
        logger.info("apply");
        giftExchService.apply(giftExchInfo);
    }

    @RequestMapping("/pulloff")
    @JsonBody
    public void pulloff(HttpServletRequest request) {
        logger.info("pulloff");
        giftService.pulloff(request.getParameter("id"));
    }

    @RequestMapping("/exchange/list")
    @JsonBody
    public PageResp exchList(HttpServletRequest request) {
        logger.info("exchList");
        List<GiftExchInfo> rows = giftExchService.list(request.getParameter("condition"),
                new PageRequest(Integer.valueOf(request.getParameter("currentPage")), Integer.valueOf(request.getParameter("pageSize")))
        );
        int count = giftExchService.getCount();
        PageResp resp = new PageResp<GiftExchInfo>(rows, count);
        return resp;
    }

    @RequestMapping("/exchange/info")
    @JsonBody
    public GiftExchInfo exchInfo(HttpServletRequest request) {
        logger.info("exchInfo");
        return giftExchService.selectById(request.getParameter("id"));
    }

    @RequestMapping("/exchange/update")
    @JsonBody
    public void exchUpdate(@RequestBody GiftExchInfo giftExchInfo) {
        logger.info("exchUpdate");
        giftExchService.updateById(giftExchInfo);
    }

    @RequestMapping("/exchange/comfirm")
    @JsonBody
    public void exchConfirm(HttpServletRequest request) {
        logger.info("exchConfirm");
        giftExchService.exchConfirm(request.getParameter("id"));
    }

    @RequestMapping("/exchange/del")
    @JsonBody
    public void exchDel(HttpServletRequest request) {
        logger.info("exchDel");
        giftExchService.delById(request.getParameter("id"));
    }

    @RequestMapping("/exchange/auto")
    @JsonBody
    public void exchBizAuto(@RequestBody GiftExchInfo giftExchInfo) {
        logger.info("exchBizAuto");
        giftExchService.exchBizAuto(giftExchInfo);
    }

    @RequestMapping("/im/send")
    @JsonBody
    public void imSend() {
        //TODO
        logger.info("imSend");
    }
}
