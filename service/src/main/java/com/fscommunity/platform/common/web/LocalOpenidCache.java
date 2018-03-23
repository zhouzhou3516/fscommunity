package com.fscommunity.platform.common.web;

import com.fscommunity.platform.common.util.LocalCache;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author lixiaoxiong
 * @version 2018-03-23
 */
@Service
public class LocalOpenidCache {

    @Resource
    LocalCache localCache;

    public void storeOpenId(String openidKey, String openid) {
        localCache.setValue(openidKey, openid);
    }

    public String queryOpenId(String openidKey) {
        return localCache.getValue(openidKey);
    }
}
