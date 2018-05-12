package com.fscommunity.platform.provider.wechat.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-05-12
 */
public class LabelVo {
    private String label;
    private String value;
    private List<LabelVo> subLabels = new ArrayList<>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
