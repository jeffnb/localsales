package com.omnilabsinc.localsellers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ocx on 4/22/15.
 */
public class SellerViewHolder extends RecyclerView.ViewHolder {

    private TextView sellerName;
    private TextView itemCount;
    private RecyclerView recyclerView;

    public SellerViewHolder(View view){
        super(view);
        sellerName = (TextView)view.findViewById(R.id.seller_name);
        itemCount = (TextView)view.findViewById(R.id.item_count);
        recyclerView = (RecyclerView)view.findViewById(R.id.image_view);
    }

    public TextView getSellerName() {
        return sellerName;
    }

    public TextView getItemCount() {
        return itemCount;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
