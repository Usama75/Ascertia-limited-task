package com.tv2u.androidassignment_muhammadusama.ui;

import android.graphics.Point;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.gson.Gson;
import com.tv2u.androidassignment_muhammadusama.R;
import com.tv2u.androidassignment_muhammadusama.models.ImageSize;
import com.tv2u.androidassignment_muhammadusama.utilities.SharedHelper;
import com.tv2u.androidassignment_muhammadusama.viewmodels.ImageSizeViewModel;

import static com.tv2u.androidassignment_muhammadusama.utilities.Constants.DIMENSION_VALUES;


public class MainActivity extends AppCompatActivity {
    private ImageSizeViewModel mViewModel;
    private PhotoView imageView;
    double ht_px, wt_px;
    int width;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);
        imageView.setImageResource(R.drawable.image);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        ImageSize imageSize = SharedHelper.getdata(MainActivity.this);
        if (imageSize == null) {
            /*if local data not available call api to define image size*/
            mViewModel = ViewModelProviders.of(this).get(ImageSizeViewModel.class);
            mViewModel.getImagedimension().observe(this, new ImageObserver());
        } else {
            /*check local data and use that data to define image size*/
            setImagedemensions();
        }


    }

    private class ImageObserver implements Observer<ImageSize> {


        @Override
        public void onChanged(@Nullable ImageSize imageSize) {
            if (imageSize == null) {
                return;
            }
            /*save data*/
            Gson gson = new Gson();
            String dimensionJson = gson.toJson(imageSize);
            SharedHelper.savedata(MainActivity.this, DIMENSION_VALUES, dimensionJson);
            setImagedemensions();

        }
    }

    private void setImagedemensions() {
        ImageSize imageSize = SharedHelper.getdata(MainActivity.this);
        ht_px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, imageSize.getTranslatedHeight(), getResources().getDisplayMetrics());
        wt_px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, getResources().getDisplayMetrics());
        /*For width and height from px to dp*/
        imageView.setLayoutParams(new NestedScrollView.LayoutParams((int) wt_px, (int) ht_px));
    }


}