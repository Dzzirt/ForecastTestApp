package com.example.forecastcodesample.data.backend.model.openweather_model;

import com.google.gson.annotations.SerializedName;

public class OWSunInfo {

    private static final int SECOND_IN_MILLIS = 1000;

    @SerializedName("sunrise")
    private long sunriseTimestamp;

    @SerializedName("sunset")
    private long sunsetTimestamp;

    public long getSunriseTimestamp() {
        return sunriseTimestamp * SECOND_IN_MILLIS;
    }

    public long getSunsetTimestamp() {
        return sunsetTimestamp * SECOND_IN_MILLIS;
    }
}
