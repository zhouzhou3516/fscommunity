package com.fscommunity.platform.common.web;

import com.fscommunity.platform.common.pojo.WxAccessToken;
import com.fscommunity.platform.common.pojo.WxJsapiTicket;
import com.fscommunity.platform.persist.pojo.WxTokenItem;
import com.fscommunity.platform.service.WxTokenService;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-01-24
 */
@Service
public class AccessTokenCache {
    private final static Logger logger = LoggerFactory.getLogger(AccessTokenCache.class);

    private static Map<String, String> tokenMap = new HashMap<>();
    private static Map<String, String> ticketMap = new HashMap<>();
    private static Map<String, String> webAuthTokenMap = new HashMap<>();
    private static Map<String, String> webAuthRefreshTokenMap = new HashMap<>();
    private static final String TOKEN_KEY = "wx_access_token_key";
    private static final String JSAPI_TICKET_KEY = "wx_jsapi_ticket_key";
    private static final String WEB_AUTH_TOKEN = "wx_web_auth_token_key";
    private static final String WEB_AUTH_REFRESH_TOKEN = "web_auth_refresh_token_key";

    @Resource
    WxInvoker wxInvoker;

    @Resource
    WxTokenService wxTokenService;

    public String getToken() {
        return tokenMap.get(TOKEN_KEY);
    }

    public String getTicket() {
        return ticketMap.get(JSAPI_TICKET_KEY);
    }

    private String getWebToken() {
        return webAuthTokenMap.get(WEB_AUTH_TOKEN);
    }

    private String getWebRefreshToken() {
        return webAuthRefreshTokenMap.get(WEB_AUTH_REFRESH_TOKEN);
    }

    public void updateToken(String token) {
        tokenMap.put(TOKEN_KEY, token);
    }

    public void updateWebToken(String token) {
        webAuthTokenMap.put(WEB_AUTH_TOKEN, token);
    }

    public void updateWebRefreshToken(String token) {
        webAuthRefreshTokenMap.put(WEB_AUTH_REFRESH_TOKEN, token);
    }

    @PostConstruct
    private void init() {
        refresh();
    }

    public void refresh() {
        ListenableFuture<WxAccessToken> future = wxInvoker
                .queryAccessToken();

        Futures.addCallback(future, new FutureCallback<WxAccessToken>() {
            @Override
            public void onSuccess(WxAccessToken result) {
                logger.info("请求wx获取accesstoken:{}, expire:{}",
                        result.getAccessToken(), result.getExpire());
                tokenMap.put(TOKEN_KEY, result.getAccessToken());
                wxTokenService.updateInterfaceToken(build(result));
                refreshTicket();
            }

            @Override
            public void onFailure(Throwable t) {
                logger.info("请求wx获取accesstoken失败", t);
            }
        });
    }

    private WxTokenItem build(WxAccessToken token) {
        WxTokenItem item = new WxTokenItem();
        item.setValue(token.getAccessToken());
        item.setExpireTime(DateUtils.addSeconds(new Date(), token.getExpire()));
        return item;
    }

    public void refreshTicket() {
        ListenableFuture<WxJsapiTicket> queryJsapiTicket = wxInvoker
                .queryJsapiTicket(getToken());
        Futures.transformAsync(queryJsapiTicket, input -> {
            logger.info("请求wx获取ticket:{}, expire:{}",
                    input.getTicket(), input.getExpiresIn());
            ticketMap.put(JSAPI_TICKET_KEY, input.getTicket());
            wxTokenService.updateTicketToken(build(input));
            return null;
        });
    }

    private WxTokenItem build(WxJsapiTicket token) {
        WxTokenItem item = new WxTokenItem();
        item.setValue(token.getTicket());
        item.setExpireTime(DateUtils.addSeconds(new Date(), token.getExpiresIn()));
        return item;
    }
}
