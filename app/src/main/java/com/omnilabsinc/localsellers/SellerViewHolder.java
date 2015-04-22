package com.omnilabsinc.localsellers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ocx on 4/22/15.
 */
public class SellerViewHolder extends RecyclerView.ViewHolder {

    protected TextView sellerName;
    protected TextView itemCount;
    protected ImageView firstItemPicture;

    public SellerViewHolder(View view){
        super(view);
        sellerName = (TextView)view.findViewById(R.id.seller_name);
        itemCount = (TextView)view.findViewById(R.id.item_count);
        firstItemPicture = (ImageView)view.findViewById(R.id.fistItemImage);
    }
}
