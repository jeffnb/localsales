package com.omnilabsinc.localsellers;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.omnilabsinc.localsellers.models.MetaResponse;
import com.omnilabsinc.localsellers.models.Seller;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity implements Callback<MetaResponse>{
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private SellerRecyclerAdapter adapter;
    private LinearLayoutManager layoutManager;
    private static final int DATA_RETURN_LIMIT = 20;
    private static final int LOAD_MORE_THRESHOLD = 10;
    private Location lastKnownLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        //Get a quick fix for location
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        //Get list
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.close5.com")
                .build();
        final Close5Service close5Service = restAdapter.create(Close5Service.class);
        close5Service.getMetaCallback(DATA_RETURN_LIMIT, 0, lastKnownLocation.getLatitude(),
                lastKnownLocation.getLongitude(), this);

        mRecyclerView.setOnScrollListener(
                new EndlessSellerScrollListener(layoutManager, LOAD_MORE_THRESHOLD) {
            @Override
            public void onLoadMore(int skipStart) {
                close5Service.getMetaCallback(DATA_RETURN_LIMIT, skipStart,
                        lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(),
                        MainActivity.this);
            }
        });

    }

    @Override
    public void success(MetaResponse metaResponse, Response response) {
        List<Seller> sellers = metaResponse.getRows();

        if(sellers.size() > 0) {

            if(this.adapter == null) {
                this.adapter = new SellerRecyclerAdapter(this, sellers);
                mRecyclerView.setAdapter(adapter);
            }
            else{
                adapter.addSellers(sellers);
            }
        }

    }

    @Override
    public void failure(RetrofitError error) {
        Log.e(TAG, "Error loading data" + error.toString());
    }
}
