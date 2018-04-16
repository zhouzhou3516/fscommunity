package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.fscommunity.platform.provider.backoffice.req.MsgBroadListQueryReq;
import com.fscommunity.platform.service.MsgBroadService;
import com.fscommunity.platform.service.UserInfoService;
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
 * @Description 留言板controller
 * @Author jing.c
 * @Date: 18-3-28
 */
@RequestMapping("/fscommunity/msgbroad")
@Controller
public class MsgBroadMgrController {
    private final static Logger logger = LoggerFactory.getLogger(MsgBroadMgrController.class);

    @Resource
    MsgBroadService msgBroadService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/list")
    @JsonBody
    public PageResp list(MsgBroadListQueryReq req) {
        logger.info("list");
        List<MsgBroad> rows = msgBroadService.list(req.getFuzzyName(),
                new PageRequest(Integer.valueOf(req.getCurrentPage()), Integer.valueOf(req.getPageSize()))
        );
        int count = msgBroadService.getCount();
        PageResp resp = new PageResp<MsgBroad>(rows, count);
        return resp;
    }
//
//    @RequestMapping("/new")
//    @JsonBody
//    public void add(@RequestBody MsgBroad msgBroad) {
//        logger.info("new");
//        msgBroadService.add(msgBroad);
//    }
//
//    @RequestMapping("/info")
//    @JsonBody
//    public MsgBroad info(HttpServletRequest request) {
//        logger.info("info");
//        MsgBroad msgBroad = msgBroadService.selectById(request.getParameter("id"));
//        return msgBroad;
//    }
//
//    @RequestMapping("/update")
//    @JsonBody
//    public void update(@RequestBody MsgBroad msgBroad) {
//        logger.info("update");
//        msgBroadService.updateById(msgBroad);
//
//    }
//
//    @RequestMapping("/del")
//    @JsonBody
//    public void delete(HttpServletRequest request) {
//        logger.info("delete");
//        msgBroadService.delById(request.getParameter("id"));
//    }
//
    /**
     * 公开显示留言
     *
     * @param request
     */
    @RequestMapping("/display")
    @JsonBody
    public void display(HttpServletRequest request) {
        logger.info("display");
        msgBroadService.displayMsg(request.getParameter("id"));
    }

    /**
     * 回复留言
     * @param newMsg 回复msg
     */
    @RequestMapping("/reply")
    @JsonBody
    public void display(@RequestBody MsgBroad newMsg) {
        logger.info("display");
        msgBroadService.replyMsg(newMsg);
    }
}
