package com.fscommunity.platform.provider.wechat.vo;

import com.google.common.collect.Lists;
import com.lxx.app.common.util.pojo.Bean;
import java.util.List;

/**
 * @author liqingzhou on 18/5/3
 */
public class BaseListVo extends Bean {

    private int count;
    private List<BaseListItemVo> items = Lists.newArrayList();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<BaseListItemVo> getItems() {
        return items;
    }

    public void setItems(List<BaseListItemVo> items) {
        this.items = items;
    }
}
