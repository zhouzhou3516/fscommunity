package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.wechat.req.AddLeaveMsgReq;
import com.fscommunity.platform.provider.wechat.voadaptor.MsgBroadVoAdatpter;
import com.fscommunity.platform.service.MsgBroadService;
import com.fscommunity.platform.service.UserInfoService;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-4-16
 */
@RequestMapping("/fscommunity/wechat/msgbroad")
@Controller
public class MsgBroadController {
    private final static Logger logger = LoggerFactory.getLogger(MsgBroadController.class);

    @Resource
    MsgBroadService msgBroadService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/add")
    @JsonBody
    public void addNewMsg(@RequestBody AddLeaveMsgReq req) {
        //todo 获取当前登录用户
        UserSimpleInfo simpleInfo = new UserSimpleInfo();
        simpleInfo.setId(1);

        MsgBroad broad = MsgBroadVoAdatpter.adaptBroad(req, simpleInfo.getId());
        MsgBroad savedBroad = msgBroadService.saveBroad(broad);
        msgBroadService.updateTreeCode(savedBroad.getTargetCid() == 0, savedBroad);
    }

//    @RequestMapping("/list")
//    @JsonBody
//    public PageResp list(MsgBroadListQueryReq req) {
//        logger.info("list");
//        //direct msg
//        List<MsgBroad> rows = msgBroadService.wxlist(
//                new PageRequest(Integer.valueOf(req.getCurrentPage()), Integer.valueOf(req.getPageSize()))
//        );
//        List<MsgBroadVo> vorows = new ArrayList<>();
//        for (MsgBroad msg : rows) {
//            //留言的回复列表
//            List<MgrMsgBroadVo> replyMsgList = new ArrayList<MgrMsgBroadVo>();
//            Stack<MsgBroad> tmp = new Stack<>();
//            //first 回复
//            MsgBroad replyMsg = msgBroadService.getReplyMsg(msg);
//            tmp.push(replyMsg);
//            while (!tmp.empty()) {
//                MsgBroad fmsg = tmp.pop();
//                //TODO
//                //replyMsgList.add(MgrMsgBroadVoAdatpter.adaptToMgrMsgBroadVo(fmsg));
//                MsgBroad smsg = msgBroadService.getReplyMsg(fmsg);
//                tmp.push(smsg);
//            }
//            //TODO
//            //vorows.add(MsgBroadVoAdatpter.adaptToMsgBroadVo(msg,replyMsgList));
//        }
//
//        int count = msgBroadService.getDirectCount();
//        PageResp resp = new PageResp<MsgBroadVo>(vorows, count);
//        return resp;
//    }
}
