package com.omnilabsinc.localsellers;

import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.omnilabsinc.localsellers.models.MetaResponse;
import com.omnilabsinc.localsellers.models.Seller;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;


public class MainActivity extends Activity implements Callback<MetaResponse>{

    private RecyclerView mRecyclerView;
    private SellerRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        //Get list
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.close5.com")
                .build();
        Close5Service close5Service = restAdapter.create(Close5Service.class);
        close5Service.getMetaCallback(5, 0, this);

    }

    @Override
    public void success(MetaResponse metaResponse, Response response) {
        List<Seller> sellers = metaResponse.getRows();

        if(sellers.size() > 0) {
            this.adapter = new SellerRecyclerAdapter(this, sellers);
            mRecyclerView.setAdapter(adapter);
        }

    }

    @Override
    public void failure(RetrofitError error) {
        RetrofitError err = error;

        String foo = "bar";
    }
}
