package com.ankit.theweatherapp.di;

import android.app.Application;

import androidx.room.Room;

import com.ankit.theweatherapp.achitecture.ArchitectureApp;
import com.ankit.theweatherapp.data.source.local.AppDatabase;
import com.ankit.theweatherapp.data.source.local.WeatherDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private ArchitectureApp application;


    public AppModule(ArchitectureApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public ArchitectureApp provideArchitecture() {
        return application;
    }


    @Singleton
    @Provides
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public WeatherDao provideItemDao(AppDatabase appDatabase){
        return appDatabase.weatherDao();
    }

    @Provides
    @Singleton
    public AppDatabase provideDatabase(){
        //TODO remove allow main thread and use asynchronous query
        return Room.databaseBuilder(application, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries().build();
    }

}
