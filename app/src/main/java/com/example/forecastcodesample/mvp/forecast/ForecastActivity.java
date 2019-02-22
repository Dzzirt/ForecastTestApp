package com.example.forecastcodesample.mvp.forecast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.forecastcodesample.R;
import com.example.forecastcodesample.data.backend.model.CurrentWeatherData;
import com.example.forecastcodesample.util.ImageUtils;
import com.example.forecastcodesample.util.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastActivity extends MvpAppCompatActivity implements ForecastView {

    private SimpleDateFormat sunDateFormat = new SimpleDateFormat("H:m", Locale.getDefault());

    @BindView(R.id.textview_city)
    TextView cityTextView;

    @BindView(R.id.textview_description)
    TextView descriptionTextView;

    @BindView(R.id.textview_temperature_prefix)
    TextView temperaturePrefixTextView;

    @BindView(R.id.textview_temperature)
    TextView temperatureTextView;

    @BindView(R.id.textview_sunrise_time)
    TextView sunriseTimeTextView;

    @BindView(R.id.textview_sunset_time)
    TextView sunsetTimeTextView;

    @BindView(R.id.textview_humidity)
    TextView humidityTextView;

    @BindView(R.id.textview_pressure)
    TextView pressureTextView;

    @BindView(R.id.textview_windspeed)
    TextView windSpeedTextView;

    @BindView(R.id.textview_wind_direction)
    TextView windDirectionTextView;

    @BindView(R.id.textview_visibility)
    TextView visibilityTextView;

    @BindView(R.id.imageview_weather)
    ImageView weatherImageView;

    @InjectPresenter
    ForecastPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void showForecast(CurrentWeatherData weatherData) {
        cityTextView.setText(weatherData.getCityName());
        descriptionTextView.setText(weatherData.getDescription());
        humidityTextView.setText(getString(R.string.percents_format, weatherData.getHumidity()));
        pressureTextView.setText(getString(R.string.pressure_format, weatherData.getPressure()));
        sunriseTimeTextView.setText(sunDateFormat.format(new Date(weatherData.getSunriseTimestamp())));
        sunsetTimeTextView.setText(sunDateFormat.format(new Date(weatherData.getSunsetTimestamp())));
        windSpeedTextView.setText(getString(R.string.meters_per_second_format, weatherData.getWindSpeed()));
        windDirectionTextView.setText(Utils.degreeToDirection(weatherData.getWindDegree()));
        visibilityTextView.setText(getString(R.string.meters_format, weatherData.getVisibility()));

        temperatureTextView.setText(String.valueOf(Math.abs(weatherData.getTemperature())));
        temperaturePrefixTextView.setVisibility(weatherData.getTemperature() < 0 ? View.VISIBLE : View.GONE);

        ImageUtils.loadFromUrl(weatherData.getIconUrl(), weatherImageView);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
