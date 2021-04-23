package com.tv2u.androidassignment_muhammadusama.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.tv2u.androidassignment_muhammadusama.models.ImageSize;
import com.tv2u.androidassignment_muhammadusama.networking.ApiInterface;
import com.tv2u.androidassignment_muhammadusama.networking.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageDimensionRepository {
    private ApiInterface apiInterface;

    public ImageDimensionRepository(Application application) {
        this.apiInterface = RestClient.getInstance(application).getApiService();
    }


    public void getImagedimensions(final MutableLiveData<ImageSize> configResponse) {
        Call<ImageSize> configModelCall = apiInterface.getImagedimension();
        configModelCall.enqueue(new Callback<ImageSize>() {
            @Override
            public void onResponse(Call<ImageSize> call, Response<ImageSize> response) {
                if (response != null && response.isSuccessful()) {
                    configResponse.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<ImageSize> call, Throwable t) {
                Log.d("apilog", t.getMessage() + " " + this.getClass().getName());

            }
        });
    }
}
