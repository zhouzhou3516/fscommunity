package com.lxx.app.common.util.http.provider;


import com.lxx.app.common.util.http.base.HttpRequest;
import com.lxx.app.common.util.http.base.HttpResponse;

/**
 * @author zhenwei.liu
 * @since 2016-07-18
 */
public interface ClientProvider<Client, Request, Response, R extends HttpResponse> {

    Client getClient();

    Request createRequest(HttpRequest source);

    R createResponse(Response source);
}
