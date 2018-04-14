package com.fscommunity.platform.provider.backoffice.req;

import com.fscommunity.platform.common.constant.ArticleType;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public class UpdateArticleReq {
    private int id;
    private ArticleType type;
    private String content;
    private String articleName;

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArticleType getType() {
        return type;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
