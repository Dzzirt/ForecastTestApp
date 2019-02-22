package com.example.forecastcodesample.mvp.base;

import com.arellomobile.mvp.MvpView;

public interface BaseView extends MvpView {
    void showErrorMessage(String errorMessage);
}
