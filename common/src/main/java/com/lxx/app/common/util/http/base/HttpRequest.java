package com.lxx.app.common.util.http.base;

import java.net.URI;

public interface HttpRequest extends HttpMessage {

    URI getURI();

    Method getMethod();

    RequestConfig getConfig();
}
