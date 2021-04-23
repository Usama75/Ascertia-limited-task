package com.tv2u.androidassignment_muhammadusama.networking;

import com.tv2u.androidassignment_muhammadusama.models.ImageSize;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("b/R7A1")
    Call<ImageSize> getImagedimension();

}
