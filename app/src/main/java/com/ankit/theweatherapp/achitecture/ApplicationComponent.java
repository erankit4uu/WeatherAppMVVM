package com.ankit.theweatherapp.achitecture;


import android.app.Activity;
import android.app.Application;

import com.ankit.theweatherapp.data.repo.WeatherRepo;
import com.ankit.theweatherapp.data.source.local.AppDatabase;
import com.ankit.theweatherapp.data.source.local.WeatherDao;
import com.ankit.theweatherapp.di.AppModule;
import com.ankit.theweatherapp.ui.weather.WeatherViewModel;


import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules = {AppModule.class})
public interface ApplicationComponent {

    void inject(Application application);

    void inject(Activity activity);

    void inject(WeatherViewModel viewModel);

    WeatherDao weatherDao();

}
