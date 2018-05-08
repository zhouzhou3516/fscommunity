package com.fscommunity.platform.provider.wechat.vo;

/**
 * @author liqingzhou on 18/5/6.
 */
public class WxCommentReplyVo extends WxCommentVo {

    private int targetCId;

    public int getTargetCId() {
        return targetCId;
    }

    public void setTargetCId(int targetCId) {
        this.targetCId = targetCId;
    }
}

