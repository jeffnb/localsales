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

    public ItemAdapter(List<Item> items, Context context){
        this.items = items;
        this.context = context;
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
        Log.e(TAG, "TESTING");
        ImageView imageView = holder.getImageView();
        if(imageView == null){
            Log.e(TAG, "ImageView is null");
        }

        Picasso.with(context).load("https://images.close5.com/v1/items/547d54c64c7817160900000e/image?number=0&width=100&height=100")
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
