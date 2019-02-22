package com.example.forecastcodesample.data.backend.model;

public interface CurrentWeatherData {

    String getCityName();

    String getDescription();

    String getIconUrl();

    int getTemperature();

    float getPressure();

    int getHumidity();

    int getVisibility();

    int getWindSpeed();

    int getWindDegree();

    long getSunriseTimestamp();

    long getSunsetTimestamp();

}
