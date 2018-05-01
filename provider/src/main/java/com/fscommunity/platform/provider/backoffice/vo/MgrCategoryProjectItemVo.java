package com.fscommunity.platform.provider.backoffice.vo;

import com.lxx.app.common.util.pojo.Bean;

/**
 * @author liqingzhou on 18/4/29
 */
public class MgrCategoryProjectItemVo extends Bean {

    private int id;
    private String type;
    private int articleId;
    private String articleName;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
