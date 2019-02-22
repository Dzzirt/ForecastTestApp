package com.example.forecastcodesample.data.backend.model.openweather_model;

import com.google.gson.annotations.SerializedName;

public class OWWeatherDescription {
    private static final String ICON_FORMAT = ".png";
    private static String ICON_URL = "http://openweathermap.org/img/w/";

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String iconName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getIconUrl() {
        return ICON_URL + iconName + ICON_FORMAT;
    }
}
