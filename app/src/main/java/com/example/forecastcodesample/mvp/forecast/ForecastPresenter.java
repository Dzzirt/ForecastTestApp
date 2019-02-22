package com.example.forecastcodesample.mvp.forecast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.forecastcodesample.ForecastApplication;
import com.example.forecastcodesample.data.backend.BackendProvider;
import com.example.forecastcodesample.mvp.base.BaseDisposablePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ForecastPresenter extends BaseDisposablePresenter<ForecastView> {

    // Hardcoded in sample purposes
    private static String CITY_NAME = "Moscow";
    private static String UNITS = BackendProvider.WeatherUnits.CELSIUS;

    @Inject
    BackendProvider backendProvider;

    public ForecastPresenter() {
        ForecastApplication.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        addDisposable(backendProvider.getCurrentWeatherData(CITY_NAME, UNITS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnError((error) -> getViewState().showErrorMessage(error.getMessage()))
                .retry()
                .subscribe((weatherData) -> getViewState().showForecast(weatherData)));
    }

    public void onResume() {

    }

}
