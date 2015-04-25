package com.omnilabsinc.localsellers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.omnilabsinc.localsellers.models.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ocx on 4/24/15.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private static final String TAG = "ItemAdapter";
    private List<Item> items = new ArrayList<>();
    private Context context;
    private int convertedSize;

    public ItemAdapter(List<Item> items, Context context){
        this.items = items;
        this.context = context;
        convertedSize = context.getResources().getDimensionPixelSize(R.dimen.image_size);
        if(context == null){
            Log.e(TAG, "Context is null" + items.get(0).getUserId());
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_layout, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = items.get(position);
        ImageView imageView = holder.getImageView();
        if(imageView == null){
            Log.e(TAG, "ImageView is null");
        }


        String imageUrl = context.getResources().getString(R.string.image_url, item.getId(),
                convertedSize);

        Picasso.with(context).load(imageUrl)
                .error(R.drawable.placeholder)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
