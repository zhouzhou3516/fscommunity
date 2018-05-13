package com.fscommunity.platform.provider.wechat.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-05-12
 */
public class LabelVo {
    private String text;
    private String value;
    private List<LabelVo> subLabels = new ArrayList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<LabelVo> getSubLabels() {
        return subLabels;
    }

    public void setSubLabels(List<LabelVo> subLabels) {
        this.subLabels = subLabels;
    }
}
