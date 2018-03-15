package com.lxx.app.common.util.http.base;

import java.io.IOException;

public interface HttpResponse extends HttpMessage {

    StatusLine getStatusLine();

    String getBodyAsString() throws IOException;

    byte[] getBodyAsBytes() throws IOException;
}
