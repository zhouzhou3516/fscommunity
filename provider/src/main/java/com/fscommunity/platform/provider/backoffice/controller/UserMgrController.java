package com.fscommunity.platform.provider.backoffice.controller;

import com.fscommunity.platform.persist.pojo.UserInfo;
import com.fscommunity.platform.provider.backoffice.adapter.MgrUserInfoVoAdaptor;
import com.fscommunity.platform.provider.backoffice.req.UserAuditRequest;
import com.fscommunity.platform.provider.backoffice.req.UserListQueryReq;
import com.fscommunity.platform.provider.backoffice.vo.MgrUserInfoVo;
import com.fscommunity.platform.service.UserInfoService;
import com.fscommunity.platform.service.useraudit.UserAuditHelper;
import com.lxx.app.common.util.page.PageRequest;
import com.lxx.app.common.util.page.PageResp;
import com.lxx.app.common.util.pojo.BizException;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author jing.c
 * @Date: 18-3-22
 */
@RequestMapping("/fscommunity/man/user")
@Controller
public class UserMgrController {

    private final static Logger logger = LoggerFactory.getLogger(UserMgrController.class);

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/list")
    @JsonBody
    public PageResp list(@RequestBody UserListQueryReq req) {
        List<UserInfo> list = userInfoService.list(req.getFuzzyName(), req.getPhone(), req.getAuditStatus(),
                new PageRequest(req.getCurrentPage(), req.getPageSize()));
        List<MgrUserInfoVo> vos = list.stream().map(userInfo -> MgrUserInfoVoAdaptor.adapt(userInfo))
                .collect(Collectors.toList());
        PageResp<MgrUserInfoVo> resp = new PageResp<>();
        resp.setTotalCount(1);
        resp.setRows(vos);
        return resp;
    }

    @RequestMapping("/audit")
    @JsonBody
    public String audit(@RequestBody UserAuditRequest auditRequest) {
        UserInfo userInfo = userInfoService.queryUserById(auditRequest.getId());
        if (userInfo == null) {
            throw new BizException("用户不存在");
        }
        UserAuditHelper helper = new UserAuditHelper(userInfo, auditRequest.getAuditStatus());
        UserInfo auditUser = helper.handle();
        userInfoService.saveUserInfo(auditUser);
        return "success";
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
    public void importExcel() {
        logger.info("review");
    }

    @RequestMapping("/export")
    @JsonBody
    public void exportExcel() {
        logger.info("review");
    }


}