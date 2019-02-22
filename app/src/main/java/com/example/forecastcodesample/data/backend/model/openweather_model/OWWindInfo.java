package com.example.forecastcodesample.data.backend.model.openweather_model;

import com.google.gson.annotations.SerializedName;

public class OWWindInfo {
    @SerializedName("speed")
    private float speed;

    @SerializedName("deg")
    private float degree;

    public float getSpeed() {
        return speed;
    }

    public float getDegree() {
        return degree;
    }
}
