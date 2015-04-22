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

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;


public class MainActivity extends Activity implements Callback<MetaResponse>{

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        //Get list test for serialization
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.close5.com")
                .build();

        Close5Service close5Service = restAdapter.create(Close5Service.class);


       //MetaResponse mr = close5Service.getList();
        close5Service.getMetaCallback(this);

        String foo = "bar";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void success(MetaResponse metaResponse, Response response) {
        MetaResponse mr = metaResponse;

        String foo = "bar";
    }

    @Override
    public void failure(RetrofitError error) {
        RetrofitError err = error;

        String foo = "bar";
    }
}
