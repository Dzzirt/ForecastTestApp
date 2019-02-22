package com.example.forecastcodesample.data.di;

import com.example.forecastcodesample.data.backend.BackendProvider;
import com.example.forecastcodesample.data.backend.OpenWeatherBackendProvider;
import com.example.forecastcodesample.data.backend.retrofit.api.OpenWeatherApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BackendModule {
    @Singleton
    @Provides
    BackendProvider getBackendProvider(OpenWeatherApi openWeatherApi) {
        return new OpenWeatherBackendProvider(openWeatherApi);
    }
}
