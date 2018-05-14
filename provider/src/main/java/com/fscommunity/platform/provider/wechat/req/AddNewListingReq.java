package com.fscommunity.platform.provider.wechat.req;

import com.fscommunity.platform.persist.pojo.ChannelType;
import com.fscommunity.platform.persist.pojo.ConsultType;
import com.google.common.collect.Lists;
import com.lxx.app.common.util.pojo.Bean;
import java.util.List;

/**
 * @author liqingzhou on 18/5/8
 */
public class AddNewListingReq extends Bean {

    /**
     * 所属栏目的目标id
     */
    private int targetId;
    /**
     * 所属栏目
     */
    private ChannelType channelType;
    /**
     * 咨询类型
     */
    private ConsultType consultType;

    /**
     * 咨询内容
     */
    private String content;

    /**
     * 微信语音mediaId
     */
    private String voiceWxMediaId;

    /**
     * 上传图片,最多三个
     */
    private List<String> imgUrls = Lists.newArrayList();
    /**
     * 视频
     */
    private String videoOssObjectName;

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVoiceWxMediaId() {
        return voiceWxMediaId;
    }

    public void setVoiceWxMediaId(String voiceWxMediaId) {
        this.voiceWxMediaId = voiceWxMediaId;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getVideoOssObjectName() {
        return videoOssObjectName;
    }

    public void setVideoOssObjectName(String videoOssObjectName) {
        this.videoOssObjectName = videoOssObjectName;
    }

    public ConsultType getConsultType() {
        return consultType;
    }

    public void setConsultType(ConsultType consultType) {
        this.consultType = consultType;
    }


}
