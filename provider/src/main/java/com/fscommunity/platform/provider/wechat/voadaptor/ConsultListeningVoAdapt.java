package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.ConsultListeningInfo;
import com.fscommunity.platform.provider.wechat.req.AddNewListingReq;
import com.lxx.app.common.util.json.JsonUtil;

/**
 * @author liqingzhou on 18/5/8
 */
public class ConsultListeningVoAdapt {


    public static ConsultListeningInfo adapt(AddNewListingReq req) {
        ConsultListeningInfo info = new ConsultListeningInfo();
        info.setTargetId(req.getTargetId());
        info.setChannelType(req.getChannelType());
        info.setConsultType(req.getConsultType());
        info.setContent(req.getContent());
        info.setReplyContent("");
        info.setVoiceUrl(req.getVoiceUrl());
        info.setImgUrls(JsonUtil.of(req.getImgUrls()));
        info.setVideoUrl(req.getVideoUrl());
        return info;
    }
}
