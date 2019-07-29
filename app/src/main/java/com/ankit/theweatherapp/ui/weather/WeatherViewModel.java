package com.ankit.theweatherapp.ui.weather;


import android.app.Activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ankit.theweatherapp.achitecture.ArchitectureApp;
import com.ankit.theweatherapp.data.source.local.AppDatabase;
import com.ankit.theweatherapp.data.source.local.WeatherDao;
import com.ankit.theweatherapp.data.source.remote.RetrofitClient;
import com.ankit.theweatherapp.data.repo.WeatherRepo;
import com.ankit.theweatherapp.data.source.remote.WebServices;
import com.ankit.theweatherapp.model.Main;
import com.ankit.theweatherapp.model.Weather;

import java.util.List;
import java.util.concurrent.Executors;

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
        repo = ArchitectureApp.REPROSITORY;
        weatherList =  repo.getWeatherData();
    }

}
