package com.fscommunity.platform.common.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fscommunity.platform.common.constant.WxMediaType;
import com.fscommunity.platform.common.pojo.WxAccessToken;
import com.fscommunity.platform.common.pojo.WxJsapiTicket;
import com.fscommunity.platform.common.pojo.WxUserExt;
import com.fscommunity.platform.common.pojo.WxWebAuthErrorResp;
import com.fscommunity.platform.common.pojo.WxWebAuthToken;
import com.fscommunity.platform.common.util.HttpClientUtil;
import com.fscommunity.platform.persist.pojo.WxUser;
import com.fscommunity.platform.service.WxTokenService;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.lxx.app.common.util.Base64Util;
import com.lxx.app.common.util.http.base.AsyncHttpResponse;
import com.lxx.app.common.util.json.JsonUtil;
import com.lxx.app.common.util.pojo.BizException;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Resource;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-01-24
 */
@Service
public class WxInvoker {

    private final static Logger logger = LoggerFactory.getLogger(WxInvoker.class);
    private final static String TOKEN_BASE_URL = "https://api.weixin.qq.com";
    private final static String WX_USER_INFO_URL = "/sns/userinfo";
    private final static String ACCESS_TOKEN_URL = "/cgi-bin/token";
    private final static String WX_USER_EXT_INFO_URL = "/cgi-bin/user/info";
    private final static String JSAPI_TICKET_TOKEN_URL = "/cgi-bin/ticket/getticket";
    private final static String WEB_ACCESS_TOKEN_URL = "/sns/oauth2/access_token";
    private final static String WEB_ACCESS_REFRESH_TOKEN_URL = "/sns/oauth2/refresh_token";
    private final static String OPEN_BASE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";
    private final static String URL_SEP = "?";
    private final static String URL_PARAM_SEP = "&";
    private final static String APP_ID = "wxad8fb528b56bdf2e";
    private final static String APP_SECRET = "2857a9393c04903e60d97f597da53efd";
    private static final String DOWNLOAD_MEDIA_URL = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";

    @Resource
    HttpClientUtil httpClientUtil;

    @Resource
    WxTokenService wxTokenService;

    public ListenableFuture<WxAccessToken> queryAccessToken() {
        StringBuilder tokenUrl = new StringBuilder();
        tokenUrl.append(TOKEN_BASE_URL).append(ACCESS_TOKEN_URL).append(URL_SEP)
                .append("grant_type=client_credential").append("&")
                .append("appid=").append(APP_ID).append("&")
                .append("secret=").append(APP_SECRET);
        ListenableFuture<AsyncHttpResponse> future = httpClientUtil
                .syncGet(tokenUrl.toString());
        return Futures.transform(future, new Function<AsyncHttpResponse, WxAccessToken>() {
            @Override
            public WxAccessToken apply(AsyncHttpResponse input) {
                return decode(input, tokenUrl.toString());
            }
        });
    }


    public boolean checkSubcribe(String openId) {
        String token = wxTokenService.queryInterfaceToken();
        if (Strings.isNullOrEmpty(token)) {
            return false;
        }

        WxUserExt wxUserExt = queryWxUserExt(token, openId);
        return wxUserExt.getSubscribe() != 0;
    }

    public ListenableFuture<WxJsapiTicket> queryJsapiTicket(String accessToken) {
        StringBuilder tokenUrl = new StringBuilder();
        tokenUrl.append(TOKEN_BASE_URL).append(JSAPI_TICKET_TOKEN_URL).append(URL_SEP)
                .append("access_token=").append(accessToken).append(URL_PARAM_SEP)
                .append("type=jsapi");
        ListenableFuture<AsyncHttpResponse> future = httpClientUtil
                .syncGet(tokenUrl.toString());
        return Futures.transform(future, new Function<AsyncHttpResponse, WxJsapiTicket>() {
            @Override
            public WxJsapiTicket apply(AsyncHttpResponse input) {
                return decodeTicket(input, tokenUrl.toString());
            }
        });
    }


