package com.fscommunity.platform.provider.wechat.controller;

import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.auth.sts.AssumeRoleResponse.Credentials;
import com.fscommunity.platform.common.util.AliOSSClient;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lixiaoxiong
 * @version 2018-03-30
 */
@RequestMapping("/fscommunity/oss/")
@Controller
public class AliOssController {


    @Resource
    AliOSSClient aliOSSClient;

    @RequestMapping("/accessToken")
    @JsonBody
    public Credentials queryAccessToken() {
        AssumeRoleResponse response = aliOSSClient.querySTSToken();
        return response.getCredentials();
    }
}
