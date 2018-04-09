package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.common.pojo.VerifyCodeTemp;
import com.fscommunity.platform.common.util.SmsSender;
import com.fscommunity.platform.persist.pojo.VerifyBizType;
import com.fscommunity.platform.persist.pojo.VerifyCode;
import com.fscommunity.platform.persist.pojo.VerifyCodeStatus;
import com.fscommunity.platform.service.VerifyCodeService;
import com.lxx.app.common.util.RandomUtil;
import com.lxx.app.common.util.WxCheckUtil;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lixiaoxiong
 * @version 2018-01-20
 */
@RequestMapping("/fscommunity/common")
@Controller
public class CommonController {
    private final static Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Resource
    SmsSender smsSender;

    @Resource
    VerifyCodeService verifyCodeService;

    /**
     * 发送四位验证码
     * @param phone 要发送的电话号码
     */
    @RequestMapping("/verifyCode")
    @JsonBody
    public void sendVerifyCode(String phone) {
        //1. 是否有可用的验证码, 无须重复生成, 保证一个电话,一种业务只有一个验证码
        VerifyCode code = verifyCodeService
                .queryVerifyCode(phone, VerifyBizType.FILL_DETAIL_INFO_CODE);
        if (code != null) {
            smsSender.sendVerifyCode(phone, new VerifyCodeTemp(code.getCode()));
            return;
        }

        //2. 没有可用的则生成新的
        VerifyCode verifyCode = buildCode(phone);
        int succCount = verifyCodeService.saveVerifyCode(verifyCode);
        if (succCount > 0) {
            smsSender.sendVerifyCode(phone, new VerifyCodeTemp(verifyCode.getCode()));
        }
    }


    @RequestMapping("/wx")
    @JsonBody
    public void wxCallBack(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        PrintWriter out = response.getWriter();
        logger.info("signature:{}, timestamp:{}, nonce:{}, echostr:{}",
                signature, timestamp, nonce, echostr);
        if(WxCheckUtil.checkSignature(signature, timestamp, nonce)){
            logger.info("check  ok");
            out.print(echostr);
        }
    }

    private VerifyCode buildCode(String phone) {
        VerifyCode code = new VerifyCode();
        code.setBizType(VerifyBizType.FILL_DETAIL_INFO_CODE);
        code.setCodeStatus(VerifyCodeStatus.NEW);
        code.setPhone(phone);
        Date current = new Date();
        code.setCreateTime(current);
        code.setUpdateTime(current);
        code.setCode(String.valueOf(RandomUtil.randomFixBit(4)));
        return code;
    }
}
