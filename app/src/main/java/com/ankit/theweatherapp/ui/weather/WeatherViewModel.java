package com.ankit.theweatherapp.ui.weather;


import android.app.Activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ankit.theweatherapp.achitecture.ArchitectureApp;
import com.ankit.theweatherapp.data.source.local.WeatherDao;
import com.ankit.theweatherapp.data.repo.WeatherRepo;

import java.util.List;

import javax.inject.Inject;


public class WeatherViewModel extends ViewModel {

    public WeatherRepo repo;
    Activity activity;
    ArchitectureApp architectureApp;
    public LiveData<List<com.ankit.theweatherapp.model.List>> weatherList;

    WeatherDao weatherDao;
    @Inject
    public WeatherViewModel(){
        architectureApp = new ArchitectureApp().getInstance();
        repo = ArchitectureApp.REPOSITORY;
        weatherList =  repo.getWeatherData();
    }

}
