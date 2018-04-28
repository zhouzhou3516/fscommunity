package com.fscommunity.platform.provider.wechat.req;

/**
 * @author liqingzhou on 18/4/28
 */
public class AddVoiceRequest {

    private String mediaId;
    private String type;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
