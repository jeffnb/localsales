package com.omnilabsinc.localsellers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omnilabsinc.localsellers.models.Seller;

import java.util.List;

/**
 * Created by ocx on 4/22/15.
 */
public class SellerRecyclerAdapter extends RecyclerView.Adapter<SellerViewHolder> {
    private List<Seller> sellers;
    private Context context;

    public SellerRecyclerAdapter(Context context, List<Seller> sellers){
        this.sellers = sellers;
        this.context = context;
    }

    @Override
    public SellerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, null);
        return new SellerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SellerViewHolder holder, int position) {
        Seller seller = sellers.get(position);
        holder.getSellerName().setText(seller.getName());
        holder.getItemCount().setText(String.valueOf(seller.getNumberOfItems()) + " items");

        RecyclerView recyclerView = holder.getRecyclerView();
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new ItemAdapter(seller.getItems(), context));

    }

    @Override
    public int getItemCount() {
        return sellers != null ? sellers.size() : 0;
    }
}
