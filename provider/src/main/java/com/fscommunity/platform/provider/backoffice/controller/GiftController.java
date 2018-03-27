package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.Gift;
import com.fscommunity.platform.service.GiftService;
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
@RequestMapping("/fscommunity/gift")
@Controller
public class GiftController {
    private final static Logger logger = LoggerFactory.getLogger(GiftController.class);

    @Resource
    GiftService giftService;

    @RequestMapping("/list")
    @JsonBody
    public List<Gift> list(HttpServletRequest request) {
        logger.info("list");
        return giftService.list(request.getParameter("condition"));
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

    @RequestMapping("/edit")
    @JsonBody
    public Gift edit(HttpServletRequest request) {
        logger.info("edit");
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
    @RequestMapping("/exchange/list")
    @JsonBody
    public void exchList() {
        logger.info("exchList");
    }

    @RequestMapping("/exchange/info")
    @JsonBody
    public void exchInfo() {
        logger.info("exchInfo");
    }

    @RequestMapping("/exchange/edit")
    @JsonBody
    public void exchEdit() {
        logger.info("exchEdit");
    }

    @RequestMapping("/exchange/comfirm")
    @JsonBody
    public void exchComfirm() {
        logger.info("exchComfirm");
    }
    @RequestMapping("/exchange/del")
    @JsonBody
    public void exchDel() {
        logger.info("exchDel");
    }

    @RequestMapping("/exchange/auto")
    @JsonBody
    public void exchAuto() {
        logger.info("exchAuto");
    }

    @RequestMapping("/im/send")
    @JsonBody
    public void imSend() {
        logger.info("imSend");
    }
}
