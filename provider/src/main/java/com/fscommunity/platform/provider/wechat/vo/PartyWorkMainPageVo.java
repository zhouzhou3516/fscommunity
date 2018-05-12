package com.fscommunity.platform.provider.wechat.vo;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chao.zhu
 * @version 2018-05-12
 */
public class PartyWorkMainPageVo {

    /**
     * 办事指南
     */
    public List<String> guides = new ArrayList<>();

    /**
     * 热点追踪
     */
    private List<BaseListItemVo> hotspots = Lists.newArrayList();

    public List<String> getGuides() {
        return guides;
    }

    public void setGuides(List<String> guides) {
        this.guides = guides;
    }

    public List<BaseListItemVo> getHotspots() {
        return hotspots;
    }

    public void setHotspots(List<BaseListItemVo> hotspots) {
        this.hotspots = hotspots;
    }
}
