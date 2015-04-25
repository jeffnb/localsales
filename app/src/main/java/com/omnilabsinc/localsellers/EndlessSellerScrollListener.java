package com.omnilabsinc.localsellers;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ocx on 4/25/15.
 */
public abstract class EndlessSellerScrollListener extends RecyclerView.OnScrollListener{
    public static String TAG = EndlessSellerScrollListener.class.getSimpleName();

    private int previousTotal = 0;
    private boolean loading = true;
    private int visibleThreshold = 10;
    private int firstVisibleItem;
    private int visibleItemCount;
    private int totalItemCount;
    private LinearLayoutManager linearLayoutManager;

    public EndlessSellerScrollListener(LinearLayoutManager linearLayoutManager, int visibleThreshold) {
        this.linearLayoutManager = linearLayoutManager;
        this.visibleThreshold = visibleThreshold;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = linearLayoutManager.getItemCount();
        firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

        //If the system is loading check to see if more items are in the layoutmanager
        if(loading){
            if(totalItemCount > previousTotal){
                loading = false;
                previousTotal = totalItemCount;
            }
        }

        if(!loading && (totalItemCount - visibleItemCount) < (firstVisibleItem + visibleThreshold)){
            loading = true;
            onLoadMore(totalItemCount);
        }

    }

    // Defines the process for actually loading more data based on page
    public abstract void onLoadMore(int skipStart);

}