    public ListenableFuture<WxWebAuthToken> queryWebAccessToken(String code) {
        StringBuilder tokenUrl = new StringBuilder();
        tokenUrl.append(TOKEN_BASE_URL).append(WEB_ACCESS_TOKEN_URL).append(URL_SEP)
                .append("appid=").append(APP_ID).append(URL_PARAM_SEP)
                .append("secret=").append(APP_SECRET).append(URL_PARAM_SEP)
                .append("code=").append(code).append(URL_PARAM_SEP)
                .append("grant_type=authorization_code");
        ListenableFuture<AsyncHttpResponse> listenableFuture = httpClientUtil
                .syncGet(tokenUrl.toString());

        return Futures.transform(listenableFuture,
                new Function<AsyncHttpResponse, WxWebAuthToken>() {
                    @Override
                    public WxWebAuthToken apply(AsyncHttpResponse input) {
                        try {
                            return decodeWebToken(input, tokenUrl.toString());
                        } catch (Exception e) {
                            logger.error("请求web auth token异常", e);
                            return null;
                        }

                    }
                });
    }

    public ListenableFuture<WxWebAuthToken> queryWebAccessTokenByRefreshToken(String refreshToken) {
        StringBuilder tokenUrl = new StringBuilder();
        tokenUrl.append(TOKEN_BASE_URL).append(WEB_ACCESS_REFRESH_TOKEN_URL).append(URL_SEP)
                .append("appid=").append(APP_ID).append(URL_PARAM_SEP)
                .append("grant_type=refresh_token").append(URL_PARAM_SEP)
                .append("refresh_token=").append(refreshToken);
        ListenableFuture<AsyncHttpResponse> listenableFuture = httpClientUtil
                .syncGet(tokenUrl.toString());

        return Futures.transform(listenableFuture,
                new Function<AsyncHttpResponse, WxWebAuthToken>() {
                    @Override
                    public WxWebAuthToken apply(AsyncHttpResponse input) {
                        try {
                            return decodeWebToken(input, "");
                        } catch (Exception e) {
                            logger.error("请求web auth token异常", e);
                            return null;
                        }
                    }
                });
    }

    public WxWebAuthToken queryOpenId(String code) {
        ListenableFuture<WxWebAuthToken> future = queryWebAccessToken(code);
        try {
            return future.get();
        } catch (InterruptedException e) {
            logger.error("获取openid线程被中断");
        } catch (ExecutionException e) {
            logger.error("获取openid线程执行异常");
        }
        return null;
    }

    public ListenableFuture<WxUser> queryWxUserRemote(String accessToken, String openid) {
        StringBuffer url = new StringBuffer();
        url.append(TOKEN_BASE_URL).append(WX_USER_INFO_URL).append(URL_SEP)
                .append("access_token=").append(accessToken).append(URL_PARAM_SEP)
                .append("openid=").append(openid).append(URL_PARAM_SEP)
                .append("lang=zh_CN");
        ListenableFuture<AsyncHttpResponse> future = httpClientUtil
                .syncGet(url.toString());
        return Futures.transform(future, new Function<AsyncHttpResponse, WxUser>() {
            @Override
            public WxUser apply(AsyncHttpResponse input) {
                return decodeWxUser(input, url.toString());
            }
        });
    }

    public WxUserExt queryWxUserExt(String accessToken, String openid) {
        StringBuffer url = new StringBuffer();
        url.append(TOKEN_BASE_URL).append(WX_USER_EXT_INFO_URL).append(URL_SEP)
                .append("access_token=").append(accessToken).append(URL_PARAM_SEP)
                .append("openid=").append(openid).append(URL_PARAM_SEP)
                .append("lang=zh_CN");
        ListenableFuture<AsyncHttpResponse> future = httpClientUtil
                .syncGet(url.toString());
        ListenableFuture<WxUserExt> transform = Futures
                .transform(future, new Function<AsyncHttpResponse, WxUserExt>() {
                    @Override
                    public WxUserExt apply(AsyncHttpResponse input) {
                        return decode(input, url.toString(), new TypeReference<WxUserExt>() {
                        });
                    }
                });

        try {
            return transform.get();
        } catch (InterruptedException | ExecutionException e) {
            logger.error("查询微信用户基本信息异常", e);
        }
        return null;
    }

    public WxUser queryWxUser(String accessToken, String openid) {
        ListenableFuture<WxUser> future = queryWxUserRemote(accessToken, openid);
        try {
            return future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            logger.error("获取用户信息异常", e);
        }
        return null;
    }

