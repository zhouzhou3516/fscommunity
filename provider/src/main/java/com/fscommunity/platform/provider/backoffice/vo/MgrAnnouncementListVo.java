package com.fscommunity.platform.provider.backoffice.vo;

import com.google.common.collect.Lists;
import com.lxx.app.common.util.pojo.Bean;
import java.util.List;

/**
 * @author liqingzhou on 18/4/29.
 */
public class MgrAnnouncementListVo extends Bean {

    private int count;
    private List<MgrAnnouncementItemVo> items = Lists.newArrayList();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MgrAnnouncementItemVo> getItems() {
        return items;
    }

    public void setItems(List<MgrAnnouncementItemVo> items) {
        this.items = items;
    }
}
