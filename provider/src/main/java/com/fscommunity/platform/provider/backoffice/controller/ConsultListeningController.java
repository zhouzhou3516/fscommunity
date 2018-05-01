package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.common.pojo.ManUser;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.persist.pojo.Article;
import com.fscommunity.platform.persist.pojo.Comment;
import com.fscommunity.platform.persist.pojo.CommentAuthStatus;
import com.fscommunity.platform.persist.pojo.CommentReplyStatus;
import com.fscommunity.platform.persist.pojo.ConsultListeningInfo;
import com.fscommunity.platform.persist.pojo.UserSimpleInfo;
import com.fscommunity.platform.provider.backoffice.adapter.CommentVoAdatpter;
import com.fscommunity.platform.provider.backoffice.adapter.MgrConsultListeningVoAdapter;
import com.fscommunity.platform.provider.backoffice.req.CommentAuthReq;
import com.fscommunity.platform.provider.backoffice.req.ConsultListeningListQueryReq;
import com.fscommunity.platform.provider.backoffice.req.NewCommentReplyReq;
import com.fscommunity.platform.provider.backoffice.req.NewListeningReplyReq;
import com.fscommunity.platform.provider.backoffice.req.QueryCommentListReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrConsultListeningVo;
import com.fscommunity.platform.service.ArticleService;
import com.fscommunity.platform.service.CommentService;
import com.fscommunity.platform.service.ConsultListeningService;
import com.fscommunity.platform.service.UserInfoService;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.page.PageResp;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liqingzhou on 18/5/1.
 */
@RequestMapping("/fscommunity/man/listening")
@Controller
public class ConsultListeningController {

    private final static Logger logger = LoggerFactory.getLogger(ConsultListeningController.class);

    @Resource
    ConsultListeningService  consultListeningService;
    @Resource
    SessionHolder sessionHolder;


    @RequestMapping("/list")
    @JsonBody
    public PageResp list(@RequestBody ConsultListeningListQueryReq req) {
        logger.info("info");
        List<ConsultListeningInfo> list= consultListeningService.list(req.getChannelType(),req.getConsultType(),
                new PageRequest(req.getCurrentPage(),req.getPageSize()));
        List<MgrConsultListeningVo> retList =  MgrConsultListeningVoAdapter.adaptToVos(list);
        int count = consultListeningService.countList(req.getChannelType(),req.getConsultType());
        PageResp pageResp = new PageResp(retList,count);
        return pageResp;
    }

    @RequestMapping("/reply")
    @JsonBody
    @Transactional
    public void replyComment(@RequestBody NewListeningReplyReq req) {
        ConsultListeningInfo info= consultListeningService.queryById(req.getId());
        if (StringUtils.isNotBlank(info.getReplyContent())) {
            throw new BizException("已经回复过");
        }
        ManUser user = sessionHolder.currentManUser();
        consultListeningService.reply(req.getId(),req.getReplyContent(),user.getId());
    }

}
