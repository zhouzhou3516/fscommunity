package com.fscommunity.platform.provider.backoffice.vo;

import com.google.common.collect.Lists;
import com.lxx.app.common.util.pojo.Bean;
import java.util.List;

/**
 * @author liqingzhou on 18/4/29.
 */
public class MgrCategoryProjectListVo extends Bean {

    private int count;
    private List<MgrCategoryProjectItemVo> items = Lists.newArrayList();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MgrCategoryProjectItemVo> getItems() {
        return items;
    }

    public void setItems(List<MgrCategoryProjectItemVo> items) {
        this.items = items;
    }
}
