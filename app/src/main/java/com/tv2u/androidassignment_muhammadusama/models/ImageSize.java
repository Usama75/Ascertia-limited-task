package com.tv2u.androidassignment_muhammadusama.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageSize {

    @SerializedName("translated_height")
    @Expose
    private Integer translatedHeight;
    @SerializedName("translated_width")
    @Expose
    private Integer translatedWidth;

    public Integer getTranslatedHeight() {
        return translatedHeight;
    }

    public void setTranslatedHeight(Integer translatedHeight) {
        this.translatedHeight = translatedHeight;
    }

    public Integer getTranslatedWidth() {
        return translatedWidth;
    }

    public void setTranslatedWidth(Integer translatedWidth) {
        this.translatedWidth = translatedWidth;
    }
}
