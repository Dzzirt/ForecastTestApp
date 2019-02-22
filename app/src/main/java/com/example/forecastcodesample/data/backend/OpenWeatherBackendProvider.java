package com.example.forecastcodesample.data.backend;

import com.example.forecastcodesample.data.backend.model.CurrentWeatherData;
import com.example.forecastcodesample.data.backend.retrofit.api.OpenWeatherApi;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;

public class OpenWeatherBackendProvider implements BackendProvider {

    private static int RETRY_INTERVAL_IN_SECONDS = 60;

    private OpenWeatherApi api;

    public OpenWeatherBackendProvider(OpenWeatherApi api) {
        this.api = api;
    }

    @Override
    public Observable<? extends CurrentWeatherData> getCurrentWeatherData(String cityName, String units) {
        return Observable
                .interval(0, RETRY_INTERVAL_IN_SECONDS, TimeUnit.SECONDS)
                .flatMap(count -> api.getCurrentWeather(cityName, units));
    }
}
