package com.example.forecastcodesample.util;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageUtils {

    public static void loadFromUrl(String url, ImageView imageView) {
        Picasso.get().load(url)
                .into(imageView);
    }
}
