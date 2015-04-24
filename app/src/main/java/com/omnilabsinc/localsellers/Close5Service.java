package com.omnilabsinc.localsellers;

import com.omnilabsinc.localsellers.models.MetaResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by ocx on 4/21/15.
 */
public interface Close5Service {

    @GET("/users/items/grouped?maxDistance=50&lat=37.320352&lon=-121.9045411")
    public void getMetaCallback(@Query("limit") int limit, @Query("skip") int skip,
                                Callback<MetaResponse> cmr);
}
