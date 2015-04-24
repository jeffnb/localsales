package com.omnilabsinc.localsellers;

import android.support.v7.widget.RecyclerView;

/**
 * Created by ocx on 4/23/15.
 */
public class SellerScrollListener extends RecyclerView.OnScrollListener {

    private Close5Service service;

    public SellerScrollListener(Close5Service service) {
        super();
        this.service = service;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
    }

}
