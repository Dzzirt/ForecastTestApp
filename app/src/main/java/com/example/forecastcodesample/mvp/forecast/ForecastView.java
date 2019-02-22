package com.example.forecastcodesample.mvp.forecast;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.forecastcodesample.data.backend.model.CurrentWeatherData;
import com.example.forecastcodesample.mvp.base.BaseView;

public interface ForecastView extends BaseView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showForecast(CurrentWeatherData weatherData);
}
