package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.WxCodeDao;
import com.fscommunity.platform.persist.pojo.WxToken;
import com.fscommunity.platform.persist.pojo.WxTokenItem;
import com.google.common.base.Strings;
import com.lxx.app.common.util.DateFormatUtil;
import com.lxx.app.common.util.json.JsonUtil;
import com.lxx.app.common.util.pojo.BizException;
import java.util.Date;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-02-01
 */
@Service
public class WxTokenService {
    private final static Logger logger = LoggerFactory.getLogger(WxTokenService.class);

    public final static String YSGH = "ysgh";

    @Resource
    WxCodeDao wxCodeDao;

    public int saveWxToken(WxToken token) {
        if (token == null) {
            return 0;
        }
        return wxCodeDao.saveWxToken(token);
    }

    public WxToken queryToken(String wxCode) {
        if (Strings.isNullOrEmpty(wxCode)) {
            return null;
        }
        return wxCodeDao.queryToken(wxCode);
    }

    public int initYsghToken() {
        WxToken token = new WxToken();
        token.setWxCode(YSGH);
        Date current = new Date();
        token.setCreateTime(current);
        token.setUpdateTime(current);
        token.setInterfaceToken(new WxTokenItem("", current));
        token.setJsApiTicket(new WxTokenItem("", current));
        token.setWebAuthToken(new WxTokenItem("", current));
        token.setWebAuthRefreshToken(new WxTokenItem("", current));
        return saveWxToken(token);
    }

    public void preCheck(WxTokenItem item) {
        WxToken token = queryToken(YSGH);
        if (token == null) {
            initYsghToken();
        }
    }

    public int updateInterfaceToken(WxTokenItem token){
        preCheck(token);
        return wxCodeDao.updateInterfaceToken(JsonUtil.of(token), YSGH);
    }
    public int updateWebToken(WxTokenItem token){
        preCheck(token);
        return wxCodeDao.updateWebToken(JsonUtil.of(token), YSGH);
    }
    public int updateWebRefreshToken(WxTokenItem token){
        preCheck(token);
        return wxCodeDao.updateWebRefreshToken(JsonUtil.of(token), YSGH);
    }
    public int updateTicketToken(WxTokenItem token){
        preCheck(token);
        return wxCodeDao.updateTicketToken(JsonUtil.of(token), YSGH);
    }

    public String queryInterfaceToken() {
        WxToken token = queryWxToken();
        if (token == null) {
            throw new BizException("查询不到有效的token");
        }

        WxTokenItem interfaceToken = token.getInterfaceToken();
        Date current = new Date();
        if (current.compareTo(interfaceToken.getExpireTime()) > 0) {
            logger.info("current time:{}, expire time:{}", DateFormatUtil.format4y2M2d2h2m2s(current),
                    DateFormatUtil.format4y2M2d2h2m(interfaceToken.getExpireTime()));
            throw new BizException("微信接口访问token过期");
        }

        return interfaceToken.getValue();
    }

    public String queryRefreshToken() {
        WxToken token = queryWxToken();
        if (token == null) {
            throw new BizException("查询不到有效的token");
        }

        WxTokenItem refreshToken = token.getWebAuthRefreshToken();
        Date current = new Date();
        if (current.compareTo(refreshToken.getExpireTime()) > 0) {
            logger.info("current time:{}, expire time:{}", DateFormatUtil.format4y2M2d2h2m2s(current),
                    DateFormatUtil.format4y2M2d2h2m(refreshToken.getExpireTime()));
            throw new BizException("微信接口访问token过期");
        }
        return refreshToken.getValue();
    }

    private WxToken queryWxToken() {
        WxToken token = wxCodeDao.queryToken(YSGH);
        if (token == null) {
            return null;
        }
        return token;
    }
}
