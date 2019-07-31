package com.ankit.theweatherapp.ui.weather;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.ankit.theweatherapp.ui.base.BaseAppActivity;

public class WeatherViewModelFactory implements ViewModelProvider.Factory {
    Context context;

    public WeatherViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new WeatherViewModel((BaseAppActivity) context);
    }


}
