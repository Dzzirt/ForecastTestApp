package com.example.forecastcodesample.data.di;

import com.arellomobile.mvp.MvpPresenter;
import com.example.forecastcodesample.mvp.forecast.ForecastActivity;
import com.example.forecastcodesample.mvp.forecast.ForecastPresenter;
import com.example.forecastcodesample.mvp.forecast.ForecastView;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        RetrofitModule.class,
        BackendModule.class})
public interface AppComponent {
    void inject(ForecastPresenter forecastPresenter);
}
