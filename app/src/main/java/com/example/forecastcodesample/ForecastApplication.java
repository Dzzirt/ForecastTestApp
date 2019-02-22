package com.example.forecastcodesample;

import android.app.Application;

import com.example.forecastcodesample.data.di.AppComponent;
import com.example.forecastcodesample.data.di.DaggerAppComponent;

public class ForecastApplication extends Application {

    private static final AppComponent appComponent = DaggerAppComponent.create();

    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
