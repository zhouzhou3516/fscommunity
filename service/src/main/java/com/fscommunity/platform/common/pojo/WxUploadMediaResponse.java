package com.fscommunity.platform.common.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/5/12
 */
public class WxUploadMediaResponse extends Bean {

    private String type;
    @JsonProperty("media_id")
    private String mediaId;
    @JsonProperty("created_at")
    private String createdAt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}