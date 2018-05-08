package com.fscommunity.platform.provider.wechat.vo;

import com.google.common.collect.Lists;
import com.lxx.app.common.util.pojo.Bean;
import java.util.List;

/**
 * @author liqingzhou on 18/5/3
 */
public class BaseContentDetailVo extends Bean {

    private int articleId;
    private String title;
    private String content;
    private List<WxCommentVo> comments = Lists.newArrayList();

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<WxCommentVo> getComments() {
        return comments;
    }

    public void setComments(List<WxCommentVo> comments) {
        this.comments = comments;
    }
}
