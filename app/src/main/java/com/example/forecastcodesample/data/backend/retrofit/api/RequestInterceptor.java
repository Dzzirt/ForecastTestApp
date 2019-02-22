package com.example.forecastcodesample.data.backend.retrofit.api;

import com.example.forecastcodesample.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {
    private static final String API_KEY = "apikey";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl urlWithApiKey = request.url().newBuilder().addQueryParameter(API_KEY, BuildConfig.API_KEY).build();
        Request updatedRequest = request.newBuilder()
                .url(urlWithApiKey)
                .build();

        return chain.proceed(updatedRequest);
    }
}
