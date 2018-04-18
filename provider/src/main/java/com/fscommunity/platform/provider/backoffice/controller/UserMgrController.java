package com.fscommunity.platform.provider.backoffice.controller;

import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-22
 */
@RequestMapping("/fscommunity/man/user")
@Controller
public class UserMgrController {
    private final static Logger logger = LoggerFactory.getLogger(UserMgrController.class);

    @RequestMapping("/list")
    @JsonBody
    public void list() {
        logger.info("list");
    }

    @RequestMapping("/info")
    @JsonBody
    public void info() {
        logger.info("info");
    }

    @RequestMapping("/del")
    @JsonBody
    public void delete() {
        logger.info("delete");
    }

    @RequestMapping("/review/list")
    @JsonBody
    public void reviews() {
        logger.info("reviews");
    }

    @RequestMapping("/review/info")
    @JsonBody
    public void reviewInfo() {
        logger.info("reviewInfo");
    }

    @RequestMapping("/review")
    @JsonBody
    public void review() {
        logger.info("review");
    }

    @RequestMapping("/import")
    @JsonBody
    public void importExcel() { logger.info("review"); }

    @RequestMapping("/export")
    @JsonBody
    public void exportExcel() {
        logger.info("review");
    }


}