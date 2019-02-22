package com.example.forecastcodesample.data.backend.model.openweather_model;

import com.example.forecastcodesample.data.backend.model.CurrentWeatherData;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OWCurrentWeatherData implements CurrentWeatherData {

    @SerializedName("name")
    private String cityName;

    @SerializedName("weather")
    private List<OWWeatherDescription> weatherDescriptions;

    @SerializedName("main")
    private OWWeatherInfo weatherInfo;

    @SerializedName("visibility")
    private int visibility;

    @SerializedName("wind")
    private OWWindInfo windInfo;

    @SerializedName("sys")
    private OWSunInfo sunInfo;


    @Override
    public String getCityName() {
        return cityName;
    }

    @Override
    public String getDescription() {
        if (weatherDescriptions == null || weatherDescriptions.isEmpty()) {
            return null;
        }
        return weatherDescriptions.get(0).getDescription();
    }

    @Override
    public String getIconUrl() {
        if (weatherDescriptions == null || weatherDescriptions.isEmpty()) {
            return null;
        }
        return weatherDescriptions.get(0).getIconUrl();
    }

    @Override
    public int getTemperature() {
        return (int) weatherInfo.getTemperature();
    }

    @Override
    public float getPressure() {
        return weatherInfo.getPressure();
    }

    @Override
    public int getHumidity() {
        return (int) weatherInfo.getHumidity();
    }

    @Override
    public int getVisibility() {
        return visibility;
    }

    @Override
    public int getWindSpeed() {
        return (int) windInfo.getSpeed();
    }

    @Override
    public int getWindDegree() {
        return (int) windInfo.getDegree();
    }

    @Override
    public long getSunriseTimestamp() {
        return sunInfo.getSunriseTimestamp();
    }

    @Override
    public long getSunsetTimestamp() {
        return sunInfo.getSunsetTimestamp();
    }
}
