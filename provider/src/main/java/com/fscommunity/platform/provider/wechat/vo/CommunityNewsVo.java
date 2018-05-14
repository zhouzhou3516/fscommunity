package com.fscommunity.platform.provider.wechat.vo;

import com.lxx.app.common.util.pojo.Bean;
import java.util.Date;

/**
 * @author liqingzhou on 18/5/2
 */
public class CommunityNewsVo extends Bean {

    private int communityNewsId;
    private int articleId;
    private String type;
    private String title;
    private String shortContent;
    private String coverUrl;
    private Date publishTime;
    private int viewCount;
    private int replyCount;

    public int getCommunityNewsId() {
        return communityNewsId;
    }

    public void setCommunityNewsId(int communityNewsId) {
        this.communityNewsId = communityNewsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
