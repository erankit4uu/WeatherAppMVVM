package com.ankit.theweatherapp.ui.weather;

import androidx.lifecycle.LiveData;

import com.ankit.theweatherapp.achitecture.ArchitectureApp;
import com.ankit.theweatherapp.data.repo.WeatherRepo;
import com.ankit.theweatherapp.data.source.local.AppDatabase;
import com.ankit.theweatherapp.ui.base.BaseAppActivity;
import com.ankit.theweatherapp.ui.base.BaseViewModel;

import java.util.List;
import java.util.concurrent.Executors;

import javax.inject.Inject;


public class WeatherViewModel extends BaseViewModel {

    public WeatherRepo repo;
    ArchitectureApp architectureApp;
    public LiveData<List<com.ankit.theweatherapp.model.List>> weatherList;
    public LiveData<List<com.ankit.theweatherapp.model.List>> hourlyList;

    @Inject
    public WeatherViewModel(BaseAppActivity activity) {
        super(activity);
        architectureApp = new ArchitectureApp().getInstance();
        repo = new WeatherRepo(Executors.newSingleThreadExecutor(),
                AppDatabase.getInstance(activity).weatherDao(), ArchitectureApp.webServices);
//        repo = ArchitectureApp.REPOSITORY;
        weatherList = repo.getCurrentData();
//        hourlyList = repo.getHourlyData();
    }

    public WeatherViewModel() {

    }

}
