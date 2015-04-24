package com.omnilabsinc.localsellers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.omnilabsinc.localsellers.R;

/**
 * Created by ocx on 4/24/15.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView)itemView.findViewById(R.id.item_image);
    }

    public ImageView getImageView() {
        return imageView;
    }
}
