package com.ankit.theweatherapp.achitecture;

import android.app.Application;

import com.ankit.theweatherapp.data.repo.WeatherRepo;
import com.ankit.theweatherapp.data.source.local.AppDatabase;
import com.ankit.theweatherapp.achitecture.di.AppModule;
import com.ankit.theweatherapp.data.source.remote.RetrofitClient;
import com.ankit.theweatherapp.data.source.remote.WebServices;

import java.util.concurrent.Executors;


public class ArchitectureApp extends Application {

    public static ArchitectureApp instance;
    public static WeatherRepo REPOSITORY;
    public static ApplicationComponent applicationComponent;
    public static WebServices webServices;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //Repo initialize
        webServices = RetrofitClient.getClient().create(WebServices.class);
//        REPOSITORY = new WeatherRepo(Executors.newSingleThreadExecutor(),
//                AppDatabase.getInstance(this).weatherDao(), webServices);

       applicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();

       applicationComponent.inject(this);

    }

    public ArchitectureApp getInstance() {
        return instance;
    }

}
