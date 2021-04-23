package com.tv2u.androidassignment_muhammadusama.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.tv2u.androidassignment_muhammadusama.repositories.ImageDimensionRepository;
import com.tv2u.androidassignment_muhammadusama.models.ImageSize;

import org.jetbrains.annotations.NotNull;

public class ImageSizeViewModel extends AndroidViewModel {

    private MutableLiveData<ImageSize> Response;

    private ImageDimensionRepository imageDimensionRepository;

    public ImageSizeViewModel(@NotNull Application application) {
        super(application);
        imageDimensionRepository = new ImageDimensionRepository(application);
        Response = new MutableLiveData<>();
    }

    public MutableLiveData<ImageSize> getImagedimension() {
        //setIsLoading(isLoading);
        imageDimensionRepository.getImagedimensions(Response);
        return getConfigResponse();
    }

    public MutableLiveData<ImageSize> getConfigResponse() {
        return Response;
    }

}
