package com.fscommunity.platform.service;

import com.fscommunity.platform.persist.dao.WxUserDao;
import com.fscommunity.platform.persist.pojo.WxUser;
import com.google.common.base.Strings;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-02-01
 */
@Service
public class WxUserService {

    @Resource
    WxUserDao wxUserDao;

    public int saveWxUser(WxUser wxUser) {
        if (wxUser == null) {
            return 0;
        }
        return wxUserDao.saveWxUser(wxUser);
    }

    public WxUser queryWxUserByOpenid(String openid) {
        if (Strings.isNullOrEmpty(openid)) {
            return null;
        }
        return wxUserDao.queryWxUserByOpenId(openid);
    }
}
