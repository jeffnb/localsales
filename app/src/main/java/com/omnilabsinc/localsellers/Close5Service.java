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

    /**
     * This calls out to get the list of sellers and items.
     * NOTE: The multiple parameters were chosen instead of the map to keep the parameters clear
     * and localized instead of breaking the encapsulation
     * @param limit
     * @param skip
     * @param lat
     * @param lon
     * @param cmr
     */
    @GET("/users/items/grouped?maxDistance=50")
    public void getMetaCallback(@Query("limit") int limit, @Query("skip") int skip,
                                @Query("lat") double lat, @Query("lon") double lon,
                                Callback<MetaResponse> cmr);
}