    public String codeUrl(String redirectUrl) {
        StringBuilder codeUrl = new StringBuilder();
        try {
            codeUrl.append(OPEN_BASE_URL).append(URL_SEP)
                    .append("appid=").append(APP_ID).append(URL_PARAM_SEP)
                    .append("redirect_uri=").append(URLEncoder
                    .encode("http://www.community-cloud.cn/ysgh/wx/auth/code/callback", Charsets.UTF_8.name()))
                    .append(URL_PARAM_SEP)
                    .append("response_type=code").append(URL_PARAM_SEP)
                    .append("scope=").append("snsapi_userinfo").append(URL_PARAM_SEP)
                    .append("state=").append(Base64Util.encode(redirectUrl))
                    .append("#wechat_redirect");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return codeUrl.toString();
    }

    public void pubCodeCallback(String redirectUrl) {
        String url = codeUrl(redirectUrl);
        ListenableFuture<AsyncHttpResponse> syncGet = httpClientUtil.syncGet(url);
    }

    public File dowloadWxMedia(String accessToken, final String mediaId, WxMediaType type) {
        ListenableFuture<File> future = downloadWxMediaRemote(accessToken, mediaId, type);
        try {
            return future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            logger.error("下载多媒体文件异常", e);
        }
        return null;
    }

    private ListenableFuture<File> downloadWxMediaRemote(String accessToken, String mediaId, WxMediaType type) {
        String url = String.format(DOWNLOAD_MEDIA_URL, accessToken, mediaId);
        ListenableFuture<AsyncHttpResponse> future = httpClientUtil.syncGet(url);
        return Futures.transform(future, (Function<AsyncHttpResponse, File>) input -> {
            File file = new File(mediaId + "." + type.getExtName());
            try {
                FileUtils.writeByteArrayToFile(file, input.getBodyAsBytes());
            } catch (IOException e) {
                file = null;
                logger.error("下载多媒体文件异常", e);
            }
            return file;
        });
    }

    private WxAccessToken decode(AsyncHttpResponse response, String url) {
        logger.info("wx request info, request:{}, status:{}",
                url, response.getStatusLine().getStatusCode());
        String responseBodyAsString = response.getBodyAsString();
        return JsonUtil.of(responseBodyAsString, WxAccessToken.class);
    }

    private WxJsapiTicket decodeTicket(AsyncHttpResponse response, String url) {
        logger.info("wx request info, request:{}, status:{}",
                url, response.getStatusLine().getStatusCode());
        String responseBodyAsString = response.getBodyAsString();
        return JsonUtil.of(responseBodyAsString, WxJsapiTicket.class);
    }

    private WxWebAuthToken decodeWebToken(AsyncHttpResponse response, String url) {
        String responseBodyAsString = response.getBodyAsString();
        if (responseBodyAsString.contains("errcode")) {
            WxWebAuthErrorResp errorResp = JsonUtil.of(responseBodyAsString, WxWebAuthErrorResp.class);
            logger.error("从微信获取openid出错, code:{}, errmsg:{}",
                    errorResp.getErrcode(), errorResp.getErrmsg());
            throw new BizException(MessageFormat.format("从微信获取openid出错, code:{0}, errmsg:{1}",
                    errorResp.getErrcode(), errorResp.getErrmsg()));
        }

        return JsonUtil.of(responseBodyAsString, WxWebAuthToken.class);
    }

    private WxUser decodeWxUser(AsyncHttpResponse response, String url) {
        String responseBodyAsString = response.getBodyAsString();
        if (responseBodyAsString.contains("errcode")) {
            WxWebAuthErrorResp errorResp = JsonUtil.of(responseBodyAsString, WxWebAuthErrorResp.class);
            logger.error("从微信获取用户信息出错, code:{}, errmsg:{}",
                    errorResp.getErrcode(), errorResp.getErrmsg());
            throw new BizException(MessageFormat.format("从微信获取openid出错, code:{0}, errmsg:{1}",
                    errorResp.getErrcode(), errorResp.getErrmsg()));
        }
        return JsonUtil.of(responseBodyAsString, WxUser.class);
    }


    private <T> T decode(AsyncHttpResponse response, String url, TypeReference<T> reference) {
        String responseBodyAsString = response.getBodyAsString();
        if (responseBodyAsString.contains("errcode")) {
            WxWebAuthErrorResp errorResp = JsonUtil.of(responseBodyAsString, WxWebAuthErrorResp.class);
            logger.error("从微信获取用户信息出错, code:{}, errmsg:{}",
                    errorResp.getErrcode(), errorResp.getErrmsg());
            throw new BizException(MessageFormat.format("从微信获取openid出错, code:{0}, errmsg:{1}",
                    errorResp.getErrcode(), errorResp.getErrmsg()));
        }

        return JsonUtil.of(responseBodyAsString, reference);
    }

}
