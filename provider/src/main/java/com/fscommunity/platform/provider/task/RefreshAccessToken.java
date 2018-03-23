package com.fscommunity.platform.provider.task;

import com.fscommunity.platform.common.web.AccessTokenCache;
import com.fscommunity.platform.service.WxTokenService;
import com.google.common.base.Strings;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-01-24
 */
@Service("refreshAccessToken")
public class RefreshAccessToken {
    private final static Logger logger = LoggerFactory.getLogger(RefreshAccessToken.class);

    @Resource
    AccessTokenCache accessTokenCache;

    @Resource
    WxTokenService wxTokenService;

    public void refresh() {
        logger.info("开始刷新access token and ticket");
        accessTokenCache.refresh();

        String refreshToken = wxTokenService.queryRefreshToken();
        if (!Strings.isNullOrEmpty(refreshToken)) {
            accessTokenCache.refreshWebAuthToken(refreshToken);
        }
    }
}
