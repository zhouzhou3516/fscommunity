package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.common.pojo.SessionUserInfo;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.persist.pojo.MsgBroad;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.wechat.req.AddLeaveMsgReq;
import com.fscommunity.platform.provider.wechat.req.WxMsgBroadListQueryReq;
import com.fscommunity.platform.provider.wechat.vo.MsgBroadListVo;
import com.fscommunity.platform.provider.wechat.vo.MsgBroadVo;
import com.fscommunity.platform.provider.wechat.voadaptor.MsgBroadVoAdatpter;
import com.fscommunity.platform.service.MsgBroadService;
import com.fscommunity.platform.service.UserInfoService;
import com.google.common.collect.Lists;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Resource
    SessionHolder sessionHolder;

    @RequestMapping("/add")
    @JsonBody
    public void addNewMsg(@RequestBody AddLeaveMsgReq req) {
        SessionUserInfo userInfo = sessionHolder.currentUser();
        MsgBroad broad = MsgBroadVoAdatpter.adaptBroad(req, userInfo.getUserId());
        // 维护留言跟节点
        if (!req.isNewMsg()) {
            MsgBroad repliedMsg = msgBroadService.queryById(req.getReplyedId());
            if(repliedMsg.getIsReply()==1) {
                broad.setRootCid(repliedMsg.getRootCid());
            }else {
                broad.setRootCid(repliedMsg.getId());
            }
        }
        MsgBroad savedBroad = msgBroadService.saveBroad(broad);
        //msgBroadService.updateTreeCode(savedBroad.getTargetCid() == 0, savedBroad);
    }


    @RequestMapping("/list")
    @JsonBody
    public MsgBroadListVo list(@RequestBody WxMsgBroadListQueryReq req) {
        List<MsgBroad> rows = msgBroadService
                .wxlistOfAuthSucc(new PageRequest(Integer.valueOf(req.getCurrentPage()), Integer.valueOf(req.getPageSize()))
                );
        if (CollectionUtils.isEmpty(rows)) {
            return new MsgBroadListVo();
        }
        List<Integer> userIds =  rows.stream().map(i->i.getUserId()).distinct().collect(Collectors.toList());
        List<Integer> ids = rows.stream().map(msgBroad -> msgBroad.getId()).collect(Collectors.toList());
        List<MsgBroad> replys = msgBroadService.queryReplyByRootCids(ids);
        userIds.addAll( replys.stream().map(r->r.getUserId()).collect(Collectors.toList()));
        userIds = userIds.stream().distinct().collect(Collectors.toList());
        List<UserSimpleInfo> userSimpleInfoList = userInfoService.querySimpleUsersByIds(userIds);
        Map<Integer, UserSimpleInfo> userMap = userSimpleInfoList.stream()
                .collect(Collectors.toMap(u -> u.getId(), u -> u));
        Map<Integer, List<MsgBroad>> map = replys.stream().collect(Collectors.groupingBy(m -> m.getRootCid()));
        List<MsgBroadVo> retVos = rows.stream().map(msgBroad -> {
            MsgBroadVo vo = new MsgBroadVo(msgBroad);
            UserSimpleInfo userSimpleInfo = userMap.get(msgBroad.getUserId());
            vo.setUserName(userSimpleInfo.getUserName());
            vo.setUserAvatar(userSimpleInfo.getUserAvatar());
            List<MsgBroad> list = map.getOrDefault(vo.getId(), Lists.newArrayList());
            List<MsgBroadVo> vos = list.stream().map(rpy -> {
                MsgBroadVo rply = new MsgBroadVo(rpy);
                rply.setUserName(userMap.get(rply.getUserId()).getUserName());
                rply.setUserAvatar(userMap.get(rply.getUserId()).getUserAvatar());
                rply.setTargetUname(vo.getUserName());
                return rply;
            }).collect(Collectors.toList());
            vo.setReplyMsg(vos);
            return vo;
        }).collect(Collectors.toList());

        MsgBroadListVo vo = new MsgBroadListVo();
        vo.setMsgs(retVos);
        vo.setTotalCount(msgBroadService.countMsg());
        return vo;
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
