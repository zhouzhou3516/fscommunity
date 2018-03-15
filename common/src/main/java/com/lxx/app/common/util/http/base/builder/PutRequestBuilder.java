package com.lxx.app.common.util.http.base.builder;

import com.lxx.app.common.util.http.base.HttpEntity;
import com.lxx.app.common.util.http.base.PutRequest;
import java.net.URI;

/**
 * @author zhenwei.liu
 * @since 2016-12-20
 */
public class PutRequestBuilder extends EntityRequestBuilder<PutRequest, PutRequestBuilder> {

    protected PutRequestBuilder() {
        super(PutRequestBuilder.class);
    }

    @Override
    PutRequest buildEntityRequest(URI uri, HttpEntity entity) {
        return new PutRequest(uri, entity);
    }
}
