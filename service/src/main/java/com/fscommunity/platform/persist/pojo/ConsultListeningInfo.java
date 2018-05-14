package com.fscommunity.platform.persist.pojo;

import com.lxx.app.common.util.pojo.Bean;
import java.util.Date;

/**
 * 你说我听
 *
 * @author liqingzhou on 18/5/1
 */
public class ConsultListeningInfo extends Bean {

    /**
     * id
     */
    private int id;
    /**
     * 所属栏目
     */
    private ChannelType channelType;
    /**
     * 所属栏目的目标id
     */
    private int targetId;
    /**
     * 咨询类型
     */
    private ConsultType consultType;

    /**
     * 咨询内容
     */
    private String content;
    /**
     * 回复人useris
     */
    private int replyUserId;
    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 语音留言
     */
    private String voiceUrl;
    /**
     * 上传图片,最多三个
     */
    private String imgUrls;
    /**
     * 视频
     */
    private String videoUrl;

    private Date createTime;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getVoiceUrl() {
        return voiceUrl;
    }

    public void setVoiceUrl(String voiceUrl) {
        this.voiceUrl = voiceUrl;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(int replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public ConsultType getConsultType() {
        return consultType;
    }

    public void setConsultType(ConsultType consultType) {
        this.consultType = consultType;
    }
}
