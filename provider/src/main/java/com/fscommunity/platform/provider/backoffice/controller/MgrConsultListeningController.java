package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.persist.pojo.ConsultListeningInfo;
import com.fscommunity.platform.provider.backoffice.adapter.MgrConsultListeningVoAdapter;
import com.fscommunity.platform.provider.backoffice.req.ConsultListeningListQueryReq;
import com.fscommunity.platform.provider.backoffice.req.NewListeningReplyReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrConsultListeningVo;
import com.fscommunity.platform.service.ConsultListeningService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.page.PageResp;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqingzhou on 18/5/1.
 */
@RequestMapping("/fscommunity/man/listening")
@Controller("mgrConsultListeningController")
public class MgrConsultListeningController {

    private final static Logger logger = LoggerFactory.getLogger(MgrConsultListeningController.class);

    @Resource
    ConsultListeningService consultListeningService;
    @Resource
    SessionHolder sessionHolder;


    @RequestMapping("/list")
    @JsonBody
    public PageResp list(@RequestBody ConsultListeningListQueryReq req) {
        logger.info("info");
        List<ConsultListeningInfo> list = consultListeningService.list(req.getChannelType(), req.getConsultType(),
                new PageRequest(req.getCurrentPage(), req.getPageSize()));
        List<MgrConsultListeningVo> retList = MgrConsultListeningVoAdapter.adaptToVos(list);
        int count = consultListeningService.countList(req.getChannelType(), req.getConsultType());
        PageResp pageResp = new PageResp(retList, count);
        return pageResp;
    }

    @RequestMapping("/reply")
    @JsonBody
    @Transactional
    public void replyComment(@RequestBody NewListeningReplyReq req) {
        ConsultListeningInfo info = consultListeningService.queryById(req.getId());
        if (StringUtils.isNotBlank(info.getReplyContent())) {
            throw new BizException("已经回复过");
        }
        ManUser user = sessionHolder.currentManUser();
        //test code
        if(user == null){
            user = new ManUser();
            user.setId(1);
        }
        consultListeningService.reply(req.getId(), req.getReplyContent(), user.getId());
    }

}
