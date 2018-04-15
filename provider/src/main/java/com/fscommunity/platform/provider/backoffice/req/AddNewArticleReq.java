package com.fscommunity.platform.provider.backoffice.req;

import com.fscommunity.platform.common.constant.ArticleType;

/**
 * @author chao.zhu
 * @version 2018-04-14
 */
public class AddNewArticleReq {
    private String name;
    private ArticleType type;
    private String content;
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
