package com.example.recycelview;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {
    @GET("continents")
    Call<ArrayDataItem> getData(@Query("api_token")String token);
}
