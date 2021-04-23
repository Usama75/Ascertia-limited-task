package com.tv2u.androidassignment_muhammadusama.networking;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static RestClient instance = null;
    private ApiInterface apiInterface;

    public static String BASE_URL = "https://jsonkeeper.com/";

    public RestClient(final Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .excludeFieldsWithModifiers(Modifier.TRANSIENT)
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RestClient getInstance(Context context) {
        instance = new RestClient(context);
        return instance;
    }

    public ApiInterface getApiService() {
        return apiInterface;
    }


}
