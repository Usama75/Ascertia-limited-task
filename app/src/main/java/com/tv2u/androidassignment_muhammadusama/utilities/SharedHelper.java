package com.tv2u.androidassignment_muhammadusama.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.tv2u.androidassignment_muhammadusama.models.ImageSize;

public class SharedHelper {
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static void savedata(Context context, String Key, String Value) {
        sharedPreferences = context.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString(Key, Value);
        editor.commit();

    }
    public static ImageSize getdata(Context context) {
        Gson gson = new Gson();
        sharedPreferences = context.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        String dimensionJSON = sharedPreferences.getString(Constants.DIMENSION_VALUES, "");
        ImageSize imageSize = gson.fromJson(dimensionJSON, ImageSize.class);
        return imageSize;

    }
}
