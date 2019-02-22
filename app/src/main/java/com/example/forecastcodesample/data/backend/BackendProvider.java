package com.example.forecastcodesample.data.backend;

import com.example.forecastcodesample.data.backend.model.CurrentWeatherData;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface BackendProvider {

    interface WeatherUnits {
        String FAHRENHEIT = "imperial";
        String CELSIUS = "metric";
        String KELVIN = "default";
    }

    Observable<? extends CurrentWeatherData> getCurrentWeatherData(String cityName, String units);
}
