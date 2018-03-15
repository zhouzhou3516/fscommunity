package com.lxx.app.common.util.http.base;

import java.net.URI;

/**
 * @author zhenwei.liu
 * @since 2016-08-31
 */
public interface PoolKeyStrategy {

    String createPoolKey(URI uri, ProxyServer proxyServer);
}
