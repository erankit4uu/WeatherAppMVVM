package com.ankit.theweatherapp.achitecture;

import android.app.Application;

import com.ankit.theweatherapp.data.repo.WeatherRepo;
import com.ankit.theweatherapp.data.source.local.AppDatabase;
import com.ankit.theweatherapp.data.source.remote.RetrofitClient;
import com.ankit.theweatherapp.data.source.remote.WebServices;
import com.ankit.theweatherapp.achitecture.di.AppModule;

import java.util.concurrent.Executors;


public class ArchitectureApp extends Application {

    public ArchitectureApp instance;
    public static WeatherRepo REPOSITORY;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //Repo initialize
        REPOSITORY = new WeatherRepo(Executors.newSingleThreadExecutor(), RetrofitClient.getClient().create(WebServices.class),
                AppDatabase.getInstance(this).weatherDao());

        DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build()
                .inject(this);

    }

    public ArchitectureApp getInstance() {
        return instance;
    }

}
