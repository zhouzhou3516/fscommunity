package com.fscommunity.platform.provider.wechat.vo;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author liqingzhou on 18/5/2
 */
public class CommunityNewsListVo {

    private List<CommunityNewsVo> list = Lists.newArrayList();

    public List<CommunityNewsVo> getList() {
        return list;
    }

    public void setList(List<CommunityNewsVo> list) {
        this.list = list;
    }
}
