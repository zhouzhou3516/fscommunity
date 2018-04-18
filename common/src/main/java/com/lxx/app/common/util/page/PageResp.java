package com.lxx.app.common.util.page;

import java.util.List;

/**
 * @Description 分页结果的封装(for Bootstrap Table)
 * @Author jing.c
 * @Date: 18-4-4
 */
public class PageResp <T>{

    // 结果集
    private List<T> rows;

    // 总数
    private long totalCount;

    public PageResp(List<T> rows,long totalCount) {
        this.rows = rows;
        this.totalCount = totalCount;
    }

    public PageResp() {
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long total) {
        this.totalCount = total;
    }

}
