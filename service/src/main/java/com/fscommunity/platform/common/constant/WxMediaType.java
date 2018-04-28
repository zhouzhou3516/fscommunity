package com.fscommunity.platform.common.constant;

/**
 * @author liqingzhou on 18/4/28
 */
public enum WxMediaType {
    IMAGE("image", "png"),
    VOICE("voice", "mp3"),
    VIDEO("video", "mp4"),
    THUMB("thumb", "png");
    private String type;
    private String extName;

    WxMediaType(String type, String extName) {
        this.type = type;
        this.extName = extName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }
}
