package com.example.forecastcodesample.data.backend.retrofit.api;

import com.example.forecastcodesample.data.backend.model.openweather_model.OWCurrentWeatherData;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherApi {
    @GET("weather")
    Observable<OWCurrentWeatherData> getCurrentWeather(@Query("q") String cityName, @Query("units") String units);

}
