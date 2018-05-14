package com.fscommunity.platform.provider.wechat.voadaptor;

import com.fscommunity.platform.persist.pojo.ConsultListeningInfo;
import com.fscommunity.platform.provider.wechat.req.AddNewListingReq;
import com.google.common.base.Joiner;

/**
 * @author liqingzhou on 18/5/8
 */
public class ConsultListeningVoAdapt {

    private static final Joiner COMM_JOINER  = Joiner.on(",");

    public static ConsultListeningInfo adapt(AddNewListingReq req, String voiceUrl, String videoUrl) {
        ConsultListeningInfo info = new ConsultListeningInfo();
        info.setTargetId(req.getTargetId());
        info.setChannelType(req.getChannelType());
        info.setConsultType(req.getConsultType());
        info.setContent(req.getContent());
        info.setReplyContent("");
        info.setVoiceUrl(voiceUrl);
        String join = COMM_JOINER.join(req.getImgUrls());
        info.setImgUrls(join);
        info.setVideoUrl(videoUrl);
        return info;
    }
}
