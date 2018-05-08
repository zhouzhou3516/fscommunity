package com.fscommunity.platform.provider.wechat.req;

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
    private String targetId;
    /**
     * 所属栏目
     */
    private String channelType;
    /**
     * 咨询类型
     */
    private String consultType;

    /**
     * 咨询内容
     */
    private String content;

    /**
     * 语音留言
     */
    private String voiceUrl;
    /**
     * 上传图片,最多三个
     */
    private List<String> imgUrls = Lists.newArrayList();
    /**
     * 视频
     */
    private String videoUrl;

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getConsultType() {
        return consultType;
    }

    public void setConsultType(String consultType) {
        this.consultType = consultType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
