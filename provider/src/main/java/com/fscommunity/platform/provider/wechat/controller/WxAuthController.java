package com.fscommunity.platform.provider.wechat.controller;

import com.fscommunity.platform.common.pojo.JsSignature;
import com.fscommunity.platform.common.pojo.WxWebAuthToken;
import com.fscommunity.platform.common.web.AccessTokenCache;
import com.fscommunity.platform.common.web.CookieManager;
import com.fscommunity.platform.common.web.JsSignatureBuilder;
import com.fscommunity.platform.common.web.LocalOpenidCache;
import com.fscommunity.platform.common.web.SessionHolder;
import com.fscommunity.platform.common.web.WxInvoker;
import com.fscommunity.platform.persist.pojo.WxUser;
import com.fscommunity.platform.provider.wechat.vo.AuthInfo;
import com.fscommunity.platform.service.WxUserService;
import com.google.common.base.Strings;
import com.lxx.app.common.util.Base64Util;
import com.lxx.app.common.util.json.JsonUtil;
import com.lxx.app.common.web.spring.annotation.JsonBody;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
 *
 * @author lixiaoxiong
 * @version 2018-01-24
 */
@RequestMapping("/ysgh/wx/auth")
@Controller
public class WxAuthController {

    private final static Logger logger = LoggerFactory.getLogger(WxAuthController.class);

    @Resource
    WxInvoker wxInvoker;

    @Resource
    SessionHolder sessionHolder;

    @Resource
    JsSignatureBuilder jsSignatureBuilder;

    @Resource
    WxUserService wxUserService;

    @Resource
    AccessTokenCache accessTokenCache;

    @Resource
    LocalOpenidCache localOpenidCache;

    @Value("${appid}")
    private String appId;

    @RequestMapping("/code/callback")
    @JsonBody
    public void wxCodeCallBack(HttpServletRequest request, HttpServletResponse response) {
        //1. 微信回到code
        String code = request.getParameter("code");
        String redirectUrl = Base64Util.decode(request.getParameter("state"));
        logger.info("收到回调请求, code:{}, state:{}", code, redirectUrl);

        //2. 获取openid
        WxWebAuthToken wxWebAuthToken = wxInvoker.queryOpenId(code);
        logger.info("获取openid:{}", JsonUtil.of(wxWebAuthToken));

        //2.1 更新web access token
        accessTokenCache.updateWebToken(wxWebAuthToken.getAccessToken(), wxWebAuthToken.getExpire());
        //2.2 更新refres token
        accessTokenCache.updateWebRefreshToken(wxWebAuthToken.getRefreshToken());

        //3. 相当于保存session, 缓存失效,则登录失效
        localOpenidCache.storeOpenId(wxWebAuthToken.getOpenid(), wxWebAuthToken.getOpenid());

        //3. 拉取用户信息
        WxUser wxUser = wxInvoker
                .queryWxUser(wxWebAuthToken.getAccessToken(), wxWebAuthToken.getOpenid());
        if (wxUser != null) {
            if (Strings.isNullOrEmpty(wxUser.getUnionid())) {
                wxUser.setUnionid("");
            }
            wxUserService.saveWxUser(wxUser);
        }
        logger.info("获取微信用户信息:{}", JsonUtil.of(wxUser));
        if (!Strings.isNullOrEmpty(wxWebAuthToken.getOpenid())) {
            CookieManager.SESSION.setCookieValue(response, wxWebAuthToken.getOpenid());
            try {
                logger.info("获取openid:{}成功, 重定向:{}", wxWebAuthToken.getOpenid(), redirectUrl);
                response.sendRedirect(redirectUrl);
            } catch (IOException ignored) {
            }
        }
    }

    @RequestMapping("/redirect")
    @JsonBody
    public void preCallBack(String redirectUrl, HttpServletResponse response) throws IOException {
        String url = wxInvoker.codeUrl(redirectUrl);
        response.sendRedirect(url);
    }

    @RequestMapping("/openid")
    @JsonBody
    public AuthInfo queryOpenid(@RequestParam("redirectUrl") String redirectUrl) {
        String op = sessionHolder.currentOpenId();
        AuthInfo info = new AuthInfo();
        if (Strings.isNullOrEmpty(op)) {
            info.setOpenid("");
        } else {
            info.setOpenid(op);
        }

        JsSignature build = jsSignatureBuilder
                .build(accessTokenCache.getTicket(), /*RequestUtil.reqUrlWithParam(request)*/redirectUrl);
        logger.info("create signature:{}", JsonUtil.of(build));
        info.setSignature(build.getSignature());
        info.setNonceStr(build.getNonceStr());
        info.setTimestamp(build.getTimestamp());
        info.setAppId(appId);
        return info;
    }
}
