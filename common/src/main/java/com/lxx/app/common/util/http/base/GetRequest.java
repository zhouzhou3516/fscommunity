package com.lxx.app.common.util.http.base;

import java.net.URI;

public class GetRequest extends BasicHttpRequest {

    public GetRequest(URI uri) {
        super(uri);
    }

    @Override
    public Method getMethod() {
        return Method.GET;
    }
}