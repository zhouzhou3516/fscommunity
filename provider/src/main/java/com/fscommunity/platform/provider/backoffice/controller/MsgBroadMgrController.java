package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.fscommunity.platform.provider.backoffice.adapter.MgrMsgBroadVoAdatpter;
import com.fscommunity.platform.provider.backoffice.req.CommentAuthReq;
import com.fscommunity.platform.provider.backoffice.req.MsgBroadListQueryReq;
import com.fscommunity.platform.provider.backoffice.req.NewCommentReplyReq;
import com.fscommunity.platform.service.MsgBroadService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.page.PageResp;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 留言板controller
 * @Author jing.c
 * @Date: 18-3-28
 */
@RequestMapping("/fscommunity/man/msgbroad")
@Controller
public class MsgBroadMgrController {

    private final static Logger logger = LoggerFactory.getLogger(MsgBroadMgrController.class);

    @Resource
    MsgBroadService msgBroadService;

    @Resource
    private SessionHolder sessionHolder;

    @RequestMapping("/reply")
    @JsonBody
    @Transactional
    public void replyComment(@RequestBody NewCommentReplyReq req) {
        MsgBroad targetCmt = msgBroadService.queryById(req.getTargetId());
        if (targetCmt.getIsReplied() == 1) {
            throw new BizException("已经被评论过");
        }
        // 更新被评论的评论状态为已评论
        msgBroadService.updateIsReplied(targetCmt.getId());
        ManUser user = sessionHolder.currentManUser();
        MsgBroad newBmsgBroad = MgrMsgBroadVoAdatpter.adaptToBroad(targetCmt, req, user.getId());
        msgBroadService.saveBroad(newBmsgBroad);
    }


    @RequestMapping("/list")
    @JsonBody
    public PageResp list(MsgBroadListQueryReq req) {
        List<MsgBroad> rows = msgBroadService.list(req.getAuthStatus(), req.getReplyStatus(),
                new PageRequest(Integer.valueOf(req.getCurrentPage()), Integer.valueOf(req.getPageSize()))
        );
        int count = msgBroadService.countList(req.getAuthStatus(), req.getReplyStatus());
        PageResp resp = new PageResp<>(rows, count);
        return resp;
    }

    @RequestMapping("/auth")
    @JsonBody
    public void authMsgBroad(@RequestBody CommentAuthReq req) {
        msgBroadService.updateAuthStatus(req.getId(), req.getAuthStatus().getCode());
    }
//

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
//    @RequestMapping("/display")
//    @JsonBody
//    public void display(HttpServletRequest request) {
//        logger.info("display");
//        msgBroadService.displayMsg(request.getParameter("id"));
//    }
//
//    /**
//     * 回复留言
//     * @param newMsg 回复msg
//     */
//    @RequestMapping("/reply")
//    @JsonBody
//    public void display(@RequestBody MsgBroad newMsg) {
//        logger.info("display");
//        msgBroadService.replyMsg(newMsg);
//    }
}
