package com.lxx.app.common.util.cache;

public interface CachedStreamEntity {
    CachedStream getCachedStream();
    void flushStream();
}
