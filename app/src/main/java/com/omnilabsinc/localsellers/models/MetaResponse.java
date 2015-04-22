package com.omnilabsinc.localsellers.models;

import java.util.List;

/**
 * Created by ocx on 4/21/15.
 */
public class MetaResponse {

    private Boolean hasMore;
    private Integer total;
    private Integer count;
    private List<Seller> rows;

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Seller> getRows() {
        return rows;
    }

    public void setRows(List<Seller> rows) {
        this.rows = rows;
    }
}
