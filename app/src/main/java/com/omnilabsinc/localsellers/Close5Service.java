package com.omnilabsinc.localsellers;

import com.omnilabsinc.localsellers.models.MetaResponse;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ocx on 4/21/15.
 */
public interface Close5Service {
    @GET("/users/items/grouped?maxDistance=50&lat=37.320352&lon=-121.9045411&limit=2&skip=0")
    public MetaResponse getList();

    @GET("/users/items/grouped?maxDistance=50&lat=37.320352&lon=-121.9045411&limit=2&skip=0")
    public void getMetaCallback(Callback<MetaResponse> cmr);

    @GET("/users/items/grouped?maxDistance=50&lat=37.320352&lon=-121.9045411&limit=2&skip=0")
    public String getFull();
}
