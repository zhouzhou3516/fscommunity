package com.fscommunity.platform.provider.backoffice.adapter;

import com.fscommunity.platform.persist.pojo.ConsultListeningInfo;
import com.fscommunity.platform.provider.backoffice.vo.MgrConsultListeningVo;
import com.google.common.base.Splitter;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;

/**
 * @author liqingzhou on 18/5/1
 */
public class MgrConsultListeningVoAdapter {

    private static Splitter imgSplitter = Splitter.on(",").omitEmptyStrings();

    public static MgrConsultListeningVo adaptToVo(ConsultListeningInfo info) {
        MgrConsultListeningVo vo = new MgrConsultListeningVo();
        vo.setChannelType(info.getChannelType());
        vo.setConsultType(info.getConsultType());
        vo.setContent(info.getContent());
        vo.setReplyContent(info.getReplyContent());
        vo.setVoiceUrl(info.getVoiceUrl());
        vo.setVideoUrl(info.getVideoUrl());
        if (StringUtils.isNotBlank(info.getImgUrls())) {
            vo.setImgUrls(imgSplitter.splitToList(info.getImgUrls()));
        }
        return vo;
    }

    public static List<MgrConsultListeningVo> adaptToVos(List<ConsultListeningInfo> infos) {
        return infos.stream().map(MgrConsultListeningVoAdapter::adaptToVo).collect(Collectors.toList());
    }

}
